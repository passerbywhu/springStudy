package com.passerbywhu.execution;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Date;

@Aspect
public class ExecutionAspect {
//    @Before("execution(public * *smile*(..))")
//    public void laugh() {
//        System.out.println("Laughing Ha Ha Ha");
//    }

    //只会匹配Sell接口中的sell方法，而Recommend方法不会被增强
//    @Before("execution(* com.passerbywhu.domain.seller.Seller.*(..))")
//    public void introduceSelf() {
//        System.out.println("Hi everybody, I'm a seller");
//    }

    //passerbywhu包以及子孙包下面的所有类的所有方法
    @Before("execution(* com.passerbywhu..*(..))")
    public void recordTime() {
        System.out.println("Now time is " + new Date().toLocaleString());
    }

//    @Before("execution(* com.passerbywhu..*.Seller.*sell*(..))")
//    public void compaign() {
//        System.out.println("I'm really busy today");
//    }
}
