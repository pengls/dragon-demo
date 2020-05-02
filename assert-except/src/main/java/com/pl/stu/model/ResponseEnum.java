package com.pl.stu.model;

import lombok.Getter;

/**
 * @ClassName: ResponseEnum
 * @Description: 统一错误码定义
 * @Author: pengl
 * @Date: 2020/5/1 22:38
 * @Version V1.0
 */
@Getter
public enum ResponseEnum implements IResponseEnum {

    VALID_ERROR(10001, "Parameters Validate Error!"),

    USER_EXITS(20001, "User already exists!"),
    PASS_STRENGTH_LOW(20002, "Password strength is low!");

    private int code;
    private String msg;

    ResponseEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
