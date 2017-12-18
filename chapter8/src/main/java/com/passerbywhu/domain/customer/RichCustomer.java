package com.passerbywhu.domain.customer;

import com.passerbywhu.domain.waiter.NaiveWaiter;
import com.passerbywhu.domain.waiter.Waiter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RichCustomer implements Customer {
    protected Waiter waiter;
    @Value("RichCustomer")
    String name;

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }

    @Override
    public void orderFood() {
        waiter.greetTo(name);
        System.out.println("Give me the best food");
        waiter.serveTo(name);
    }

    @Override
    public void payBill() {
        waiter.greetTo(name);
        System.out.println("Need not to give me back the left money");
        waiter.serveTo(name);
    }
}
