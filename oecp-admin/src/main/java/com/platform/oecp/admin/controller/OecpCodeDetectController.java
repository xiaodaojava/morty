package com.platform.oecp.admin.controller;

import com.platform.oecp.business.manager.CodeDetectManager;
import com.platform.oecp.dto.CodeDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import red.lixiang.tools.base.BaseResponse;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @version 1.0
 * @author gaozhirong 2020/3/22 13:57
 * @description 代码检测接口类
 */
@RestController
@RequestMapping("/oecpCodeDetect")
public class OecpCodeDetectController {

    @Resource
    private CodeDetectManager codeDetectManager;

    /**
     * 错误码检测接口
     * @param codeDto 代码传输对象
     * @return 校验结果
     */
    @PostMapping
    public BaseResponse<String> detectCode(@RequestBody CodeDto codeDto) {
        BaseResponse<String> baseResponse = new BaseResponse<>();
        codeDetectManager.detectCode(codeDto.getCode());
        baseResponse.setData("OK");
        return baseResponse;
    }

}
