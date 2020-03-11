package com.platform.oecp.dao;

import com.platform.oecp.models.dos.OecpCaseInfoDO;
import com.platform.oecp.models.qc.OecpCaseInfoQC;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 本类只做简单的增删改查,复杂的用mapper自己手写,也可以写在Provider里面
 * @author 造飞机团队自动生成
 */
@Mapper
@Repository
public interface OecpCaseInfoMapper {

    /**
     * 获取列表
     * @param oecpCaseInfoQC
     * @return
     */
    @SelectProvider(type = OecpCaseInfoProvider.class)
    List<OecpCaseInfoDO> listOecpCaseInfos(OecpCaseInfoQC oecpCaseInfoQC);

    /**
     * 获取数量
     * @param oecpCaseInfoQC
     * @return
     */
    @SelectProvider(type = OecpCaseInfoProvider.class)
    long countOecpCaseInfos(OecpCaseInfoQC oecpCaseInfoQC);

    /**
     * 插入
     * @param oecpCaseInfo
     * @return
     */
    @InsertProvider(type = OecpCaseInfoProvider.class)
    int insertOecpCaseInfo(OecpCaseInfoDO oecpCaseInfo);

    /**
     * 更新,必须要有id
     * @param oecpCaseInfo
     * @return
     */
    @UpdateProvider(type = OecpCaseInfoProvider.class)
    int updateOecpCaseInfo(OecpCaseInfoDO oecpCaseInfo);


    /**
    * 删除,必须要有id
    * @param id
    * @return
    */
    @UpdateProvider(type = OecpCaseInfoProvider.class)
    int removeOecpCaseInfoById(long id);
}
