package com.passerbywhu.plugin;

import org.springframework.stereotype.Component;

@Component
public class TwoPlugin implements Plugin {
    @Override
    public String toString() {
        return "twoPlugin";
    }
}
