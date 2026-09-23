package com.rest.demo.common;

import lombok.Data;
import org.slf4j.MDC;

@Data
public class Result<T> {
    private int code;
    private String message;
    private T data;
    private long timestamp;
    private String traceId;  // 用于获取链路追踪 ID

    private Result(){
        System.out.println("构造器执行，MDC 里的 traceId: " + MDC.get("traceId"));
        this.timestamp = System.currentTimeMillis();
        this.traceId = MDC.get("traceId");
    }

    // 成功响应工厂的方法
    public static <T> Result<T> success(){
        return success(null);
    }

    public static <T> Result<T> success(T data){
        Result<T> result = new Result<>();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMessage(ResultCode.SUCCESS.getMessage());
        result.setData(data);
        return result;
    }

    // 失败响应工厂的方法
    public static <T> Result<T> error(ResultCode resultCode){
        Result<T> result = new Result<>();
        result.setCode(resultCode.getCode());
        result.setMessage(resultCode.getMessage());
        return result;
    }

    public static <T> Result<T> error(int code,String message){
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

}
