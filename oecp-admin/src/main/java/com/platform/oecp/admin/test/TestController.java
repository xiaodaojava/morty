package com.platform.oecp.admin.test;

import com.platform.oecp.models.dos.OecpSysUserDO;
import com.platform.oecp.utils.UserUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @className: TestController
 * @author: LILIANG
 * @date: Create In 2020/3/26 21:31
 * @description:
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/user")
    public OecpSysUserDO testSysUser(){
        OecpSysUserDO user = UserUtil.currentUser();
        return user;
    }
}
