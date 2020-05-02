package com.pl.stu.model;

import com.pl.stu.exception.BaseException;
import com.pl.stu.validate.Assert;
import lombok.Getter;

import java.text.MessageFormat;

/**
 * @ClassName: ResponseEnum
 * @Description: 统一错误码定义
 * @Author: pengl
 * @Date: 2020/5/1 22:38
 * @Version V1.0
 */
@Getter
public enum ResponseEnum implements Assert {
    SYSTEM_ERROR(10000, "Server Error!"),
    VALID_ERROR(10001, "Parameters Validate Error!"),

    PARAM_EMPTY_ERROR(20000, "Missing necessary parameters!"),

    USER_EXITS(20001, "User already exists!"),
    PASS_STRENGTH_LOW(20002, "Password strength is low!");

    private int code;
    private String msg;

    ResponseEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public BaseException ofException(Object... args) {
        String msg = MessageFormat.format(this.getMsg(), args);
        return new BaseException(getCode(), msg);
    }
}
