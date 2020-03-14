package com.platform.oecp.models.dos;

import red.lixiang.tools.common.mybatis.model.SqlField;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lixiang
 */
public class OecpRoleDO implements Serializable{

   
   /** 主键UUID  */
   @SqlField
   private Long id;

   /** 归属机构ID  */
   @SqlField
   private String officeId;

   /** 角色名称  */
   @SqlField
   private String name;

   /** 英文名称  */
   @SqlField
   private String enName;

   /** 角色类型  */
   @SqlField
   private Integer roleType;

   /** 是否可用，0:代表可用;1:代表不可用  */
   @SqlField
   private Integer useable;

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

   public OecpRoleDO setId(Long id) {
        this.id = id;
        return this;
   }
   public String getOfficeId() {
        return this.officeId;
   }

   public OecpRoleDO setOfficeId(String officeId) {
        this.officeId = officeId;
        return this;
   }
   public String getName() {
        return this.name;
   }

   public OecpRoleDO setName(String name) {
        this.name = name;
        return this;
   }
   public String getEnName() {
        return this.enName;
   }

   public OecpRoleDO setEnName(String enName) {
        this.enName = enName;
        return this;
   }
   public Integer getRoleType() {
        return this.roleType;
   }

   public OecpRoleDO setRoleType(Integer roleType) {
        this.roleType = roleType;
        return this;
   }
   public Integer getUseable() {
        return this.useable;
   }

   public OecpRoleDO setUseable(Integer useable) {
        this.useable = useable;
        return this;
   }
   public String getRemarks() {
        return this.remarks;
   }

   public OecpRoleDO setRemarks(String remarks) {
        this.remarks = remarks;
        return this;
   }
   public Integer getDelFlag() {
        return this.delFlag;
   }

   public OecpRoleDO setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
   }
   public Date getCreateDate() {
        return this.createDate;
   }

   public OecpRoleDO setCreateDate(Date createDate) {
        this.createDate = createDate;
        return this;
   }
   public String getCreateBy() {
        return this.createBy;
   }

   public OecpRoleDO setCreateBy(String createBy) {
        this.createBy = createBy;
        return this;
   }
   public Date getUpdateDate() {
        return this.updateDate;
   }

   public OecpRoleDO setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
        return this;
   }
   public String getUpdateBy() {
        return this.updateBy;
   }

   public OecpRoleDO setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
        return this;
   }
   

   public static OecpRoleDO create(){
       return new OecpRoleDO();
   }

   public OecpRoleDO build(){
       return this;
   }

}