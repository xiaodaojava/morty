package com.platform.oecp.business.manager;

import com.platform.oecp.dao.OecpErrorInfoAndCaseMapper;
import com.platform.oecp.dto.CaseInfoDto;
import com.platform.oecp.dto.ErrorInfoAndCaseDto;
import com.platform.oecp.factory.*;
import com.platform.oecp.models.document.CaseTag;
import com.platform.oecp.models.document.ErrorTag;
import com.platform.oecp.models.dos.*;
import com.platform.oecp.models.qc.OecpErrorCaseQC;
import com.platform.oecp.models.qc.OecpErrorInfoQC;
import com.platform.oecp.models.qc.OecpErrorTagQC;
import com.platform.oecp.models.qc.OecpSearchMainQC;
import com.platform.oecp.models.request.OecpCaseInfoRequest;
import com.platform.oecp.models.request.OecpDeleteCaseInfoRequest;
import com.platform.oecp.models.request.OecpErrorInfoRequest;
import com.platform.oecp.models.request.OecpTagRequest;
import com.platform.oecp.utils.UserUtil;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import red.lixiang.tools.common.mybatis.model.Page;
import red.lixiang.tools.jdk.ListTools;
import red.lixiang.tools.spring.redis.RedisSpringTools;

import javax.naming.CommunicationException;
import java.util.List;

/**
 * @version 1.0
 * @className: CommonManager
 * @author: LILIANG
 * @date: Create In 2020/3/24 23:55
 * @description: 公用业务类
 */
@Service
public class CommonManager {

    @Autowired
    private OecpErrorInfoManager oecpErrorInfoManager;

    @Autowired
    private OecpErrorInfoFactory oecpErrorInfoFactory;

    @Autowired
    private OecpCaseInfoFactory oecpCaseInfoFactory;

    @Autowired
    private OecpTagManager oecpTagManager;

    @Autowired
    private OecpErrorTagManager oecpErrorTagManager;

    @Autowired
    private OecpCaseInfoManager oecpCaseInfoManager;

    @Autowired
    private OecpErrorCaseManager oecpErrorCaseManager;

    @Autowired
    private OecpCaseTagManager oecpCaseTagManager;

    @Autowired
    private OecpErrorInfoAndCaseMapper oecpErrorInfoAndCaseMapper;

    @Autowired
    private OecpSearchMainManager oecpSearchMainManager;

    @Autowired
    private OecpSearchSubManager oecpSearchSubManager;

    @Autowired
    private OecpSearchMainFactory oecpSearchMainFactory;

    @Autowired
    private OecpSearchSubFactory oecpSearchSubFactory;

    @Autowired
    private SearchManager searchManager;

    @Autowired
    private RedisSpringTools redisUtils;

    public CommonManager() {
    }

    /**
     * @author: LILIANG
     * @date: 2020/3/29 21:47
     *
     * @return: java.util.List<com.platform.oecp.dto.ErrorInfoAndCaseDto>
     * @description: 查出当前用户得错误码信息
     */
    public List<ErrorInfoAndCaseDto> getErrorInfos(Page page){
        OecpSysUserDO user = UserUtil.currentUser();
        List<ErrorInfoAndCaseDto> errorInfoAndCaseDtos = oecpErrorInfoAndCaseMapper.errorInfoList(String.valueOf(user.getId()),page);
        for(ErrorInfoAndCaseDto errorInfoAndCaseDto:errorInfoAndCaseDtos){
            List<CaseInfoDto> caseInfoDtos = oecpErrorInfoAndCaseMapper.caseInfoList(String.valueOf(user.getId()),errorInfoAndCaseDto.getCodeId());
            errorInfoAndCaseDto.setCaseInfos(caseInfoDtos);
        }
        return errorInfoAndCaseDtos;
    }

    public Long countErrorInfos(){
        OecpSysUserDO user = UserUtil.currentUser();
        Long totalCount = oecpErrorInfoAndCaseMapper.countErrorInfo(String.valueOf(user.getId()));
        return totalCount;
    }

