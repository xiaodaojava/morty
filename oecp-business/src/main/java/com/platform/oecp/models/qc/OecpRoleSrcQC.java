package com.platform.oecp.models.qc;

import red.lixiang.tools.common.mybatis.model.BaseQC;
import red.lixiang.tools.common.mybatis.model.QC;
import java.util.Date;

/**
 * @author lixiang
 */
public class OecpRoleSrcQC extends BaseQC {

   
   
   /** 主键UUID  */
   private Long id;
   
   
   /** 角色ID  */
   private String roleId;
   
   
   /** 资源路径ID  */
   private String valueId;
   
   
   
   
   
   
   
   

    
    

    public Long getId() {
        return this.id;
    }

    public OecpRoleSrcQC setId(Long id) {
        this.id = id;
        return this;
    }
     
    

    public String getRoleId() {
        return this.roleId;
    }

    public OecpRoleSrcQC setRoleId(String roleId) {
        this.roleId = roleId;
        return this;
    }
     
    

    public String getValueId() {
        return this.valueId;
    }

    public OecpRoleSrcQC setValueId(String valueId) {
        this.valueId = valueId;
        return this;
    }
     
    
    
    
    
    
    
    


    public static OecpRoleSrcQC create(){
        return new OecpRoleSrcQC();
    }

    public OecpRoleSrcQC build(){
        return this;
    }

}
