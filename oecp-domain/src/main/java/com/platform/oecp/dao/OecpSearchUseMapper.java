package com.platform.oecp.dao;

import com.platform.oecp.models.dos.OecpSearchUseDO;
import com.platform.oecp.models.qc.OecpSearchUseQC;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 本类只做简单的增删改查,复杂的用mapper自己手写,也可以写在Provider里面
 * @author 造飞机团队自动生成
 */
@Mapper
@Repository
public interface OecpSearchUseMapper {

    /**
     * 获取列表
     * @param oecpSearchUseQC
     * @return
     */
    @SelectProvider(type = OecpSearchUseProvider.class)
    List<OecpSearchUseDO> listOecpSearchUses(OecpSearchUseQC oecpSearchUseQC);

    /**
     * 获取数量
     * @param oecpSearchUseQC
     * @return
     */
    @SelectProvider(type = OecpSearchUseProvider.class)
    long countOecpSearchUses(OecpSearchUseQC oecpSearchUseQC);

    /**
     * 插入
     * @param oecpSearchUse
     * @return
     */
    @InsertProvider(type = OecpSearchUseProvider.class)
    @SelectKey(keyColumn = "id",resultType = Long.class,before = false,keyProperty = "id",statement ="SELECT LAST_INSERT_ID()" )
    int insertOecpSearchUse(OecpSearchUseDO oecpSearchUse);

    /**
     * 更新,必须要有id
     * @param oecpSearchUse
     * @return
     */
    @UpdateProvider(type = OecpSearchUseProvider.class)
    int updateOecpSearchUse(OecpSearchUseDO oecpSearchUse);


    /**
    * 删除,必须要有id
    * @param id
    * @return
    */
    @UpdateProvider(type = OecpSearchUseProvider.class)
    int removeOecpSearchUseById(long id);
}
