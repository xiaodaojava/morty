package com.platform.oecp.business.manager.impl;

import com.platform.oecp.business.manager.OecpErrorCaseManager;
import com.platform.oecp.dao.OecpErrorCaseMapper;
import com.platform.oecp.models.dos.OecpErrorCaseDO;
import com.platform.oecp.models.qc.OecpErrorCaseQC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import red.lixiang.tools.common.mybatis.model.Page;
import red.lixiang.tools.jdk.ListTools;

import java.util.List;

@Component
public class OecpErrorCaseManagerImpl implements OecpErrorCaseManager{

    @Autowired
    private OecpErrorCaseMapper oecpErrorCaseMapper;

    @Override
    public OecpErrorCaseDO getOecpErrorCaseById(Long id) {
        OecpErrorCaseQC qc = new OecpErrorCaseQC();
        qc.setId(id);
        qc.setPage(Page.getOne());
        List<OecpErrorCaseDO> oecpErrorCaseDOS = queryOecpErrorCase(qc);
        return ListTools.getOne(oecpErrorCaseDOS);
    }
    

    @Override
    public List<OecpErrorCaseDO> queryOecpErrorCase(OecpErrorCaseQC qc){

        List<OecpErrorCaseDO> oecpErrorCases = oecpErrorCaseMapper.listOecpErrorCases(qc);
        return oecpErrorCases;
    }


    @Override
    public Long countOecpErrorCase(OecpErrorCaseQC qc){

        Long count = oecpErrorCaseMapper.countOecpErrorCases(qc);
        return count;
    }

    @Override
    public OecpErrorCaseDO saveOecpErrorCase(OecpErrorCaseDO oecpErrorCase){

        if(oecpErrorCase.getId()!=null){
            oecpErrorCase.preUpdate();
             oecpErrorCaseMapper.updateOecpErrorCase(oecpErrorCase);
        }else {
            oecpErrorCase.preInsert();
             oecpErrorCaseMapper.insertOecpErrorCase(oecpErrorCase);
        }
        return oecpErrorCase;

    }

    @Override
    public int removeOecpErrorCaseById(Long id){

        return oecpErrorCaseMapper.removeOecpErrorCaseById(id);

    }

    @Override
    public int removeOecpErrorCaseByCodeIdAndCaseId(Long codeId, Long caseId) {

        return oecpErrorCaseMapper.removeOecpErrorCaseByCodeIdAndCaseId(codeId,caseId);
    }


}
