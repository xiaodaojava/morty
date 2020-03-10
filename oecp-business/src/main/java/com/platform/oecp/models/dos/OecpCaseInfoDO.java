package com.platform.oecp.models.dos;
import red.lixiang.tools.common.mybatis.model.SqlField;
import java.io.Serializable;
import java.util.Date;

/**
 * @author lixiang
 */
public class OecpCaseInfoDO implements Serializable{

   
   /** UUID主键  */
   @SqlField
   private Long id;

   /** 案列内容  */
   @SqlField
   private String content;

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
   private String delFlag;

   
   public Long getId() {
        return this.id;
   }

   public OecpCaseInfoDO setId(Long id) {
        this.id = id;
        return this;
   }
   public String getContent() {
        return this.content;
   }

   public OecpCaseInfoDO setContent(String content) {
        this.content = content;
        return this;
   }
   public String getCreateBy() {
        return this.createBy;
   }

   public OecpCaseInfoDO setCreateBy(String createBy) {
        this.createBy = createBy;
        return this;
   }

   public String getUpdateBy() {
        return this.updateBy;
   }

   public OecpCaseInfoDO setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
        return this;
   }

    public Date getCreateDate() {
        return createDate;
    }

    public OecpCaseInfoDO setCreateDate(Date createDate) {
        this.createDate = createDate;
        return this;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public OecpCaseInfoDO setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
        return this;
    }

    public String getRemarks() {
        return this.remarks;
   }

   public OecpCaseInfoDO setRemarks(String remarks) {
        this.remarks = remarks;
        return this;
   }
   public String getDelFlag() {
        return this.delFlag;
   }

   public OecpCaseInfoDO setDelFlag(String delFlag) {
        this.delFlag = delFlag;
        return this;
   }
   

   public static OecpCaseInfoDO create(){
       return new OecpCaseInfoDO();
   }

   public OecpCaseInfoDO build(){
       return this;
   }

}