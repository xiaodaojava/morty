package com.platform.oecp.dao;

import com.platform.oecp.models.dos.OecpErrorInfoDO;
import com.platform.oecp.models.qc.OecpErrorInfoQC;
import com.platform.oecp.dto.ErrorInfoAndCaseDto;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 本类只做简单的增删改查,复杂的用mapper自己手写,也可以写在Provider里面
 * @author 造飞机团队自动生成
 */
@Mapper
@Repository
public interface OecpErrorInfoMapper {

    /**
     * 获取列表
     * @param oecpErrorInfoQC
     * @return
     */
    @SelectProvider(type = OecpErrorInfoProvider.class)
    List<OecpErrorInfoDO> listOecpErrorInfos(OecpErrorInfoQC oecpErrorInfoQC);

    /**
     * 获取数量
     * @param oecpErrorInfoQC
     * @return
     */
    @SelectProvider(type = OecpErrorInfoProvider.class)
    long countOecpErrorInfos(OecpErrorInfoQC oecpErrorInfoQC);

    /**
     * 根据 code 查询 ErrorInfoDO 信息.
     * @param code 错误码
     * @return 错误信息对象
     */
    @SelectProvider(type = OecpErrorInfoProvider.class)
    OecpErrorInfoDO getByCode(String code);

    /**
     * 插入
     * @param oecpErrorInfo
     * @return
     */
    @InsertProvider(type = OecpErrorInfoProvider.class)
    int insertOecpErrorInfo(OecpErrorInfoDO oecpErrorInfo);

    /**
     * 更新,必须要有id
     * @param oecpErrorInfo
     * @return
     */
    @UpdateProvider(type = OecpErrorInfoProvider.class)
    int updateOecpErrorInfo(OecpErrorInfoDO oecpErrorInfo);


    /**
    * 删除,必须要有id
    * @param id
    * @return
    */
    @UpdateProvider(type = OecpErrorInfoProvider.class)
    int removeOecpErrorInfoById(long id);
}
