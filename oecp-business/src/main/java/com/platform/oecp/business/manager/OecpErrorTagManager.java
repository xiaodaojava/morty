package com.platform.oecp.business.manager;


import com.platform.oecp.models.dos.OecpErrorTagDO;
import com.platform.oecp.models.qc.OecpErrorTagQC;

import red.lixiang.tools.common.mybatis.model.Page;
import red.lixiang.tools.common.mybatis.model.Sort;
import java.util.List;


public interface OecpErrorTagManager {

    public OecpErrorTagDO getOecpErrorTagById (Long id);


    public List<OecpErrorTagDO> queryOecpErrorTag(OecpErrorTagQC qc);


    public Long countOecpErrorTag(OecpErrorTagQC oecpErrorTag);

    public OecpErrorTagDO saveOecpErrorTag(OecpErrorTagDO oecpErrorTag);

    public int removeOecpErrorTagById(Long id);



}
