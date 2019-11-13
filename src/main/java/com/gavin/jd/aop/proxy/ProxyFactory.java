package com.gavin.jd.aop.proxy;

import com.gavin.jd.aop.aspects.Aspect;
import com.gavin.jd.core.util.ReflectUtil;

import java.io.Serializable;

/**
 * @author: Gavin
 * @Date: 2019/11/10 18:58
 */
public abstract class ProxyFactory implements Serializable {
    private static final long serialVersionUID = 1L;

    public static <T> T createProxy(T target, Class<? extends Aspect> aspectClass) {
        return createProxy(target, ReflectUtil.newInstance(aspectClass));
    }

    public abstract <T> T proxy(T target, Aspect aspect);
    public static <T> T createProxy(T target, Aspect aspect) {
        return create().proxy(target, aspect);
    }

    public static ProxyFactory create() {
        try {
            return new CglibProxyFactory();
        } catch (NoClassDefFoundError e) {

        }
        return new JdkProxyFactory();
    }
}
