package com.passerbywhu.domain.customer;

import com.passerbywhu.domain.waiter.VIPWaiter;
import org.springframework.stereotype.Component;

@com.passerbywhu.annotation.VIPCustomer
@Component("vipCustomer")
public class VIPCustomer extends RichCustomer {
    public void setWaiter(VIPWaiter waiter) {
        this.waiter = waiter;
    }
}
