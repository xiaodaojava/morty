package com.platform.oecp.models.qc;

import red.lixiang.tools.common.mybatis.model.BaseQC;

/**
 * @author lixiang
 */
public class OecpRoleQC extends BaseQC {

   
   
   /** 主键UUID  */
   private Long id;
   
   
   /** 归属机构ID  */
   private String officeId;
   
   
   
   
   
   
   
   
   
   
   
   

    
    

    public Long getId() {
        return this.id;
    }

    public OecpRoleQC setId(Long id) {
        this.id = id;
        return this;
    }
     
    

    public String getOfficeId() {
        return this.officeId;
    }

    public OecpRoleQC setOfficeId(String officeId) {
        this.officeId = officeId;
        return this;
    }
     
    
    
    
    
    
    
    
    
    
    
    


    public static OecpRoleQC create(){
        return new OecpRoleQC();
    }

    public OecpRoleQC build(){
        return this;
    }

}
