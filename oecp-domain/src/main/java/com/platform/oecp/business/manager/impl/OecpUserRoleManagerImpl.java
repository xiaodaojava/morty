package com.platform.oecp.business.manager.impl;

import com.platform.oecp.models.dos.OecpUserRoleDO;
import com.platform.oecp.models.qc.OecpUserRoleQC;
import red.lixiang.tools.jdk.ListTools;
import com.platform.oecp.business.manager.OecpUserRoleManager;
import com.platform.oecp.dao.OecpUserRoleMapper;
import red.lixiang.tools.common.mybatis.model.Page;
import red.lixiang.tools.common.mybatis.model.Sort;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class OecpUserRoleManagerImpl implements OecpUserRoleManager{

    @Autowired
    private OecpUserRoleMapper oecpUserRoleMapper;
    
    @Override
    public OecpUserRoleDO getOecpUserRoleById(Long id) {
        OecpUserRoleQC qc = new OecpUserRoleQC();
        qc.setId(id);
        qc.setPage(Page.getOne());
        List<OecpUserRoleDO> oecpUserRoleDOS = queryOecpUserRole(qc);
        return ListTools.getOne(oecpUserRoleDOS);
    }
    

    @Override
    public List<OecpUserRoleDO> queryOecpUserRole(OecpUserRoleQC qc){

        List<OecpUserRoleDO> oecpUserRoles = oecpUserRoleMapper.listOecpUserRoles(qc);
        return oecpUserRoles;
    }
    

    @Override
    public Long countOecpUserRole(OecpUserRoleQC qc){

        Long count = oecpUserRoleMapper.countOecpUserRoles(qc);
        return count;
    }

    @Override
    public OecpUserRoleDO saveOecpUserRole(OecpUserRoleDO oecpUserRole){

        if(oecpUserRole.getId()!=null){
            oecpUserRole.preUpdate();
             oecpUserRoleMapper.updateOecpUserRole(oecpUserRole);
        }else {
            oecpUserRole.preInsert();
             oecpUserRoleMapper.insertOecpUserRole(oecpUserRole);
        }
        return oecpUserRole;

    }

    @Override
    public int removeOecpUserRoleById(Long id){

        return oecpUserRoleMapper.removeOecpUserRoleById(id);

    }


}
