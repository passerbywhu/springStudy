package com.passerbywhu.domain.customer;

import com.passerbywhu.domain.waiter.GoldVIPWaiter;
import org.springframework.stereotype.Component;

@Component("goldVipCustomer")
public class GoldVIPCustomer extends VIPCustomer {
    public void setWaiter(GoldVIPWaiter waiter) {
        this.waiter = waiter;
    }
}
