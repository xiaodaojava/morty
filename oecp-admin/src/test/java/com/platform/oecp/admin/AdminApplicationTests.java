package com.platform.oecp.admin;

import com.platform.oecp.dao.OecpErrorCaseMapper;
import com.platform.oecp.models.dos.OecpErrorAndCaseInfoDO;
import com.platform.oecp.models.dos.OecpErrorCaseDO;
import com.platform.oecp.models.qc.OecpErrorCaseQC;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import red.lixiang.tools.common.mybatis.generate.MybatisGenerateUtils;

import javax.sql.DataSource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminApplicationTests {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private OecpErrorCaseMapper mapper;

	@Test
	public void testList(){
		OecpErrorCaseDO caseDO = new OecpErrorCaseDO();
		caseDO.setCaseId(1L).setCodeId(1L);
		int i = mapper.insertOecpErrorCase(caseDO);
		System.out.println(i);
	}

	@Test
	public void contextLoads() {
		MybatisGenerateUtils utils = new MybatisGenerateUtils(dataSource);
		//这种生成方式,会直接生成到对应文件夹里面
		utils.defaultGenerate("morty", "oecp_case_tag","com.platform.oecp");

	}

}
