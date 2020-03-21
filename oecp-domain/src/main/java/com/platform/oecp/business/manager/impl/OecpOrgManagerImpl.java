package com.platform.oecp.business.manager.impl;

import com.platform.oecp.models.dos.OecpOrgDO;
import com.platform.oecp.models.qc.OecpOrgQC;
import red.lixiang.tools.jdk.ListTools;
import com.platform.oecp.business.manager.OecpOrgManager;
import com.platform.oecp.dao.OecpOrgMapper;
import red.lixiang.tools.common.mybatis.model.Page;
import red.lixiang.tools.common.mybatis.model.Sort;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class OecpOrgManagerImpl implements OecpOrgManager{

    @Autowired
    private OecpOrgMapper oecpOrgMapper;
    
    @Override
    public OecpOrgDO getOecpOrgById(Long id) {
        OecpOrgQC qc = new OecpOrgQC();
        qc.setId(id);
        qc.setPage(Page.getOne());
        List<OecpOrgDO> oecpOrgDOS = queryOecpOrg(qc);
        return ListTools.getOne(oecpOrgDOS);
    }
    

    @Override
    public List<OecpOrgDO> queryOecpOrg(OecpOrgQC qc){

        List<OecpOrgDO> oecpOrgs = oecpOrgMapper.listOecpOrgs(qc);
        return oecpOrgs;
    }
    

    @Override
    public Long countOecpOrg(OecpOrgQC qc){

        Long count = oecpOrgMapper.countOecpOrgs(qc);
        return count;
    }

    @Override
    public OecpOrgDO saveOecpOrg(OecpOrgDO oecpOrg){

        if(oecpOrg.getId()!=null){
            oecpOrg.preUpdate();
             oecpOrgMapper.updateOecpOrg(oecpOrg);
        }else {
            oecpOrg.preInsert();
             oecpOrgMapper.insertOecpOrg(oecpOrg);
        }
        return oecpOrg;

    }

    @Override
    public int removeOecpOrgById(Long id){

        return oecpOrgMapper.removeOecpOrgById(id);

    }


}
