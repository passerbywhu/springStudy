package com.passerbywhu.placeholder;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.ArrayList;
import java.util.List;

public class EncryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
    private List<String> propertyNameList;

    {
        propertyNameList = new ArrayList<String>();
        propertyNameList.add("userName");
        propertyNameList.add("password");
    }

    @Override
    protected String convertProperty(String propertyName, String propertyValue) {
        if (propertyNameList.contains(propertyName)) {
            return DESUtils.getDecryptString(propertyValue);
        }
        return propertyValue;
    }
}
