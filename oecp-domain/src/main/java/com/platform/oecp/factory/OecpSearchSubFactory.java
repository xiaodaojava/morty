package com.platform.oecp.factory;

import com.platform.oecp.models.dos.OecpCaseInfoDO;
import com.platform.oecp.models.dos.OecpSearchMainDO;
import com.platform.oecp.models.dos.OecpSearchSubDO;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @className: OecpSearchSubFactory
 * @author: LILIANG
 * @date: Create In 2020/3/29 17:46
 * @description:
 */
@Component
public class OecpSearchSubFactory {

    /**
     * @author: LILIANG
     * @date: 2020/3/29 17:54
     * @Param : oecpCaseInfoDO
     * @Param : oecpSearchMainDO
     * @return: com.platform.oecp.models.dos.OecpSearchSubDO
     * @description: 创建子搜寻表实例
     */
    public OecpSearchSubDO createNewInstance(OecpCaseInfoDO oecpCaseInfoDO, OecpSearchMainDO oecpSearchMainDO){
        OecpSearchSubDO oecpSearchSubDO = new OecpSearchSubDO();
        oecpSearchSubDO.setCaseTag(oecpCaseInfoDO.getId());
        oecpSearchSubDO.setTitle(oecpCaseInfoDO.getTitle());
        oecpSearchSubDO.setTitleForSearch(oecpCaseInfoDO.getTitleForSearch());
        oecpSearchSubDO.setContentForSearch(oecpCaseInfoDO.getContentForSearch());
        oecpSearchSubDO.setSearchMainId(oecpSearchMainDO.getId());
        return oecpSearchSubDO;
    }
}
