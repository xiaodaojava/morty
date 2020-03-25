package com.platform.oecp.models.dos;
import com.platform.oecp.common.DataEntity;
import red.lixiang.tools.common.mybatis.model.SqlField;
import java.io.Serializable;
import java.util.Date;

/**
 * @author lixiang
 */
public class OecpSearchSubDO extends DataEntity<OecpSearchSubDO> implements Serializable{

   
   /** 主键UUID  */
   @SqlField
   private Long id;

   /** 案例标题  */
   @SqlField
   private String title;

   /** 案例分词  */
   @SqlField
   private String titleForSearch;

   /** 内容摘要  */
   @SqlField
   private String contentForSearch;

   /** 搜索主表ID，外键  */
   @SqlField
   private Long searchMainId;

   /** 案例标签，对应案例ID，外键  */
   @SqlField
   private Long caseTag;

   public String getTitle() {
        return this.title;
   }

   public OecpSearchSubDO setTitle(String title) {
        this.title = title;
        return this;
   }
   public String getTitleForSearch() {
        return this.titleForSearch;
   }

   public OecpSearchSubDO setTitleForSearch(String titleForSearch) {
        this.titleForSearch = titleForSearch;
        return this;
   }
   public String getContentForSearch() {
        return this.contentForSearch;
   }

   public OecpSearchSubDO setContentForSearch(String contentForSearch) {
        this.contentForSearch = contentForSearch;
        return this;
   }
   public Long getSearchMainId() {
        return this.searchMainId;
   }

   public OecpSearchSubDO setSearchMainId(Long searchMainId) {
        this.searchMainId = searchMainId;
        return this;
   }
   public Long getCaseTag() {
        return this.caseTag;
   }

   public OecpSearchSubDO setCaseTag(Long caseTag) {
        this.caseTag = caseTag;
        return this;
   }

   public static OecpSearchSubDO create(){
       return new OecpSearchSubDO();
   }

   public OecpSearchSubDO build(){
       return this;
   }

}