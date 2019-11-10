package com.gavin.jd.aop;

import com.gavin.jd.aop.aspects.Aspect;
import com.gavin.jd.core.util.ClassUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author: Gavin
 * @Date: 2019/11/10 17:54
 */
public class ProxyUtil {

    public static <T> T proxy(T target, Class<? extends Aspect> aspectClass) {
        return ProxyFactory.createProxy(target, aspectClass);
    }

    public static <T> T newProxyInstance(ClassLoader classLoader, InvocationHandler invocationHandler, Class<?>... interfaces) {
        return (T) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
    }

    public static <T> T newProxyInstance(InvocationHandler invocationHandler, Class<?>... interfaces) {
        return newProxyInstance(ClassUtil.getClassLoader(), invocationHandler, interfaces);
    }
}
