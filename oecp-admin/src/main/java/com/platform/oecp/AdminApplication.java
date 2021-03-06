package com.platform.oecp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

/**
 * @author lixiang
 */
@SpringBootApplication
@EnableAsync
public class AdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminApplication.class, args);
	}

	@Bean
	@Order(-1)
	public WebFilter contextPathWebFilter() {
		String contextPath = "/api";
		return (exchange, chain) -> {
			if (exchange.getRequest().getURI().getPath().equals("/")) {
				return chain.filter(exchange.mutate().request(exchange.getRequest().mutate().path("/index.html").build()).build());
			}
			ServerHttpRequest request = exchange.getRequest();
			if (request.getURI().getPath().startsWith(contextPath)) {
				return chain.filter(
						exchange.mutate()
								.request(request.mutate().contextPath(contextPath).build())
								.build());
			}
			return chain.filter(exchange);
		};
	}

	private static final String ALLOWED_HEADERS = "x-requested-with, authorization, Content-Type, Authorization, credential,token, X-XSRF-TOKEN";
	private static final String ALLOWED_METHODS = "GET, PUT, POST, DELETE, OPTIONS";
	private static final String ALLOWED_ORIGIN = "https://localhost";
	private static final String MAX_AGE = "3600";
	@Bean
	public WebFilter corsFilter() {
		return (ServerWebExchange ctx, WebFilterChain chain) -> {
			ServerHttpRequest request = ctx.getRequest();
				ServerHttpResponse response = ctx.getResponse();
				HttpHeaders headers = response.getHeaders();
				headers.add("Access-Control-Allow-Origin", ALLOWED_ORIGIN);
				headers.add("Access-Control-Allow-Methods", ALLOWED_METHODS);
				headers.add("Access-Control-Max-Age", MAX_AGE);
				headers.add("Access-Control-Allow-Headers",ALLOWED_HEADERS);
				headers.add("Access-Control-Allow-Credentials","true");
				if (request.getMethod() == HttpMethod.OPTIONS) {
					response.setStatusCode(HttpStatus.OK);
					return Mono.empty();
				}

			return chain.filter(ctx);
		};
	}

}
