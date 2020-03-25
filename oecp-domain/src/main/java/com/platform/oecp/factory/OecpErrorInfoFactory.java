package com.platform.oecp.factory;

import com.platform.oecp.models.dos.OecpErrorInfoDO;
import com.platform.oecp.models.request.OecpErrorInfoRequest;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @className: OecpErrorInfoFactory
 * @author: LILIANG
 * @date: Create In 2020/3/25 0:04
 * @description:
 */
@Component
public class OecpErrorInfoFactory {

    /**
     * @author: LILIANG
     * @date: 2020/3/25 0:06
     * @Param : oecpErrorInfoRequest
     * @return: com.platform.oecp.models.dos.OecpErrorInfoDO
     * @description: 创建错误实体对象
     */
    public OecpErrorInfoDO createNewInstance(OecpErrorInfoRequest oecpErrorInfoRequest){
        OecpErrorInfoDO oecpErrorInfoDO = new OecpErrorInfoDO();
        oecpErrorInfoDO.setId(oecpErrorInfoRequest.getCodeId());
        oecpErrorInfoDO.setCode(oecpErrorInfoRequest.getCode());
        oecpErrorInfoDO.setErrorInfo(oecpErrorInfoRequest.getErrorInfo());
        oecpErrorInfoDO.setRemarks(oecpErrorInfoRequest.getErrorDesc());
        return oecpErrorInfoDO;
    }
}
