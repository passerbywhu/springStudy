package com.passerbywhu.configure;

import com.passerbywhu.domain.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertNotNull;

public class ClassPathApplicationContext {
    @Test
    public void getBean() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        Car car = ctx.getBean("car", Car.class);
        assertNotNull(car);
        System.out.println(car.getBrand());
    }
}
