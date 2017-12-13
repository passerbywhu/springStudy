package com.passerbywhu.beanfactory;

import com.passerbywhu.domain.Car;
import org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.testng.annotations.Test;

public class BeanFactoryTest {
    @Test
    public void getBeans() throws Throwable {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource res = resolver.getResource("classpath:beans.xml");
        System.out.println(res.getURL());

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(res);

        factory.addBeanPostProcessor(new MyBeanPostProcessor());
        factory.addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());
        factory.addBeanPostProcessor(new InitDestroyAnnotationBeanPostProcessor());

        Car car = factory.getBean("car", Car.class);
        System.out.println(car.getBrand());

        Car car2 = factory.getBean("car", Car.class);
        System.out.println("car1 == car2 " + (car == car2));
        factory.destroySingletons();
    }
}
