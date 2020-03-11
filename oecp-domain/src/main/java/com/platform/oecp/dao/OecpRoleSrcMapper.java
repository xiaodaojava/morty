package com.platform.oecp.dao;

import com.platform.oecp.models.dos.OecpRoleSrcDO;
import com.platform.oecp.models.qc.OecpRoleSrcQC;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 本类只做简单的增删改查,复杂的用mapper自己手写,也可以写在Provider里面
 * @author 造飞机团队自动生成
 */
@Mapper
@Repository
public interface OecpRoleSrcMapper {

    /**
     * 获取列表
     * @param oecpRoleSrcQC
     * @return
     */
    @SelectProvider(type = OecpRoleSrcProvider.class)
    List<OecpRoleSrcDO> listOecpRoleSrcs(OecpRoleSrcQC oecpRoleSrcQC);

    /**
     * 获取数量
     * @param oecpRoleSrcQC
     * @return
     */
    @SelectProvider(type = OecpRoleSrcProvider.class)
    long countOecpRoleSrcs(OecpRoleSrcQC oecpRoleSrcQC);

    /**
     * 插入
     * @param oecpRoleSrc
     * @return
     */
    @InsertProvider(type = OecpRoleSrcProvider.class)
    int insertOecpRoleSrc(OecpRoleSrcDO oecpRoleSrc);

    /**
     * 更新,必须要有id
     * @param oecpRoleSrc
     * @return
     */
    @UpdateProvider(type = OecpRoleSrcProvider.class)
    int updateOecpRoleSrc(OecpRoleSrcDO oecpRoleSrc);


    /**
    * 删除,必须要有id
    * @param id
    * @return
    */
    @UpdateProvider(type = OecpRoleSrcProvider.class)
    int removeOecpRoleSrcById(long id);
}
