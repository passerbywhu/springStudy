package com.passerbywhu.domain;

public class Car {
    String brand;
    int price;

    public Car(String brand, int price) {
        this.brand = brand;
        this.price = price;
    }

    public Car() {

    }

    public String getBrand() {
        return brand;
    }

    public int getPrice() {
        return price;
    }


    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return this.brand + this.price;
    }
}
