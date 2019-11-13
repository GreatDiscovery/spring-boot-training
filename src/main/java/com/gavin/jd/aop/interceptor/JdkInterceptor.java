package com.gavin.jd.aop.interceptor;

import com.gavin.jd.aop.aspects.Aspect;
import com.gavin.jd.core.util.ClassUtil;
import com.gavin.jd.core.util.ReflectUtil;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: Gavin
 * @date: 2019/11/11 21:28
 * @description:
 */
public class JdkInterceptor implements InvocationHandler, Serializable {
    private Object target;
    private Aspect aspect;

    public JdkInterceptor(Object target, Aspect aspect) {
        this.target = target;
        this.aspect = aspect;
    }

    public Object getTarget() {
        return this.target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        final Object target = this.target;
        final Aspect aspect = this.aspect;
        Object result = null;
        if (aspect.before(target, method, args)) {
//             有些private方法没法被外部调用
            ReflectUtil.setAccessible(method);
            try {
                result = method.invoke(ClassUtil.isStatic(method) ? null : target, args);
            } catch (InvocationTargetException e) {
                if (aspect.afterException(target, method, args, e.getTargetException())) {
                    throw e;
                }
            }
        }

        if (aspect.after(target, method, args, result)) {
            return result;
        }
        return null;
    }
}
