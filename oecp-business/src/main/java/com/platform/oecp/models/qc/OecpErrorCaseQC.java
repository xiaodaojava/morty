package com.platform.oecp.models.qc;

import red.lixiang.tools.common.mybatis.model.BaseQC;
import red.lixiang.tools.common.mybatis.model.QC;
import java.util.Date;

/**
 * @author lixiang
 */
public class OecpErrorCaseQC extends BaseQC {

   
   
   /** 主键UUID  */
   private Long id;
   
   
   /** 错误码主键id  */
   private Long codeId;
   
   
   /** 案例主键id  */
   private Long caseId;
   
   
   
   
   
   
   
   

    
    

    public Long getId() {
        return this.id;
    }

    public OecpErrorCaseQC setId(Long id) {
        this.id = id;
        return this;
    }
     
    

    public Long getCodeId() {
        return this.codeId;
    }

    public OecpErrorCaseQC setCodeId(Long codeId) {
        this.codeId = codeId;
        return this;
    }
     
    

    public Long getCaseId() {
        return this.caseId;
    }

    public OecpErrorCaseQC setCaseId(Long caseId) {
        this.caseId = caseId;
        return this;
    }
     
    
    
    
    
    
    
    


    public static OecpErrorCaseQC create(){
        return new OecpErrorCaseQC();
    }

    public OecpErrorCaseQC build(){
        return this;
    }

}
