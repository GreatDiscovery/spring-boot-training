package com.gavin.jd.core.util;

import com.gavin.jd.core.exception.UtilException;

/**
 * @author: Gavin
 * @date: 2019/11/12 20:56
 * @description:
 */
public class ArrayUtil {
    public static boolean isEmpty(Object[] array) {
        if (null == array) {
            return true;
        } else if (isArray(array)) {
            return 0 == array.length;
        }
        throw new UtilException("Object to provide is not a Array !");
    }

    public static boolean isArray(Object obj) {
        if (null == obj) {
            return false;
        }
        return obj.getClass().isArray();
    }
}
