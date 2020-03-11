package com.platform.oecp.business.manager;


import com.platform.oecp.models.dos.OecpRoleSrcDO;
import com.platform.oecp.models.qc.OecpRoleSrcQC;

import red.lixiang.tools.common.mybatis.model.Page;
import red.lixiang.tools.common.mybatis.model.Sort;
import java.util.List;


public interface OecpRoleSrcManager {

    public OecpRoleSrcDO getOecpRoleSrcById (Long id);


    public List<OecpRoleSrcDO> queryOecpRoleSrc(OecpRoleSrcQC qc);


    public Long countOecpRoleSrc(OecpRoleSrcQC oecpRoleSrc);

    public OecpRoleSrcDO saveOecpRoleSrc(OecpRoleSrcDO oecpRoleSrc);

    public int removeOecpRoleSrcById(Long id);



}
