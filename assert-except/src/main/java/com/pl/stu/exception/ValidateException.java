package com.pl.stu.exception;

import lombok.Getter;

/**
 * @ClassName: BaseException
 * @Description: validate exception
 * @Author: pengl
 * @Date: 2020/5/1 21:59
 * @Version V1.0
 */
@Getter
public class ValidateException extends BaseException {
    private int code;
    private String msg;

    public ValidateException(int code, String msg) {
        super(code, msg);
    }
}
