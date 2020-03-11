package com.platform.oecp.dao;

import com.platform.oecp.models.dos.OecpUserRoleDO;
import com.platform.oecp.models.qc.OecpUserRoleQC;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 本类只做简单的增删改查,复杂的用mapper自己手写,也可以写在Provider里面
 * @author 造飞机团队自动生成
 */
@Mapper
@Repository
public interface OecpUserRoleMapper {

    /**
     * 获取列表
     * @param oecpUserRoleQC
     * @return
     */
    @SelectProvider(type = OecpUserRoleProvider.class)
    List<OecpUserRoleDO> listOecpUserRoles(OecpUserRoleQC oecpUserRoleQC);

    /**
     * 获取数量
     * @param oecpUserRoleQC
     * @return
     */
    @SelectProvider(type = OecpUserRoleProvider.class)
    long countOecpUserRoles(OecpUserRoleQC oecpUserRoleQC);

    /**
     * 插入
     * @param oecpUserRole
     * @return
     */
    @InsertProvider(type = OecpUserRoleProvider.class)
    @SelectKey(keyColumn = "id",resultType = Long.class,before = false,keyProperty = "id",statement ="SELECT LAST_INSERT_ID()" )
    int insertOecpUserRole(OecpUserRoleDO oecpUserRole);

    /**
     * 更新,必须要有id
     * @param oecpUserRole
     * @return
     */
    @UpdateProvider(type = OecpUserRoleProvider.class)
    int updateOecpUserRole(OecpUserRoleDO oecpUserRole);


    /**
    * 删除,必须要有id
    * @param id
    * @return
    */
    @UpdateProvider(type = OecpUserRoleProvider.class)
    int removeOecpUserRoleById(long id);
}
