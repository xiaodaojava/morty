package com.platform.oecp.business.manager.impl;

import com.platform.oecp.models.dos.OecpConfigDO;
import com.platform.oecp.models.qc.OecpConfigQC;
import red.lixiang.tools.jdk.ListTools;
import com.platform.oecp.business.manager.OecpConfigManager;
import com.platform.oecp.dao.OecpConfigMapper;
import red.lixiang.tools.common.mybatis.model.Page;
import red.lixiang.tools.common.mybatis.model.Sort;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class OecpConfigManagerImpl implements OecpConfigManager{

    @Autowired
    private OecpConfigMapper oecpConfigMapper;
    
    @Override
    public OecpConfigDO getOecpConfigById(Long id) {
        OecpConfigQC qc = new OecpConfigQC();
        qc.setId(id);
        qc.setPage(Page.getOne());
        List<OecpConfigDO> oecpConfigDOS = queryOecpConfig(qc);
        return ListTools.getOne(oecpConfigDOS);
    }
    

    @Override
    public List<OecpConfigDO> queryOecpConfig(OecpConfigQC qc){

        List<OecpConfigDO> oecpConfigs = oecpConfigMapper.listOecpConfigs(qc);
        return oecpConfigs;
    }
    

    @Override
    public Long countOecpConfig(OecpConfigQC qc){

        Long count = oecpConfigMapper.countOecpConfigs(qc);
        return count;
    }

    @Override
    public OecpConfigDO saveOecpConfig(OecpConfigDO oecpConfig){

        if(oecpConfig.getId()!=null){
            oecpConfig.preUpdate();
             oecpConfigMapper.updateOecpConfig(oecpConfig);
        }else {
            oecpConfig.preInsert();
             oecpConfigMapper.insertOecpConfig(oecpConfig);
        }
        return oecpConfig;

    }

    @Override
    public int removeOecpConfigById(Long id){

        return oecpConfigMapper.removeOecpConfigById(id);

    }


}
