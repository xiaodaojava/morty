package com.platform.oecp.service.test.mybatisTests;

import com.platform.oecp.service.ServiceApplicationTests;
import com.platform.tools.mybatis.generate.MybatisGenerateUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;

/**
 * @Author lixiang
 * @CreateTime 2019-08-01
 **/
public class MybatisTests extends ServiceApplicationTests {

    @Autowired
    private DataSource dataSource;

    @Test
    public void testGenerate(){
        MybatisGenerateUtils utils = new MybatisGenerateUtils(dataSource);
        //这种生成方式,会直接生成到对应文件夹里面
        utils.defaultGenerate("item", "freight_value","com.platform.market","freight",true);
        // 这种生成方式,只会生成在根目录里面
       // utils.defaultGenerate("item","sku","com.platform.market");

    }



}
