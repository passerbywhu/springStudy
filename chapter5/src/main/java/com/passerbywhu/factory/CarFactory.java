package com.passerbywhu.factory;

import com.passerbywhu.domain.Car;

public class CarFactory {
    public Car getCar() {
        Car car = new Car("busCar", 10);
        return car;
    }
}
