package com.platform.oecp.models.dos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.platform.oecp.common.DataEntity;
import red.lixiang.tools.common.mybatis.model.SqlField;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lixiang
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OecpSysUserDO extends DataEntity<OecpSysUserDO> implements Serializable{

   /** 第三方用户ID，唯一  */
   @SqlField
   private String thirdPartyId;

   /** 第三方用户昵称  */
   @SqlField
   private String nickName;

   /** 用户头像地址  */
   @SqlField
   private String avatar;

   /** 省份名称  */
   @SqlField
   private String province;

   /** 市名称  */
   @SqlField
   private String city;

   /** 公司ID  */
   @SqlField
   private String companyId;

   /** 部门ID  */
   @SqlField
   private String officeId;

   /** 是否是学生  */
   @SqlField
   private String isStudentCertified;

   /** 用户类型(1/2) 1:代表公司账户；2:代表个人账户  */
   @SqlField
   private String userType;

   /** 用户状态（Q/T/B/W）Q:代表快速注册用户  T:代表已认证用户 B:代表被冻结账号 W:代表已注册，未激活的用户  */
   @SqlField
   private String userStatus;

   /** 是否通过实名认证，T是通过F是没有实名认证  */
   @SqlField
   private String isCertified;

   /** 性别（F:女性；M:男性）  */
   @SqlField
   private String gender;

   /** 错误平台用户登陆账号  */
   @SqlField
   private String accountId;

   /** 如果为第三方登录，密码则为空，如果为本平台登录，密码必填  */
   @SqlField
   private String password;

   /** 联系邮箱  */
   @SqlField
   private String email;

   /** 联系手机  */
   @SqlField
   private String telephone;

   /** 登陆方式  */
   @SqlField
   private Integer loginType;

   /** 第三方最新登陆IP  */
   @SqlField
   private String loginIp;

   /** 第三方最新登陆日期  */
   @SqlField
   private Date loginDate;

   /** 是否可登陆，0:可登陆;1:不可登陆  */
   @SqlField
   private Integer loginFlag;

   /** 用户二维码图片链接地址  */
   @SqlField
   private String qrCode;

   /** 个性签名  */
   @SqlField
   private String sign;

   public String getThirdPartyId() {
        return this.thirdPartyId;
   }

   public OecpSysUserDO setThirdPartyId(String thirdPartyId) {
        this.thirdPartyId = thirdPartyId;
        return this;
   }
   public String getNickName() {
        return this.nickName;
   }

   public OecpSysUserDO setNickName(String nickName) {
        this.nickName = nickName;
        return this;
   }
   public String getAvatar() {
        return this.avatar;
   }

   public OecpSysUserDO setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
   }
   public String getProvince() {
        return this.province;
   }

   public OecpSysUserDO setProvince(String province) {
        this.province = province;
        return this;
   }
   public String getCity() {
        return this.city;
   }

   public OecpSysUserDO setCity(String city) {
        this.city = city;
        return this;
   }
   public String getCompanyId() {
        return this.companyId;
   }

   public OecpSysUserDO setCompanyId(String companyId) {
        this.companyId = companyId;
        return this;
   }
   public String getOfficeId() {
        return this.officeId;
   }

   public OecpSysUserDO setOfficeId(String officeId) {
        this.officeId = officeId;
        return this;
   }
   public String getIsStudentCertified() {
        return this.isStudentCertified;
   }

   public OecpSysUserDO setIsStudentCertified(String isStudentCertified) {
        this.isStudentCertified = isStudentCertified;
        return this;
   }
   public String getUserType() {
        return this.userType;
   }

   public OecpSysUserDO setUserType(String userType) {
        this.userType = userType;
        return this;
   }
   public String getUserStatus() {
        return this.userStatus;
   }

   public OecpSysUserDO setUserStatus(String userStatus) {
        this.userStatus = userStatus;
        return this;
   }
   public String getIsCertified() {
        return this.isCertified;
   }

   public OecpSysUserDO setIsCertified(String isCertified) {
        this.isCertified = isCertified;
        return this;
   }
   public String getGender() {
        return this.gender;
   }

   public OecpSysUserDO setGender(String gender) {
        this.gender = gender;
        return this;
   }
   public String getAccountId() {
        return this.accountId;
   }

   public OecpSysUserDO setAccountId(String accountId) {
        this.accountId = accountId;
        return this;
   }
   public String getPassword() {
        return this.password;
   }

   public OecpSysUserDO setPassword(String password) {
        this.password = password;
        return this;
   }
   public String getEmail() {
        return this.email;
   }

   public OecpSysUserDO setEmail(String email) {
        this.email = email;
        return this;
   }
   public String getTelephone() {
        return this.telephone;
   }

   public OecpSysUserDO setTelephone(String telephone) {
        this.telephone = telephone;
        return this;
   }
   public Integer getLoginType() {
        return this.loginType;
   }

   public OecpSysUserDO setLoginType(Integer loginType) {
        this.loginType = loginType;
        return this;
   }
   public String getLoginIp() {
        return this.loginIp;
   }

   public OecpSysUserDO setLoginIp(String loginIp) {
        this.loginIp = loginIp;
        return this;
   }
   public Date getLoginDate() {
        return this.loginDate;
   }

   public OecpSysUserDO setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
        return this;
   }
   public Integer getLoginFlag() {
        return this.loginFlag;
   }

   public OecpSysUserDO setLoginFlag(Integer loginFlag) {
        this.loginFlag = loginFlag;
        return this;
   }
   public String getQrCode() {
        return this.qrCode;
   }

   public OecpSysUserDO setQrCode(String qrCode) {
        this.qrCode = qrCode;
        return this;
   }
   public String getSign() {
        return this.sign;
   }

   public OecpSysUserDO setSign(String sign) {
        this.sign = sign;
        return this;
   }

    public static OecpSysUserDO create(){
       return new OecpSysUserDO();
   }

   public OecpSysUserDO build(){
       return this;
   }

}