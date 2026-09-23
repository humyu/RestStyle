package com.rest.demo.common;

public enum ResultCode {
    SUCCESS(200, "操作成功"),

    // 客户端错误(4xxxxx)
    BAD_REQUEST(40000, "请求参数错误"),
    UNAUTHORIZED(40100, "未登录或Token已过期"),
    FORBIDDEN(40300, "没有操作权限"),
    NOT_FOUND(40400,"请求的资源不存在"),

    // 服务端错误(5xxxx)
    INTERNAL_SERVER_ERROR(50000, "服务器内部异常"),
    SERVICE_UNAVAILABLE(50300, "服务暂时不可用");


    private final int code;
    private final String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
