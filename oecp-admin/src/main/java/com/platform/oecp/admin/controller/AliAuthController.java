package com.platform.oecp.admin.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.alipay.api.response.AlipayUserInfoShareResponse;
import com.platform.oecp.business.manager.impl.AliCommonManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author lixiang
 * @date 2020/3/9
 **/
@RestController
public class AliAuthController {

    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(AliAuthController.class);

    @Autowired
    private AliCommonManager aliCommonManager;

    /**
     * @author: LILIANG
     * @date: 2020/3/14 16:56
     * @Param authCode:
     * @return: com.alipay.api.response.AlipaySystemOauthTokenResponse
     * @description: 用户信息授权
     *      拿authCode去换accessToken
     */
    @GetMapping("authRedirect")
    public AlipaySystemOauthTokenResponse authRedirect(@NotNull(message = "authCode不能为空") @Valid @RequestParam("authCode") String authCode,
                                                       @NotNull(message = "appId不能为空") @Valid @RequestParam("appId") String appId){
        logger.info("Method》authRedirect,请求参数auth_code:{}",authCode);
        try {
            AlipaySystemOauthTokenResponse oauthTokenResponse = aliCommonManager.aliPayAuth(appId,authCode);
            return oauthTokenResponse;
        } catch (Exception e) {
            logger.info("调用遭遇异常，原因:{}",e.getMessage());
        }
        logger.info("前端获取token失败！auth_code:{}",authCode);
        return null;
    }

    /**
     * @author: LILIANG
     * @date: 2020/3/14 16:56
     * @Param accessToken:
     * @return: com.alipay.api.response.AlipayUserInfoShareResponse
     * @description:
     */
    @GetMapping("getAuthInfo")
    public AlipayUserInfoShareResponse getAuthInfo(@NotNull(message = "accessToken不能为空") @Valid @RequestParam("accessToken") String accessToken,
                                                   @NotNull(message = "appId不能为空") @Valid @RequestParam("appId") String appId){
        try {
            AlipayUserInfoShareResponse response = aliCommonManager.getAliUserInfo(accessToken,appId);
            return response;
        } catch (AlipayApiException e) {
            logger.info("获取用户信息失败！异常错误码为：{},异常内容为:{}",e.getErrCode(),e.getErrMsg());
        }
        return null;
    }
}
