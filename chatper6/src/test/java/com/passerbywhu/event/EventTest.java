package com.passerbywhu.event;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class EventTest {
    @Test
    public void test() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:com/passerbywhu/event/beans.xml");
        MailSender sender = (MailSender) ctx.getBean("mailSender");
        sender.sendMail("robot");
    }
}
