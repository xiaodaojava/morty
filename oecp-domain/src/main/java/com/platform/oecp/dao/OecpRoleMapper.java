package com.platform.oecp.dao;

import com.platform.oecp.models.dos.OecpRoleDO;
import com.platform.oecp.models.qc.OecpRoleQC;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 本类只做简单的增删改查,复杂的用mapper自己手写,也可以写在Provider里面
 * @author 造飞机团队自动生成
 */
@Mapper
@Repository
public interface OecpRoleMapper {

    /**
     * 获取列表
     * @param oecpRoleQC
     * @return
     */
    @SelectProvider(type = OecpRoleProvider.class)
    List<OecpRoleDO> listOecpRoles(OecpRoleQC oecpRoleQC);

    /**
     * 获取数量
     * @param oecpRoleQC
     * @return
     */
    @SelectProvider(type = OecpRoleProvider.class)
    long countOecpRoles(OecpRoleQC oecpRoleQC);

    /**
     * 插入
     * @param oecpRole
     * @return
     */
    @InsertProvider(type = OecpRoleProvider.class)
    @SelectKey(keyColumn = "id",resultType = Long.class,before = false,keyProperty = "id",statement ="SELECT LAST_INSERT_ID()" )
    int insertOecpRole(OecpRoleDO oecpRole);

    /**
     * 更新,必须要有id
     * @param oecpRole
     * @return
     */
    @UpdateProvider(type = OecpRoleProvider.class)
    int updateOecpRole(OecpRoleDO oecpRole);


    /**
    * 删除,必须要有id
    * @param id
    * @return
    */
    @UpdateProvider(type = OecpRoleProvider.class)
    int removeOecpRoleById(long id);
}
