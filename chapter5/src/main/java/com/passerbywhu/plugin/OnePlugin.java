package com.passerbywhu.plugin;

import org.springframework.stereotype.Component;

@Component
public class OnePlugin implements Plugin {
    @Override
    public String toString() {
        return "onePlugin";
    }
}
