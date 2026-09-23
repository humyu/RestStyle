package com.rest.demo.exception;

import com.rest.demo.common.ResultCode;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException{
    private final int code;

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(ResultCode resultCode) {
        super(resultCode.getMessage());
        this.code = resultCode.getCode();
    }

}
