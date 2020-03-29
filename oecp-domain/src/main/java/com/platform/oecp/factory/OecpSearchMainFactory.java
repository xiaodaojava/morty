package com.platform.oecp.factory;

import com.platform.oecp.models.dos.OecpErrorInfoDO;
import com.platform.oecp.models.dos.OecpSearchMainDO;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @className: OecpSearchMainFactory
 * @author: LILIANG
 * @date: Create In 2020/3/29 17:45
 * @description:
 */
@Component
public class OecpSearchMainFactory {

    /**
     * @author: LILIANG
     * @date: 2020/3/29 17:47
     * @Param : oecpErrorInfoDO
     * @return: com.platform.oecp.models.dos.OecpSearchMainDO
     * @description: 创建searchMain实例
     */
    public OecpSearchMainDO createNewInstance(OecpErrorInfoDO oecpErrorInfoDO){
        OecpSearchMainDO oecpSearchMainDO = new OecpSearchMainDO();
        oecpSearchMainDO.setErrorCode(oecpErrorInfoDO.getCode());
        oecpSearchMainDO.setErrorDesc(oecpErrorInfoDO.getRemarks());
        oecpSearchMainDO.setErrorMsg(oecpErrorInfoDO.getErrorInfo());
        oecpSearchMainDO.setErrorTag(oecpErrorInfoDO.getId());
        return oecpSearchMainDO;
    }
}
