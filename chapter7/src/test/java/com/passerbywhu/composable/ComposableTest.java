package com.passerbywhu.composable;

import com.passerbywhu.controlflow.WaiterDelegate;
import com.passerbywhu.dynamic.GreetingDynamicPointCut;
import com.passerbywhu.waiter.NaiveWaiter;
import com.passerbywhu.waiter.Waiter;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.ControlFlowPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class ComposableTest {
    @Test
    public void classpahtTest() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:composable/beans.xml");
        Waiter proxyWaiter = (Waiter) ctx.getBean("proxyWaiter");
        proxyWaiter.greetTo("xxx");
        WaiterDelegate delegate = new WaiterDelegate();
        delegate.setWaiter(proxyWaiter);
        delegate.service("xxx");
        delegate.service("HongYe");
    }

    @Test
    public void test() {
        ProxyFactory factory = new ProxyFactory();
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
        ComposablePointcut composablePointcut = new ComposablePointcut();
        ControlFlowPointcut flowPointcut = new ControlFlowPointcut(WaiterDelegate.class, "service");
        NameMatchMethodPointcut methodNamePointcut = new NameMatchMethodPointcut();
        methodNamePointcut.addMethodName("greetTo");
        GreetingDynamicPointCut specialCustomerPointcut = new GreetingDynamicPointCut();
        composablePointcut.intersection((Pointcut) flowPointcut);
        composablePointcut.intersection((Pointcut) methodNamePointcut);
        composablePointcut.intersection((Pointcut) specialCustomerPointcut);
        advisor.setPointcut(composablePointcut);

        BeforeAdvice beforeAdvice = new com.passerbywhu.advice.BeforeAdvice();
        advisor.setAdvice(beforeAdvice);

        NaiveWaiter target = new NaiveWaiter();
        factory.setTarget(target);
        factory.addAdvisor(advisor);
        Waiter composableWaiter = (Waiter) factory.getProxy();
        composableWaiter.greetTo("xxx");
        composableWaiter.serveTo("xxx");
        WaiterDelegate delegate = new WaiterDelegate();
        delegate.setWaiter(composableWaiter);
        delegate.service("xxx");
        delegate.service("HongYe");

    }
}
