package com.passerbywhu.domain.seller;

import com.passerbywhu.annotation.Begger;

public class NormalSeller implements Seller {
    @Begger
    @Override
    public void sell(String goods) {
        System.out.println("seller " + goods);
    }
}
