package com.passerbywhu.performance;

import com.passerbywhu.introduction.ControllablePerformanceMonitor;
import com.passerbywhu.introduction.Monitorable;
import com.passerbywhu.waiter.NaiveWaiter;
import com.passerbywhu.waiter.Waiter;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultIntroductionAdvisor;
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

        Waiter waiter2 = (Waiter) ctx.getBean("monitorableWaiter2");
        System.out.println(waiter == waiter2);
        ((Monitorable) waiter2).setMonitorActive(false);
//        System.out.println(((Monitorable) waiter2).getMonitorActive());
        waiter2.greetTo("xxx");
        waiter2.serveTo("xxx");
        ((Monitorable) waiter2).setMonitorActive(true);
        waiter2.greetTo("xxx");
        waiter2.serveTo("xxx");
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

        DefaultIntroductionAdvisor introductionAdvisor = new DefaultIntroductionAdvisor(monitor);
        ProxyFactory factory2 = new ProxyFactory();
        factory2.addAdvisor(introductionAdvisor);
        factory2.setTarget(waiter);
        factory2.setProxyTargetClass(true);
        Waiter waiter2 = (Waiter) factory2.getProxy();
        waiter2.greetTo("xxx");
        waiter2.serveTo("xxx");
        ((Monitorable) waiter2).setMonitorActive(true);
        waiter2.greetTo("xxx");
        waiter2.serveTo("xxx");
    }
}
