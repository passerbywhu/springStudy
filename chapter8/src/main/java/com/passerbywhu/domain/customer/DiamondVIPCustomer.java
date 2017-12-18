package com.passerbywhu.domain.customer;

import com.passerbywhu.domain.waiter.DiamondVIPWaiter;
import org.springframework.stereotype.Component;

@Component("diamondVipCustomer")
public class DiamondVIPCustomer extends GoldVIPCustomer {
    public void setWaiter(DiamondVIPWaiter waiter) {
        this.waiter = waiter;
    }
}
