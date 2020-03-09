package com.platform.oecp.admin.controller;

import com.alibaba.fastjson.JSON;
import com.alipay.easysdk.base.oauth.models.AlipaySystemOauthTokenResponse;
import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.kernel.BaseClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lixiang
 * @date 2020/3/9
 **/
@Controller
public class AliAuthController {
    @GetMapping("authRedirect")
    @ResponseBody
    public String authRedirect(@RequestParam("auth_code") String authCode){
        //拿authCode去换accessToken
        try {

            Factory.setOptions(getOptions());
            AlipaySystemOauthTokenResponse token = Factory.Base.OAuth().getToken(authCode);
            return "你的支付宝userId是:"+ JSON.toJSONString(token);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "wrong";
    }

    private static BaseClient.Config getOptions() {
        BaseClient.Config config = new BaseClient.Config();
        config.protocol = "https";
        config.gatewayHost = "openapi.alipay.com";
        config.signType = "RSA2";

        // 请更换为您的AppId
        config.appId = "2021001141609481";
//        // 请更换为您的应用公钥证书文件路径
//        config.merchantCertPath = "/home/foo/appCertPublicKey_2019051064521003.crt";
//        // 请更换为您的支付宝公钥证书文件路径
//        config.alipayCertPath = "/home/foo/alipayCertPublicKey_RSA2.crt";
//        // 请更换为您的支付宝根证书文件路径
//        config.alipayRootCertPath = "/home/foo/alipayRootCert.crt";
        // 请更换为您的PKCS8格式的应用私钥
        config.merchantPrivateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCIcJo8AHtbHR/Cirb4AlulrnrRFUcTRB6XRdK21p00m6hNOE98HowmYp38d8v1UJEpXwYufTjq3aOt0X9X1mH7KK5EhE6ZbuWkMPmo5OFAaz7BMSi/7ARSvDOT9gzC3MPQne3AKHdKL5AvUgSBt6phCQ2K9Aa25ydCicM9x9Z9kEf9iezx7myIdcZ3MEKed2S0WnTSE//V8Ez4kb8WjHZNZ2wJiKYMX7OxCcbt0liCN5A9KIhN30bjxhA7vY90pU5ZsXtoBBZgCEMLsKCRI4g5XnT2bwWVtL+c59+ZFQQV6X4e24vcc0O2cZiCmuurD1Gv7CqkligLQhyfMlq/vNaBAgMBAAECggEAeDODncLq6i1xUom0gjBJn2Bk8RimwlFsBedMqSnP244aqtUmKXocDKErAEZmGFv/VwxRPNmzMC9NSQ/c+Xx0W7nONay+NixeAdXnzSS/UWpqIfd2KAb9FAqcAglt2qp1lK/dykGcPm5Cv32pXMJ7Rvubw8QSukZQ7yzBJgeNbpZHzEjIgbxpvJ5kULUJrY7PNmQ2h+0bKAw6K75blm3dgafj0IeA+6evyHgQ439M0Y+uGAwDEZev3O/jpuK6paMj4Hcd/BJuYm4ahFYy+9oHSeDQvX/x8oIEoiZIwjp7iJ9dTsD3gTnay9DOolxchA3RgTtbUb9Exp6oJYSy7rF5MQKBgQDPeKusq/a2yWLzF+o2h0v+vPKZAWTtAKslcQD45lMj0hgD3loKPWTnlUvKhT3/EElJBkoLBFKZYaROI+cLoE1w5hYTtu8v+N/a2OX8ViJNJnnPJv7fdxi7APt1sBfPsOg34mPrA1sBplSYq2x4FzMdrQAemgsFFEaL/8bvLQaHtQKBgQCoWpV8vrUcVnkNzlrBmlFRahdNzj8xUMHG62IvjDCYuJ/zdlFHiYGieAw2LyRVnD7lmCqFeVo7NWHWtRI4L38KauGUD5fATrmSto4T1f8BGv0uoVFsqA00uHcBJessTV5J+3lX1Gk1KEZ9Y9w2SlcYVbU+/Hjd2YNYYeQeJ837HQKBgQCty2TsEWVrOwnznz3oja/AZaFHQJ691kiH5cCtv6s3n3/UhcehOkqzoCHMNY94gbkSPf16exWCPQP5HSQnXhJhF6y4uQ5mfjFvTzBhD/pN7IQvXng007xYsnry3B8mMQhl//Q5YycyG5ZUCY2kj7KXElu+RsYibBiooAuSQYJt3QKBgFzEtZTsvX3lBIWgDRCbyW10aWz9VoMFPhIvyIXs2SZ+rd0JeJZT5jQxtIDzDzGBjIMVi3DLQvZXXxdh5a1CNt31sWHWCcf1WXrHz5iMlhz000irqeOW4tgHQcRHMcTSyT85LE9Cg8q/67/SlBjyc/W73MjddHjDEAZWws3/HxjdAoGAH92IWNuvRtK1/+KhqAr+pvTjcdib0bmqcAeNK03RoQGWXsaKg2gwxJsbCxUw8szlgBJOMtawEhACB3DIqYxdLXek+a8/Xu91VdcFs149xuHWIXmQ7XIlwSKftZ4h4GWTfGUYKH2Y2Y+Jz2JESHv2O/d/dV6Q11oRdZVZKKEytbg=";

        // 如果采用非证书模式，则无需赋值上面的三个证书路径，改为赋值如下的支付宝公钥字符串即可
         config.alipayPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAl9qJ97ulCzpRXvTPLYWONFXOrRxr3/fUuxxe2y7H29TZ2a6p36oa3eF7nHXFFC0rbanIGNpTBxHTTr8nv7zlL+oZF8MVGR5KZhUvZ5QNYTay7LWbNs5i/WtWqrx+qikJoXmmWcBJOo1AIwU4h0q9cXRyDT2OrgHX1MEJ/7kE+gW9lAIh+B/aFwmjqDJGChDC/Qa9GEm2kkksHh9AbQ02+bZffc/LmFR3puBlK9WqBeiwoQjujETVmI0W1dW7RIBzHZ9XBW9SkRY250YxxWpIzDEdmVoiCixW6aPj7OAzpWGMHiTXtHBjG5RzGP6YtF1vInJnoLNCy2Aw3wbzTRM+vwIDAQAB";
        return config;
    }
}
