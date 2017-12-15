package com.passerbywhu.performance;

import java.lang.reflect.Method;

public class PerformanceMonitor {
    public static final ThreadLocal<Monitor> monitor = new ThreadLocal<Monitor>();
    public static void begin(Method method) {
        if (monitor.get() == null) {
            monitor.set(new Monitor());
        }
        monitor.get().begin(method);
    }

    public static void end() {
        monitor.get().end();
    }

    public static class Monitor {
        long beginTime;
        long endTime;
        String methodName;
        public void begin(Method method) {
            this.methodName = method.getName();
            beginTime = System.currentTimeMillis();
        }

        public void end() {
            endTime = System.currentTimeMillis();
            System.out.println("function " + methodName + " consumed " + (endTime - beginTime) + "ms");
        }
    }
}
