package com.platform.oecp.dao;

import com.platform.oecp.models.dos.OecpErrorTagDO;
import com.platform.oecp.models.qc.OecpErrorTagQC;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * 本类只做简单的增删改查,复杂的用mapper自己手写,也可以写在Provider里面
 * @author 造飞机团队自动生成
 */
@Mapper
@Repository
public interface OecpErrorTagMapper {

    /**
     * 获取列表
     * @param oecpErrorTagQC
     * @return
     */
    @SelectProvider(type = OecpErrorTagProvider.class)
    List<OecpErrorTagDO> listOecpErrorTags(OecpErrorTagQC oecpErrorTagQC);

    /**
     * 获取数量
     * @param oecpErrorTagQC
     * @return
     */
    @SelectProvider(type = OecpErrorTagProvider.class)
    long countOecpErrorTags(OecpErrorTagQC oecpErrorTagQC);

    /**
     * 插入
     * @param oecpErrorTag
     * @return
     */
    @InsertProvider(type = OecpErrorTagProvider.class)
    int insertOecpErrorTag(OecpErrorTagDO oecpErrorTag);

    /**
     * 更新,必须要有id
     * @param oecpErrorTag
     * @return
     */
    @UpdateProvider(type = OecpErrorTagProvider.class)
    int updateOecpErrorTag(OecpErrorTagDO oecpErrorTag);


    /**
    * 删除,必须要有id
    * @param id
    * @return
    */
    @UpdateProvider(type = OecpErrorTagProvider.class)
    int removeOecpErrorTagById(long id);

    List<OecpErrorTagDO> listOecpErrorTagByIds(@Param("ids")Set<Long> codeIdSet);
}
