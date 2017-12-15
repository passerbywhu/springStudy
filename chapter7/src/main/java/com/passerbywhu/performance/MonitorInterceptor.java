package com.passerbywhu.performance;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MonitorInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        PerformanceMonitor.begin(methodInvocation.getMethod());
        Object result = methodInvocation.proceed();
        PerformanceMonitor.end();
        return result;
    }
}
