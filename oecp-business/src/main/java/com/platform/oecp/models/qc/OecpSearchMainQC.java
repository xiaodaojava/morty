package com.platform.oecp.models.qc;

import red.lixiang.tools.common.mybatis.model.BaseQC;

/**
 * @author lixiang
 */
public class OecpSearchMainQC extends BaseQC {

   
   
   /** 主键UUID  */
   private Long id;
   
   
   /** 错误码  */
   private String errorCode;

   /** 错误码主键 ID */
   private Long errorTag;
   
   
   
   
   
   
   
   
   
   
   

    
    

    public Long getId() {
        return this.id;
    }

    public OecpSearchMainQC setId(Long id) {
        this.id = id;
        return this;
    }
     
    

    public String getErrorCode() {
        return this.errorCode;
    }

    public OecpSearchMainQC setErrorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public Long getErrorTag() {
        return errorTag;
    }

    public void setErrorTag(Long errorTag) {
        this.errorTag = errorTag;
    }

    public static OecpSearchMainQC create(){
        return new OecpSearchMainQC();
    }

    public OecpSearchMainQC build(){
        return this;
    }

}
