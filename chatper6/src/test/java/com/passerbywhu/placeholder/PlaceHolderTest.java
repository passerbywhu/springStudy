package com.passerbywhu.placeholder;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class PlaceHolderTest {
    @Test
    public void test() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:com/passerbywhu/placeholder/beans.xml");
        DataSourceHolder holder = (DataSourceHolder) ctx.getBean("dataSourceHolder");
        System.out.println(holder.getDataSource());
    }
}
