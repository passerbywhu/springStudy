package com.passerbywhu.advice;

import org.springframework.aop.ThrowsAdvice;

public class NoServeToEmptyPersonAdvice implements ThrowsAdvice {
    public void afterThrowing(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
