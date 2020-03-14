package com.platform.oecp.models.dos;

import red.lixiang.tools.common.mybatis.model.SqlField;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lixiang
 */
public class OecpApplyInfoDO implements Serializable{

   
   /** 主键UUID  */
   @SqlField
   private Long id;

   /** 用户ID，外键  */
   @SqlField
   private Long userId;

   /** 应用名称  */
   @SqlField
   private String applyName;

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

   public OecpApplyInfoDO setId(Long id) {
        this.id = id;
        return this;
   }
   public Long getUserId() {
        return this.userId;
   }

   public OecpApplyInfoDO setUserId(Long userId) {
        this.userId = userId;
        return this;
   }
   public String getApplyName() {
        return this.applyName;
   }

   public OecpApplyInfoDO setApplyName(String applyName) {
        this.applyName = applyName;
        return this;
   }
   public String getRemarks() {
        return this.remarks;
   }

   public OecpApplyInfoDO setRemarks(String remarks) {
        this.remarks = remarks;
        return this;
   }
   public Integer getDelFlag() {
        return this.delFlag;
   }

   public OecpApplyInfoDO setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
   }
   public Date getCreateDate() {
        return this.createDate;
   }

   public OecpApplyInfoDO setCreateDate(Date createDate) {
        this.createDate = createDate;
        return this;
   }
   public String getCreateBy() {
        return this.createBy;
   }

   public OecpApplyInfoDO setCreateBy(String createBy) {
        this.createBy = createBy;
        return this;
   }
   public Date getUpdateDate() {
        return this.updateDate;
   }

   public OecpApplyInfoDO setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
        return this;
   }
   public String getUpdateBy() {
        return this.updateBy;
   }

   public OecpApplyInfoDO setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
        return this;
   }
   

   public static OecpApplyInfoDO create(){
       return new OecpApplyInfoDO();
   }

   public OecpApplyInfoDO build(){
       return this;
   }

}