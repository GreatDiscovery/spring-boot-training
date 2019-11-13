package com.gavin.jd.core.exception;

/**
 * @author: Gavin
 * @date: 2019/11/12 21:00
 * @description:
 */
public class UtilException extends RuntimeException {
    public UtilException(Throwable e) {
        super(e.getMessage(), e);
    }
    public UtilException(String message) {
        super(message);
    }
}
