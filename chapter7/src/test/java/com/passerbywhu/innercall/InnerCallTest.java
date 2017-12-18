package com.passerbywhu.innercall;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class InnerCallTest {
    @Test
    public void test() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:innercall/beans.xml");
        Man man = (Man) ctx.getBean("man");
        man.wear();
    }
}
