package com.platform.oecp.factory;

import com.platform.oecp.models.dos.OecpCaseInfoDO;
import com.platform.oecp.models.request.OecpCaseInfoRequest;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @className: OecpCaseInfoFactory
 * @author: LILIANG
 * @date: Create In 2020/3/25 10:14
 * @description:
 */
@Component
public class OecpCaseInfoFactory {

    /**
     * @author: LILIANG
     * @date: 2020/3/25 10:17
     * @Param : oecpCaseInfoRequest
     * @return: com.platform.oecp.models.dos.OecpCaseInfoDO
     * @description: 创建案列实体
     */
    public OecpCaseInfoDO createNewInstance(OecpCaseInfoRequest oecpCaseInfoRequest){
        OecpCaseInfoDO oecpCaseInfoDO = new OecpCaseInfoDO();
        oecpCaseInfoDO.setTitle(oecpCaseInfoRequest.getTitle());
        oecpCaseInfoDO.setContent(oecpCaseInfoRequest.getContent());
        oecpCaseInfoDO.setTitleForSearch(oecpCaseInfoRequest.getTitleForSearch());
        oecpCaseInfoDO.setContentForSearch(oecpCaseInfoRequest.getContentForSearch());
        oecpCaseInfoDO.setId(oecpCaseInfoRequest.getCaseId());
        return oecpCaseInfoDO;
    }
}
