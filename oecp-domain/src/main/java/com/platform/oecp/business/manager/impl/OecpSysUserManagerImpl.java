package com.platform.oecp.business.manager.impl;

import com.platform.oecp.models.dos.OecpSysUserDO;
import com.platform.oecp.models.qc.OecpSysUserQC;
import red.lixiang.tools.jdk.ListTools;
import com.platform.oecp.business.manager.OecpSysUserManager;
import com.platform.oecp.dao.OecpSysUserMapper;
import red.lixiang.tools.common.mybatis.model.Page;
import red.lixiang.tools.common.mybatis.model.Sort;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class OecpSysUserManagerImpl implements OecpSysUserManager{

    @Autowired
    private OecpSysUserMapper oecpSysUserMapper;
    
    @Override
    public OecpSysUserDO getOecpSysUserById(Long id) {
        OecpSysUserQC qc = new OecpSysUserQC();
        qc.setId(id);
        qc.setPage(Page.getOne());
        List<OecpSysUserDO> oecpSysUserDOS = queryOecpSysUser(qc);
        return ListTools.getOne(oecpSysUserDOS);
    }
    

    @Override
    public List<OecpSysUserDO> queryOecpSysUser(OecpSysUserQC qc){

        List<OecpSysUserDO> oecpSysUsers = oecpSysUserMapper.listOecpSysUsers(qc);
        return oecpSysUsers;
    }
    

    @Override
    public Long countOecpSysUser(OecpSysUserQC qc){

        Long count = oecpSysUserMapper.countOecpSysUsers(qc);
        return count;
    }

    @Override
    public OecpSysUserDO saveOecpSysUser(OecpSysUserDO oecpSysUser){

        if(oecpSysUser.getId()!=null){
             oecpSysUserMapper.updateOecpSysUser(oecpSysUser);
        }else {
            oecpSysUser.setCreateDate(new Date());
             oecpSysUserMapper.insertOecpSysUser(oecpSysUser);
        }
        return oecpSysUser;

    }

    @Override
    public int removeOecpSysUserById(Long id){

        return oecpSysUserMapper.removeOecpSysUserById(id);

    }


}
