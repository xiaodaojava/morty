package com.platform.oecp.models.dos;

import com.platform.oecp.common.DataEntity;
import red.lixiang.tools.common.mybatis.model.SqlField;

import java.io.Serializable;

/**
 * @author lixiang
 */
public class OecpErrorAndCaseInfoDO extends DataEntity<OecpErrorAndCaseInfoDO> implements Serializable{

   /** 错误码主键id  */
   @SqlField
   private Long codeId;

   /** 案例主键id  */
   @SqlField
   private Long caseId;

   /** 标题内容  */
   @SqlField
   private String title;

   /** 案列内容  */
   @SqlField
   private String content;

   public Long getCodeId() {
        return this.codeId;
   }

   public OecpErrorAndCaseInfoDO setCodeId(Long codeId) {
        this.codeId = codeId;
        return this;
   }
   public Long getCaseId() {
        return this.caseId;
   }

   public OecpErrorAndCaseInfoDO setCaseId(Long caseId) {
        this.caseId = caseId;
        return this;
   }

   public static OecpErrorAndCaseInfoDO create(){
       return new OecpErrorAndCaseInfoDO();
   }

   public OecpErrorAndCaseInfoDO build(){
       return this;
   }
  public String getTitle() {
       return this.title;
  }

  public OecpErrorAndCaseInfoDO setTitle(String title) {
       this.title = title;
       return this;
  }
  public String getContent() {
       return this.content;
  }

  public OecpErrorAndCaseInfoDO setContent(String content) {
       this.content = content;
       return this;
  }

}