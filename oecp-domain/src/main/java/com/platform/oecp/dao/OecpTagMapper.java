package com.platform.oecp.dao;

import com.platform.oecp.models.dos.OecpTagDO;
import com.platform.oecp.models.qc.OecpTagQC;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 本类只做简单的增删改查,复杂的用mapper自己手写,也可以写在Provider里面
 * @author 造飞机团队自动生成
 */
@Mapper
@Repository
public interface OecpTagMapper {

    /**
     * 获取列表
     * @param oecpTagQC
     * @return
     */
    @SelectProvider(type = OecpTagProvider.class)
    List<OecpTagDO> listOecpTags(OecpTagQC oecpTagQC);

    /**
     * 获取数量
     * @param oecpTagQC
     * @return
     */
    @SelectProvider(type = OecpTagProvider.class)
    long countOecpTags(OecpTagQC oecpTagQC);

    /**
     * 插入
     * @param oecpTag
     * @return
     */
    @InsertProvider(type = OecpTagProvider.class)
    @SelectKey(keyColumn = "id",resultType = Long.class,before = false,keyProperty = "id",statement ="SELECT LAST_INSERT_ID()" )
    int insertOecpTag(OecpTagDO oecpTag);

    /**
     * 更新,必须要有id
     * @param oecpTag
     * @return
     */
    @UpdateProvider(type = OecpTagProvider.class)
    int updateOecpTag(OecpTagDO oecpTag);


    /**
    * 删除,必须要有id
    * @param id
    * @return
    */
    @UpdateProvider(type = OecpTagProvider.class)
    int removeOecpTagById(long id);
}
