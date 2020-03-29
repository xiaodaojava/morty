package com.platform.oecp.admin.controller;

import com.platform.oecp.business.manager.OecpErrorInfoEsManager;
import com.platform.oecp.models.document.OecpErrorDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * @version 1.0
 * @className: OecpErrorInfoEsController
 * @author: LILIANG
 * @date: Create In 2020/3/29 11:29
 * @description:
 */
@RestController
@RequestMapping("es")
public class OecpErrorInfoEsController {

    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(OecpErrorInfoEsController.class);

    @Autowired
    private OecpErrorInfoEsManager oecpErrorInfoEsManager;

    /**
     * @author: LILIANG
     * @date: 2020/3/29 11:35
     * @Param : errorCode
     * @return: com.platform.oecp.models.document.OecpErrorDocument
     * @description: 通过错误码查找错误相关信息（包括案例和标签）
     */
    @GetMapping("/findByErrorCode")
    public OecpErrorDocument findByErrorCode(@RequestParam("errorCode")String errorCode){
        OecpErrorDocument oecpErrorDocument = null;
        try {
             oecpErrorDocument = oecpErrorInfoEsManager.findByErrorCode(errorCode);
        } catch (IOException e) {
            logger.info("es中信息查询异常，异常内容为：{}",e.getMessage());
        }
        return oecpErrorDocument;
    }

    /**
     * @author: LILIANG
     * @date: 2020/3/29 11:39
     * @Param : info
     * @return: java.util.List<com.platform.oecp.models.document.OecpErrorDocument>
     * @description: 通过错误信息查找相关错误码异常
     */
    @GetMapping("searchErrorCode")
    public List<OecpErrorDocument> searchErrorCode(@RequestParam("info") String info){
        List<OecpErrorDocument> oecpErrorDocuments = null;
        try {
            oecpErrorDocuments = oecpErrorInfoEsManager.searchErrorCode(info);
        } catch (IOException e) {
            logger.info("通过信息查找相关错误码异常，异常内容为：{}",e.getMessage());
        }
        return oecpErrorDocuments;
    }

    /**
     * @author: LILIANG
     * @date: 2020/3/29 11:42
     * @Param : info
     * @return: java.util.List<com.platform.oecp.models.document.OecpErrorDocument>
     * @description: 通过错误信息建议错误码
     */
    @GetMapping("suggestErrorCode")
    public List<OecpErrorDocument> suggestErrorCode(@RequestParam("info") String info){
        List<OecpErrorDocument> oecpErrorDocuments = null;
        try {
            oecpErrorDocuments = oecpErrorInfoEsManager.suggestErrorCode(info);
        } catch (IOException e) {
            logger.info("通过错误信息建议错误码异常，异常内容为：{}",e.getMessage());
        }
        return oecpErrorDocuments;
    }

    /**
     * @author: LILIANG
     * @date: 2020/3/29 12:02
     * @Param : errorCode
     * @return: java.lang.String
     * @description: 删除es中错误码信息
     */
    @PostMapping("deleteErrorCode")
    public String deleteErrorCode(@RequestParam("errorCode")String errorCode){
        String resultMsg = null;
        try {
            resultMsg = oecpErrorInfoEsManager.deleteErrorCode(errorCode);
        } catch (IOException e) {
            logger.info("删除es中错误码信息异常，异常内容为：{}",e.getMessage());
        }
        return resultMsg;
    }

}
