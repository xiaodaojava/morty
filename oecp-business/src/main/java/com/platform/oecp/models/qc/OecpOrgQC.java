package com.platform.oecp.models.qc;

import red.lixiang.tools.common.mybatis.model.BaseQC;
import red.lixiang.tools.common.mybatis.model.QC;
import java.util.Date;

/**
 * @author lixiang
 */
public class OecpOrgQC extends BaseQC {

   
   
   /** 主键UUID  */
   private Long id;
   
   
   /** 父级编号  */
   private String parentId;
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   

    
    

    public Long getId() {
        return this.id;
    }

    public OecpOrgQC setId(Long id) {
        this.id = id;
        return this;
    }
     
    

    public String getParentId() {
        return this.parentId;
    }

    public OecpOrgQC setParentId(String parentId) {
        this.parentId = parentId;
        return this;
    }
     
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    


    public static OecpOrgQC create(){
        return new OecpOrgQC();
    }

    public OecpOrgQC build(){
        return this;
    }

}
