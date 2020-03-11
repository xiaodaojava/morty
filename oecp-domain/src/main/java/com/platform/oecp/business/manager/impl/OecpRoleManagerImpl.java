package com.platform.oecp.business.manager.impl;

import com.platform.oecp.models.dos.OecpRoleDO;
import com.platform.oecp.models.qc.OecpRoleQC;
import red.lixiang.tools.jdk.ListTools;
import com.platform.oecp.business.manager.OecpRoleManager;
import com.platform.oecp.dao.OecpRoleMapper;
import red.lixiang.tools.common.mybatis.model.Page;
import red.lixiang.tools.common.mybatis.model.Sort;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class OecpRoleManagerImpl implements OecpRoleManager{

    @Autowired
    private OecpRoleMapper oecpRoleMapper;
    
    @Override
    public OecpRoleDO getOecpRoleById(Long id) {
        OecpRoleQC qc = new OecpRoleQC();
        qc.setId(id);
        qc.setPage(Page.getOne());
        List<OecpRoleDO> oecpRoleDOS = queryOecpRole(qc);
        return ListTools.getOne(oecpRoleDOS);
    }
    

    @Override
    public List<OecpRoleDO> queryOecpRole(OecpRoleQC qc){

        List<OecpRoleDO> oecpRoles = oecpRoleMapper.listOecpRoles(qc);
        return oecpRoles;
    }
    

    @Override
    public Long countOecpRole(OecpRoleQC qc){

        Long count = oecpRoleMapper.countOecpRoles(qc);
        return count;
    }

    @Override
    public OecpRoleDO saveOecpRole(OecpRoleDO oecpRole){

        if(oecpRole.getId()!=null){
             oecpRoleMapper.updateOecpRole(oecpRole);
        }else {
            oecpRole.setCreateDate(new Date());
             oecpRoleMapper.insertOecpRole(oecpRole);
        }
        return oecpRole;

    }

    @Override
    public int removeOecpRoleById(Long id){

        return oecpRoleMapper.removeOecpRoleById(id);

    }


}