    /**
     * @author: LILIANG
     * @date: 2020/3/25 0:30
     * @Param : oecpErrorInfoRequest
     * @return: com.platform.oecp.models.response.OecpErrorInfoResponse
     * @description: 创建新的错误码信息
     */
    @Transactional
    public OecpErrorInfoDO saveErrorInfo(OecpErrorInfoRequest oecpErrorInfoRequest) throws CommunicationException {
        //保存错误码信息
        OecpErrorInfoDO oecpErrorInfoDO = oecpErrorInfoFactory.createNewInstance(oecpErrorInfoRequest);
        oecpErrorInfoDO = oecpErrorInfoManager.saveOecpErrorInfo(oecpErrorInfoDO);
        oecpErrorInfoRequest.setCodeId(oecpErrorInfoDO.getId());
        //将信息保存到search表和es
        OecpSearchMainDO oecpSearchMainDO = oecpSearchMainFactory.createNewInstance(oecpErrorInfoDO);
        oecpSearchMainDO = oecpSearchMainManager.saveOecpSearchMain(oecpSearchMainDO);
        if(oecpErrorInfoDO != null) {
            //保存tag
            for (ErrorTag tag : oecpErrorInfoRequest.getTags()) {
                OecpTagDO oecpTagDO = new OecpTagDO();
                oecpTagDO.setId(tag.getId()==null? null :Long.valueOf(tag.getId()));
                oecpTagDO.setTag(tag.getTag());
                oecpTagDO = oecpTagManager.saveOecpTag(oecpTagDO);
                //保存错误码tag信息oecp_error_tag
                OecpErrorTagDO oecpErrorTagDO = new OecpErrorTagDO();
                oecpErrorTagDO.setCodeId(oecpErrorInfoDO.getId());
                oecpErrorTagDO.setTagId(oecpTagDO.getId());
                oecpErrorTagManager.saveOecpErrorTag(oecpErrorTagDO);
            }
            //保存案例信息
            for (OecpCaseInfoRequest oecpCaseInfoRequest : oecpErrorInfoRequest.getOecpCaseInfoRequests()) {
                OecpCaseInfoDO oecpCaseInfoDO = oecpCaseInfoFactory.createNewInstance(oecpCaseInfoRequest);
                oecpCaseInfoDO = oecpCaseInfoManager.saveOecpCaseInfo(oecpCaseInfoDO);
                oecpCaseInfoRequest.setCaseId(oecpCaseInfoDO.getId());
                oecpCaseInfoRequest.setTitleForSearch(oecpCaseInfoDO.getTitleForSearch());
                oecpCaseInfoRequest.setContentForSearch(oecpCaseInfoDO.getContentForSearch());
                if(oecpCaseInfoRequest.getTags() != null){
                for (CaseTag caseTag : oecpCaseInfoRequest.getTags()) {
                    OecpTagDO oecpTagDO = new OecpTagDO();
                    oecpTagDO.setId(caseTag.getId()==null? null :Long.valueOf(caseTag.getId()));
                    oecpTagDO.setTag(caseTag.getTag());
                    oecpTagDO = oecpTagManager.saveOecpTag(oecpTagDO);
                    //保存案例tag信息oecp_case_tag
                    OecpCaseTagDO oecpCaseTagDO = new OecpCaseTagDO();
                    oecpCaseTagDO.setCaseId(oecpCaseInfoDO.getId());
                    oecpCaseTagDO.setTagId(oecpTagDO.getId());
                    oecpCaseTagManager.saveOecpCaseTag(oecpCaseTagDO);
                }
                }
                //保存错误码和案例关联关系
                OecpErrorCaseDO oecpErrorCaseDO = new OecpErrorCaseDO();
                oecpErrorCaseDO.setCodeId(oecpErrorInfoDO.getId());
                oecpErrorCaseDO.setCaseId(oecpCaseInfoDO.getId());
                oecpErrorCaseManager.saveOecpErrorCase(oecpErrorCaseDO);
                //保存案例到search表中
                OecpSearchSubDO oecpSearchSubDO =oecpSearchSubFactory.createNewInstance(oecpCaseInfoDO,oecpSearchMainDO);
                oecpSearchSubManager.saveOecpSearchSub(oecpSearchSubDO);
            }
        }
        //异步更新es
        searchManager.saveEsContent(oecpErrorInfoRequest,null,null,null);
        return oecpErrorInfoDO;
    }

