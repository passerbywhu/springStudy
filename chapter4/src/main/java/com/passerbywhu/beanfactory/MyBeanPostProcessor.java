package com.passerbywhu.beanfactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String s) throws BeansException {
        if (s.equals("car")) {
            System.out.println("BeanPostProcessor beforeInitialization called");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String s) throws BeansException {
        if (s.equals("car")) {
            System.out.println("BeanPostProcessor afterInitialization called");
        }
        return bean;
    }
}
