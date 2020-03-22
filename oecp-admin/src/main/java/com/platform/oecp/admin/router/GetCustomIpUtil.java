package com.platform.oecp.admin.router;


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
