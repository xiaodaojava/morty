package com.platform.oecp.dao;

import com.platform.oecp.models.dos.OecpErrorCaseDO;
import com.platform.oecp.models.qc.OecpErrorCaseQC;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 本类只做简单的增删改查,复杂的用mapper自己手写,也可以写在Provider里面
 * @author 造飞机团队自动生成
 */
@Mapper
@Repository
public interface OecpErrorCaseMapper {

    /**
     * 获取列表
     * @param oecpErrorCaseQC
     * @return
     */
    @SelectProvider(type = OecpErrorCaseProvider.class)
    List<OecpErrorCaseDO> listOecpErrorCases(OecpErrorCaseQC oecpErrorCaseQC);

    /**
     * 获取数量
     * @param oecpErrorCaseQC
     * @return
     */
    @SelectProvider(type = OecpErrorCaseProvider.class)
    long countOecpErrorCases(OecpErrorCaseQC oecpErrorCaseQC);

    /**
     * 插入
     * @param oecpErrorCase
     * @return
     */
    @InsertProvider(type = OecpErrorCaseProvider.class)
    int insertOecpErrorCase(OecpErrorCaseDO oecpErrorCase);

    /**
     * 更新,必须要有id
     * @param oecpErrorCase
     * @return
     */
    @UpdateProvider(type = OecpErrorCaseProvider.class)
    int updateOecpErrorCase(OecpErrorCaseDO oecpErrorCase);


    /**
    * 删除,必须要有id
    * @param id
    * @return
    */
    @UpdateProvider(type = OecpErrorCaseProvider.class)
    int removeOecpErrorCaseById(long id);
}
