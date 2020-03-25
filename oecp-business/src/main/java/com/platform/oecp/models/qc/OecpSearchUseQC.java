package com.platform.oecp.models.qc;

import red.lixiang.tools.common.mybatis.model.BaseQC;
import red.lixiang.tools.common.mybatis.model.QC;
import java.util.Date;

/**
 * @author lixiang
 */
public class OecpSearchUseQC extends BaseQC {

   
   
   /** 主键UUID  */
   private Long id;
   
   
   /** 错误信息  */
   private String codeInfo;
   
   
   /** 标签内容，分割  */
   private String tagInfo;
   
   
   /** 案例内容，分割  */
   private String caseInfo;
   
   
   
   
   
   
   
   

    
    

    public Long getId() {
        return this.id;
    }

    public OecpSearchUseQC setId(Long id) {
        this.id = id;
        return this;
    }
     
    

    public String getCodeInfo() {
        return this.codeInfo;
    }

    public OecpSearchUseQC setCodeInfo(String codeInfo) {
        this.codeInfo = codeInfo;
        return this;
    }
     
    

    public String getTagInfo() {
        return this.tagInfo;
    }

    public OecpSearchUseQC setTagInfo(String tagInfo) {
        this.tagInfo = tagInfo;
        return this;
    }
     
    

    public String getCaseInfo() {
        return this.caseInfo;
    }

    public OecpSearchUseQC setCaseInfo(String caseInfo) {
        this.caseInfo = caseInfo;
        return this;
    }
     
    
    
    
    
    
    
    


    public static OecpSearchUseQC create(){
        return new OecpSearchUseQC();
    }

    public OecpSearchUseQC build(){
        return this;
    }

}
