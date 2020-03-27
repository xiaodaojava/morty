package com.platform.oecp.business.manager.impl;

import com.platform.oecp.dao.OecpSearchUseMapper;
import com.platform.oecp.models.dos.OecpSearchUseDO;
import com.platform.oecp.models.qc.OecpSearchUseQC;
import red.lixiang.tools.jdk.ListTools;
import com.platform.oecp.business.manager.OecpSearchUseManager;
import red.lixiang.tools.common.mybatis.model.Page;
import red.lixiang.tools.common.mybatis.model.Sort;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class OecpSearchUseManagerImpl implements OecpSearchUseManager{

    @Autowired
    private OecpSearchUseMapper oecpSearchUseMapper;
    
    @Override
    public OecpSearchUseDO getOecpSearchUseById(Long id) {
        OecpSearchUseQC qc = new OecpSearchUseQC();
        qc.setId(id);
        qc.setPage(Page.getOne());
        List<OecpSearchUseDO> oecpSearchUseDOS = queryOecpSearchUse(qc);
        return ListTools.getOne(oecpSearchUseDOS);
    }
    

    @Override
    public List<OecpSearchUseDO> queryOecpSearchUse(OecpSearchUseQC qc){

        List<OecpSearchUseDO> oecpSearchUses = oecpSearchUseMapper.listOecpSearchUses(qc);
        return oecpSearchUses;
    }
    

    @Override
    public Long countOecpSearchUse(OecpSearchUseQC qc){

        Long count = oecpSearchUseMapper.countOecpSearchUses(qc);
        return count;
    }

    @Override
    public OecpSearchUseDO saveOecpSearchUse(OecpSearchUseDO oecpSearchUse){

        if(oecpSearchUse.getId()!=null){
             oecpSearchUseMapper.updateOecpSearchUse(oecpSearchUse);
        }else {
            oecpSearchUse.setCreateDate(new Date());
             oecpSearchUseMapper.insertOecpSearchUse(oecpSearchUse);
        }
        return oecpSearchUse;

    }

    @Override
    public int removeOecpSearchUseById(Long id){

        return oecpSearchUseMapper.removeOecpSearchUseById(id);

    }


}
