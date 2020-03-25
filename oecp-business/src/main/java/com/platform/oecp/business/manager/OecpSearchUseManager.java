package com.platform.oecp.business.manager;


import com.platform.oecp.models.dos.OecpSearchUseDO;
import com.platform.oecp.models.qc.OecpSearchUseQC;

import red.lixiang.tools.common.mybatis.model.Page;
import red.lixiang.tools.common.mybatis.model.Sort;
import java.util.List;


public interface OecpSearchUseManager {

    public OecpSearchUseDO getOecpSearchUseById (Long id);


    public List<OecpSearchUseDO> queryOecpSearchUse(OecpSearchUseQC qc);


    public Long countOecpSearchUse(OecpSearchUseQC oecpSearchUse);

    public OecpSearchUseDO saveOecpSearchUse(OecpSearchUseDO oecpSearchUse);

    public int removeOecpSearchUseById(Long id);



}
