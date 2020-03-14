package com.platform.oecp.models.qc;

import red.lixiang.tools.common.mybatis.model.BaseQC;

/**
 * @author lixiang
 */
public class OecpApplyInfoQC extends BaseQC {

   
   
   /** 主键UUID  */
   private Long id;
   
   
   /** 用户ID，外键  */
   private Long userId;
   
   
   
   
   
   
   
   
   

    
    

    public Long getId() {
        return this.id;
    }

    public OecpApplyInfoQC setId(Long id) {
        this.id = id;
        return this;
    }
     
    

    public Long getUserId() {
        return this.userId;
    }

    public OecpApplyInfoQC setUserId(Long userId) {
        this.userId = userId;
        return this;
    }
     
    
    
    
    
    
    
    
    


    public static OecpApplyInfoQC create(){
        return new OecpApplyInfoQC();
    }

    public OecpApplyInfoQC build(){
        return this;
    }

}
