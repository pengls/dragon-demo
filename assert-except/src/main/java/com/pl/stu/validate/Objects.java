package com.pl.stu.validate;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

/**
 * @ClassName: Objects
 * @Description: object utils
 * @Author: pengl
 * @Date: 2020/5/1 22:32
 * @Version V1.0
 */
public final class Objects {

    public static boolean isEmpty(Object object) {
        if (object == null) {
            return true;
        } else if (object instanceof CharSequence) {
            return ((CharSequence) object).length() == 0;
        } else if (object.getClass().isArray()) {
            return Array.getLength(object) == 0;
        } else if (object instanceof Collection) {
            return ((Collection) object).isEmpty();
        } else {
            return object instanceof Map ? ((Map) object).isEmpty() : false;
        }
    }

    public static boolean isNotEmpty(Object object) {
        return !isEmpty(object);
    }
}
