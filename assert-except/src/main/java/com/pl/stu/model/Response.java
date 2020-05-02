package com.pl.stu.model;

import lombok.Getter;

/**
 * @ClassName: Response
 * @Description: 统一前端结果模型
 * @Author: pengl
 * @Date: 2020/5/1 21:51
 * @Version V1.0
 */
@Getter
public class Response<T> {
    private static final int SUC_CODE = 0;
    private static final String SUC_MSG = "成功";

    private int code;
    private String msg;
    private T data;

    private Response(T data) {
        this.code = SUC_CODE;
        this.msg = SUC_MSG;
        this.data = data;
    }

    private Response(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static final <T> Response ok() {
        return new Response<>(null);
    }

    public static final <T> Response ok(T data) {
        return new Response<>(data);
    }

    public static final <T> Response error(int code, String msg) {
        return new Response<>(code, msg, null);
    }

    public static final <T> Response res(int code, String msg, T data) {
        return new Response<>(code, msg, data);
    }
}
