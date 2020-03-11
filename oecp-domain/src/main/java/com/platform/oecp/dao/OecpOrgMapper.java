package com.platform.oecp.dao;

import com.platform.oecp.models.dos.OecpOrgDO;
import com.platform.oecp.models.qc.OecpOrgQC;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 本类只做简单的增删改查,复杂的用mapper自己手写,也可以写在Provider里面
 * @author 造飞机团队自动生成
 */
@Mapper
@Repository
public interface OecpOrgMapper {

    /**
     * 获取列表
     * @param oecpOrgQC
     * @return
     */
    @SelectProvider(type = OecpOrgProvider.class)
    List<OecpOrgDO> listOecpOrgs(OecpOrgQC oecpOrgQC);

    /**
     * 获取数量
     * @param oecpOrgQC
     * @return
     */
    @SelectProvider(type = OecpOrgProvider.class)
    long countOecpOrgs(OecpOrgQC oecpOrgQC);

    /**
     * 插入
     * @param oecpOrg
     * @return
     */
    @InsertProvider(type = OecpOrgProvider.class)
    @SelectKey(keyColumn = "id",resultType = Long.class,before = false,keyProperty = "id",statement ="SELECT LAST_INSERT_ID()" )
    int insertOecpOrg(OecpOrgDO oecpOrg);

    /**
     * 更新,必须要有id
     * @param oecpOrg
     * @return
     */
    @UpdateProvider(type = OecpOrgProvider.class)
    int updateOecpOrg(OecpOrgDO oecpOrg);


    /**
    * 删除,必须要有id
    * @param id
    * @return
    */
    @UpdateProvider(type = OecpOrgProvider.class)
    int removeOecpOrgById(long id);
}
