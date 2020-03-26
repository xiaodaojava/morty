package com.platform.oecp.dto;

import java.io.Serializable;

/**
 * @version 1.0
 * @className: OecpTagDto
 * @author: LILIANG
 * @date: Create In 2020/3/26 23:08
 * @description:
 */
public class OecpTagDto implements Serializable {
    /**
     * 主键ID
     */
    private Long id;
    /**
     * 标签内容
     */
    private String tag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "OecpTagDto{" +
                "id=" + id +
                ", tag='" + tag + '\'' +
                '}';
    }
}
