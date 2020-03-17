package com.platform.oecp.admin.router;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import red.lixiang.tools.base.BaseResponse;
import red.lixiang.tools.base.exception.BusinessException;

/**
 * @author lixiang
 * @date 2020/3/17
 **/

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(code = HttpStatus.OK)
    public BaseResponse handleCustomException(BusinessException e) {
        return BaseResponse.fail(String.valueOf(e.getErrorCode()),e.getMessage());
    }

}
