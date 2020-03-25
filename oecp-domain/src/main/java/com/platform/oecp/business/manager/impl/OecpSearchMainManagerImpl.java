package com.platform.oecp.business.manager.impl;

import com.platform.oecp.business.manager.OecpSearchMainManager;
import com.platform.oecp.dao.OecpSearchMainMapper;
import com.platform.oecp.models.dos.OecpSearchMainDO;
import com.platform.oecp.models.qc.OecpSearchMainQC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import red.lixiang.tools.common.mybatis.model.Page;
import red.lixiang.tools.jdk.ListTools;

import java.util.List;

@Component
public class OecpSearchMainManagerImpl implements OecpSearchMainManager{

    @Autowired
    private OecpSearchMainMapper oecpSearchMainMapper;
    
    @Override
    public OecpSearchMainDO getOecpSearchMainById(Long id) {
        OecpSearchMainQC qc = new OecpSearchMainQC();
        qc.setId(id);
        qc.setPage(Page.getOne());
        List<OecpSearchMainDO> oecpSearchMainDOS = queryOecpSearchMain(qc);
        return ListTools.getOne(oecpSearchMainDOS);
    }
    

    @Override
    public List<OecpSearchMainDO> queryOecpSearchMain(OecpSearchMainQC qc){

        List<OecpSearchMainDO> oecpSearchMains = oecpSearchMainMapper.listOecpSearchMains(qc);
        return oecpSearchMains;
    }
    

    @Override
    public Long countOecpSearchMain(OecpSearchMainQC qc){

        Long count = oecpSearchMainMapper.countOecpSearchMains(qc);
        return count;
    }

    @Override
    public OecpSearchMainDO saveOecpSearchMain(OecpSearchMainDO oecpSearchMain){

        if(oecpSearchMain.getId()!=null){
            oecpSearchMain.preUpdate();
            oecpSearchMainMapper.updateOecpSearchMain(oecpSearchMain);
        }else {
             oecpSearchMain.preInsert();
             oecpSearchMainMapper.insertOecpSearchMain(oecpSearchMain);
        }
        return oecpSearchMain;

    }

    @Override
    public int removeOecpSearchMainById(Long id){

        return oecpSearchMainMapper.removeOecpSearchMainById(id);

    }


}
