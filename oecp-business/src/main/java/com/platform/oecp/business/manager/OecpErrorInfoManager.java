package com.platform.oecp.business.manager;


import com.platform.oecp.models.dos.OecpErrorInfoDO;
import com.platform.oecp.models.qc.OecpErrorInfoQC;
import com.platform.oecp.models.request.OecpErrorInfoRequest;

import javax.naming.CommunicationException;
import java.util.List;


public interface OecpErrorInfoManager {

    public OecpErrorInfoDO getOecpErrorInfoById (Long id);


    public List<OecpErrorInfoDO> queryOecpErrorInfo(OecpErrorInfoQC qc);


    public Long countOecpErrorInfo(OecpErrorInfoQC oecpErrorInfo);

    public OecpErrorInfoDO saveOecpErrorInfo(OecpErrorInfoDO oecpErrorInfo) throws CommunicationException;

    public int removeOecpErrorInfoById(Long id);



}
