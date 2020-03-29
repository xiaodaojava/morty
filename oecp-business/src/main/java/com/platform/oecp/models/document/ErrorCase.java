package com.platform.oecp.models.document;

import java.util.List;

/**
 * @author: dingaimin
 * @date: 2020/3/27 16:01
 */
public class ErrorCase {

    private String id;
    private String title;
    private String titleForSearch;
    private String contentForSearch;
    private List<CaseTag> caseTag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleForSearch() {
        return titleForSearch;
    }

    public void setTitleForSearch(String titleForSearch) {
        this.titleForSearch = titleForSearch;
    }

    public String getContentForSearch() {
        return contentForSearch;
    }

    public void setContentForSearch(String contentForSearch) {
        this.contentForSearch = contentForSearch;
    }

    public List<CaseTag> getCaseTag() {
        return caseTag;
    }

    public void setCaseTag(List<CaseTag> caseTag) {
        this.caseTag = caseTag;
    }
}
