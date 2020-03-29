package com.platform.oecp.factory;

import com.platform.oecp.models.document.ErrorCase;
import com.platform.oecp.models.document.ErrorTag;
import com.platform.oecp.models.document.OecpErrorDocument;
import com.platform.oecp.models.request.OecpCaseInfoRequest;
import com.platform.oecp.models.request.OecpErrorInfoRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @className: EsDocumentFactory
 * @author: LILIANG
 * @date: Create In 2020/3/29 21:52
 * @description:
 */
@Component
public class OecpErrorDocumentFactory {

    /**
     * @author: LILIANG
     * @date: 2020/3/29 22:26
     * @Param : oecpErrorInfoRequest
     * @return: com.platform.oecp.models.document.OecpErrorDocument
     * @description: 创建es请求入参实体
     */
    public OecpErrorDocument createNewInstance(OecpErrorInfoRequest oecpErrorInfoRequest){
        OecpErrorDocument oecpErrorDocument = new OecpErrorDocument();
        oecpErrorDocument.setErrorCode(oecpErrorInfoRequest.getCode());
        oecpErrorDocument.setErrorDesc(oecpErrorInfoRequest.getErrorDesc());
        oecpErrorDocument.setErrorMsg(oecpErrorInfoRequest.getErrorInfo());
        oecpErrorDocument.setErrorTag(oecpErrorInfoRequest.getTags());
        List<ErrorCase> errorCases = new ArrayList<>();
        for(OecpCaseInfoRequest oecpCaseInfoRequest:oecpErrorInfoRequest.getOecpCaseInfoRequests()){
            ErrorCase errorCase = new ErrorCase();
            errorCase.setId(String.valueOf(oecpCaseInfoRequest.getCaseId()));
            errorCase.setTitle(oecpCaseInfoRequest.getTitle());
            errorCase.setTitleForSearch(oecpCaseInfoRequest.getTitleForSearch());
            errorCase.setContentForSearch(oecpCaseInfoRequest.getContentForSearch());
            errorCase.setCaseTag(oecpCaseInfoRequest.getTags());
            errorCases.add(errorCase);
        }
        oecpErrorDocument.setErrorCase(errorCases);
        return oecpErrorDocument;
    }
}
