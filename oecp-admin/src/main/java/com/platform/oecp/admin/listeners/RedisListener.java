package com.platform.oecp.admin.listeners;

import com.platform.oecp.RedisClientApplication;
import io.lettuce.core.api.StatefulRedisConnection;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import red.lixiang.tools.spring.ContextHolder;

/**
 * @className: RedisListener
 * @author: LILIANG
 * @date: Create In 2020/3/14 12:57 
 * @description:
 * @version 1.0
 */
@Component
public class RedisListener implements ApplicationListener<ContextRefreshedEvent> {

    /**
     * @author: LILIANG
     * @date: 2020/3/14 13:35
     * @Param event:
     * @return: void
     * @description:
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext context = ContextHolder.getApplicationContext();
        //redis客户端初始化
        StatefulRedisConnection<String,String> connection = (StatefulRedisConnection<String,String>) context.getBean("statefulRedisConnection");
        RedisClientApplication.commands=connection.sync();
    }
}
