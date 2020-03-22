package com.platform.oecp.models.dos;

import com.platform.oecp.common.DataEntity;
import red.lixiang.tools.common.mybatis.model.SqlField;

import java.io.Serializable;

/**
 * @author lixiang
 */
public class OecpApplyInfoDO extends DataEntity<OecpApplyInfoDO> implements Serializable{


   /** 用户ID，外键  */
   @SqlField
   private Long userId;

   /** 应用名称  */
   @SqlField
   private String applyName;

   public Long getUserId() {
        return this.userId;
   }

   public OecpApplyInfoDO setUserId(Long userId) {
        this.userId = userId;
        return this;
   }
   public String getApplyName() {
        return this.applyName;
   }

   public OecpApplyInfoDO setApplyName(String applyName) {
        this.applyName = applyName;
        return this;
   }
   

   public static OecpApplyInfoDO create(){
       return new OecpApplyInfoDO();
   }

   public OecpApplyInfoDO build(){
       return this;
   }

}