package com.gavin.jd.aop.interceptor;

import com.gavin.jd.aop.aspects.Aspect;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: Gavin
 * @date: 2019/11/12 20:35
 * @description:
 */
public class CglibInterceptor implements MethodInterceptor {
    private Object target;
    private Aspect aspect;

    public CglibInterceptor(Object target, Aspect aspect) {
        this.target = target;
        this.aspect = aspect;
    }

    public Object getTarget() {
        return this.target;
    }
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        Object result = null;
        if (aspect.before(target, method, args)) {
          try {
            result = methodProxy.invokeSuper(o, args);
          } catch (InvocationTargetException e) {
              if (aspect.after(target, method, args));
              throw e;
          }
        }
        if (aspect.after(target, method, args)) {
            return result;
        }
        return null;
    }
}
