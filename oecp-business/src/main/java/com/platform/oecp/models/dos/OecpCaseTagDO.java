package com.platform.oecp.models.dos;
import com.platform.oecp.common.DataEntity;
import red.lixiang.tools.common.mybatis.model.SqlField;
import java.io.Serializable;
import java.util.Date;

/**
 * @author lixiang
 */
public class OecpCaseTagDO extends DataEntity<OecpCaseTagDO> implements Serializable{

   /** 案例主键ID  */
   @SqlField
   private Long caseId;

   /** 标签主键ID  */
   @SqlField
   private Long tagId;

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

   public static OecpCaseTagDO create(){
       return new OecpCaseTagDO();
   }

   public OecpCaseTagDO build(){
       return this;
   }

}