package com.passerbywhu.configure;

import com.passerbywhu.domain.Boss;
import com.passerbywhu.domain.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnnotationBeans {
    @Bean(name = "AnnotationCar")
    public Car buildCar() {
        Car car = new Car();
        car.setBrand("SlowCar");
        car.setColor("red");
        car.setMaxSpeed(200);
        return car;
    }

    @Bean(name = "BossWang")
    public Boss getBossWang() {
        Boss boss = new Boss();
        boss.setCar(buildCar());
        boss.setName("BossWang");
        return boss;
    }
}
