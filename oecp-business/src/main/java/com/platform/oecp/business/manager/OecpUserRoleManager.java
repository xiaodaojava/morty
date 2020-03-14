package com.platform.oecp.business.manager;


import com.platform.oecp.models.dos.OecpUserRoleDO;
import com.platform.oecp.models.qc.OecpUserRoleQC;

import java.util.List;


public interface OecpUserRoleManager {

    public OecpUserRoleDO getOecpUserRoleById (Long id);


    public List<OecpUserRoleDO> queryOecpUserRole(OecpUserRoleQC qc);


    public Long countOecpUserRole(OecpUserRoleQC oecpUserRole);

    public OecpUserRoleDO saveOecpUserRole(OecpUserRoleDO oecpUserRole);

    public int removeOecpUserRoleById(Long id);



}
