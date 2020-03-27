package com.platform.oecp.models.dos;
import com.platform.oecp.common.DataEntity;
import red.lixiang.tools.common.mybatis.model.SqlField;
import java.io.Serializable;
import java.util.Date;

/**
 * @author lixiang
 */
public class OecpSearchMainDO extends DataEntity<OecpSearchMainDO> implements Serializable{

   /** 错误码  */
   @SqlField
   private String errorCode;

   /** 错误信息  */
   @SqlField
   private String errorMsg;

   /** 错误描述  */
   @SqlField
   private String errorDesc;

   /** 错误码标签，对应错误码主键ID  */
   @SqlField
   private Long errorTag;

   public String getErrorCode() {
        return this.errorCode;
   }

   public OecpSearchMainDO setErrorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
   }
   public String getErrorMsg() {
        return this.errorMsg;
   }

   public OecpSearchMainDO setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
        return this;
   }
   public String getErrorDesc() {
        return this.errorDesc;
   }

   public OecpSearchMainDO setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
        return this;
   }
   public Long getErrorTag() {
        return this.errorTag;
   }

   public OecpSearchMainDO setErrorTag(Long errorTag) {
        this.errorTag = errorTag;
        return this;
   }
   

   public static OecpSearchMainDO create(){
       return new OecpSearchMainDO();
   }

   public OecpSearchMainDO build(){
       return this;
   }

}