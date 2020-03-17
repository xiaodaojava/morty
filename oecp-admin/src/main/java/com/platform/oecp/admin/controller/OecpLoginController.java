package com.platform.oecp.admin.controller;

import com.platform.oecp.business.manager.LoginManager;
import com.platform.oecp.models.response.ResponseBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * @version 1.0
 * @className: OecpLoginController
 * @author: LILIANG
 * @date: Create In 2020/3/15 15:36
 * @description:
 */
@RestController
@RequestMapping("/account")
public class OecpLoginController {

    /**
     * 日志
     */
    Logger logger = LoggerFactory.getLogger(OecpLoginController.class);

    @Autowired
    private LoginManager loginManager;

    /**
     * @author: LILIANG
     * @date: 2020/3/16 15:05
     * @Param : username
     * @Param : password
     * @return: com.platform.oecp.models.response.ResponseBase
     * @description: 用户登陆
     */
    @PostMapping("/login")
    public ResponseBase userLogin(@NotNull(message = "用户名不能为空") @Valid @RequestParam("username")String username,
                                  @NotNull(message = "用户密码不能为空") @Valid @RequestParam("password")String password) {
        ResponseBase responseBase = new ResponseBase();
        Map<String,Object> map = loginManager.login(username,password);
        responseBase.setData(map);
        responseBase.setCode(200);
        responseBase.setMsg("success");
        return responseBase;
    }
}
