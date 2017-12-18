package com.passerbywhu.domain.customer;

import com.passerbywhu.domain.waiter.NaiveWaiter;
import com.passerbywhu.domain.waiter.Waiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PoorCustomer implements Customer {
    @Value("poorCustomer")
    String name;
    Waiter waiter;

    public void setWaiter(Object waiter) {
        this.waiter = (Waiter) waiter;
    }

    @Override
    public void orderFood() {
        System.out.println(name + " begin orderFood");
        waiter.greetTo(name);
        System.out.println("Give me some cheap food. Thank you");
        waiter.serveTo(name);
        System.out.println(name + " end orderFood");
    }

    @Override
    public void payBill() {
        System.out.println(name + " begin payBill");
        waiter.greetTo(name);
        System.out.println("Could you give me some disCount?");
        waiter.serveTo(name);
        System.out.println(name + " end payBill");
    }
}
