package com.gavin.jd.aop.proxy;

import com.gavin.jd.aop.ProxyUtil;
import com.gavin.jd.aop.aspects.Aspect;
import com.gavin.jd.aop.interceptor.JdkInterceptor;

/**
 * @author: Gavin
 * @date: 2019/11/11 21:20
 * @description:
 */
public class JdkProxyFactory extends ProxyFactory {
    @Override
    public <T> T proxy(T target, Aspect aspect) {
        return (T) ProxyUtil.newProxyInstance(target.getClass().getClassLoader(),
                new JdkInterceptor(target, aspect),
                target.getClass().getInterfaces());
    }
}
