package com.gavin.jd.core.util;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Gavin
 * @Date: 2019/11/10 20:16
 */
public class ReflectUtil {

    /**
     *对象缓存
      */
    private static final Map<Class<?>, Constructor<?>[]> CONSTRUCTORS_CACHE = new HashMap<>();
    public static <T extends AccessibleObject> T setAccessible(T accessibleObject) {
        if (null != accessibleObject && false == accessibleObject.isAccessible()) {
            accessibleObject.setAccessible(true);
        }
        return accessibleObject;
    }

    public static <T> T newInstance(String clazz) throws Exception {
        try {
            return (T) Class.forName(clazz).newInstance();
        } catch (Exception e) {
            throw new Exception("Instance class [{}] error!");
        }
    }

    public static <T> T newInstance(Class<T> clazz, Object... params) {
        if (ArrayUtil.isEmpty(params)) {
            final Constructor<T> constructor = getConstructor(clazz);
        }
    }


    public static <T> Constructor<T> getConstructor(Class<T> clazz) {
        if (null == clazz) {
            return null;
        }

        final Constructor<?>[] constructors = getConstructors(clazz);

    }

    public static <T> Constructor<T>[] getConstructors(Class<?> clazz) {
        Constructor<?>[] constructors =
    }
}
