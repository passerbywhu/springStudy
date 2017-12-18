package com.passerbywhu.innercall;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SystemBootManager implements ApplicationListener<ContextRefreshedEvent> {
    private boolean hasInit = false;

    @Autowired
    private List<BootPlugin> bootPlugins;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (!hasInit) {
            hasInit = true;
            for (BootPlugin plugin: bootPlugins) {
                plugin.onBoot();
            }
        }
    }
}
