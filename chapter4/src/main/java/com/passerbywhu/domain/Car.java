package com.passerbywhu.domain;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Car implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {
    private static final String TAG = "CarBean ";

    public String getBrand() {
        return brand;
    }

    String brand;
    String color;
    int maxSpeed;

    public Car() {
        System.out.println(TAG + "constructor called");
    }

    public void setBrand(String brand) {
        System.out.println(TAG + "brand property set");
        this.brand = brand;
    }

    public void setColor(String color) {
        System.out.println(TAG + "color property set");
        this.color = color;
    }

    public void setMaxSpeed(int maxSpeed) {
        System.out.println(TAG + "maxSpeed property set");
        this.maxSpeed = maxSpeed;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println(TAG + "BeanFactory is " + beanFactory);
    }

    @Override
    public void setBeanName(String s) {
        System.out.println(TAG + "name is " + s);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println(TAG + "DisposableBean destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(TAG + "InitilizingBean afterPropertiesSet");
    }

    //通过<bean>的init-method属性指定的初始化方法
    public void myInit() {
        System.out.println(TAG + "init-method called");
    }

    //通过<bean>的destroy-method属性指定的销毁方法
    public void myDestroy() {
        System.out.println(TAG + "destroy-method called");
    }

    @PostConstruct
    public void myInitByAnnotation() {
        System.out.println(TAG + "postConstruct function called");
    }

    @PreDestroy
    public void myDestroyByAnnotation() {
        System.out.println(TAG + "preDestroy function called");
    }
}
