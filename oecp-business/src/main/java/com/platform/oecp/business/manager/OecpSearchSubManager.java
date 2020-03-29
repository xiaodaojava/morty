package com.platform.oecp.business.manager;


import com.platform.oecp.models.dos.OecpSearchSubDO;
import com.platform.oecp.models.qc.OecpSearchSubQC;

import red.lixiang.tools.common.mybatis.model.Page;
import red.lixiang.tools.common.mybatis.model.Sort;
import java.util.List;


public interface OecpSearchSubManager {

    public OecpSearchSubDO getOecpSearchSubById (Long id);


    public List<OecpSearchSubDO> queryOecpSearchSub(OecpSearchSubQC qc);


    public Long countOecpSearchSub(OecpSearchSubQC oecpSearchSub);

    public OecpSearchSubDO saveOecpSearchSub(OecpSearchSubDO oecpSearchSub);

    public int removeOecpSearchSubById(Long id);

    int removeOecpSearchSubByMainId(Long mainId);

    int removeOecpSearchSubByCaseId(Long caseId);

}
