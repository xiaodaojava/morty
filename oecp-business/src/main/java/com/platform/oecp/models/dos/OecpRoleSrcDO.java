package com.platform.oecp.models.dos;

import com.platform.oecp.common.DataEntity;
import red.lixiang.tools.common.mybatis.model.SqlField;

import java.io.Serializable;

/**
 * @author lixiang
 */
public class OecpRoleSrcDO extends DataEntity<OecpRoleSrcDO> implements Serializable{

   /** 角色ID  */
   @SqlField
   private String roleId;

   /** 资源路径ID  */
   @SqlField
   private String valueId;

   public String getRoleId() {
        return this.roleId;
   }

   public OecpRoleSrcDO setRoleId(String roleId) {
        this.roleId = roleId;
        return this;
   }
   public String getValueId() {
        return this.valueId;
   }

   public OecpRoleSrcDO setValueId(String valueId) {
        this.valueId = valueId;
        return this;
   }

   public static OecpRoleSrcDO create(){
       return new OecpRoleSrcDO();
   }

   public OecpRoleSrcDO build(){
       return this;
   }

}