    /**
     * @author: LILIANG
     * @date: 2020/3/25 9:07
     * @Param : oecpCaseInfo
     * @return: com.platform.oecp.models.dos.OecpCaseInfoDO
     * @description: 创建新的错误案例信息
     */
    @Transactional
    public OecpCaseInfoDO saveCaseInfo(OecpCaseInfoRequest oecpCaseInfoRequest){
        //对title和content进行处理
        OecpCaseInfoDO oecpCaseInfoDO = oecpCaseInfoFactory.createNewInstance(oecpCaseInfoRequest);
        //保存案例信息
        oecpCaseInfoDO = oecpCaseInfoManager.saveOecpCaseInfo(oecpCaseInfoDO);
        oecpCaseInfoRequest.setCaseId(oecpCaseInfoDO.getId());
        oecpCaseInfoRequest.setTitleForSearch(oecpCaseInfoDO.getTitleForSearch());
        oecpCaseInfoRequest.setContentForSearch(oecpCaseInfoDO.getContentForSearch());
        //保存和修改案例tag
        if(oecpCaseInfoRequest.getTags() != null) {
            for (CaseTag tag : oecpCaseInfoRequest.getTags()) {
                OecpTagDO oecpTagDO = new OecpTagDO();
                oecpTagDO.setId(tag.getId() == null ? null : Long.valueOf(tag.getId()));
                oecpTagDO.setTag(tag.getTag());
                oecpTagDO = oecpTagManager.saveOecpTag(oecpTagDO);
                if (StringUtils.isEmpty(oecpCaseInfoRequest.getCaseId())) {
                    //保存案例tag信息oecp_case_tag
                    OecpCaseTagDO oecpCaseTagDO = new OecpCaseTagDO();
                    oecpCaseTagDO.setCaseId(oecpCaseInfoDO.getId());
                    oecpCaseTagDO.setTagId(oecpTagDO.getId());
                    oecpCaseTagManager.saveOecpCaseTag(oecpCaseTagDO);
                }
            }
        }
        if(oecpCaseInfoDO != null && StringUtils.isEmpty(oecpCaseInfoRequest.getCaseId())) {
            //保存错误案例关联信息
            OecpErrorCaseDO oecpErrorCaseDO = new OecpErrorCaseDO();
            oecpErrorCaseDO.setCodeId(oecpCaseInfoRequest.getCodeId());
            oecpErrorCaseDO.setCaseId(oecpCaseInfoDO.getId());
            oecpErrorCaseManager.saveOecpErrorCase(oecpErrorCaseDO);
        }
        //将信息更新到search表和es
        OecpSearchMainDO oecpSearchMainDO = oecpSearchMainManager.getOecpSearchMainByCodeId(oecpCaseInfoRequest.getCodeId());
        if(oecpSearchMainDO != null) {
            OecpSearchSubDO oecpSearchSubDO = oecpSearchSubFactory.createNewInstance(oecpCaseInfoDO, oecpSearchMainDO);
            oecpSearchSubManager.saveOecpSearchSub(oecpSearchSubDO);
        }
        //异步更新es
        searchManager.saveEsContent(null,oecpCaseInfoRequest,null,null);
        return oecpCaseInfoDO;
    }

