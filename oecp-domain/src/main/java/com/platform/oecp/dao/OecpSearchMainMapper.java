package com.platform.oecp.dao;

import com.platform.oecp.models.dos.OecpSearchMainDO;
import com.platform.oecp.models.qc.OecpSearchMainQC;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 本类只做简单的增删改查,复杂的用mapper自己手写,也可以写在Provider里面
 * @author 造飞机团队自动生成
 */
@Mapper
@Repository
public interface OecpSearchMainMapper {

    /**
     * 获取列表
     * @param oecpSearchMainQC
     * @return
     */
    @SelectProvider(type = OecpSearchMainProvider.class)
    List<OecpSearchMainDO> listOecpSearchMains(OecpSearchMainQC oecpSearchMainQC);

    /**
     * 获取数量
     * @param oecpSearchMainQC
     * @return
     */
    @SelectProvider(type = OecpSearchMainProvider.class)
    long countOecpSearchMains(OecpSearchMainQC oecpSearchMainQC);

    /**
     * 插入
     * @param oecpSearchMain
     * @return
     */
    @InsertProvider(type = OecpSearchMainProvider.class)
    @SelectKey(keyColumn = "id",resultType = Long.class,before = false,keyProperty = "id",statement ="SELECT LAST_INSERT_ID()" )
    int insertOecpSearchMain(OecpSearchMainDO oecpSearchMain);

    /**
     * 更新,必须要有id
     * @param oecpSearchMain
     * @return
     */
    @UpdateProvider(type = OecpSearchMainProvider.class)
    int updateOecpSearchMain(OecpSearchMainDO oecpSearchMain);


    /**
    * 删除,必须要有id
    * @param id
    * @return
    */
    @UpdateProvider(type = OecpSearchMainProvider.class)
    int removeOecpSearchMainById(long id);
}
