package com.passerbywhu.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class ServeToInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object[] args = methodInvocation.getArguments();
        String methodName = methodInvocation.getMethod().getName();
        if (methodName.contains("serveTo")) {
            String clientName = (String) args[0];
            System.out.println("You are a stupid man " + clientName);
        }
        Object result = methodInvocation.proceed();
        if (methodName.contains("serveTo")) {
            String clientName = (String) args[0];
            System.out.println("Go back your home now " + clientName);
        }
        return result;
    }
}
