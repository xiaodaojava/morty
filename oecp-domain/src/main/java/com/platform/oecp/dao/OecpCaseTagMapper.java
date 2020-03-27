package com.platform.oecp.dao;

import com.platform.oecp.models.dos.OecpCaseTagDO;
import com.platform.oecp.models.qc.OecpCaseTagQC;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 本类只做简单的增删改查,复杂的用mapper自己手写,也可以写在Provider里面
 * @author 造飞机团队自动生成
 */
@Mapper
@Repository
public interface OecpCaseTagMapper {

    /**
     * 获取列表
     * @param oecpCaseTagQC
     * @return
     */
    @SelectProvider(type = OecpCaseTagProvider.class)
    List<OecpCaseTagDO> listOecpCaseTags(OecpCaseTagQC oecpCaseTagQC);

    /**
     * 获取数量
     * @param oecpCaseTagQC
     * @return
     */
    @SelectProvider(type = OecpCaseTagProvider.class)
    long countOecpCaseTags(OecpCaseTagQC oecpCaseTagQC);

    /**
     * 插入
     * @param oecpCaseTag
     * @return
     */
    @InsertProvider(type = OecpCaseTagProvider.class)
    @SelectKey(keyColumn = "id",resultType = Long.class,before = false,keyProperty = "id",statement ="SELECT LAST_INSERT_ID()" )
    int insertOecpCaseTag(OecpCaseTagDO oecpCaseTag);

    /**
     * 更新,必须要有id
     * @param oecpCaseTag
     * @return
     */
    @UpdateProvider(type = OecpCaseTagProvider.class)
    int updateOecpCaseTag(OecpCaseTagDO oecpCaseTag);


    /**
    * 删除,必须要有id
    * @param id
    * @return
    */
    @UpdateProvider(type = OecpCaseTagProvider.class)
    int removeOecpCaseTagById(long id);

    /**
     * 案列下的tag批量删除
     * @param caseId
     * @return
     */
    @UpdateProvider(type = OecpCaseTagProvider.class)
    int removeOecpCaseTagByCaseId(long caseId);
}
