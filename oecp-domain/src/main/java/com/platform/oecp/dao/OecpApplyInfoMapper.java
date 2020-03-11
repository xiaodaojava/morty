package com.platform.oecp.dao;

import com.platform.oecp.models.dos.OecpApplyInfoDO;
import com.platform.oecp.models.qc.OecpApplyInfoQC;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 本类只做简单的增删改查,复杂的用mapper自己手写,也可以写在Provider里面
 * @author 造飞机团队自动生成
 */
@Mapper
@Repository
public interface OecpApplyInfoMapper {

    /**
     * 获取列表
     * @param oecpApplyInfoQC
     * @return
     */
    @SelectProvider(type = OecpApplyInfoProvider.class)
    List<OecpApplyInfoDO> listOecpApplyInfos(OecpApplyInfoQC oecpApplyInfoQC);

    /**
     * 获取数量
     * @param oecpApplyInfoQC
     * @return
     */
    @SelectProvider(type = OecpApplyInfoProvider.class)
    long countOecpApplyInfos(OecpApplyInfoQC oecpApplyInfoQC);

    /**
     * 插入
     * @param oecpApplyInfo
     * @return
     */
    @InsertProvider(type = OecpApplyInfoProvider.class)
    int insertOecpApplyInfo(OecpApplyInfoDO oecpApplyInfo);

    /**
     * 更新,必须要有id
     * @param oecpApplyInfo
     * @return
     */
    @UpdateProvider(type = OecpApplyInfoProvider.class)
    int updateOecpApplyInfo(OecpApplyInfoDO oecpApplyInfo);


    /**
    * 删除,必须要有id
    * @param id
    * @return
    */
    @UpdateProvider(type = OecpApplyInfoProvider.class)
    int removeOecpApplyInfoById(long id);
}
