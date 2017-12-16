package com.passerbywhu.controlflow;

import com.passerbywhu.waiter.Waiter;

public class WaiterDelegate {
    private Waiter waiter;

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }

    public void service(String name) {
        waiter.greetTo(name);
        waiter.serveTo(name);
    }
}
