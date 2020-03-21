package com.platform.oecp.models.dos;

import com.platform.oecp.common.DataEntity;
import red.lixiang.tools.common.mybatis.model.SqlField;

import java.io.Serializable;

/**
 * @author lixiang
 */
public class OecpConfigDO extends DataEntity<OecpConfigDO> implements Serializable{

   /** 邮箱服务器地址  */
   @SqlField
   private String smtp;

   /** 邮箱服务器端口  */
   @SqlField
   private String smtpPort;

   /** 系统邮箱地址  */
   @SqlField
   private String sysMail;

   /** 系统邮箱密码  */
   @SqlField
   private String sysMailPass;

   /**   */
   @SqlField
   private String accessKeyId;

   /**   */
   @SqlField
   private String accessKeySecret;

   /** 短信签名  */
   @SqlField
   private String signature;

   /** 短信模板  */
   @SqlField
   private String templateCode;

   /** 默认主题  */
   @SqlField
   private String defaultTheme;

   /** 产品名称  */
   @SqlField
   private String productName;

   /** logo  */
   @SqlField
   private String logo;

   /** 容许多登陆（0:容许；1：不容许）  */
   @SqlField
   private Integer multiLogin;

   /** 单一登录方式（0:单一；1:不单一）  */
   @SqlField
   private Integer singleLogin;

   /** 首页  */
   @SqlField
   private String homeUrl;

   /** 默认布局  */
   @SqlField
   private String defaultLayout;

   public String getSmtp() {
        return this.smtp;
   }

   public OecpConfigDO setSmtp(String smtp) {
        this.smtp = smtp;
        return this;
   }
   public String getSmtpPort() {
        return this.smtpPort;
   }

   public OecpConfigDO setSmtpPort(String smtpPort) {
        this.smtpPort = smtpPort;
        return this;
   }
   public String getSysMail() {
        return this.sysMail;
   }

   public OecpConfigDO setSysMail(String sysMail) {
        this.sysMail = sysMail;
        return this;
   }
   public String getSysMailPass() {
        return this.sysMailPass;
   }

   public OecpConfigDO setSysMailPass(String sysMailPass) {
        this.sysMailPass = sysMailPass;
        return this;
   }
   public String getAccessKeyId() {
        return this.accessKeyId;
   }

   public OecpConfigDO setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
        return this;
   }
   public String getAccessKeySecret() {
        return this.accessKeySecret;
   }

   public OecpConfigDO setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
        return this;
   }
   public String getSignature() {
        return this.signature;
   }

   public OecpConfigDO setSignature(String signature) {
        this.signature = signature;
        return this;
   }
   public String getTemplateCode() {
        return this.templateCode;
   }

   public OecpConfigDO setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
        return this;
   }
   public String getDefaultTheme() {
        return this.defaultTheme;
   }

   public OecpConfigDO setDefaultTheme(String defaultTheme) {
        this.defaultTheme = defaultTheme;
        return this;
   }
   public String getProductName() {
        return this.productName;
   }

   public OecpConfigDO setProductName(String productName) {
        this.productName = productName;
        return this;
   }
   public String getLogo() {
        return this.logo;
   }

   public OecpConfigDO setLogo(String logo) {
        this.logo = logo;
        return this;
   }
   public Integer getMultiLogin() {
        return this.multiLogin;
   }

   public OecpConfigDO setMultiLogin(Integer multiLogin) {
        this.multiLogin = multiLogin;
        return this;
   }
   public Integer getSingleLogin() {
        return this.singleLogin;
   }

   public OecpConfigDO setSingleLogin(Integer singleLogin) {
        this.singleLogin = singleLogin;
        return this;
   }
   public String getHomeUrl() {
        return this.homeUrl;
   }

   public OecpConfigDO setHomeUrl(String homeUrl) {
        this.homeUrl = homeUrl;
        return this;
   }
   public String getDefaultLayout() {
        return this.defaultLayout;
   }

   public OecpConfigDO setDefaultLayout(String defaultLayout) {
        this.defaultLayout = defaultLayout;
        return this;
   }

   public static OecpConfigDO create(){
       return new OecpConfigDO();
   }

   public OecpConfigDO build(){
       return this;
   }

}