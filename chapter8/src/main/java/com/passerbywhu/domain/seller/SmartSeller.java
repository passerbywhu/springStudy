package com.passerbywhu.domain.seller;

import org.springframework.stereotype.Component;

@Component("seller")
public class SmartSeller extends NormalSeller {
    public void recommend(String goods) {
        System.out.println("recommend " + goods);
    }
}
