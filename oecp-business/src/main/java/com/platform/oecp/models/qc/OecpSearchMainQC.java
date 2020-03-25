package com.platform.oecp.models.qc;

import red.lixiang.tools.common.mybatis.model.BaseQC;
import red.lixiang.tools.common.mybatis.model.QC;
import java.util.Date;

/**
 * @author lixiang
 */
public class OecpSearchMainQC extends BaseQC {

   
   
   /** 主键UUID  */
   private Long id;
   
   
   /** 错误码  */
   private String errorCode;
   
   
   
   
   
   
   
   
   
   
   

    
    

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
     
    
    
    
    
    
    
    
    
    
    


    public static OecpSearchMainQC create(){
        return new OecpSearchMainQC();
    }

    public OecpSearchMainQC build(){
        return this;
    }

}
