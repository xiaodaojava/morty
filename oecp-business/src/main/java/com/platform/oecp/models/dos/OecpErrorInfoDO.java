package com.platform.oecp.models.dos;

import red.lixiang.tools.common.mybatis.model.SqlField;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lixiang
 */
public class OecpErrorInfoDO implements Serializable{

   
   /** UUID主键  */
   @SqlField
   private Long id;

   /** 错误码  */
   @SqlField
   private String code;

   /** 错误信息  */
   @SqlField
   private String errorInfo;

   /** 创建人  */
   @SqlField
   private String createBy;

   /** 创建时间  */
   @SqlField
   private Date createDate;

   /** 更新人  */
   @SqlField
   private String updateBy;

   /** 更新时间  */
   @SqlField
   private Date updateDate;

   /** 备注信息  */
   @SqlField
   private String remarks;

   /** 逻辑删除（0显示；1隐藏）  */
   @SqlField
   private Integer delFlag;

   


   
   public Long getId() {
        return this.id;
   }

   public OecpErrorInfoDO setId(Long id) {
        this.id = id;
        return this;
   }
   public String getCode() {
        return this.code;
   }

   public OecpErrorInfoDO setCode(String code) {
        this.code = code;
        return this;
   }
   public String getErrorInfo() {
        return this.errorInfo;
   }

   public OecpErrorInfoDO setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
        return this;
   }
   public String getCreateBy() {
        return this.createBy;
   }

   public OecpErrorInfoDO setCreateBy(String createBy) {
        this.createBy = createBy;
        return this;
   }
   public Date getCreateDate() {
        return this.createDate;
   }

   public OecpErrorInfoDO setCreateDate(Date createDate) {
        this.createDate = createDate;
        return this;
   }
   public String getUpdateBy() {
        return this.updateBy;
   }

   public OecpErrorInfoDO setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
        return this;
   }
   public Date getUpdateDate() {
        return this.updateDate;
   }

   public OecpErrorInfoDO setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
        return this;
   }
   public String getRemarks() {
        return this.remarks;
   }

   public OecpErrorInfoDO setRemarks(String remarks) {
        this.remarks = remarks;
        return this;
   }
   public Integer getDelFlag() {
        return this.delFlag;
   }

   public OecpErrorInfoDO setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
   }
   

   public static OecpErrorInfoDO create(){
       return new OecpErrorInfoDO();
   }

   public OecpErrorInfoDO build(){
       return this;
   }

}