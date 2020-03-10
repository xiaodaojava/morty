package com.platform.oecp.admin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import red.lixiang.tools.common.mybatis.generate.MybatisGenerateUtils;

import javax.sql.DataSource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminApplicationTests {

	@Autowired
	private DataSource dataSource;
	@Test
	public void contextLoads() {
		MybatisGenerateUtils utils = new MybatisGenerateUtils(dataSource);
		//这种生成方式,会直接生成到对应文件夹里面
		utils.defaultGenerate("morty", "oecp_case_info","com.platform.oecp");

	}

}
