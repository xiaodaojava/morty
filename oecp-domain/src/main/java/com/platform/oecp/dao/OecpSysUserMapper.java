package com.platform.oecp.dao;

import com.platform.oecp.models.dos.OecpSysUserDO;
import com.platform.oecp.models.qc.OecpSysUserQC;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 本类只做简单的增删改查,复杂的用mapper自己手写,也可以写在Provider里面
 * @author 造飞机团队自动生成
 */
@Mapper
@Repository
public interface OecpSysUserMapper {

    /**
     * 获取列表
     * @param oecpSysUserQC
     * @return
     */
    @SelectProvider(type = OecpSysUserProvider.class)
    List<OecpSysUserDO> listOecpSysUsers(OecpSysUserQC oecpSysUserQC);

    /**
     * 获取数量
     * @param oecpSysUserQC
     * @return
     */
    @SelectProvider(type = OecpSysUserProvider.class)
    long countOecpSysUsers(OecpSysUserQC oecpSysUserQC);

    /**
     * 插入
     * @param oecpSysUser
     * @return
     */
    @InsertProvider(type = OecpSysUserProvider.class)
    @SelectKey(keyColumn = "id",resultType = Long.class,before = false,keyProperty = "id",statement ="SELECT LAST_INSERT_ID()" )
    int insertOecpSysUser(OecpSysUserDO oecpSysUser);

    /**
     * 更新,必须要有id
     * @param oecpSysUser
     * @return
     */
    @UpdateProvider(type = OecpSysUserProvider.class)
    int updateOecpSysUser(OecpSysUserDO oecpSysUser);


    /**
    * 删除,必须要有id
    * @param id
    * @return
    */
    @UpdateProvider(type = OecpSysUserProvider.class)
    int removeOecpSysUserById(long id);
}
