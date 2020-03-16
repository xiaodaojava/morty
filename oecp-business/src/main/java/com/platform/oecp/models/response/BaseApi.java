package com.platform.oecp.models.response;

/**
 * @version 1.0
 * @className: BaseApi
 * @author: LILIANG
 * @date: Create In 2020/3/16 10:20
 * @description:
 */
public class BaseApi {

    /**
     * @author: LILIANG
     * @date: 2020/3/16 10:21
     * @Param : code
     * @Param : msg
     * @return: com.platform.oecp.models.response.ResponseBase
     * @description: 设置结果错误-通用方式
     */
    public ResponseBase setResultError(Integer code, String msg) {
        return setResult(code, msg, null);
    }

    /**
     * @author: LILIANG
     * @date: 2020/3/16 10:21
     * @Param : msg
     * @return: com.platform.oecp.models.response.ResponseBase
     * @description: 返回错误，可以传msg
     */
    public ResponseBase setResultError(String msg) {
        return setResult(500, msg, null);
    }

    /**
     * @author: LILIANG
     * @date: 2020/3/16 10:22
     * @Param : data
     * @return: com.platform.oecp.models.response.ResponseBase
     * @description: 返回成功，可以传data值
     */
    public ResponseBase setResultSuccess(Object data) {
        return setResult(200, "处理成功", data);
    }

    /**
     * @author: LILIANG
     * @date: 2020/3/16 10:22
     *
     * @return: com.platform.oecp.models.response.ResponseBase
     * @description: 返回成功，沒有data值
     */
    public ResponseBase setResultSuccess() {
        return setResult(200, "处理成功", null);
    }

    /**
     * @author: LILIANG
     * @date: 2020/3/16 10:22
     * @Param : msg
     * @return: com.platform.oecp.models.response.ResponseBase
     * @description: 返回成功，沒有data值
     */
    public ResponseBase setResultSuccess(String msg) {
        return setResult(200, msg, null);
    }

    /**
     * @author: LILIANG
     * @date: 2020/3/16 10:23
     * @Param : code
     * @Param : msg
     * @Param : data
     * @return: com.platform.oecp.models.response.ResponseBase
     * @description: 通用封装
     */
    public ResponseBase setResult(Integer code, String msg, Object data) {
        return new ResponseBase(code, msg, data);
    }
}
