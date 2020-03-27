package com.platform.oecp.models.dos;
import red.lixiang.tools.common.mybatis.model.SqlField;
import java.io.Serializable;
import java.util.Date;

/**
 * @author lixiang
 */
public class OecpCaseTagDO implements Serializable{

   
   /** 主键UUID  */
   @SqlField
   private Long id;

   /** 案例主键ID  */
   @SqlField
   private Long caseId;

   /** 标签主键ID  */
   @SqlField
   private Long tagId;

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

   public OecpCaseTagDO setId(Long id) {
        this.id = id;
        return this;
   }
   public Long getCaseId() {
        return this.caseId;
   }

   public OecpCaseTagDO setCaseId(Long caseId) {
        this.caseId = caseId;
        return this;
   }
   public Long getTagId() {
        return this.tagId;
   }

   public OecpCaseTagDO setTagId(Long tagId) {
        this.tagId = tagId;
        return this;
   }
   public String getCreateBy() {
        return this.createBy;
   }

   public OecpCaseTagDO setCreateBy(String createBy) {
        this.createBy = createBy;
        return this;
   }
   public Date getCreateDate() {
        return this.createDate;
   }

   public OecpCaseTagDO setCreateDate(Date createDate) {
        this.createDate = createDate;
        return this;
   }
   public String getUpdateBy() {
        return this.updateBy;
   }

   public OecpCaseTagDO setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
        return this;
   }
   public Date getUpdateDate() {
        return this.updateDate;
   }

   public OecpCaseTagDO setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
        return this;
   }
   public String getRemarks() {
        return this.remarks;
   }

   public OecpCaseTagDO setRemarks(String remarks) {
        this.remarks = remarks;
        return this;
   }
   public Integer getDelFlag() {
        return this.delFlag;
   }

   public OecpCaseTagDO setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
   }
   

   public static OecpCaseTagDO create(){
       return new OecpCaseTagDO();
   }

   public OecpCaseTagDO build(){
       return this;
   }

}