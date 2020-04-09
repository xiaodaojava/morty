package com.platform.oecp.admin.errorInfo;

import com.platform.oecp.business.manager.CommonManager;
import com.platform.oecp.dao.OecpErrorCaseMapper;
import com.platform.oecp.dto.ErrorInfoAndCaseDto;
import com.platform.oecp.models.dos.OecpErrorCaseDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import red.lixiang.tools.common.mybatis.generate.MybatisGenerateUtils;
import red.lixiang.tools.common.mybatis.model.Page;

import javax.sql.DataSource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ErrorInfoTests {


	@Autowired
	private CommonManager commonManager;

	@Test
	public void testGetErrorInfos(){
		List<ErrorInfoAndCaseDto> errorInfos = commonManager.getErrorInfos(new Page(1,10));
	}

}
