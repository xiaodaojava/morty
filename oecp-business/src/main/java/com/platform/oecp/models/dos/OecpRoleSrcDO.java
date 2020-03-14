package com.platform.oecp.models.dos;

import red.lixiang.tools.common.mybatis.model.SqlField;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lixiang
 */
public class OecpRoleSrcDO implements Serializable{

   
   /** 主键UUID  */
   @SqlField
   private Long id;

   /** 角色ID  */
   @SqlField
   private String roleId;

   /** 资源路径ID  */
   @SqlField
   private String valueId;

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

   public OecpRoleSrcDO setId(Long id) {
        this.id = id;
        return this;
   }
   public String getRoleId() {
        return this.roleId;
   }

   public OecpRoleSrcDO setRoleId(String roleId) {
        this.roleId = roleId;
        return this;
   }
   public String getValueId() {
        return this.valueId;
   }

   public OecpRoleSrcDO setValueId(String valueId) {
        this.valueId = valueId;
        return this;
   }
   public String getRemarks() {
        return this.remarks;
   }

   public OecpRoleSrcDO setRemarks(String remarks) {
        this.remarks = remarks;
        return this;
   }
   public Integer getDelFlag() {
        return this.delFlag;
   }

   public OecpRoleSrcDO setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
   }
   public Date getCreateDate() {
        return this.createDate;
   }

   public OecpRoleSrcDO setCreateDate(Date createDate) {
        this.createDate = createDate;
        return this;
   }
   public String getCreateBy() {
        return this.createBy;
   }

   public OecpRoleSrcDO setCreateBy(String createBy) {
        this.createBy = createBy;
        return this;
   }
   public Date getUpdateDate() {
        return this.updateDate;
   }

   public OecpRoleSrcDO setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
        return this;
   }
   public String getUpdateBy() {
        return this.updateBy;
   }

   public OecpRoleSrcDO setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
        return this;
   }
   

   public static OecpRoleSrcDO create(){
       return new OecpRoleSrcDO();
   }

   public OecpRoleSrcDO build(){
       return this;
   }

}