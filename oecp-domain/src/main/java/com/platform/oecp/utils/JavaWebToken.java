package com.platform.oecp.utils;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.Map;

/**
 * @version 1.0
 * @className: JavaWebToken
 * @author: LILIANG
 * @date: Create In 2020/3/16 13:24
 * @description:
 */
public class JavaWebToken {
    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(JavaWebToken.class);
    /**
     * 自定义KEY
     */
    private static final String DEFINE_SECRET_KEY = "ABORIGINAL";

    /**
     * @author: LILIANG
     * @date: 2020/3/16 13:48
     *
     * @return: java.security.Key
     * @description: 该方法使用HS256算法和Secret:bankgl生成signKey
     */
    private static Key getKeyInstance() {
        //We will sign our JavaWebToken with our ApiKey secret
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        //加密，里面的字符串可自行定义
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(DEFINE_SECRET_KEY);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        return signingKey;
    }

    /**
     * @author: LILIANG
     * @date: 2020/3/16 13:59
     * @Param : claims 待转化的数据
     * @return: java.lang.String token字符串
     * @description: 使用HS256签名算法和生成的signingKey最终合成Token,claims中是有效载荷
     */
    public static String createToken(Map<String, Object> claims) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        return Jwts.builder()
                .setClaims(claims)
                //超时时间，设置为30分钟
                .setExpiration(new Date(nowMillis + 1000*60*30))
                .setIssuedAt(now)
                .setNotBefore(now)
                .signWith(SignatureAlgorithm.HS256, getKeyInstance())
                .compact();
    }

    /**
     * @author: LILIANG
     * @date: 2020/3/16 13:59
     * @Param : jwt token字符串
     * @return: java.util.Map<java.lang.String,java.lang.Object> 解析的数据
     * @description: 解析Token，同时也能验证Token，当验证失败返回null
     */
    public static Map<String, Object> parserJavaWebToken(String jwt) {
        try {
            Map<String, Object> jwtClaims =
                    Jwts.parser().setSigningKey(getKeyInstance()).parseClaimsJws(jwt).getBody();
            return jwtClaims;
        } catch (Exception e) {
            logger.info("json web token verify failed : " + e.getMessage());
            return null;
        }
    }

}
