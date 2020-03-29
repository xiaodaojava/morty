package com.platform.oecp.dto;

import com.platform.oecp.dto.CaseInfoDto;
import com.platform.oecp.dto.OecpTagDto;

import java.io.Serializable;
import java.util.List;

/**
 * @version 1.0
 * @className: ErrorInfoAndCaseDto
 * @author: LILIANG
 * @date: Create In 2020/3/28 20:19
 * @description:
 */
public class ErrorInfoAndCaseDto implements Serializable {

    /** 错误码ID  */
    private Long codeId;

    /** 备注信息  */
    private String errorMsg;

    /** 错误码  */
    private String code;

    /** 错误信息  */
    private String errorInfo;

    /** 错误标签  */
    private List<OecpTagDto> errorTags;

    /** 错误对应得案列信息  */
    private List<CaseInfoDto> caseInfos;

    public Long getCodeId() {
        return codeId;
    }

    public void setCodeId(Long codeId) {
        this.codeId = codeId;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    public List<OecpTagDto> getErrorTags() {
        return errorTags;
    }

    public void setErrorTags(List<OecpTagDto> errorTags) {
        this.errorTags = errorTags;
    }

    public List<CaseInfoDto> getCaseInfos() {
        return caseInfos;
    }

    public void setCaseInfos(List<CaseInfoDto> caseInfos) {
        this.caseInfos = caseInfos;
    }

    @Override
    public String toString() {
        return "ErrorInfoAndCaseDto{" +
                "codeId=" + codeId +
                ", errorMsg='" + errorMsg + '\'' +
                ", code='" + code + '\'' +
                ", errorInfo='" + errorInfo + '\'' +
                ", errorTags=" + errorTags +
                ", caseInfos=" + caseInfos +
                '}';
    }
}
