package com.platform.oecp.models.response;

import java.io.Serializable;

/**
 * @version 1.0
 * @className: response
 * @author: LILIANG
 * @date: Create In 2020/3/16 10:15
 * @description: 服务接口有响应  可以选择响应服务接口信息
 */
public class ResponseBase implements Serializable {
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 返回信息
     */
    private String msg;
    /**
     * 返回数据
     */
    private Object data;

    public ResponseBase() {

    }

    public ResponseBase(Integer code, String msg, Object data) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseBase{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
