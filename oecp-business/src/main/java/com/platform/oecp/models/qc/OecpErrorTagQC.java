package com.platform.oecp.models.qc;

import red.lixiang.tools.common.mybatis.model.BaseQC;

/**
 * @author lixiang
 */
public class OecpErrorTagQC extends BaseQC {

   
   
   /** 主键UUID  */
   private Long id;
   
   
   /** 错误码主键ID  */
   private Long codeId;
   
   
   /** 标签主键ID  */
   private Long tagId;
   
   
   
   
   
   
   
   

    
    

    public Long getId() {
        return this.id;
    }

    public OecpErrorTagQC setId(Long id) {
        this.id = id;
        return this;
    }
     
    

    public Long getCodeId() {
        return this.codeId;
    }

    public OecpErrorTagQC setCodeId(Long codeId) {
        this.codeId = codeId;
        return this;
    }
     
    

    public Long getTagId() {
        return this.tagId;
    }

    public OecpErrorTagQC setTagId(Long tagId) {
        this.tagId = tagId;
        return this;
    }
     
    
    
    
    
    
    
    


    public static OecpErrorTagQC create(){
        return new OecpErrorTagQC();
    }

    public OecpErrorTagQC build(){
        return this;
    }

}
