package com.passerbywhu.performance;

import com.passerbywhu.introduction.ControllablePerformanceMonitor;
import com.passerbywhu.introduction.Monitorable;
import com.passerbywhu.waiter.NaiveWaiter;
import com.passerbywhu.waiter.Waiter;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class PerformanceTest {
    @Test
    public void pathTest() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:performance/beans.xml");
        Waiter waiter = (Waiter) ctx.getBean("monitorableWaiter");
        waiter.greetTo("Jack");
        waiter.serveTo("Jack");
        ((Monitorable) waiter).setMonitorActive(true);
        waiter.greetTo("Ma");
        waiter.serveTo("Ma");
    }
    @Test
    public void test() {
        NaiveWaiter waiter = new NaiveWaiter();
        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(waiter);

        MonitorInterceptor monitorInterceptor = new MonitorInterceptor();
        factory.addAdvice(monitorInterceptor);

        ControllablePerformanceMonitor monitor = new ControllablePerformanceMonitor();
        factory.addAdvice(monitor);
        //引介增强必须要指明增强的接口是啥
        factory.addInterface(Monitorable.class);
        factory.setProxyTargetClass(true);

        Monitorable monitorWaiter = (Monitorable) factory.getProxy();
        monitorWaiter.setMonitorActive(false);
        ((Waiter) monitorWaiter).greetTo("Lion");
        ((Waiter) monitorWaiter).serveTo("Lion");

        monitorWaiter.setMonitorActive(true);
        ((Waiter) monitorWaiter).greetTo("Rein");
        ((Waiter) monitorWaiter).serveTo("Rein");
    }
}
