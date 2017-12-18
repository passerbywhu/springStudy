package com.passerbywhu.aspectj;

import com.passerbywhu.domain.customer.*;
import com.passerbywhu.domain.waiter.*;
import com.passerbywhu.domain.seller.Seller;
import com.passerbywhu.domain.seller.SmartSeller;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class SimpleTest {
    @Test
    public void aspectJTest() {
        NaiveWaiter waiter = new NaiveWaiter();
        waiter.setName("NaiveWang");
        AspectJProxyFactory factory = new AspectJProxyFactory();
        factory.setTarget(waiter);
        factory.addAspect(PreGreetingAspect.class);
        Waiter proxy = factory.getProxy();
        proxy.greetTo("xxx");
        proxy.serveTo("xxx");
    }
    @Test
    public void test() {
        //这种方式还是安逸的
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:com/passerbywhu/aspectj/beans.xml");
        Waiter waiter = (Waiter) ctx.getBean("waiter");
        waiter.greetTo("xxx");
        waiter.serveTo("xxx");
        ((NaiveWaiter) waiter).smile("xxx");
        ((Seller) waiter).sell("water");

        SmartSeller seller = (SmartSeller) ctx.getBean("seller");
        seller.recommend("big house");
        seller.sell("big house");
    }

    @Test
    public void customerTest() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:com/passerbywhu/aspectj/beans.xml");
        PoorCustomer customer = (PoorCustomer) ctx.getBean("poorCustomer");
        Waiter waiter = (Waiter) ctx.getBean("waiter");
        customer.setWaiter(waiter);
        customer.orderFood();
        customer.payBill();
    }

    @Test
    public void richCustomerTest() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:com/passerbywhu/aspectj/beans.xml");
        RichCustomer customer = (RichCustomer) ctx.getBean("richCustomer");
        Waiter waiter = (Waiter) ctx.getBean("waiter");
        customer.setWaiter(waiter);
        customer.orderFood();
        customer.payBill();
    }


    //VIPCustomer接受的参数是setWaiter(VIPWaiter waiter)。

    //把@VIP标注在NaiveWaiter上面的时候。
    //这个时候 @Before("@args(com.passerbywhu.annotation.VIPWaiter)")是匹配不到setWaiter方法的
    //也即注解所在的类的类型是不能高于实参参数的类型的。否则是匹配不上的

    //把@VIP标注在VIPWaiter上面。
    //参数是VIPWaiter的子类都行

    //把@VIP标注在GoldVIPWaiter上面。
    //和书上描述的不一致。GoldVIPWaiter以及GoldVIPWaiter的子类都没有增强

    //所以args是针对运行期的参数
    @Test
    public void argOrderTest() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:com/passerbywhu/aspectj/beans.xml");
        VIPCustomer vipCustomer = (VIPCustomer) ctx.getBean("vipCustomer");
        VIPWaiter vipWaiter = (VIPWaiter) ctx.getBean("vipWaiter");
        GoldVIPWaiter goldVIPWaiter = (GoldVIPWaiter) ctx.getBean("goldVipWaiter");
        DiamondVIPWaiter diamondVIPWaiter = (DiamondVIPWaiter) ctx.getBean("diamondVipWaiter");
        vipCustomer.setWaiter(vipWaiter);
        vipCustomer.setWaiter(goldVIPWaiter);
        vipCustomer.setWaiter(diamondVIPWaiter);
    }


    //可以看到within(RichCustomer)对于VIPCustomer的方法并没有起作用
    //但是target(RichCustomer)起作用了。
    //所以默认within是不包含+的，target却是默认包含+的
    @Test
    public void withinTargetTest() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:com/passerbywhu/aspectj/beans.xml");
        VIPCustomer vipCustomer = (VIPCustomer) ctx.getBean("vipCustomer");
        VIPWaiter vipWaiter = (VIPWaiter) ctx.getBean("vipWaiter");
        vipCustomer.setWaiter(vipWaiter);
        vipCustomer.orderFood();
    }

    //这里和书上是不一致的。
    //无论是@target还是@within。都对其子类是不起作用的
    @Test
    public void annotationWithinTargetTest() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:com/passerbywhu/aspectj/beans.xml");
//        VIPCustomer vipCustomer = (VIPCustomer) ctx.getBean("vipCustomer");
//        VIPWaiter vipWaiter = (VIPWaiter) ctx.getBean("vipWaiter");
//        vipCustomer.setWaiter(vipWaiter);
//        vipCustomer.orderFood();

        GoldVIPCustomer goldVIPCustomer = (GoldVIPCustomer) ctx.getBean("goldVipCustomer");
        GoldVIPWaiter goldVIPWaiter = (GoldVIPWaiter) ctx.getBean("goldVipWaiter");
        goldVIPCustomer.setWaiter(goldVIPWaiter);
        goldVIPCustomer.orderFood();

    }
}
