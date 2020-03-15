package com.platform.oecp.admin.utils;


import org.springframework.http.server.reactive.ServerHttpRequest;

/**
 * @version 1.0
 * @className: GetCustomIpUtil
 * @author: LILIANG
 * @date: Create In 2020/3/15 15:01
 * @description:
 */
public class GetCustomIpUtil {

    /**
     * 未知ip标识
     */
    private static final String UN_KNOW = "unknown";
    /**
     * local
     */
    private static final String LOCAL_FLAG = "0:0:0:0:0:0:0:1";
    /**
     * local name
     */
    private static final String LOCAL_NAME = "localhost";
    /**
     * HEADER 方式
     */
    private static final String HEADER_TYPE_ONE = "x-forwarded-for";
    private static final String HEADER_TYPE_TWO = "Proxy-Client-IP";
    private static final String HEADER_TYPE_THREE = "WL-Proxy-Client-IP";

    /**
     * @author: LILIANG
     * @date: 2020/3/15 15:02
     * @Param : request
     * @return: java.lang.String
     * @description: 获取登录用户IP地址
     */
    public static String getIp(ServerHttpRequest request) {
        String ip = request.getRemoteAddress().getAddress().getHostAddress();
        return ip;
    }
}
