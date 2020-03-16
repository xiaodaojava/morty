package com.platform.oecp.dto;

import java.io.Serializable;

/**
 * @version 1.0
 * @className: OecpUserInfoRequestDto
 * @author: LILIANG
 * @date: Create In 2020/3/16 22:32
 * @description:
 */
public class OecpUserInfoRequestDto implements Serializable {

    private Long id;

    /** 部门ID  */
    private String officeId;

    /** 错误平台用户登陆账号  */
    private String accountId;

    /** 为本平台登录旧密码必填  */
    private String oldPassword;

    /** 为本平台登录新密码必填  */
    private String newPassword;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOfficeId() {
        return officeId;
    }

    public void setOfficeId(String officeId) {
        this.officeId = officeId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    @Override
    public String toString() {
        return "OecpUserInfoRequestDto{" +
                "id=" + id +
                ", officeId='" + officeId + '\'' +
                ", accountId='" + accountId + '\'' +
                ", oldPassword='" + oldPassword + '\'' +
                ", newPassword='" + newPassword + '\'' +
                '}';
    }
}
