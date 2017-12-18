package com.passerbywhu.domain.waiter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("waiter")
public class NaiveWaiter implements Waiter {
    @Value("WaiterWang")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public void greetTo(String name) {
        System.out.println(this.name + " greetTo " + name);
    }

    @Override
    public void serveTo(String name) {
        System.out.println(this.name + " serveTo " + name);
    }

    public void smile(String name) {
        System.out.println(this.name + " smileTo " + name);
    }
}
