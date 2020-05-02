package com.pl.stu.validate;

import com.pl.stu.exception.BaseException;

/**
 * @ClassName: Assert
 * @Description: validate something
 * @Author: pengl
 * @Date: 2020/5/1 22:29
 * @Version V1.0
 */
public interface Assert {

    BaseException ofException(Object... args);

    default void notNull(Object object, Object... args) {
        if (object == null) {
            throw ofException(args);
        }
    }

    default void notBlank(String str, Object... args) {
        if (StrUtils.isBlank(str)) {
            throw ofException(args);
        }
    }

    default void isAnyBlank(CharSequence... css){
        if(StrUtils.isAnyBlank(css)){
            throw  ofException();
        }
    }

    default void isTrue(boolean expression, Object... args) {
        if (!expression) {
            throw ofException(args);
        }
    }

    default void isFalse(boolean expression, Object... args) {
        if (expression) {
            throw ofException(args);
        }
    }
}
