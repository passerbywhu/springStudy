package com.passerbywhu.autoproxy;

import com.passerbywhu.waiter.Waiter;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class NameAutoProxyTest {
    @Test
    public void test() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:autoproxy/beans.xml");
        Waiter waiter = (Waiter) ctx.getBean("waiter");
        waiter.greetTo("xxx");
        waiter.serveTo("xxx");

    }
}
