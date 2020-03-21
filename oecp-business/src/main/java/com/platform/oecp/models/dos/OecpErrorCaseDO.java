package com.platform.oecp.models.dos;

import com.platform.oecp.common.DataEntity;
import red.lixiang.tools.common.mybatis.model.SqlField;

import java.io.Serializable;

/**
 * @author lixiang
 */
public class OecpErrorCaseDO extends DataEntity<OecpErrorCaseDO> implements Serializable{

   /** 错误码主键id  */
   @SqlField
   private Long codeId;

   /** 案例主键id  */
   @SqlField
   private Long caseId;

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

   public static OecpErrorCaseDO create(){
       return new OecpErrorCaseDO();
   }

   public OecpErrorCaseDO build(){
       return this;
   }

}