package com.passerbywhu.beanattr;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class BeanAttrTest {
    @Test
    public void test() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:com/passerbywhu/beanattr/beans.xml");
        SysConfigLoader loader = (SysConfigLoader) ctx.getBean("sysConfigLoader");
        System.out.println(loader);
    }
}
