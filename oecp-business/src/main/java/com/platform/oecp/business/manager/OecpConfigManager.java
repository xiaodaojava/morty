package com.platform.oecp.business.manager;


import com.platform.oecp.models.dos.OecpConfigDO;
import com.platform.oecp.models.qc.OecpConfigQC;

import red.lixiang.tools.common.mybatis.model.Page;
import red.lixiang.tools.common.mybatis.model.Sort;
import java.util.List;


public interface OecpConfigManager {

    public OecpConfigDO getOecpConfigById (Long id);


    public List<OecpConfigDO> queryOecpConfig(OecpConfigQC qc);


    public Long countOecpConfig(OecpConfigQC oecpConfig);

    public OecpConfigDO saveOecpConfig(OecpConfigDO oecpConfig);

    public int removeOecpConfigById(Long id);



}
