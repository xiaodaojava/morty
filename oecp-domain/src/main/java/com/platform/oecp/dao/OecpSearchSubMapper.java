package com.platform.oecp.dao;

import com.platform.oecp.models.dos.OecpSearchSubDO;
import com.platform.oecp.models.qc.OecpSearchSubQC;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 本类只做简单的增删改查,复杂的用mapper自己手写,也可以写在Provider里面
 * @author 造飞机团队自动生成
 */
@Mapper
@Repository
public interface OecpSearchSubMapper {

    /**
     * 获取列表
     * @param oecpSearchSubQC
     * @return
     */
    @SelectProvider(type = OecpSearchSubProvider.class)
    List<OecpSearchSubDO> listOecpSearchSubs(OecpSearchSubQC oecpSearchSubQC);

    /**
     * 获取数量
     * @param oecpSearchSubQC
     * @return
     */
    @SelectProvider(type = OecpSearchSubProvider.class)
    long countOecpSearchSubs(OecpSearchSubQC oecpSearchSubQC);

    /**
     * 插入
     * @param oecpSearchSub
     * @return
     */
    @InsertProvider(type = OecpSearchSubProvider.class)
    @SelectKey(keyColumn = "id",resultType = Long.class,before = false,keyProperty = "id",statement ="SELECT LAST_INSERT_ID()" )
    int insertOecpSearchSub(OecpSearchSubDO oecpSearchSub);

    /**
     * 更新,必须要有id
     * @param oecpSearchSub
     * @return
     */
    @UpdateProvider(type = OecpSearchSubProvider.class)
    int updateOecpSearchSub(OecpSearchSubDO oecpSearchSub);


    /**
    * 删除,必须要有id
    * @param id
    * @return
    */
    @UpdateProvider(type = OecpSearchSubProvider.class)
    int removeOecpSearchSubById(long id);

    /**
     * 删除以mainId为条件
     * @param mainId
     * @return
     */
    @UpdateProvider(type = OecpSearchSubProvider.class)
    int removeOecpSearchMainByMainId(long mainId);

    /**
     * 删除以caseId为条件
     * @param caseId
     * @return
     */
    @UpdateProvider(type = OecpSearchSubProvider.class)
    int removeOecpSearchSubByCaseId(long caseId);
}
