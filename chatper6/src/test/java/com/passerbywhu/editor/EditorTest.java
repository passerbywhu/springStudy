package com.passerbywhu.editor;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class EditorTest {
    @Test
    public void test() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:com/passerbywhu/editor/beans.xml");
        Boss boss = (Boss) ctx.getBean("boss");
        System.out.println(boss);
    }
}
