package com.platform.oecp.admin.router;

import com.alibaba.fastjson.JSON;
import com.platform.oecp.models.dos.OecpSysUserDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;
import red.lixiang.tools.base.exception.BusinessException;
import red.lixiang.tools.jdk.StringTools;
import red.lixiang.tools.spring.redis.RedisTools;

import java.util.Arrays;
import java.util.List;

import static com.platform.oecp.models.OecpCommonConstants.PLEASE_LOGIN_ERROR;
import static com.platform.oecp.models.OecpCommonConstants.TOKEN_IS_NULL;

/**
 *
 * @Author lixiang
 * @CreateTime 2019-08-10
 **/
@Configuration
public class CheckFilter implements WebFilter {

    /**
     * 日志
     */
    Logger logger = LoggerFactory.getLogger(CheckFilter.class);
    /**
     * 项目编码
     */
    @Value("${project.code}")
    private int projectCode;

    @Autowired
    private RedisTools redisUtils;

    /**
     * Process the Web request and (optionally) delegate to the next
     * {@code WebFilter} through the given {@link WebFilterChain}.
     *
     * @param exchange the current server exchange
     * @param chain    provides a way to delegate to the next filter
     * @return {@code Mono<Void>} to indicate when request processing is complete
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        ServerWebExchange serverWebExchange = null;

        try {
            serverWebExchange = doFilter(exchange, chain);
        } catch (Exception e) {
            logger.error("wrong in filter ",e);
            //如果jwt为空的话, 构建一个新的请求,在那个请求里面进行处理返回
            ServerHttpRequest authErrorReq = exchange.getRequest().mutate().path("/common/error?msg=系统处理异常").build();
            ServerWebExchange authErrorExchange = exchange.mutate().request(authErrorReq).build();
            return chain.filter(authErrorExchange);
        }
        return chain.filter(serverWebExchange);
    }

    /**
     * @description 做过滤处理
     * @param exchange
     * @param chain
     * @return
     */
    public ServerWebExchange doFilter(ServerWebExchange exchange, WebFilterChain chain){
        ServerHttpRequest request = exchange.getRequest();

        List<String> skipUrls = Arrays.asList("/","/api/account/login"
                ,"/api/authRedirect"
                ,"/api/getAuthInfo"
                ,"/api/account/loginByAccountName","/api/account/register");
        String path = request.getPath().toString();
        if(skipUrls.contains(path) || path.contains("static")|| path.contains("favicon.ico")){
            return exchange;
        }

        // 从header里面取出Jwt
        String token = request.getHeaders().getFirst("token");
        if(null ==token){
            logger.info("访问异常，token为空！");
            throw new BusinessException("token is null", projectCode+ TOKEN_IS_NULL);
        }
        // token不为空,则取出用户信息
        AccountRepo.setToken(token);
        String accountJSON = (String)redisUtils.get("TOKEN_TELL_KEY_" + token);
        if(StringTools.isBlank(accountJSON)){
            logger.info("访问异常，token不为空，但是已经失效！");
            throw new BusinessException("please login",projectCode+ PLEASE_LOGIN_ERROR);
        }
        if(null != accountJSON){
            OecpSysUserDO vo = JSON.parseObject(accountJSON,OecpSysUserDO.class);
            AccountRepo.setAccountInMemory(vo);
        }

        return exchange;
    }

}
