package com.platform.oecp.business.manager;


import com.platform.oecp.models.dos.OecpRoleDO;
import com.platform.oecp.models.qc.OecpRoleQC;

import java.util.List;


public interface OecpRoleManager {

    public OecpRoleDO getOecpRoleById (Long id);


    public List<OecpRoleDO> queryOecpRole(OecpRoleQC qc);


    public Long countOecpRole(OecpRoleQC oecpRole);

    public OecpRoleDO saveOecpRole(OecpRoleDO oecpRole);

    public int removeOecpRoleById(Long id);



}
