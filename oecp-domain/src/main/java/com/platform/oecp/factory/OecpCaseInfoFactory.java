package com.platform.oecp.factory;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;
import com.platform.oecp.models.dos.OecpCaseInfoDO;
import com.platform.oecp.models.request.OecpCaseInfoRequest;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;

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
        List<Term> terms = HanLP.segment(oecpCaseInfoRequest.getTitle());
        Iterator iterator = terms.iterator();
        String title = null;
        while(iterator.hasNext()){
            title = title + iterator.next()+"|";
        }
        oecpCaseInfoDO.setTitleForSearch(title);
        oecpCaseInfoDO.setContentForSearch(HanLP.extractSummary(oecpCaseInfoRequest.getTitle(), 1).get(0));
        oecpCaseInfoDO.setId(oecpCaseInfoRequest.getCaseId());
        return oecpCaseInfoDO;
    }
}
