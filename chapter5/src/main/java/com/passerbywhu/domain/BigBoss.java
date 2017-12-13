package com.passerbywhu.domain;

import com.passerbywhu.plugin.Plugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class BigBoss {
    @Autowired
    List<Car> carList;
    List<String> women;

    public Boss getBoss() {
        return boss;
    }

    public void setBoss(Boss boss) {
        this.boss = boss;
    }

    Boss boss;

    public List<Plugin> getPlugins() {
        return plugins;
    }

    public void setPlugins(List<Plugin> plugins) {
        this.plugins = plugins;
    }

    @Autowired
    List<Plugin> plugins;

    public Properties getCompanies() {
        return companies;
    }

    public void setCompanies(Properties companies) {
        this.companies = companies;
    }

    Properties companies;

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    public List<String> getWomen() {
        return women;
    }

    public void setWomen(List<String> women) {
        this.women = women;
    }

    public Map<String, String> getWomenStyle() {
        return womenStyle;
    }

    public void setWomenStyle(Map<String, String> womenStyle) {
        this.womenStyle = womenStyle;
    }

    Map<String, String> womenStyle;
}
