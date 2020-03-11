package com.platform.oecp.dao;

import com.platform.oecp.models.dos.OecpConfigDO;
import com.platform.oecp.models.qc.OecpConfigQC;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 本类只做简单的增删改查,复杂的用mapper自己手写,也可以写在Provider里面
 * @author 造飞机团队自动生成
 */
@Mapper
@Repository
public interface OecpConfigMapper {

    /**
     * 获取列表
     * @param oecpConfigQC
     * @return
     */
    @SelectProvider(type = OecpConfigProvider.class)
    List<OecpConfigDO> listOecpConfigs(OecpConfigQC oecpConfigQC);

    /**
     * 获取数量
     * @param oecpConfigQC
     * @return
     */
    @SelectProvider(type = OecpConfigProvider.class)
    long countOecpConfigs(OecpConfigQC oecpConfigQC);

    /**
     * 插入
     * @param oecpConfig
     * @return
     */
    @InsertProvider(type = OecpConfigProvider.class)
    int insertOecpConfig(OecpConfigDO oecpConfig);

    /**
     * 更新,必须要有id
     * @param oecpConfig
     * @return
     */
    @UpdateProvider(type = OecpConfigProvider.class)
    int updateOecpConfig(OecpConfigDO oecpConfig);


    /**
    * 删除,必须要有id
    * @param id
    * @return
    */
    @UpdateProvider(type = OecpConfigProvider.class)
    int removeOecpConfigById(long id);
}
