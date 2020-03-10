package com.platform.oecp.models.dos;
import red.lixiang.tools.common.mybatis.model.SqlField;
import java.io.Serializable;
import java.util.Date;

/**
 * @author lixiang
 */
public class OecpApplyInfoDO implements Serializable{

   


   

   public static OecpApplyInfoDO create(){
       return new OecpApplyInfoDO();
   }

   public OecpApplyInfoDO build(){
       return this;
   }

}