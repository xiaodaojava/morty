package com.platform.oecp.business.manager;

import com.platform.oecp.models.document.OecpErrorDocument;

import java.io.IOException;
import java.util.List;

/**
 * 和 ES 交互的接口
 *
 * @author: dingaimin
 * @date: 2020/3/20 20:57
 */
public interface OecpErrorInfoEsManager {

    public String createErrorCodeIndex() throws IOException;

    public OecpErrorDocument findByErrorCode(String errorCode) ;

    public String editErrorCode(OecpErrorDocument document) throws IOException;

    public List<OecpErrorDocument> searchErrorCode(String info) throws Exception;

    public List<OecpErrorDocument> suggestErrorCode(String info) throws Exception;

    public String deleteErrorCode(String id) throws IOException;
}
