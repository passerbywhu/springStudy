package com.passerbywhu.configure;

import com.passerbywhu.domain.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertNotNull;

public class AnnotationApplicationContextTest {
    @Test
    public void getBeans() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AnnotationBeans.class);
        Car car = ctx.getBean("AnnotationCar", Car.class);
        assertNotNull(car);
        System.out.println(car.getBrand());
    }
}
