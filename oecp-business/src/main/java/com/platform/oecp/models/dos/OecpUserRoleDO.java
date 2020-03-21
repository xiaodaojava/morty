package com.platform.oecp.models.dos;

import com.platform.oecp.common.DataEntity;
import red.lixiang.tools.common.mybatis.model.SqlField;

import java.io.Serializable;

/**
 * @author lixiang
 */
public class OecpUserRoleDO extends DataEntity<OecpUserRoleDO> implements Serializable{

   /** 用户ID  */
   @SqlField
   private String userId;

   /** 角色ID，外键  */
   @SqlField
   private String roleId;

   public String getUserId() {
        return this.userId;
   }

   public OecpUserRoleDO setUserId(String userId) {
        this.userId = userId;
        return this;
   }
   public String getRoleId() {
        return this.roleId;
   }

   public OecpUserRoleDO setRoleId(String roleId) {
        this.roleId = roleId;
        return this;
   }

   public static OecpUserRoleDO create(){
       return new OecpUserRoleDO();
   }

   public OecpUserRoleDO build(){
       return this;
   }

}