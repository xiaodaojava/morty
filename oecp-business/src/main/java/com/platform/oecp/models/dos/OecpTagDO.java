package com.platform.oecp.models.dos;
import red.lixiang.tools.common.mybatis.model.SqlField;
import java.io.Serializable;
import java.util.Date;

/**
 * @author lixiang
 */
public class OecpTagDO implements Serializable{

   
   /** 主键UUID  */
   @SqlField
   private Long id;

   /** 标签内容(相当于ES中的TERM)  */
   @SqlField
   private String tag;

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

   public OecpTagDO setId(Long id) {
        this.id = id;
        return this;
   }
   public String getTag() {
        return this.tag;
   }

   public OecpTagDO setTag(String tag) {
        this.tag = tag;
        return this;
   }
   public String getCreateBy() {
        return this.createBy;
   }

   public OecpTagDO setCreateBy(String createBy) {
        this.createBy = createBy;
        return this;
   }
   public Date getCreateDate() {
        return this.createDate;
   }

   public OecpTagDO setCreateDate(Date createDate) {
        this.createDate = createDate;
        return this;
   }
   public String getUpdateBy() {
        return this.updateBy;
   }

   public OecpTagDO setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
        return this;
   }
   public Date getUpdateDate() {
        return this.updateDate;
   }

   public OecpTagDO setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
        return this;
   }
   public String getRemarks() {
        return this.remarks;
   }

   public OecpTagDO setRemarks(String remarks) {
        this.remarks = remarks;
        return this;
   }
   public Integer getDelFlag() {
        return this.delFlag;
   }

   public OecpTagDO setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
   }
   

   public static OecpTagDO create(){
       return new OecpTagDO();
   }

   public OecpTagDO build(){
       return this;
   }

}