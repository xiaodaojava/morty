package com.platform.oecp.models.dos;

import com.platform.oecp.common.DataEntity;
import red.lixiang.tools.common.mybatis.model.SqlField;

import java.io.Serializable;

/**
 * @author lixiang
 */
public class OecpTagDO extends DataEntity<OecpTagDO> implements Serializable{

   /** 标签内容(相当于ES中的TERM)  */
   @SqlField
   private String tag;

   public String getTag() {
        return this.tag;
   }

   public OecpTagDO setTag(String tag) {
        this.tag = tag;
        return this;
   }

   public static OecpTagDO create(){
       return new OecpTagDO();
   }

   public OecpTagDO build(){
       return this;
   }

}