package com.platform.oecp.models.document;

import java.util.List;

/**
 * @author: dingaimin
 * @date: 2020/3/20 21:01
 */
public class OecpErrorDocument {

    private String id;
    private String errorCode;
    private String errorMsg;
    private String errorDesc;
    private List<String> errorTag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public void setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
    }

    public List<String> getErrorTag() {
        return errorTag;
    }

    public void setErrorTag(List<String> errorTag) {
        this.errorTag = errorTag;
    }

    @Override
    public String toString() {
        return "OecpErrorDocument{" +
                "id='" + id + '\'' +
                ", errorCode='" + errorCode + '\'' +
                ", errorMsg='" + errorMsg + '\'' +
                ", errorDesc='" + errorDesc + '\'' +
                ", errorTag=" + errorTag +
                '}';
    }
}
