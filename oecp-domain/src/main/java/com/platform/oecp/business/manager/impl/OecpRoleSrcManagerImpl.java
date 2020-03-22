package com.platform.oecp.business.manager.impl;

import com.platform.oecp.models.dos.OecpRoleSrcDO;
import com.platform.oecp.models.qc.OecpRoleSrcQC;
import red.lixiang.tools.jdk.ListTools;
import com.platform.oecp.business.manager.OecpRoleSrcManager;
import com.platform.oecp.dao.OecpRoleSrcMapper;
import red.lixiang.tools.common.mybatis.model.Page;
import red.lixiang.tools.common.mybatis.model.Sort;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class OecpRoleSrcManagerImpl implements OecpRoleSrcManager{

    @Autowired
    private OecpRoleSrcMapper oecpRoleSrcMapper;
    
    @Override
    public OecpRoleSrcDO getOecpRoleSrcById(Long id) {
        OecpRoleSrcQC qc = new OecpRoleSrcQC();
        qc.setId(id);
        qc.setPage(Page.getOne());
        List<OecpRoleSrcDO> oecpRoleSrcDOS = queryOecpRoleSrc(qc);
        return ListTools.getOne(oecpRoleSrcDOS);
    }
    

    @Override
    public List<OecpRoleSrcDO> queryOecpRoleSrc(OecpRoleSrcQC qc){

        List<OecpRoleSrcDO> oecpRoleSrcs = oecpRoleSrcMapper.listOecpRoleSrcs(qc);
        return oecpRoleSrcs;
    }
    

    @Override
    public Long countOecpRoleSrc(OecpRoleSrcQC qc){

        Long count = oecpRoleSrcMapper.countOecpRoleSrcs(qc);
        return count;
    }

    @Override
    public OecpRoleSrcDO saveOecpRoleSrc(OecpRoleSrcDO oecpRoleSrc){

        if(oecpRoleSrc.getId()!=null){
            oecpRoleSrc.preUpdate();
             oecpRoleSrcMapper.updateOecpRoleSrc(oecpRoleSrc);
        }else {
            oecpRoleSrc.preInsert();
             oecpRoleSrcMapper.insertOecpRoleSrc(oecpRoleSrc);
        }
        return oecpRoleSrc;

    }

    @Override
    public int removeOecpRoleSrcById(Long id){

        return oecpRoleSrcMapper.removeOecpRoleSrcById(id);

    }


}
