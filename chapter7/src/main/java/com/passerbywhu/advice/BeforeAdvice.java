package com.passerbywhu.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class BeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        String methodName = method.getName();
        System.out.println("Before function " + methodName);
    }
}
