package com.passerbywhu.introduction;

import com.passerbywhu.performance.PerformanceMonitor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

public class ControllablePerformanceMonitor extends DelegatingIntroductionInterceptor implements Monitorable {
    private static ThreadLocal<Boolean> monitorStatus = new ThreadLocal<Boolean>();

    public ControllablePerformanceMonitor() {
        super();
        System.out.println("controllablePerformanceMonitor init");
    }

    @Override
    public void setMonitorActive(boolean active) {
        monitorStatus.set(active);
    }

    @Override
    public boolean getMonitorActive() {
        return monitorStatus.get();
    }

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        Object result = null;
        if (monitorStatus.get() != null && monitorStatus.get()) {
            PerformanceMonitor.begin(mi.getMethod());
            result = super.invoke(mi);
            PerformanceMonitor.end();
        } else {
            result = super.invoke(mi);
        }
        return result;
    }
}
