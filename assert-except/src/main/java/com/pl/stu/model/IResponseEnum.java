package com.pl.stu.model;

import com.pl.stu.exception.BaseException;
import com.pl.stu.validate.BaseAssert;

import java.text.MessageFormat;

public interface IResponseEnum extends BaseAssert {

    int getCode();

    String getMsg();

    @Override
    default BaseException ofException(Object... args) {
        String msg = MessageFormat.format(this.getMsg(), args);
        return new BaseException(getCode(), msg);
    }
}
