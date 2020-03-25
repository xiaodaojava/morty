package com.platform.oecp.models.qc;

import red.lixiang.tools.common.mybatis.model.BaseQC;
import red.lixiang.tools.common.mybatis.model.QC;
import java.util.Date;

/**
 * @author lixiang
 */
public class OecpCaseTagQC extends BaseQC {

   
   
   /** 主键UUID  */
   private Long id;
   
   
   /** 案例主键ID  */
   private Long caseId;
   
   
   /** 标签主键ID  */
   private Long tagId;
   
   
   
   
   
   
   
   

    
    

    public Long getId() {
        return this.id;
    }

    public OecpCaseTagQC setId(Long id) {
        this.id = id;
        return this;
    }
     
    

    public Long getCaseId() {
        return this.caseId;
    }

    public OecpCaseTagQC setCaseId(Long caseId) {
        this.caseId = caseId;
        return this;
    }
     
    

    public Long getTagId() {
        return this.tagId;
    }

    public OecpCaseTagQC setTagId(Long tagId) {
        this.tagId = tagId;
        return this;
    }
     
    
    
    
    
    
    
    


    public static OecpCaseTagQC create(){
        return new OecpCaseTagQC();
    }

    public OecpCaseTagQC build(){
        return this;
    }

}
