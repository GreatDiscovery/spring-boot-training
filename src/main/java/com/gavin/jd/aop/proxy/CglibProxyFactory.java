package com.gavin.jd.aop.proxy;

import com.gavin.jd.aop.aspects.Aspect;
import com.gavin.jd.aop.interceptor.CglibInterceptor;
import net.sf.cglib.proxy.Enhancer;

/**
 * @author: Gavin
 * @date: 2019/11/11 21:15
 * @description:
 */
public class CglibProxyFactory extends ProxyFactory{
    private static final long serialVersionUID = 1L;
    @Override
    public <T> T proxy(T target, Aspect aspect) {
        final Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(new CglibInterceptor(target, aspect));
        return (T) enhancer.create();
    }
}
