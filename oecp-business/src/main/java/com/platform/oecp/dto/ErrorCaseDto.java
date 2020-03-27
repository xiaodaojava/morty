package com.platform.oecp.dto;

import java.io.Serializable;

/**
 * @version 1.0
 * @className: ErrorCaseDto
 * @author: LILIANG
 * @date: Create In 2020/3/26 23:12
 * @description:
 */
public class ErrorCaseDto implements Serializable {

    /**
     * 主键ID
     */
    private Long id;
    /**
     * 案例标题
     */
    private String title;
    /**
     * 案例标题分词
     */
    private String titleForSearch;
    /**
     * 案例内容摘要
     */
    private String contentForSearch;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    @Override
    public String toString() {
        return "ErrorCaseDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", titleForSearch='" + titleForSearch + '\'' +
                ", contentForSearch='" + contentForSearch + '\'' +
                '}';
    }
}
