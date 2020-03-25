package com.platform.oecp.business.manager.impl;

import com.platform.oecp.business.manager.OecpSearchSubManager;
import com.platform.oecp.dao.OecpSearchSubMapper;
import com.platform.oecp.models.dos.OecpSearchSubDO;
import com.platform.oecp.models.qc.OecpSearchSubQC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import red.lixiang.tools.common.mybatis.model.Page;
import red.lixiang.tools.jdk.ListTools;

import java.util.List;

@Component
public class OecpSearchSubManagerImpl implements OecpSearchSubManager{

    @Autowired
    private OecpSearchSubMapper oecpSearchSubMapper;
    
    @Override
    public OecpSearchSubDO getOecpSearchSubById(Long id) {
        OecpSearchSubQC qc = new OecpSearchSubQC();
        qc.setId(id);
        qc.setPage(Page.getOne());
        List<OecpSearchSubDO> oecpSearchSubDOS = queryOecpSearchSub(qc);
        return ListTools.getOne(oecpSearchSubDOS);
    }
    

    @Override
    public List<OecpSearchSubDO> queryOecpSearchSub(OecpSearchSubQC qc){

        List<OecpSearchSubDO> oecpSearchSubs = oecpSearchSubMapper.listOecpSearchSubs(qc);
        return oecpSearchSubs;
    }
    

    @Override
    public Long countOecpSearchSub(OecpSearchSubQC qc){

        Long count = oecpSearchSubMapper.countOecpSearchSubs(qc);
        return count;
    }

    @Override
    public OecpSearchSubDO saveOecpSearchSub(OecpSearchSubDO oecpSearchSub){

        if(oecpSearchSub.getId()!=null){
            oecpSearchSub.preUpdate();
             oecpSearchSubMapper.updateOecpSearchSub(oecpSearchSub);
        }else {
             oecpSearchSub.preInsert();
             oecpSearchSubMapper.insertOecpSearchSub(oecpSearchSub);
        }
        return oecpSearchSub;

    }

    @Override
    public int removeOecpSearchSubById(Long id){

        return oecpSearchSubMapper.removeOecpSearchSubById(id);

    }


}
