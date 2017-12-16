package com.passerbywhu.controlflow;

import com.passerbywhu.waiter.NaiveWaiter;
import com.passerbywhu.waiter.Waiter;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ControlFlowPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class ControlFlowTest {
    @Test
    public void classPathTest() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:controlflow/beans.xml");
        Waiter controlWaiter = (Waiter) ctx.getBean("controlWaiter");
        controlWaiter.greetTo("xxx");
        WaiterDelegate delegate = new WaiterDelegate();
        delegate.setWaiter(controlWaiter);
        delegate.service("xxx");
    }

    @Test
    public void test() {
        ProxyFactory factory = new ProxyFactory();
        BeforeAdvice advice = new com.passerbywhu.advice.BeforeAdvice();
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
        ControlFlowPointcut pointCut = new ControlFlowPointcut(WaiterDelegate.class, "service");
        advisor.setPointcut(pointCut);
        advisor.setAdvice(advice);

        NaiveWaiter target = new NaiveWaiter();
        factory.setTarget(target);
        factory.addAdvisor(advisor);
        Waiter proxyWaiter = (Waiter) factory.getProxy();
        proxyWaiter.greetTo("xxx");
        WaiterDelegate delegate = new WaiterDelegate();
        delegate.setWaiter(proxyWaiter);
        delegate.service("xxx");
    }
}
