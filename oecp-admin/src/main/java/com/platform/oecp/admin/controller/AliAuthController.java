package com.platform.oecp.admin.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipaySystemOauthTokenRequest;
import com.alipay.api.request.AlipayUserInfoShareRequest;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.alipay.api.response.AlipayUserInfoShareResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    /**
     * 支付相关配置信息
     */
    private static final String SERVER_URL = "https://openapi.alipay.com/gateway.do";
    private static final String APP_ID = "2021001141609481";
    private static final String FORMAT = "json";
    private static final String CHARSET = "GBK";
    private static final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAl9qJ97ulCzpRXvTPLYWONFXOrRxr3/fUuxxe2y7H29TZ2a6p36oa3eF7nHXFFC0rbanIGNpTBxHTTr8nv7zlL+oZF8MVGR5KZhUvZ5QNYTay7LWbNs5i/WtWqrx+qikJoXmmWcBJOo1AIwU4h0q9cXRyDT2OrgHX1MEJ/7kE+gW9lAIh+B/aFwmjqDJGChDC/Qa9GEm2kkksHh9AbQ02+bZffc/LmFR3puBlK9WqBeiwoQjujETVmI0W1dW7RIBzHZ9XBW9SkRY250YxxWpIzDEdmVoiCixW6aPj7OAzpWGMHiTXtHBjG5RzGP6YtF1vInJnoLNCy2Aw3wbzTRM+vwIDAQAB";
    private static final String APP_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCIcJo8AHtbHR/Cirb4AlulrnrRFUcTRB6XRdK21p00m6hNOE98HowmYp38d8v1UJEpXwYufTjq3aOt0X9X1mH7KK5EhE6ZbuWkMPmo5OFAaz7BMSi/7ARSvDOT9gzC3MPQne3AKHdKL5AvUgSBt6phCQ2K9Aa25ydCicM9x9Z9kEf9iezx7myIdcZ3MEKed2S0WnTSE//V8Ez4kb8WjHZNZ2wJiKYMX7OxCcbt0liCN5A9KIhN30bjxhA7vY90pU5ZsXtoBBZgCEMLsKCRI4g5XnT2bwWVtL+c59+ZFQQV6X4e24vcc0O2cZiCmuurD1Gv7CqkligLQhyfMlq/vNaBAgMBAAECggEAeDODncLq6i1xUom0gjBJn2Bk8RimwlFsBedMqSnP244aqtUmKXocDKErAEZmGFv/VwxRPNmzMC9NSQ/c+Xx0W7nONay+NixeAdXnzSS/UWpqIfd2KAb9FAqcAglt2qp1lK/dykGcPm5Cv32pXMJ7Rvubw8QSukZQ7yzBJgeNbpZHzEjIgbxpvJ5kULUJrY7PNmQ2h+0bKAw6K75blm3dgafj0IeA+6evyHgQ439M0Y+uGAwDEZev3O/jpuK6paMj4Hcd/BJuYm4ahFYy+9oHSeDQvX/x8oIEoiZIwjp7iJ9dTsD3gTnay9DOolxchA3RgTtbUb9Exp6oJYSy7rF5MQKBgQDPeKusq/a2yWLzF+o2h0v+vPKZAWTtAKslcQD45lMj0hgD3loKPWTnlUvKhT3/EElJBkoLBFKZYaROI+cLoE1w5hYTtu8v+N/a2OX8ViJNJnnPJv7fdxi7APt1sBfPsOg34mPrA1sBplSYq2x4FzMdrQAemgsFFEaL/8bvLQaHtQKBgQCoWpV8vrUcVnkNzlrBmlFRahdNzj8xUMHG62IvjDCYuJ/zdlFHiYGieAw2LyRVnD7lmCqFeVo7NWHWtRI4L38KauGUD5fATrmSto4T1f8BGv0uoVFsqA00uHcBJessTV5J+3lX1Gk1KEZ9Y9w2SlcYVbU+/Hjd2YNYYeQeJ837HQKBgQCty2TsEWVrOwnznz3oja/AZaFHQJ691kiH5cCtv6s3n3/UhcehOkqzoCHMNY94gbkSPf16exWCPQP5HSQnXhJhF6y4uQ5mfjFvTzBhD/pN7IQvXng007xYsnry3B8mMQhl//Q5YycyG5ZUCY2kj7KXElu+RsYibBiooAuSQYJt3QKBgFzEtZTsvX3lBIWgDRCbyW10aWz9VoMFPhIvyIXs2SZ+rd0JeJZT5jQxtIDzDzGBjIMVi3DLQvZXXxdh5a1CNt31sWHWCcf1WXrHz5iMlhz000irqeOW4tgHQcRHMcTSyT85LE9Cg8q/67/SlBjyc/W73MjddHjDEAZWws3/HxjdAoGAH92IWNuvRtK1/+KhqAr+pvTjcdib0bmqcAeNK03RoQGWXsaKg2gwxJsbCxUw8szlgBJOMtawEhACB3DIqYxdLXek+a8/Xu91VdcFs149xuHWIXmQ7XIlwSKftZ4h4GWTfGUYKH2Y2Y+Jz2JESHv2O/d/dV6Q11oRdZVZKKEytbg=";
    private static final String SIGN_TYPE = "RSA2";
    private static final String GRANT_TYPE = "authorization_code";

    /**
     * @author: LILIANG
     * @date: 2020/3/14 16:56
     * @Param authCode:
     * @return: com.alipay.api.response.AlipaySystemOauthTokenResponse
     * @description: 用户信息授权
     *      拿authCode去换accessToken
     */
    @GetMapping("authRedirect")
    public AlipaySystemOauthTokenResponse authRedirect(@RequestParam("auth_code") String authCode){
        logger.info("Method》authRedirect,请求参数auth_code:{}",authCode);
        try {
            // 1. 设置参数（全局只需设置一次）
            AlipayClient alipayClient = new DefaultAlipayClient(SERVER_URL, APP_ID, APP_PRIVATE_KEY, FORMAT, CHARSET, ALIPAY_PUBLIC_KEY, SIGN_TYPE);
            AlipaySystemOauthTokenRequest request = new AlipaySystemOauthTokenRequest();
            request.setCode(authCode);
            request.setGrantType(GRANT_TYPE);
            AlipaySystemOauthTokenResponse oauthTokenResponse = alipayClient.execute(request);
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
    public AlipayUserInfoShareResponse getAuthInfo(@RequestParam("access_token") String accessToken){
        AlipayClient alipayClient = new DefaultAlipayClient(SERVER_URL,APP_ID,APP_PRIVATE_KEY,FORMAT,CHARSET,ALIPAY_PUBLIC_KEY,SIGN_TYPE);
        AlipayUserInfoShareRequest request = new AlipayUserInfoShareRequest();
        AlipayUserInfoShareResponse response = null;
        try {
            response = alipayClient.execute(request,accessToken);
            if(response.isSuccess()){
                logger.info("调用成功");
            } else {
                logger.info("调用失败");
            }
            return response;
        } catch (AlipayApiException e) {
            logger.info("获取用户信息失败！异常错误码为：{},异常内容为:{}",e.getErrCode(),e.getErrMsg());
        }
        return null;
    }


}
