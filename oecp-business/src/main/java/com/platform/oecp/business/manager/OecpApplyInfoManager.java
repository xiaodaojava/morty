package com.platform.oecp.business.manager;


import com.platform.oecp.models.dos.OecpApplyInfoDO;
import com.platform.oecp.models.qc.OecpApplyInfoQC;

import red.lixiang.tools.common.mybatis.model.Page;
import red.lixiang.tools.common.mybatis.model.Sort;
import java.util.List;


public interface OecpApplyInfoManager {

    public OecpApplyInfoDO getOecpApplyInfoById (Long id);


    public List<OecpApplyInfoDO> queryOecpApplyInfo(OecpApplyInfoQC qc);


    public Long countOecpApplyInfo(OecpApplyInfoQC oecpApplyInfo);

    public OecpApplyInfoDO saveOecpApplyInfo(OecpApplyInfoDO oecpApplyInfo);

    public int removeOecpApplyInfoById(Long id);



}
