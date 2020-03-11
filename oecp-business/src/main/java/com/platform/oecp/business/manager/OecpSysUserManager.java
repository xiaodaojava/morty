package com.platform.oecp.business.manager;


import com.platform.oecp.models.dos.OecpSysUserDO;
import com.platform.oecp.models.qc.OecpSysUserQC;

import red.lixiang.tools.common.mybatis.model.Page;
import red.lixiang.tools.common.mybatis.model.Sort;
import java.util.List;


public interface OecpSysUserManager {

    public OecpSysUserDO getOecpSysUserById (Long id);


    public List<OecpSysUserDO> queryOecpSysUser(OecpSysUserQC qc);


    public Long countOecpSysUser(OecpSysUserQC oecpSysUser);

    public OecpSysUserDO saveOecpSysUser(OecpSysUserDO oecpSysUser);

    public int removeOecpSysUserById(Long id);



}
