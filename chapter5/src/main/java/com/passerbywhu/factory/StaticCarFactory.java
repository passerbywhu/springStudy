package com.passerbywhu.factory;

import com.passerbywhu.domain.Car;

public class StaticCarFactory {
    public static Car getStaticCar() {
        Car car = new Car("staticCar", 10);
        return car;
    }
}
