package com.platform.oecp;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.SetArgs;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisClientApplication {
	@Value("${spring.redis.host}")
	private String host;
	
	@Value("${spring.redis.password}")
	private String password;
	
	@Value("${spring.redis.port}")
	private String port;

	public static RedisCommands<String,String> commands;
	
	private static int expireSecond = 5;
	
	@Bean(name="RedisUri")
	RedisURI RedisUri(){
		return RedisURI.builder().withHost(host).withPort(Integer.parseInt(port)).withPassword(password).build();
    }
	
	@Bean
	RedisClient redisClient(RedisURI RedisUri){
		RedisClient client = RedisClient.create(RedisUri);
		return client;
    }

	@Bean(destroyMethod = "close")
	StatefulRedisConnection<String,String> statefulRedisConnection(RedisClient redisClient){
		return redisClient.connect();
    }
    
	public void TestRedisSet() {
		System.out.println("使用100个线程竞争set,键值时效时间为5s,测试时间1min");
		for (int i = 0; i < 100; i++) {
			TestRedisSetThread testRedisSetThread = new TestRedisSetThread(i);
			new Thread(testRedisSetThread).start();			
		}
	}
    
	/**
	 * 如果该key在redis中不存在，尝试写入并附带有效时间
	 * @param key
	 * @return true表示写入成功
	 */
	public static boolean setNxExpire(String key) {
		String resultString = commands.set(key, "Y", new SetArgs().nx().ex(expireSecond));
		boolean isSetOK = (resultString != null && resultString.equals("OK"));
		return isSetOK;
	}
    
	private class TestRedisSetThread implements Runnable {
		private int number;
		
		public TestRedisSetThread(int number) {
			this.number=number;
		}

		@Override
		public void run() {
	        try {
	        	for (int i = 0; i < 600; i++) {
			        if (setNxExpire("expireKeyTesT")) {
				        System.out.println("线程编号"+number+"尝试set成功!当前时间"+new Date());
					}
					Thread.sleep(100);					
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
