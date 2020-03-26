package com.platform.oecp.models.request;

import com.platform.oecp.dto.ErrorCaseDto;
import com.platform.oecp.dto.OecpTagDto;

import java.io.Serializable;
import java.util.List;

/**
 * @version 1.0
 * @className: EsSearchResponse
 * @author: LILIANG
 * @date: Create In 2020/3/26 23:01
 * @description:
 */
public class EsSearchRequest implements Serializable {
    /**
     * 主键ID
     */
    private Long id;
    /**
     * 错误码
     */
    private String errorCode;
    /**
     * 错误信息
     */
    private String errorMsg;
    /**
     * 错误描述
     */
    private String errorDesc;
    /**
     * 错误标签
     */
    private List<OecpTagDto> errorTag;

    /**
     * 案例标签
     */
    private List<OecpTagDto> caseTag;
    /**
     * 错误下对应的案例
     */
    private List<ErrorCaseDto> errorCase;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public List<OecpTagDto> getErrorTag() {
        return errorTag;
    }

    public void setErrorTag(List<OecpTagDto> errorTag) {
        this.errorTag = errorTag;
    }

    public List<OecpTagDto> getCaseTag() {
        return caseTag;
    }

    public void setCaseTag(List<OecpTagDto> caseTag) {
        this.caseTag = caseTag;
    }

    public List<ErrorCaseDto> getErrorCase() {
        return errorCase;
    }

    public void setErrorCase(List<ErrorCaseDto> errorCase) {
        this.errorCase = errorCase;
    }

    @Override
    public String toString() {
        return "EsSearchRequest{" +
                "id=" + id +
                ", errorCode='" + errorCode + '\'' +
                ", errorMsg='" + errorMsg + '\'' +
                ", errorDesc='" + errorDesc + '\'' +
                ", errorTag=" + errorTag +
                ", caseTag=" + caseTag +
                ", errorCase=" + errorCase +
                '}';
    }
}
