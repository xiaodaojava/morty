package com.platform.oecp.business.manager.impl;

import com.platform.oecp.models.dos.OecpCaseInfoDO;
import com.platform.oecp.models.dos.OecpErrorAndCaseInfoDO;
import com.platform.oecp.models.dos.OecpErrorCaseDO;
import com.platform.oecp.models.qc.OecpErrorCaseQC;
import red.lixiang.tools.jdk.SnowflakeGenerator;

import com.platform.oecp.business.manager.OecpErrorCaseManager;
import com.platform.oecp.dao.OecpCaseInfoMapper;
import com.platform.oecp.dao.OecpErrorCaseMapper;
import red.lixiang.tools.common.mybatis.model.Page;
import red.lixiang.tools.common.mybatis.model.Sort;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Component
public class OecpErrorCaseManagerImpl implements OecpErrorCaseManager{

    @Autowired
    private OecpErrorCaseMapper oecpErrorCaseMapper;
    
    @Autowired
    private OecpCaseInfoMapper oecpCaseInfoMapper;    
//    @Override
//    public OecpErrorCaseDO getOecpErrorCaseById(Long id) {
//        OecpErrorCaseQC qc = new OecpErrorCaseQC();
//        qc.setId(id);
//        qc.setPage(Page.getOne());
//        List<OecpErrorCaseDO> oecpErrorCaseDOS = queryOecpErrorCase(qc);
//        return ListTools.getOne(oecpErrorCaseDOS);
//    }
    

//    @Override
//    public List<OecpErrorCaseDO> queryOecpErrorCase(OecpErrorCaseQC qc){
//
//        List<OecpErrorCaseDO> oecpErrorCases = oecpErrorCaseMapper.listOecpErrorCases(qc);
//        return oecpErrorCases;
//    }

    @Override
    public List<OecpErrorAndCaseInfoDO> queryOecpErrorCase(OecpErrorCaseQC qc){

        List<OecpErrorAndCaseInfoDO> oecpErrorCases = oecpErrorCaseMapper.listOecpErrorCases(qc);
        return oecpErrorCases;
    }


    @Override
    public Long countOecpErrorCase(OecpErrorCaseQC qc){

        Long count = oecpErrorCaseMapper.countOecpErrorCases(qc);
        return count;
    }
//
//    @Override
//    public OecpErrorCaseDO saveOecpErrorCase(OecpErrorCaseDO oecpErrorCase){
//
//        if(oecpErrorCase.getId()!=null){
//            oecpErrorCase.preUpdate();
//             oecpErrorCaseMapper.updateOecpErrorCase(oecpErrorCase);
//        }else {
//            oecpErrorCase.preInsert();
//             oecpErrorCaseMapper.insertOecpErrorCase(oecpErrorCase);
//        }
//        return oecpErrorCase;
//
//    }
    @Transactional
    @Override
    public OecpErrorAndCaseInfoDO saveOecpErrorCase(OecpErrorAndCaseInfoDO oecpErrorAndCaseInfo){

        if(oecpErrorAndCaseInfo.getId()!=null){
//          oecpErrorCase.preUpdate();
//          oecpErrorCaseMapper.updateOecpErrorCase(oecpErrorCase);
        }else {
        	Long caseIdLong = SnowflakeGenerator.generateKey();
        	OecpErrorCaseDO oecpErrorCase = OecpErrorCaseDO.create();
            oecpErrorCase.preInsert();
            oecpErrorCase.setCaseId(caseIdLong);
            oecpErrorCase.setCodeId(oecpErrorAndCaseInfo.getCodeId());
            oecpErrorCaseMapper.insertOecpErrorCase(oecpErrorCase);
            
            OecpCaseInfoDO oecpCaseInfo = OecpCaseInfoDO.create();
            oecpCaseInfo.preInsert();
            oecpCaseInfo.setId(caseIdLong);
            oecpCaseInfo.setTitle(oecpErrorAndCaseInfo.getTitle());
            oecpCaseInfo.setContent(oecpErrorAndCaseInfo.getContent());
            oecpCaseInfoMapper.insertOecpCaseInfo(oecpCaseInfo); 
        }
        return oecpErrorAndCaseInfo;

    }

    @Override
    public int removeOecpErrorCaseById(Long id){

        return oecpErrorCaseMapper.removeOecpErrorCaseById(id);

    }


}
