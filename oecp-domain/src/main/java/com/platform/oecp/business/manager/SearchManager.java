package com.platform.oecp.business.manager;

import com.platform.oecp.factory.OecpErrorDocumentFactory;
import com.platform.oecp.models.document.CaseTag;
import com.platform.oecp.models.document.ErrorCase;
import com.platform.oecp.models.document.OecpErrorDocument;
import com.platform.oecp.models.dos.OecpErrorInfoDO;
import com.platform.oecp.models.request.OecpCaseInfoRequest;
import com.platform.oecp.models.request.OecpDeleteCaseInfoRequest;
import com.platform.oecp.models.request.OecpErrorInfoRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @version 1.0
 * @className: SearchManager
 * @author: LILIANG
 * @date: Create In 2020/3/29 16:19
 * @description:
 */
@Service
public class SearchManager {

    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(SearchManager.class);

    @Autowired
    private OecpErrorInfoEsManager oecpErrorInfoEsManager;

    @Autowired
    private OecpErrorDocumentFactory oecpErrorDocumentFactory;

    @Autowired
    private OecpErrorInfoManager oecpErrorInfoManager;

    @Async
    public void saveEsContent(OecpErrorDocument esOecpErrorDocument,OecpErrorInfoRequest oecpErrorInfoRequest, OecpCaseInfoRequest oecpCaseInfoRequest,String errorCode, OecpDeleteCaseInfoRequest oecpDeleteCaseInfoRequest) {
        // 异步把错误码信息入到 ES 中
        CompletableFuture.runAsync(() -> {
            String result = null;
            try {
                if(oecpErrorInfoRequest != null) {
                    OecpErrorDocument oecpErrorDocument = oecpErrorDocumentFactory.createNewInstance(oecpErrorInfoRequest);
                    result = oecpErrorInfoEsManager.editErrorCode(oecpErrorDocument);
                }
                if(esOecpErrorDocument != null){
                    result = oecpErrorInfoEsManager.editErrorCode(esOecpErrorDocument);
                }
                if(oecpCaseInfoRequest != null){
                    OecpErrorInfoDO oecpErrorInfoDO = oecpErrorInfoManager.getOecpErrorInfoById(oecpCaseInfoRequest.getCodeId());
                    OecpErrorDocument oecpErrorDocument = oecpErrorInfoEsManager.findByErrorCode(oecpErrorInfoDO.getCode());
                    for(ErrorCase errorCase:oecpErrorDocument.getErrorCase()){
                        if(oecpCaseInfoRequest.getCaseId().equals(errorCase.getId())){
                            errorCase.setTitle(oecpCaseInfoRequest.getTitle());
                            errorCase.setTitleForSearch(oecpCaseInfoRequest.getTitleForSearch());
                            errorCase.setContentForSearch(oecpCaseInfoRequest.getContentForSearch());
                            List<CaseTag> caseTags = new ArrayList<>();
                            for(CaseTag caseTag:oecpCaseInfoRequest.getTags()) {
                                caseTags.add(caseTag);
                            }
                            errorCase.setCaseTag(caseTags);
                        }
                    }
                    result = oecpErrorInfoEsManager.editErrorCode(oecpErrorDocument);
                }
                if(errorCode != null){
                    result = oecpErrorInfoEsManager.deleteErrorCode(errorCode);
                }
                if(oecpDeleteCaseInfoRequest != null){
                    OecpErrorInfoDO oecpErrorInfoDO = oecpErrorInfoManager.getOecpErrorInfoById(oecpDeleteCaseInfoRequest.getCodeId());
                    OecpErrorDocument oecpErrorDocument = oecpErrorInfoEsManager.findByErrorCode(oecpErrorInfoDO.getCode());
                    //todo:案例删除
                    result = oecpErrorInfoEsManager.editErrorCode(oecpErrorDocument);
                }
            } catch (IOException e) {
                logger.error("编辑错误码信息同步到 ES 中发生异常，错误码 {}，", oecpErrorInfoRequest.getCode(), e);
            }
            logger.info("更新错误码异步更新到 ES 响应结果 {}", result);
        }, ThreadPoolConfig.ioExecutor);
    }
}
