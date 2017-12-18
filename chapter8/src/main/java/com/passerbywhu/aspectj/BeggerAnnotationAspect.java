package com.passerbywhu.aspectj;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class BeggerAnnotationAspect {
    @AfterReturning("@annotation(com.passerbywhu.annotation.Begger)")
    public void begger() {
        System.out.println("please give me some money");
    }
}
