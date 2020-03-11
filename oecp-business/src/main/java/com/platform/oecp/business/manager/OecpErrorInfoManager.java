package com.platform.oecp.business.manager;


import com.platform.oecp.models.dos.OecpErrorInfoDO;
import com.platform.oecp.models.qc.OecpErrorInfoQC;

import red.lixiang.tools.common.mybatis.model.Page;
import red.lixiang.tools.common.mybatis.model.Sort;
import java.util.List;


public interface OecpErrorInfoManager {

    public OecpErrorInfoDO getOecpErrorInfoById (Long id);


    public List<OecpErrorInfoDO> queryOecpErrorInfo(OecpErrorInfoQC qc);


    public Long countOecpErrorInfo(OecpErrorInfoQC oecpErrorInfo);

    public OecpErrorInfoDO saveOecpErrorInfo(OecpErrorInfoDO oecpErrorInfo);

    public int removeOecpErrorInfoById(Long id);



}
