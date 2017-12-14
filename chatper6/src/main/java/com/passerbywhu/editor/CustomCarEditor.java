package com.passerbywhu.editor;

import java.beans.PropertyEditorSupport;

public class CustomCarEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (text == null || text.indexOf(",") == -1) {
            throw new IllegalArgumentException("format error");
        }
        String[] infos = text.split(",");
        Car car = new Car();
        car.setBrand(infos[0]);
        car.setMaxSpeed(Integer.parseInt(infos[1]));
        car.setPrice(Double.parseDouble(infos[2]));
        setValue(car);
    }

    @Override
    public String getAsText() {
        Object value = getValue();
        if (value == null) {
            return "";
        } else {
            Car car = (Car) value;
            return car.toString();
        }
    }
}
