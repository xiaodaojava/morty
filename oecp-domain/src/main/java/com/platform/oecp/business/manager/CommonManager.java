package com.platform.oecp.business.manager;

import com.platform.oecp.dao.OecpErrorInfoAndCaseMapper;
import com.platform.oecp.dto.CaseInfoDto;
import com.platform.oecp.dto.ErrorInfoAndCaseDto;
import com.platform.oecp.factory.OecpCaseInfoFactory;
import com.platform.oecp.factory.OecpErrorInfoFactory;
import com.platform.oecp.models.dos.*;
import com.platform.oecp.models.qc.OecpErrorCaseQC;
import com.platform.oecp.models.qc.OecpErrorInfoQC;
import com.platform.oecp.models.qc.OecpErrorTagQC;
import com.platform.oecp.models.request.OecpCaseInfoRequest;
import com.platform.oecp.models.request.OecpDeleteCaseInfoRequest;
import com.platform.oecp.models.request.OecpErrorInfoRequest;
import com.platform.oecp.models.request.OecpTagRequest;
import com.platform.oecp.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import red.lixiang.tools.common.mybatis.model.Page;
import red.lixiang.tools.jdk.ListTools;
import red.lixiang.tools.spring.redis.RedisSpringTools;

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
    private RedisSpringTools redisUtils;

    public CommonManager() {
    }

    public List<ErrorInfoAndCaseDto> getErrorInfos(){
        //如果同一个人先从缓存拿
//        redisUtils.get("ERROR_INFO_"+userId);
//        if(){
//            String accountJSON = (String)redisUtils.get("TOKEN_TELL_KEY_" + token);
//            if(StringTools.isBlank(accountJSON)){
//                OecpSysUserDO vo = JSON.parseObject(accountJSON,OecpSysUserDO.class);
//            }
//        }
        OecpSysUserDO user = UserUtil.currentUser();
//        if(user != null) {
//            //错误信息带标签
//            OecpErrorInfoQC oecpErrorInfoQC = new OecpErrorInfoQC();
//            oecpErrorInfoQC.setCreateBy(String.valueOf(user.getId()));
//            List<OecpErrorInfoDO> oecpErrorInfoDOS = oecpErrorInfoManager.queryOecpErrorInfo(oecpErrorInfoQC);
//            //案例信息带标签
//            for(OecpErrorInfoDO oecpErrorInfoDO:oecpErrorInfoDOS){
//                //错误下的案列
//                OecpErrorCaseQC oecpErrorCaseQC = new OecpErrorCaseQC();
//                oecpErrorCaseQC.setCodeId(oecpErrorInfoDO.getId());
//                List<OecpErrorCaseDO> oecpErrorAndCaseInfoDOS = oecpErrorCaseManager.queryOecpErrorCase(oecpErrorCaseQC);
//                for(OecpErrorCaseDO oecpErrorCaseDO:oecpErrorAndCaseInfoDOS){
//                    OecpCaseInfoQC oecpCaseInfoQC = new OecpCaseInfoQC();
//                    oecpCaseInfoQC.setId(oecpErrorCaseDO.getCaseId());
//                    List<OecpCaseInfoDO> oecpCaseInfoDOS = oecpCaseInfoManager.queryOecpCaseInfo(oecpCaseInfoQC);
//                }
//            }
//        }
        List<ErrorInfoAndCaseDto> errorInfoAndCaseDtos = oecpErrorInfoAndCaseMapper.errorInfoList(String.valueOf(user.getId()));
        for(ErrorInfoAndCaseDto errorInfoAndCaseDto:errorInfoAndCaseDtos){
            List<CaseInfoDto> caseInfoDtos = oecpErrorInfoAndCaseMapper.caseInfoList(String.valueOf(user.getId()),errorInfoAndCaseDto.getCodeId());
            errorInfoAndCaseDto.setCaseInfos(caseInfoDtos);
        }
        return errorInfoAndCaseDtos;
    }

    /**
     * @author: LILIANG
     * @date: 2020/3/25 0:30
     * @Param : oecpErrorInfoRequest
     * @return: com.platform.oecp.models.response.OecpErrorInfoResponse
     * @description: 创建新的错误码信息
     */
    @Transactional
    public OecpErrorInfoDO saveErrorInfo(OecpErrorInfoRequest oecpErrorInfoRequest){
        //保存错误码信息
        OecpErrorInfoDO oecpErrorInfoDO = oecpErrorInfoFactory.createNewInstance(oecpErrorInfoRequest);
        oecpErrorInfoDO = oecpErrorInfoManager.saveOecpErrorInfo(oecpErrorInfoDO);
        if(oecpErrorInfoDO != null) {
            //保存tag
            for (OecpTagRequest tag : oecpErrorInfoRequest.getTags()) {
                OecpTagDO oecpTagDO = new OecpTagDO();
                oecpTagDO.setId(tag.getTagId());
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
                for (OecpTagRequest caseTag : oecpCaseInfoRequest.getTags()) {
                    OecpTagDO oecpTagDO = new OecpTagDO();
                    oecpTagDO.setId(caseTag.getTagId());
                    oecpTagDO.setTag(caseTag.getTag());
                    oecpTagDO = oecpTagManager.saveOecpTag(oecpTagDO);
                    //保存案例tag信息oecp_case_tag
                    OecpCaseTagDO oecpCaseTagDO = new OecpCaseTagDO();
                    oecpCaseTagDO.setCaseId(oecpCaseInfoDO.getId());
                    oecpCaseTagDO.setTagId(oecpTagDO.getId());
                    oecpCaseTagManager.saveOecpCaseTag(oecpCaseTagDO);
                }
                //保存错误码和案例关联关系
                OecpErrorCaseDO oecpErrorCaseDO = new OecpErrorCaseDO();
                oecpErrorCaseDO.setCodeId(oecpErrorInfoDO.getId());
                oecpErrorCaseDO.setCaseId(oecpCaseInfoDO.getId());
                oecpErrorCaseManager.saveOecpErrorCase(oecpErrorCaseDO);
            }
        }
        //将信息更新到search表
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
        oecpCaseInfoDO =oecpCaseInfoManager.saveOecpCaseInfo(oecpCaseInfoDO);
        //保存和修改案例tag
        for(OecpTagRequest tag : oecpCaseInfoRequest.getTags()){
            OecpTagDO oecpTagDO = new OecpTagDO();
            oecpTagDO.setId(tag.getTagId());
            oecpTagDO.setTag(tag.getTag());
            oecpTagDO = oecpTagManager.saveOecpTag(oecpTagDO);
            if(StringUtils.isEmpty(oecpCaseInfoRequest.getCaseId())) {
                //保存案例tag信息oecp_case_tag
                OecpCaseTagDO oecpCaseTagDO = new OecpCaseTagDO();
                oecpCaseTagDO.setCaseId(oecpCaseInfoDO.getId());
                oecpCaseTagDO.setTagId(oecpTagDO.getId());
                oecpCaseTagManager.saveOecpCaseTag(oecpCaseTagDO);
            }
        }
        if(oecpCaseInfoDO != null && StringUtils.isEmpty(oecpCaseInfoRequest.getCaseId())) {
            //保存错误案例关联信息
            OecpErrorCaseDO oecpErrorCaseDO = new OecpErrorCaseDO();
            oecpErrorCaseDO.setCodeId(oecpCaseInfoRequest.getCodeId());
            oecpErrorCaseDO.setCaseId(oecpCaseInfoDO.getId());
            oecpErrorCaseManager.saveOecpErrorCase(oecpErrorCaseDO);
        }
        //将信息更新到search表
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
