package com.platform.oecp.business.manager;


import com.platform.oecp.models.dos.OecpCaseTagDO;
import com.platform.oecp.models.qc.OecpCaseTagQC;

import red.lixiang.tools.common.mybatis.model.Page;
import red.lixiang.tools.common.mybatis.model.Sort;
import java.util.List;


public interface OecpCaseTagManager {

    public OecpCaseTagDO getOecpCaseTagById (Long id);


    public List<OecpCaseTagDO> queryOecpCaseTag(OecpCaseTagQC qc);


    public Long countOecpCaseTag(OecpCaseTagQC oecpCaseTag);

    public OecpCaseTagDO saveOecpCaseTag(OecpCaseTagDO oecpCaseTag);

    public int removeOecpCaseTagById(Long id);

    int removeOecpCaseTagByCaseId(Long caseId);

}
