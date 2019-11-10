package com.gavin.jd.proxy;

import com.gavin.jd.aop.aspects.Aspect;
import sun.reflect.misc.ReflectUtil;

import java.io.Serializable;

/**
 * @author: Gavin
 * @Date: 2019/11/10 18:58
 */
public class ProxyFactory implements Serializable {
    private static final long serialVersionUID = 1L;

    public static <T> T createProxy(T target, Class<? extends Aspect> aspectClass) {
        return createProxy(target, ReflectUtil.newInstance(aspectClass));
    }

    public static <T> T createProxy(T target, Aspect aspect) {

    }
}
