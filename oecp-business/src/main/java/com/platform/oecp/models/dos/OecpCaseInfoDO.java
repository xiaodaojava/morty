package com.platform.oecp.models.dos;

import com.platform.oecp.common.DataEntity;
import red.lixiang.tools.common.mybatis.model.SqlField;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lixiang
 */
public class OecpCaseInfoDO extends DataEntity<OecpCaseInfoDO> implements Serializable{

   /** 标题tag  */
   @SqlField
   private String titleForSearch;

   /** 标题内容  */
   @SqlField
   private String title;

   /** 案例tag  */
   @SqlField
   private String contentForSearch;

   /** 案列内容  */
   @SqlField
   private String content;

   public String getTitleForSearch() {
        return this.titleForSearch;
   }

   public OecpCaseInfoDO setTitleForSearch(String titleForSearch) {
        this.titleForSearch = titleForSearch;
        return this;
   }
   public String getTitle() {
        return this.title;
   }

   public OecpCaseInfoDO setTitle(String title) {
        this.title = title;
        return this;
   }
   public String getContentForSearch() {
        return this.contentForSearch;
   }

   public OecpCaseInfoDO setContentForSearch(String contentForSearch) {
        this.contentForSearch = contentForSearch;
        return this;
   }
   public String getContent() {
        return this.content;
   }

   public OecpCaseInfoDO setContent(String content) {
        this.content = content;
        return this;
   }

   public static OecpCaseInfoDO create(){
       return new OecpCaseInfoDO();
   }

   public OecpCaseInfoDO build(){
       return this;
   }

}