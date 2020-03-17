package com.platform.oecp.admin.router;

import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.*;
import org.springframework.web.server.WebExceptionHandler;
import reactor.core.publisher.Mono;
import red.lixiang.tools.base.BaseResponse;

import java.util.Map;

/**
 * @author lixiang
 * @date 2020/3/17
 **/
@Component
public class GlobalErrorHandler extends AbstractErrorWebExceptionHandler {


    public GlobalErrorHandler(ErrorAttributes errorAttributes, ResourceProperties resourceProperties, ApplicationContext applicationContext, ServerCodecConfigurer configurer) {
        super(errorAttributes, resourceProperties, applicationContext);
        this.setMessageWriters(configurer.getWriters());

    }

    /**
     * Create a {@link RouterFunction} that can route and handle errors as JSON responses
     * or HTML views.
     * <p>
     * If the returned {@link RouterFunction} doesn't route to a {@code HandlerFunction},
     * the original exception is propagated in the pipeline and can be processed by other
     * {@link WebExceptionHandler}s.
     *
     * @param errorAttributes the {@code ErrorAttributes} instance to use to extract error
     *                        information
     * @return a {@link RouterFunction} that routes and handles errors
     */
    @Override
    protected RouterFunction<ServerResponse> getRoutingFunction(
            ErrorAttributes errorAttributes) {

        return RouterFunctions.route(
                RequestPredicates.all(), this::renderErrorResponse);
    }

    private Mono<ServerResponse> renderErrorResponse(
            ServerRequest request) {

        Map<String, Object> errorPropertiesMap = getErrorAttributes(request, false);
        BaseResponse baseResponse = BaseResponse.fail(errorPropertiesMap.get("status").toString(),
                errorPropertiesMap.get("message").toString());
        return ServerResponse.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(baseResponse));
    }
}
