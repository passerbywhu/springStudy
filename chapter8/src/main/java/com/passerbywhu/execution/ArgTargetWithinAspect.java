package com.passerbywhu.execution;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class ArgTargetWithinAspect {
    //针对运行时参数，而不是方法签名的。
    //execution(* *(com.passerbywhu.domain.waiter.Waiter))是针对方法签名的
    //所以PoorCustomer的setWaiter(Object waiter)方法仍然被增强了
    @Before("args(com.passerbywhu.domain.waiter.Waiter)")
    public void waiterInjectHint() {
        System.out.println("You have got a waiter");
    }

    @Before("within(com.passerbywhu.domain.customer.RichCustomer)")
    public void splashMoney() {
        System.out.println("within RichCustomer Money Money Money");
    }

    @Before("target(com.passerbywhu.domain.customer.RichCustomer)")
    public void targetMoney() {
        System.out.println("target RichCustomer Money Money Money");
    }

    @Before("@args(com.passerbywhu.annotation.VIPWaiter)")
    public void welcomVIP() {
        System.out.println("You got a VIPWaiter, welcome");
    }

    @Before("@target(com.passerbywhu.annotation.VIPCustomer)")
    public void showCard() {
        System.out.println("@target VIPCustomer show you my vip card");
    }

    @Before("@within(com.passerbywhu.annotation.VIPCustomer)")
    public void withinShowCard() {
        System.out.println("@within VIPCustomer show you my vip card");
    }
}
