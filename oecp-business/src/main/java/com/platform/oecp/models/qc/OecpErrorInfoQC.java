package com.platform.oecp.models.qc;

import red.lixiang.tools.common.mybatis.model.BaseQC;

/**
 * @author lixiang
 */
public class OecpErrorInfoQC extends BaseQC {

   
   
   /** UUID主键  */
   private Long id;
   
   
   
   
   
   
   
   
   
   

    
    

    public Long getId() {
        return this.id;
    }

    public OecpErrorInfoQC setId(Long id) {
        this.id = id;
        return this;
    }
     
    
    
    
    
    
    
    
    
    


    public static OecpErrorInfoQC create(){
        return new OecpErrorInfoQC();
    }

    public OecpErrorInfoQC build(){
        return this;
    }

}
