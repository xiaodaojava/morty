package com.platform.oecp.business.manager;


import com.platform.oecp.models.dos.OecpSearchMainDO;
import com.platform.oecp.models.qc.OecpSearchMainQC;

import red.lixiang.tools.common.mybatis.model.Page;
import red.lixiang.tools.common.mybatis.model.Sort;
import java.util.List;


public interface OecpSearchMainManager {

    public OecpSearchMainDO getOecpSearchMainById (Long id);


    public List<OecpSearchMainDO> queryOecpSearchMain(OecpSearchMainQC qc);


    public Long countOecpSearchMain(OecpSearchMainQC oecpSearchMain);

    public OecpSearchMainDO saveOecpSearchMain(OecpSearchMainDO oecpSearchMain);

    public int removeOecpSearchMainById(Long id);



}
