package com.passerbywhu.delecareparent;

import com.passerbywhu.domain.seller.Seller;
import com.passerbywhu.domain.seller.NormalSeller;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class WaiterWithSellerAspect {
    @DeclareParents(value = "com.passerbywhu.domain.waiter.NaiveWaiter", defaultImpl = NormalSeller.class)
    public Seller seller;
}
