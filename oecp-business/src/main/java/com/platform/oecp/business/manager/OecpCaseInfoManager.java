package com.platform.oecp.business.manager;


import com.platform.oecp.models.dos.OecpCaseInfoDO;
import com.platform.oecp.models.qc.OecpCaseInfoQC;

import red.lixiang.tools.common.mybatis.model.Page;
import red.lixiang.tools.common.mybatis.model.Sort;
import java.util.List;


public interface OecpCaseInfoManager {

    public OecpCaseInfoDO getOecpCaseInfoById (Long id);


    public List<OecpCaseInfoDO> queryOecpCaseInfo(OecpCaseInfoQC qc);


    public Long countOecpCaseInfo(OecpCaseInfoQC oecpCaseInfo);

    public OecpCaseInfoDO saveOecpCaseInfo(OecpCaseInfoDO oecpCaseInfo);

    public int removeOecpCaseInfoById(Long id);



}
