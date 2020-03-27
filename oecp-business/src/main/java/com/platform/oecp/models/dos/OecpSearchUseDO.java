package com.platform.oecp.models.dos;
import red.lixiang.tools.common.mybatis.model.SqlField;
import java.io.Serializable;
import java.util.Date;

/**
 * @author lixiang
 */
public class OecpSearchUseDO implements Serializable{

   
   /** 主键UUID  */
   @SqlField
   private Long id;

   /** 错误信息  */
   @SqlField
   private String codeInfo;

   /** 标签内容，分割  */
   @SqlField
   private String tagInfo;

   /** 案例内容，分割  */
   @SqlField
   private String caseInfo;

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

   public OecpSearchUseDO setId(Long id) {
        this.id = id;
        return this;
   }
   public String getCodeInfo() {
        return this.codeInfo;
   }

   public OecpSearchUseDO setCodeInfo(String codeInfo) {
        this.codeInfo = codeInfo;
        return this;
   }
   public String getTagInfo() {
        return this.tagInfo;
   }

   public OecpSearchUseDO setTagInfo(String tagInfo) {
        this.tagInfo = tagInfo;
        return this;
   }
   public String getCaseInfo() {
        return this.caseInfo;
   }

   public OecpSearchUseDO setCaseInfo(String caseInfo) {
        this.caseInfo = caseInfo;
        return this;
   }
   public String getCreateBy() {
        return this.createBy;
   }

   public OecpSearchUseDO setCreateBy(String createBy) {
        this.createBy = createBy;
        return this;
   }
   public Date getCreateDate() {
        return this.createDate;
   }

   public OecpSearchUseDO setCreateDate(Date createDate) {
        this.createDate = createDate;
        return this;
   }
   public String getUpdateBy() {
        return this.updateBy;
   }

   public OecpSearchUseDO setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
        return this;
   }
   public Date getUpdateDate() {
        return this.updateDate;
   }

   public OecpSearchUseDO setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
        return this;
   }
   public String getRemarks() {
        return this.remarks;
   }

   public OecpSearchUseDO setRemarks(String remarks) {
        this.remarks = remarks;
        return this;
   }
   public Integer getDelFlag() {
        return this.delFlag;
   }

   public OecpSearchUseDO setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
   }
   

   public static OecpSearchUseDO create(){
       return new OecpSearchUseDO();
   }

   public OecpSearchUseDO build(){
       return this;
   }

}