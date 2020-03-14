package com.platform.oecp.models.qc;

import red.lixiang.tools.common.mybatis.model.BaseQC;

/**
 * @author lixiang
 */
public class OecpConfigQC extends BaseQC {

   
   
   /** 主键UUID  */
   private Long id;
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   

    
    

    public Long getId() {
        return this.id;
    }

    public OecpConfigQC setId(Long id) {
        this.id = id;
        return this;
    }
     
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    


    public static OecpConfigQC create(){
        return new OecpConfigQC();
    }

    public OecpConfigQC build(){
        return this;
    }

}
