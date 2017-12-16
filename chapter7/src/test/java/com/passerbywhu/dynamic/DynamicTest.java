package com.passerbywhu.dynamic;

import com.passerbywhu.advice.AfterAdvice;
import com.passerbywhu.advice.BeforeAdvice;
import com.passerbywhu.waiter.NaiveWaiter;
import com.passerbywhu.waiter.Waiter;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class DynamicTest {
    @Test
    public void classpathTest() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:dynamic/beans.xml");
        Waiter specialWaiter = (Waiter) ctx.getBean("specialWaiter");
        specialWaiter.greetTo("Monkey");
        specialWaiter.greetTo("HongYe");
        specialWaiter.serveTo("HongYe");
    }

    @Test
    public void test() {
        ProxyFactory factory = new ProxyFactory();
        DefaultPointcutAdvisor defaultPointcutAdvisor = new DefaultPointcutAdvisor();
        MethodBeforeAdvice beforeAdvice = new BeforeAdvice();
        AfterReturningAdvice afterAdvice = new AfterAdvice();
        NaiveWaiter waiter = new NaiveWaiter();
        factory.setTarget(waiter);

        Pointcut dynamicPointCut = new GreetingDynamicPointCut();
        defaultPointcutAdvisor.setAdvice(beforeAdvice);
        defaultPointcutAdvisor.setPointcut(dynamicPointCut);

        factory.addAdvisor(defaultPointcutAdvisor);
        Waiter proxyWaiter = (Waiter) factory.getProxy();
        proxyWaiter.greetTo("xxx");
        proxyWaiter.greetTo("HongYe");
        proxyWaiter.serveTo("HongYe");

    }
}
