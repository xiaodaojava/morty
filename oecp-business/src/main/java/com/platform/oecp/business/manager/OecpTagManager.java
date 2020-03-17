package com.platform.oecp.business.manager;


import com.platform.oecp.models.dos.OecpTagDO;
import com.platform.oecp.models.qc.OecpTagQC;

import java.util.List;


public interface OecpTagManager {

    public OecpTagDO getOecpTagById (Long id);


    public List<OecpTagDO> queryOecpTag(OecpTagQC qc);

    public List<OecpTagDO> searchByTag(String tag);


    public Long countOecpTag(OecpTagQC oecpTag);

    public OecpTagDO saveOecpTag(OecpTagDO oecpTag);

    public int removeOecpTagById(Long id);



}
