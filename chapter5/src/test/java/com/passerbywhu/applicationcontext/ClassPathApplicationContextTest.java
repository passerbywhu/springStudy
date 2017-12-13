package com.passerbywhu.applicationcontext;

import com.passerbywhu.domain.BigBoss;
import com.passerbywhu.domain.Boss;
import com.passerbywhu.domain.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class ClassPathApplicationContextTest {

    @Test
    public void getCar() {
        ApplicationContext parentCt = new ClassPathXmlApplicationContext("classpath:beans_parent.xml");
        ApplicationContext ct = new ClassPathXmlApplicationContext(new String[]{"classpath:beans.xml"}, parentCt);
        Car car = (Car) ct.getBean("car");
        Car car2 = (Car) ct.getBean("car2");
        Car busCar = (Car) ct.getBean("busCar");
        Car staticCar = (Car) ct.getBean("staticCar");
        System.out.println(car.getBrand() + " " + car.getPrice() + "万");
        System.out.println(car2.getBrand() + " " + car2.getPrice() + "万");
        System.out.println(busCar.getBrand());
        System.out.println(staticCar.getBrand());
        Boss bossLi = (Boss) ct.getBean("bossLi");
        System.out.println(bossLi.getCar().getBrand());
        Boss bossZhang = (Boss) ct.getBean("bossZhang");
        System.out.println(bossZhang.getCar().getBrand());
        BigBoss bigBoss = (BigBoss) ct.getBean("bigBoss");
        System.out.println(bigBoss.getWomen());
        System.out.println(bigBoss.getWomenStyle());
        System.out.println(bigBoss.getCompanies());

        BigBoss bigBossChild = (BigBoss) ct.getBean("bigBossChild");
        System.out.println(bigBossChild.getWomen());
        System.out.println(bigBossChild.getWomenStyle());
        System.out.println(bigBossChild.getCarList());
        System.out.println(bigBossChild.getPlugins());

        BigBoss bigBoss2 = (BigBoss) ct.getBean("bigBoss2");
        System.out.println(bigBoss2.getBoss().getCar());
        System.out.println(bigBoss2.getBoss().getCar());
        System.out.println(bigBoss2.getBoss().getCar());
    }
}
