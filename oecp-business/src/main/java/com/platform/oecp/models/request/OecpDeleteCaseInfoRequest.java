package com.platform.oecp.models.request;

import java.io.Serializable;
import java.util.List;

/**
 * @version 1.0
 * @className: OecpDeleteCaseInfoRequest
 * @author: LILIANG
 * @date: Create In 2020/3/25 10:36
 * @description:
 */
public class OecpDeleteCaseInfoRequest implements Serializable {

    /**
     * 错误码主键ID
     */
    private Long codeId;

    /**
     * 案例主键ID集合（适用批量删除、单个删除）
     */
    private List<Long> caseIds;

    public Long getCodeId() {
        return codeId;
    }

    public void setCodeId(Long codeId) {
        this.codeId = codeId;
    }

    public List<Long> getCaseIds() {
        return caseIds;
    }

    public void setCaseIds(List<Long> caseIds) {
        this.caseIds = caseIds;
    }

    @Override
    public String toString() {
        return "OecpDeleteCaseInfoRequest{" +
                "codeId=" + codeId +
                ", caseIds=" + caseIds +
                '}';
    }
}
