package com.platform.oecp.business.manager;


import com.platform.oecp.models.dos.OecpErrorCaseDO;
import com.platform.oecp.models.qc.OecpErrorCaseQC;

import java.util.List;


public interface OecpErrorCaseManager {

    public OecpErrorCaseDO getOecpErrorCaseById (Long id);


    public List<OecpErrorCaseDO> queryOecpErrorCase(OecpErrorCaseQC qc);


    public Long countOecpErrorCase(OecpErrorCaseQC oecpErrorCase);

    public OecpErrorCaseDO saveOecpErrorCase(OecpErrorCaseDO oecpErrorCase);

    public int removeOecpErrorCaseById(Long id);

    int removeOecpErrorCaseByCodeIdAndCaseId(Long codeId,Long caseId);

}
