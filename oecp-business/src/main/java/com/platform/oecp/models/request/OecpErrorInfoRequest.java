package com.platform.oecp.models.request;

import com.platform.oecp.models.document.ErrorTag;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @version 1.0
 * @className: OecpErrorInfoRequestDto
 * @author: LILIANG
 * @date: Create In 2020/3/24 23:41
 * @description: 错误信息请求类
 */
public class OecpErrorInfoRequest implements Serializable {

    /** 错误码主键Id  */
    private Long codeId;

    /** 错误码  */
    @NotNull(message = "错误码不能为空")
    @Valid
    private String code;

    /** 错误信息  */
    @NotNull(message = "错误码信息不能为空")
    @Valid
    private String errorInfo;

    /** 错误码标签内容(相当于ES中的TERM)  */
    @NotNull(message = "错误码tag不能为空,至少一个")
    @Valid
    private List<ErrorTag> tags;

    /** 案列列表 */
    private List<OecpCaseInfoRequest> oecpCaseInfoRequests;

    /**错误描述 */
    private String errorDesc;

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

    public List<ErrorTag> getTags() {
        return tags;
    }

    public void setTags(List<ErrorTag> tags) {
        this.tags = tags;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public void setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
    }

    public Long getCodeId() {
        return codeId;
    }

    public void setCodeId(Long codeId) {
        this.codeId = codeId;
    }

    public List<OecpCaseInfoRequest> getOecpCaseInfoRequests() {
        return oecpCaseInfoRequests;
    }

    public void setOecpCaseInfoRequests(List<OecpCaseInfoRequest> oecpCaseInfoRequests) {
        this.oecpCaseInfoRequests = oecpCaseInfoRequests;
    }

    @Override
    public String toString() {
        return "OecpErrorInfoRequest{" +
                "codeId=" + codeId +
                ", code='" + code + '\'' +
                ", errorInfo='" + errorInfo + '\'' +
                ", tags=" + tags +
                ", oecpCaseInfoRequests=" + oecpCaseInfoRequests +
                ", errorDesc='" + errorDesc + '\'' +
                '}';
    }
}