    /**
     * @author: LILIANG
     * @date: 2020/3/25 12:14
     * @Param : codeId
     * @return: int
     * @description: 错误码的删除
     */
    public int deleteErrorInfo(Long codeId){
        int errorInfoDeleteFlag = oecpErrorInfoManager.removeOecpErrorInfoById(codeId);
        if(errorInfoDeleteFlag >0 ){
            //错误标签tag删除
            OecpErrorTagQC oecpErrorTagQC = new OecpErrorTagQC();
            oecpErrorTagQC.setCodeId(codeId);
            List<OecpErrorTagDO> oecpErrorTagDOS = oecpErrorTagManager.queryOecpErrorTag(oecpErrorTagQC);
            for(OecpErrorTagDO oecpErrorTagDO : oecpErrorTagDOS){
                oecpErrorTagManager.removeOecpErrorTagById(oecpErrorTagDO.getId());
            }
            //错误案例关联进行删除
            OecpErrorCaseQC oecpErrorCaseQC = new OecpErrorCaseQC();
            oecpErrorCaseQC.setCodeId(codeId);
            List<OecpErrorCaseDO> oecpErrorAndCaseInfoDOS = oecpErrorCaseManager.queryOecpErrorCase(oecpErrorCaseQC);
            for(OecpErrorCaseDO oecpErrorCaseDO : oecpErrorAndCaseInfoDOS){
                oecpErrorCaseManager.removeOecpErrorCaseById(oecpErrorCaseDO.getId());
                //案例下面的tag进行删除
                oecpCaseTagManager.removeOecpCaseTagByCaseId(oecpErrorCaseDO.getCaseId());
            }
            //删除es中的错误码信息和search表中的
            OecpSearchMainDO oecpSearchMainDO = oecpSearchMainManager.getOecpSearchMainByCodeId(codeId);
            oecpSearchMainManager.removeOecpSearchMainById(oecpSearchMainDO.getId());
            oecpSearchSubManager.removeOecpSearchSubByMainId(oecpSearchMainDO.getId());
            //异步更新es
            searchManager.saveEsContent(null,null,oecpSearchMainDO.getErrorCode(),null);
            return errorInfoDeleteFlag;
        }
        return 0;
    }

    /**
     * @author: LILIANG
     * @date: 2020/3/25 12:13
     * @Param : oecpDeleteCaseInfoRequest
     * @return: int
     * @description: 案例的删除
     */
    public int deleteCaseInfo(OecpDeleteCaseInfoRequest oecpDeleteCaseInfoRequest){
        int caseInfoDeleteFlag = 0;
        for(Long caseId : oecpDeleteCaseInfoRequest.getCaseIds()) {
            caseInfoDeleteFlag = oecpCaseInfoManager.removeOecpCaseInfoById(caseId);
            if (caseInfoDeleteFlag > 0) {
                //错误案例关联进行删除
                oecpErrorCaseManager.removeOecpErrorCaseByCodeIdAndCaseId(oecpDeleteCaseInfoRequest.getCodeId(),caseId);
                //案例下面的tag进行删除
                oecpCaseTagManager.removeOecpCaseTagByCaseId(caseId);
            }
            //同步更新到es中和search表中
            oecpSearchSubManager.removeOecpSearchSubByCaseId(caseId);
            //异步更新es
            searchManager.saveEsContent(null,null,null,oecpDeleteCaseInfoRequest);
            if(caseInfoDeleteFlag <= 0){
                return 0;
            }
        }
        return caseInfoDeleteFlag;
    }

    /**
     * @author: LILIANG
     * @date: 2020/3/25 9:20
     * @Param : errorCode
     * @return: com.platform.oecp.models.dos.OecpErrorInfoDO
     * @description: 检查错误码是否有重复
     */
    public OecpErrorInfoDO checkErrorCodeRepeat(String errorCode){
        OecpErrorInfoQC oecpErrorInfoQC = new OecpErrorInfoQC();
        oecpErrorInfoQC.setCode(errorCode);
        oecpErrorInfoQC.setPage(Page.getOne());
        List<OecpErrorInfoDO> oecpErrorInfoDOS = oecpErrorInfoManager.queryOecpErrorInfo(oecpErrorInfoQC);
        return ListTools.getOne(oecpErrorInfoDOS);
    }
}
