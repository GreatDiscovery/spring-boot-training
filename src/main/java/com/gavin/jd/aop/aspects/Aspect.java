package com.gavin.jd.aop.aspects;

import java.lang.reflect.Method;

/**
 * @author: Gavin
 * @Date: 2019/11/10 18:49
 */
public interface Aspect {
    boolean before(Object target, Method method, Object[] args);
    boolean after(Object target, Method method, Object[] args);
    boolean after(Object target, Method method, Object[] args, Object returnVal);
    boolean afterException(Object target, Method method, Object[] args, Throwable e);
}
