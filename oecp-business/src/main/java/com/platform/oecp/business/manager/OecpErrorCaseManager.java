package com.platform.oecp.business.manager;


import com.platform.oecp.models.dos.OecpErrorCaseDO;
import com.platform.oecp.models.qc.OecpErrorCaseQC;

import red.lixiang.tools.common.mybatis.model.Page;
import red.lixiang.tools.common.mybatis.model.Sort;
import java.util.List;


public interface OecpErrorCaseManager {

    public OecpErrorCaseDO getOecpErrorCaseById (Long id);


    public List<OecpErrorCaseDO> queryOecpErrorCase(OecpErrorCaseQC qc);


    public Long countOecpErrorCase(OecpErrorCaseQC oecpErrorCase);

    public OecpErrorCaseDO saveOecpErrorCase(OecpErrorCaseDO oecpErrorCase);

    public int removeOecpErrorCaseById(Long id);



}
