package com.platform.oecp.models.qc;

import red.lixiang.tools.common.mybatis.model.BaseQC;

/**
 * @author lixiang
 */
public class OecpSysUserQC extends BaseQC {

   
   
   /** 主键UUID，物理主键  */
   private Long id;
   
   
   /** 第三方用户ID，唯一  */
   private String thirdPartyId;
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   

    
    

    public Long getId() {
        return this.id;
    }

    public OecpSysUserQC setId(Long id) {
        this.id = id;
        return this;
    }
     
    

    public String getThirdPartyId() {
        return this.thirdPartyId;
    }

    public OecpSysUserQC setThirdPartyId(String thirdPartyId) {
        this.thirdPartyId = thirdPartyId;
        return this;
    }
     
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    


    public static OecpSysUserQC create(){
        return new OecpSysUserQC();
    }

    public OecpSysUserQC build(){
        return this;
    }

}
