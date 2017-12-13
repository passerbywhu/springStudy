package com.passerbywhu.plugin;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class OnePlugin implements Plugin {
    @Override
    public String toString() {
        return "onePlugin";
    }
}
