package com.platform.oecp.models.qc;

import red.lixiang.tools.common.mybatis.model.BaseQC;

/**
 * @author lixiang
 */
public class OecpErrorInfoQC extends BaseQC {

   
   
   /** UUID主键  */
   private Long id;
   
   /** 错误码 */
   private String code;

    /** 错误码创建人 */
   private String createBy;


    public Long getId() {
        return this.id;
    }

    public OecpErrorInfoQC setId(Long id) {
        this.id = id;
        return this;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public static OecpErrorInfoQC create(){
        return new OecpErrorInfoQC();
    }

    public OecpErrorInfoQC build(){
        return this;
    }

}
