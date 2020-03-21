package com.platform.oecp.models.dos;

import com.platform.oecp.common.DataEntity;
import red.lixiang.tools.common.mybatis.model.SqlField;

import java.io.Serializable;

/**
 * @author lixiang
 */
public class OecpErrorTagDO extends DataEntity<OecpErrorTagDO> implements Serializable{

   /** 错误码主键ID  */
   @SqlField
   private Long codeId;

   /** 标签主键ID  */
   @SqlField
   private Long tagId;

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

   public static OecpErrorTagDO create(){
       return new OecpErrorTagDO();
   }

   public OecpErrorTagDO build(){
       return this;
   }

}