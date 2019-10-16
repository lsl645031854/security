package com.jetty.homolo.security.lambda;

/**
 * @Author: lsl
 * @Description:
 * @Date: Created on 14:43 2019/10/16
 */
@FunctionalInterface
public interface FilterDash<T> {
    boolean predicate(T t);
}
