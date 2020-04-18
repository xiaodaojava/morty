package com.platform.oecp.business.manager;


import com.platform.oecp.models.dos.OecpErrorTagDO;
import com.platform.oecp.models.qc.OecpErrorTagQC;

import java.util.List;
import java.util.Set;


public interface OecpErrorTagManager {

    public OecpErrorTagDO getOecpErrorTagById (Long id);

    public List<OecpErrorTagDO> queryOecpErrorTag(OecpErrorTagQC qc);


    public Long countOecpErrorTag(OecpErrorTagQC oecpErrorTag);

    public OecpErrorTagDO saveOecpErrorTag(OecpErrorTagDO oecpErrorTag);

    public int removeOecpErrorTagById(Long id);

    List<OecpErrorTagDO> listOecpErrorTagByIds(Set<Long> codeIdSet);
}
