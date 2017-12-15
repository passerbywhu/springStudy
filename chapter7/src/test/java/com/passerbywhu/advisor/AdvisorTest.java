package com.passerbywhu.advisor;

import com.passerbywhu.advice.BeforeAdvice;
import com.passerbywhu.waiter.NaiveWaiter;
import com.passerbywhu.waiter.Waiter;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class AdvisorTest {
    @Test
    public void pathTest() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:advisor/beans.xml");
        Waiter waiter = (Waiter) ctx.getBean("proxyWaiter");
        waiter.greetTo("Rock");
        waiter.serveTo("Rock");

        Waiter waiter2 = (Waiter) ctx.getBean("regexWaiter");
        waiter2.greetTo("Mary");
        waiter2.serveTo("Mary");
    }

    @Test
    public void test() {
        NaiveWaiter waiter = new NaiveWaiter();
        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(waiter);

        GreetingAdvisor greetingAdvisor = new GreetingAdvisor();
        greetingAdvisor.setAdvice(new BeforeAdvice());
        factory.addAdvisor(greetingAdvisor);

        Waiter realWaiter = (Waiter) factory.getProxy();
        realWaiter.greetTo("bob");
        realWaiter.serveTo("bob");
    }
}
