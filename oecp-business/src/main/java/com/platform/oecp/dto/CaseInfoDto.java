package com.platform.oecp.dto;

import red.lixiang.tools.common.mybatis.model.SqlField;

import java.io.Serializable;
import java.util.List;

/**
 * @version 1.0
 * @className: CaseInfoDto
 * @author: LILIANG
 * @date: Create In 2020/3/28 20:33
 * @description:
 */
public class CaseInfoDto implements Serializable {

    /** 案例ID  */
    private Long caseId;

    /** 标题tag  */
    @SqlField
    private String titleForSearch;

    /** 标题内容  */
    @SqlField
    private String title;

    /** 案例tag  */
    @SqlField
    private String contentForSearch;

    /** 案列内容  */
    @SqlField
    private String content;

    /** 案列标签  */
    private List<OecpTagDto> caseTags;

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

    public List<OecpTagDto> getCaseTags() {
        return caseTags;
    }

    public void setCaseTags(List<OecpTagDto> caseTags) {
        this.caseTags = caseTags;
    }

    @Override
    public String toString() {
        return "CaseInfoDto{" +
                "caseId=" + caseId +
                ", titleForSearch='" + titleForSearch + '\'' +
                ", title='" + title + '\'' +
                ", contentForSearch='" + contentForSearch + '\'' +
                ", content='" + content + '\'' +
                ", caseTags=" + caseTags +
                '}';
    }
}
