package com.platform.oecp.models.dos;
import red.lixiang.tools.common.mybatis.model.SqlField;
import java.io.Serializable;
import java.util.Date;

/**
 * @author lixiang
 */
public class OecpErrorCaseDO implements Serializable{

   
   /** 主键UUID  */
   @SqlField
   private Long id;

   /** 错误码主键id  */
   @SqlField
   private Long codeId;

   /** 案例主键id  */
   @SqlField
   private Long caseId;

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

   public OecpErrorCaseDO setId(Long id) {
        this.id = id;
        return this;
   }
   public Long getCodeId() {
        return this.codeId;
   }

   public OecpErrorCaseDO setCodeId(Long codeId) {
        this.codeId = codeId;
        return this;
   }
   public Long getCaseId() {
        return this.caseId;
   }

   public OecpErrorCaseDO setCaseId(Long caseId) {
        this.caseId = caseId;
        return this;
   }
   public String getCreateBy() {
        return this.createBy;
   }

   public OecpErrorCaseDO setCreateBy(String createBy) {
        this.createBy = createBy;
        return this;
   }
   public Date getCreateDate() {
        return this.createDate;
   }

   public OecpErrorCaseDO setCreateDate(Date createDate) {
        this.createDate = createDate;
        return this;
   }
   public String getUpdateBy() {
        return this.updateBy;
   }

   public OecpErrorCaseDO setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
        return this;
   }
   public Date getUpdateDate() {
        return this.updateDate;
   }

   public OecpErrorCaseDO setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
        return this;
   }
   public String getRemarks() {
        return this.remarks;
   }

   public OecpErrorCaseDO setRemarks(String remarks) {
        this.remarks = remarks;
        return this;
   }
   public Integer getDelFlag() {
        return this.delFlag;
   }

   public OecpErrorCaseDO setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
   }
   

   public static OecpErrorCaseDO create(){
       return new OecpErrorCaseDO();
   }

   public OecpErrorCaseDO build(){
       return this;
   }

}