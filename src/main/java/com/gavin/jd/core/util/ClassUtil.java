package com.gavin.jd.core.util;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author: Gavin
 * @Date: 2019/11/10 18:18
 */
public class ClassUtil {
    public static <T> Class<T> getClass(T obj) {
        return null;
    }

    public static ClassLoader getClassLoader() {
        return ClassLoaderUtil.getClassLoader();
    }

    public static boolean isStatic(Method method) {
        return Modifier.isStatic(method.getModifiers());
    }
}
