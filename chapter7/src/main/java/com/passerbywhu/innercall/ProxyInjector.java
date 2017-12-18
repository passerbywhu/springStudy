package com.passerbywhu.innercall;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProxyInjector implements BootPlugin{
    @Autowired
    List<SelfProxyAware> selfProxyAwareList;
    private ApplicationContext applicationContext;

    @Override
    public void onBoot() {
        for (SelfProxyAware aware : selfProxyAwareList) {
            aware.setProxy(aware);
        }
    }
}
