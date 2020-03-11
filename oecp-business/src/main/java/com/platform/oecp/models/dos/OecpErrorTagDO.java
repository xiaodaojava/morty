package com.platform.oecp.models.dos;
import red.lixiang.tools.common.mybatis.model.SqlField;
import java.io.Serializable;
import java.util.Date;

/**
 * @author lixiang
 */
public class OecpErrorTagDO implements Serializable{

   
   /** 主键UUID  */
   @SqlField
   private Long id;

   /** 错误码主键ID  */
   @SqlField
   private Long codeId;

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

   public OecpErrorTagDO setId(Long id) {
        this.id = id;
        return this;
   }
   public Long getCodeId() {
        return this.codeId;
   }

   public OecpErrorTagDO setCodeId(Long codeId) {
        this.codeId = codeId;
        return this;
   }
   public Long getTagId() {
        return this.tagId;
   }

   public OecpErrorTagDO setTagId(Long tagId) {
        this.tagId = tagId;
        return this;
   }
   public String getCreateBy() {
        return this.createBy;
   }

   public OecpErrorTagDO setCreateBy(String createBy) {
        this.createBy = createBy;
        return this;
   }
   public Date getCreateDate() {
        return this.createDate;
   }

   public OecpErrorTagDO setCreateDate(Date createDate) {
        this.createDate = createDate;
        return this;
   }
   public String getUpdateBy() {
        return this.updateBy;
   }

   public OecpErrorTagDO setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
        return this;
   }
   public Date getUpdateDate() {
        return this.updateDate;
   }

   public OecpErrorTagDO setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
        return this;
   }
   public String getRemarks() {
        return this.remarks;
   }

   public OecpErrorTagDO setRemarks(String remarks) {
        this.remarks = remarks;
        return this;
   }
   public Integer getDelFlag() {
        return this.delFlag;
   }

   public OecpErrorTagDO setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
   }
   

   public static OecpErrorTagDO create(){
       return new OecpErrorTagDO();
   }

   public OecpErrorTagDO build(){
       return this;
   }

}