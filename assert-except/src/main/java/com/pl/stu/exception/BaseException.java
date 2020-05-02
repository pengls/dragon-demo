package com.pl.stu.exception;

import lombok.Getter;

/**
 * @ClassName: BaseException
 * @Description: 基础业务异常，扩展code属性
 * @Author: pengl
 * @Date: 2020/5/1 21:59
 * @Version V1.0
 */
@Getter
public class BaseException extends RuntimeException{
    private int code;
    private String msg;

    public BaseException(int code, String msg){
        super(msg);
        this.code = code;
        this.msg = msg;
    }
}
