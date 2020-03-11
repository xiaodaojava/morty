package com.platform.oecp.models.qc;

import red.lixiang.tools.common.mybatis.model.BaseQC;
import red.lixiang.tools.common.mybatis.model.QC;
import java.util.Date;

/**
 * @author lixiang
 */
public class OecpCaseInfoQC extends BaseQC {

   
   
   /** UUID主键  */
   private Long id;
   
   
   
   
   
   
   
   
   
   
   
   

    
    

    public Long getId() {
        return this.id;
    }

    public OecpCaseInfoQC setId(Long id) {
        this.id = id;
        return this;
    }
     
    
    
    
    
    
    
    
    
    
    
    


    public static OecpCaseInfoQC create(){
        return new OecpCaseInfoQC();
    }

    public OecpCaseInfoQC build(){
        return this;
    }

}
