package com.platform.oecp.admin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import red.lixiang.tools.base.exception.BusinessException;

/**
 * @author lixiang
 * @date 2020/3/19
 **/
@RestController
public class CommonController {
    @RequestMapping("api/common/error")
    public void error(@RequestParam(name = "msg") String msg,@RequestParam(name = "code") String code) {
        throw  new BusinessException(msg,(code));
    }

}
