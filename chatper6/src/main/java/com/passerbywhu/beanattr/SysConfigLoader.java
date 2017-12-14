package com.passerbywhu.beanattr;

import org.springframework.beans.factory.annotation.Value;

public class SysConfigLoader {
    @Value("#{sysConfig.sessionTimeout}")
    private int sessionTimeout;
    @Value("#{sysConfig.maxTabPageNum}")
    private int maxTabPageNum;

    @Override
    public String toString() {
        return sessionTimeout + " " + maxTabPageNum;
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
