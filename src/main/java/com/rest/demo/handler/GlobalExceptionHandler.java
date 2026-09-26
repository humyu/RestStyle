package com.rest.demo.handler;

import com.rest.demo.common.Result;
import com.rest.demo.common.ResultCode;
import com.rest.demo.exception.BusinessException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 自定义 BusinessException 异常
    @ExceptionHandler(BusinessException.class)
    public Result<?> handlerBusinessException(BusinessException e){
        return Result.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result<?> handlerException(Exception e){
        return Result.error(ResultCode.INTERNAL_SERVER_ERROR);
    }
}
