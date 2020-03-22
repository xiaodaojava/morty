package com.platform.oecp.models.dos;

import com.platform.oecp.common.DataEntity;
import red.lixiang.tools.common.mybatis.model.SqlField;

import java.io.Serializable;

/**
 * @author lixiang
 */
public class OecpRoleDO extends DataEntity<OecpRoleDO> implements Serializable{

   /** 归属机构ID  */
   @SqlField
   private String officeId;

   /** 角色名称  */
   @SqlField
   private String name;

   /** 英文名称  */
   @SqlField
   private String enName;

   /** 角色类型  */
   @SqlField
   private Integer roleType;

   /** 是否可用，0:代表可用;1:代表不可用  */
   @SqlField
   private Integer useable;

   public String getOfficeId() {
        return this.officeId;
   }

   public OecpRoleDO setOfficeId(String officeId) {
        this.officeId = officeId;
        return this;
   }
   public String getName() {
        return this.name;
   }

   public OecpRoleDO setName(String name) {
        this.name = name;
        return this;
   }
   public String getEnName() {
        return this.enName;
   }

   public OecpRoleDO setEnName(String enName) {
        this.enName = enName;
        return this;
   }
   public Integer getRoleType() {
        return this.roleType;
   }

   public OecpRoleDO setRoleType(Integer roleType) {
        this.roleType = roleType;
        return this;
   }
   public Integer getUseable() {
        return this.useable;
   }

   public OecpRoleDO setUseable(Integer useable) {
        this.useable = useable;
        return this;
   }

   public static OecpRoleDO create(){
       return new OecpRoleDO();
   }

   public OecpRoleDO build(){
       return this;
   }

}