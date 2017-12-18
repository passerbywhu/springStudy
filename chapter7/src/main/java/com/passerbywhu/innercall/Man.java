package com.passerbywhu.innercall;

public class Man implements SelfProxyAware {
    Man proxy;
    public void wearSuit() {
        System.out.println("wear Suit");
    }

    public void wearPants() {
        System.out.println("wear pants");
    }

    public void wearShoes() {
        System.out.println("wear shoes");
    }

    public void wear() {
        System.out.println("wear");
        proxy.wearSuit();
        proxy.wearPants();
        proxy.wearShoes();
    }

    @Override
    public void setProxy(Object proxy) {
        if (!(proxy instanceof Man)) {
           throw new IllegalArgumentException("proxy should be inherited from Bean class");
        }
        this.proxy = (Man) proxy;
    }
}
