package com.bowen.blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * Created by libowen on 2018/7/12.
 * 前端统一返回结果
 */
@Data
@AllArgsConstructor
public class Result<T> {

    private int code;
    private String msg;
    private T data;

    @AllArgsConstructor
    public enum ResponseStatus {

        OK(200),

        PARAM_INVALID(400),

        NOT_LOGIN(1000),

        SERVER_ERROR(500);

        @Getter
        private final int code;
    }

    public Result(ResponseStatus responseStatus, String msg) {
        this.code = responseStatus.code;
        this.msg = msg;
    }

    public Result(ResponseStatus responseStatus, String msg, T data) {
        this.code = responseStatus.code;
        this.msg = msg;
        this.data = data;
    }

    public static <T>Result<T> success() {
        return new Result<T>(ResponseStatus.OK, "操作成功");
    }

    public static <T>Result<T> paramInvalid(String msg) {
        return new Result<T>(ResponseStatus.PARAM_INVALID, msg);
    }

}
