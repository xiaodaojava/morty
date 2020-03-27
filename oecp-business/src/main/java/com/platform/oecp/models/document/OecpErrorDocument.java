package com.platform.oecp.models.document;

import java.util.List;

/**
 * @author: dingaimin
 * @date: 2020/3/20 21:01
 */
public class OecpErrorDocument {

    private String errorCode;
    private String errorMsg;
    private String errorDesc;
    private List<ErrorTag> errorTag;
    private List<ErrorCase> errorCase;
    private List<CaseTag> caseTag;

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

    public List<ErrorTag> getErrorTag() {
        return errorTag;
    }

    public void setErrorTag(List<ErrorTag> errorTag) {
        this.errorTag = errorTag;
    }

    public List<ErrorCase> getErrorCase() {
        return errorCase;
    }

    public void setErrorCase(List<ErrorCase> errorCase) {
        this.errorCase = errorCase;
    }

    public List<CaseTag> getCaseTag() {
        return caseTag;
    }

    public void setCaseTag(List<CaseTag> caseTag) {
        this.caseTag = caseTag;
    }
}
