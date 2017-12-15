package com.passerbywhu.advice;

import com.passerbywhu.waiter.NaiveWaiter;
import com.passerbywhu.waiter.Waiter;
import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class AdviceInterceptorTest {
    @Test
    public void test() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:advice/beans.xml");
        Waiter waiter = (Waiter) ctx.getBean("augmentWaiter");
        waiter.greetTo("robot");
        waiter.serveTo("robot");
    }

    @Test
    public void test2() {
        Waiter target = new NaiveWaiter();
        org.springframework.aop.BeforeAdvice advice = new BeforeAdvice();
        org.springframework.aop.AfterAdvice afterAdvice = new AfterAdvice();
        MethodInterceptor serveInterceptor = new ServeToInterceptor();
        ThrowsAdvice emptyNameAdvice = new NoServeToEmptyPersonAdvice();
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvice(advice);
        pf.addAdvice(afterAdvice);
        pf.addAdvice(serveInterceptor);
        pf.addAdvice(emptyNameAdvice);
        Waiter proxy = (Waiter) pf.getProxy();
        proxy.greetTo("John");
        proxy.serveTo("John");
        try {
            proxy.serveTo("");
        } catch (IllegalArgumentException e) {

        }
    }
}
