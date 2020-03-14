package com.platform.oecp.business.manager;


import com.platform.oecp.models.dos.OecpOrgDO;
import com.platform.oecp.models.qc.OecpOrgQC;

import java.util.List;


public interface OecpOrgManager {

    public OecpOrgDO getOecpOrgById (Long id);


    public List<OecpOrgDO> queryOecpOrg(OecpOrgQC qc);


    public Long countOecpOrg(OecpOrgQC oecpOrg);

    public OecpOrgDO saveOecpOrg(OecpOrgDO oecpOrg);

    public int removeOecpOrgById(Long id);



}
