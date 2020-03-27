package com.platform.oecp.models.qc;

import red.lixiang.tools.common.mybatis.model.BaseQC;
import red.lixiang.tools.common.mybatis.model.QC;
import java.util.Date;

/**
 * @author lixiang
 */
public class OecpSearchSubQC extends BaseQC {

   
   
   /** 主键UUID  */
   private Long id;
   
   
   
   
   
   
   
   
   
   
   
   
   

    
    

    public Long getId() {
        return this.id;
    }

    public OecpSearchSubQC setId(Long id) {
        this.id = id;
        return this;
    }
     
    
    
    
    
    
    
    
    
    
    
    
    


    public static OecpSearchSubQC create(){
        return new OecpSearchSubQC();
    }

    public OecpSearchSubQC build(){
        return this;
    }

}
