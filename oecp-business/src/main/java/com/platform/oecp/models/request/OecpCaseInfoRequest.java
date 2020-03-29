package com.platform.oecp.models.request;

import com.platform.oecp.models.document.CaseTag;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @version 1.0
 * @className: OecpCaseInfoRequest
 * @author: LILIANG
 * @date: Create In 2020/3/25 9:43
 * @description: 案列信息请求类
 */
public class OecpCaseInfoRequest implements Serializable {

    /** 错误码主键ID */
    @NotNull(message = "错误码ID参数不为空")
    @Valid
    private Long codeId;

    /** 案列主键ID */
    private Long caseId;

    /** 标题tag  */
    private String titleForSearch;

    /** 标题内容  */
    private String title;

    /** 案例tag  */
    private String contentForSearch;

    /** 案列内容  */
    private String content;

    /** 案列标签 */
    private List<CaseTag> tags;

    public Long getCaseId() {
        return caseId;
    }

    public void setCaseId(Long caseId) {
        this.caseId = caseId;
    }

    public String getTitleForSearch() {
        return titleForSearch;
    }

    public void setTitleForSearch(String titleForSearch) {
        this.titleForSearch = titleForSearch;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContentForSearch() {
        return contentForSearch;
    }

    public void setContentForSearch(String contentForSearch) {
        this.contentForSearch = contentForSearch;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getCodeId() {
        return codeId;
    }

    public void setCodeId(Long codeId) {
        this.codeId = codeId;
    }

    public List<CaseTag> getTags() {
        return tags;
    }

    public void setTags(List<CaseTag> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "OecpCaseInfoRequest{" +
                "codeId=" + codeId +
                ", caseId=" + caseId +
                ", titleForSearch='" + titleForSearch + '\'' +
                ", title='" + title + '\'' +
                ", contentForSearch='" + contentForSearch + '\'' +
                ", content='" + content + '\'' +
                ", tags=" + tags +
                '}';
    }
}
