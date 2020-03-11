package com.platform.oecp.business.manager;


import com.platform.oecp.models.dos.OecpTagDO;
import com.platform.oecp.models.qc.OecpTagQC;

import red.lixiang.tools.common.mybatis.model.Page;
import red.lixiang.tools.common.mybatis.model.Sort;
import java.util.List;


public interface OecpTagManager {

    public OecpTagDO getOecpTagById (Long id);


    public List<OecpTagDO> queryOecpTag(OecpTagQC qc);


    public Long countOecpTag(OecpTagQC oecpTag);

    public OecpTagDO saveOecpTag(OecpTagDO oecpTag);

    public int removeOecpTagById(Long id);



}
