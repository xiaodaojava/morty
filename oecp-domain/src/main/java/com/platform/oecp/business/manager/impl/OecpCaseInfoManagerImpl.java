package com.platform.oecp.business.manager.impl;

import com.platform.oecp.business.manager.OecpCaseTagManager;
import com.platform.oecp.business.manager.OecpTagManager;
import com.platform.oecp.dao.OecpErrorCaseMapper;
import com.platform.oecp.dao.OecpSysUserMapper;
import com.platform.oecp.models.dos.OecpCaseInfoDO;
import com.platform.oecp.models.dos.OecpCaseTagDO;
import com.platform.oecp.models.dos.OecpErrorCaseDO;
import com.platform.oecp.models.dos.OecpSysUserDO;
import com.platform.oecp.models.qc.OecpCaseInfoQC;
import com.platform.oecp.models.qc.OecpCaseTagQC;
import com.platform.oecp.models.qc.OecpSysUserQC;
import red.lixiang.tools.jdk.ListTools;
import com.platform.oecp.business.manager.OecpCaseInfoManager;
import com.platform.oecp.dao.OecpCaseInfoMapper;
import red.lixiang.tools.common.mybatis.model.Page;
import red.lixiang.tools.common.mybatis.model.Sort;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class OecpCaseInfoManagerImpl implements OecpCaseInfoManager{

    @Autowired
    private OecpCaseInfoMapper oecpCaseInfoMapper;

    @Autowired
    private OecpSysUserMapper oecpSysUserMapper;

    @Autowired
    private OecpCaseTagManager oecpCaseTagManager;

    @Autowired
    private OecpErrorCaseMapper oecpErrorCaseMapper;
    
    @Override
    public OecpCaseInfoDO getOecpCaseInfoById(Long id) {
        OecpCaseInfoQC qc = new OecpCaseInfoQC();
        qc.setId(id);
        qc.setPage(Page.getOne());
        List<OecpCaseInfoDO> oecpCaseInfoDOS = queryOecpCaseInfo(qc);
        OecpCaseInfoDO infoDO = ListTools.getOne(oecpCaseInfoDOS);
        if(infoDO != null){
            String creatorId = infoDO.getCreateBy();
            OecpSysUserQC userQC = new OecpSysUserQC();
            userQC.setId(Long.valueOf(creatorId));
            OecpSysUserDO userDO = ListTools.getOne(oecpSysUserMapper.listOecpSysUsers(userQC));
            if(userDO != null) {
                infoDO.setCreatorName(userDO.getNickName());
                infoDO.setCreatorAvator(userDO.getAvatar());
            }
        }
        return infoDO;
    }


    @Override
    public List<OecpCaseInfoDO> queryOecpCaseInfo(OecpCaseInfoQC qc){

        List<OecpCaseInfoDO> oecpCaseInfos = oecpCaseInfoMapper.listOecpCaseInfos(qc);
        if(oecpCaseInfos != null) {
            List<Long> caseIdList = oecpCaseInfos.stream().map(info ->{
                return info.getId();
            }).distinct().collect(Collectors.toList());
            Map<Long,OecpCaseInfoDO> map = new HashMap<>();
            for(OecpCaseInfoDO oecpCaseInfoDO : oecpCaseInfos){
                map.put(oecpCaseInfoDO.getId(),oecpCaseInfoDO);
            }
            List<OecpErrorCaseDO> oecpErrorCaseDOS = oecpErrorCaseMapper.listOecpErrorCasesByCaseIdList(caseIdList);
            if(oecpErrorCaseDOS != null){
                Map<Long,Long> caseAndCodeMap = new HashMap<>();
               for(OecpErrorCaseDO caseDO : oecpErrorCaseDOS){
                   Long codeID = caseAndCodeMap.get(caseDO.getCaseId());
                   if(codeID == null){
                       caseAndCodeMap.put(caseDO.getCaseId(),caseDO.getCodeId());
                   }
               }
               for(OecpCaseInfoDO infoDO : oecpCaseInfos){
                   Long id = caseAndCodeMap.get(infoDO.getId());
                   if(id != null) {
                       infoDO.setCodeId(caseAndCodeMap.get(infoDO.getId()));
                   }
               }
            }
        }

        return oecpCaseInfos;
    }
    

    @Override
    public Long countOecpCaseInfo(OecpCaseInfoQC qc){

        Long count = oecpCaseInfoMapper.countOecpCaseInfos(qc);
        return count;
    }

    @Override
    public OecpCaseInfoDO saveOecpCaseInfo(OecpCaseInfoDO oecpCaseInfo){

        if(oecpCaseInfo.getId()!=null){
            oecpCaseInfo.preUpdate();
             oecpCaseInfoMapper.updateOecpCaseInfo(oecpCaseInfo);
        }else {
            oecpCaseInfo.preInsert();
             oecpCaseInfoMapper.insertOecpCaseInfo(oecpCaseInfo);
        }
        return oecpCaseInfo;

    }

    @Override
    public int removeOecpCaseInfoById(Long id){

        return oecpCaseInfoMapper.removeOecpCaseInfoById(id);

    }


}
