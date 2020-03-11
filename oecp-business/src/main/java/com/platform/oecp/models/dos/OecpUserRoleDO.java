package com.platform.oecp.models.dos;
import red.lixiang.tools.common.mybatis.model.SqlField;
import java.io.Serializable;
import java.util.Date;

/**
 * @author lixiang
 */
public class OecpUserRoleDO implements Serializable{

   
   /** 主键UUID  */
   @SqlField
   private Long id;

   /** 用户ID  */
   @SqlField
   private String userId;

   /** 角色ID，外键  */
   @SqlField
   private String roleId;

   /** 备注信息  */
   @SqlField
   private String remarks;

   /** 逻辑删除标记（0：显示；1：隐藏）  */
   @SqlField
   private Integer delFlag;

   /** 创建时间  */
   @SqlField
   private Date createDate;

   /** 创建人  */
   @SqlField
   private String createBy;

   /** 更新时间  */
   @SqlField
   private Date updateDate;

   /** 更新人  */
   @SqlField
   private String updateBy;

   


   
   public Long getId() {
        return this.id;
   }

   public OecpUserRoleDO setId(Long id) {
        this.id = id;
        return this;
   }
   public String getUserId() {
        return this.userId;
   }

   public OecpUserRoleDO setUserId(String userId) {
        this.userId = userId;
        return this;
   }
   public String getRoleId() {
        return this.roleId;
   }

   public OecpUserRoleDO setRoleId(String roleId) {
        this.roleId = roleId;
        return this;
   }
   public String getRemarks() {
        return this.remarks;
   }

   public OecpUserRoleDO setRemarks(String remarks) {
        this.remarks = remarks;
        return this;
   }
   public Integer getDelFlag() {
        return this.delFlag;
   }

   public OecpUserRoleDO setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
   }
   public Date getCreateDate() {
        return this.createDate;
   }

   public OecpUserRoleDO setCreateDate(Date createDate) {
        this.createDate = createDate;
        return this;
   }
   public String getCreateBy() {
        return this.createBy;
   }

   public OecpUserRoleDO setCreateBy(String createBy) {
        this.createBy = createBy;
        return this;
   }
   public Date getUpdateDate() {
        return this.updateDate;
   }

   public OecpUserRoleDO setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
        return this;
   }
   public String getUpdateBy() {
        return this.updateBy;
   }

   public OecpUserRoleDO setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
        return this;
   }
   

   public static OecpUserRoleDO create(){
       return new OecpUserRoleDO();
   }

   public OecpUserRoleDO build(){
       return this;
   }

}