package com.platform.oecp.models.request;

import java.io.Serializable;

/**
 * @version 1.0
 * @className: OecpTagRequest
 * @author: LILIANG
 * @date: Create In 2020/3/25 9:59
 * @description:
 */
public class OecpTagRequest implements Serializable {

    /** 标签主键ID  */
    private Long tagId;

    /** 标签内容(相当于ES中的TERM)  */
    private String tag;

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "OecpTagRequest{" +
                "tagId=" + tagId +
                ", tag='" + tag + '\'' +
                '}';
    }
}
