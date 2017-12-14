package com.passerbywhu.beanattr;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component("sysConfig")
public class SysConfig {
    private int sessionTimeout;
    private int maxTabPageNum;

    @Override
    public String toString() {
        return sessionTimeout + " " + maxTabPageNum;
    }

    @PostConstruct
    public void initFromDB() {
        sessionTimeout = 30;
        maxTabPageNum = 10;
    }

    public int getSessionTimeout() {
        return sessionTimeout;
    }

    public void setSessionTimeout(int sessionTimeout) {
        this.sessionTimeout = sessionTimeout;
    }

    public int getMaxTabPageNum() {
        return maxTabPageNum;
    }

    public void setMaxTabPageNum(int maxTabPageNum) {
        this.maxTabPageNum = maxTabPageNum;
    }
}
