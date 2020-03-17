package com.platform.oecp.dto;

import org.springframework.lang.NonNull;

import javax.validation.constraints.NotNull;
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

    /** 错误平台用户登陆账号  必填*/
    @NotNull(message = "账号不能为空")
    private String accountId;

    /** 为本平台登录旧密码  ;isThirtyLogin为false时必填*/
    private String oldPassword;

    /** 为本平台登录新密码,为空默认不修改  */
    private String newPassword;

    /** 是否第三方登陆 必填  ;第三方登陆修改用户信息不需要填写老密码*/
    @NotNull(message = "是否第三方登陆标志不能为空")
    private Boolean isThirtyLogin;

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

    public Boolean getThirtyLogin() {
        return isThirtyLogin;
    }

    public void setThirtyLogin(Boolean thirtyLogin) {
        isThirtyLogin = thirtyLogin;
    }

    @Override
    public String toString() {
        return "OecpUserInfoRequestDto{" +
                "id=" + id +
                ", officeId='" + officeId + '\'' +
                ", accountId='" + accountId + '\'' +
                ", oldPassword='" + oldPassword + '\'' +
                ", newPassword='" + newPassword + '\'' +
                ", isThirtyLogin=" + isThirtyLogin +
                '}';
    }
}
