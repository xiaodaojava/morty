package com.platform.oecp.models.qc;

import red.lixiang.tools.common.mybatis.model.BaseQC;

/**
 * @author lixiang
 */
public class OecpUserRoleQC extends BaseQC {

   
   
   /** 主键UUID  */
   private Long id;
   
   
   /** 用户ID  */
   private String userId;
   
   
   /** 角色ID，外键  */
   private String roleId;
   
   
   
   
   
   
   
   

    
    

    public Long getId() {
        return this.id;
    }

    public OecpUserRoleQC setId(Long id) {
        this.id = id;
        return this;
    }
     
    

    public String getUserId() {
        return this.userId;
    }

    public OecpUserRoleQC setUserId(String userId) {
        this.userId = userId;
        return this;
    }
     
    

    public String getRoleId() {
        return this.roleId;
    }

    public OecpUserRoleQC setRoleId(String roleId) {
        this.roleId = roleId;
        return this;
    }
     
    
    
    
    
    
    
    


    public static OecpUserRoleQC create(){
        return new OecpUserRoleQC();
    }

    public OecpUserRoleQC build(){
        return this;
    }

}
