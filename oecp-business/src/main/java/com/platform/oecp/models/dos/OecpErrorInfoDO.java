package com.platform.oecp.models.dos;

import com.platform.oecp.common.DataEntity;
import red.lixiang.tools.common.mybatis.model.SqlField;

import java.io.Serializable;

/**
 * @author lixiang
 */
public class OecpErrorInfoDO extends DataEntity<OecpErrorInfoDO> implements Serializable{

   /** 错误码  */
   @SqlField
   private String code;

   /** 错误信息  */
   @SqlField
   private String errorInfo;

   public String getCode() {
        return this.code;
   }

   public OecpErrorInfoDO setCode(String code) {
        this.code = code;
        return this;
   }
   public String getErrorInfo() {
        return this.errorInfo;
   }

   public OecpErrorInfoDO setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
        return this;
   }

   public static OecpErrorInfoDO create(){
       return new OecpErrorInfoDO();
   }

   public OecpErrorInfoDO build(){
       return this;
   }

}