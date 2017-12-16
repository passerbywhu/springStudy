package com.passerbywhu.dynamic;

import com.passerbywhu.waiter.Waiter;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class GreetingDynamicPointCut extends DynamicMethodMatcherPointcut {
    private List<String> specialCustomer = new ArrayList<String>();
    {
        specialCustomer.add("HongYe");
        specialCustomer.add("LiTing");
    }

    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            @Override
            public boolean matches(Class<?> aClass) {
                return Waiter.class.isAssignableFrom(aClass);
            }
        };
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        String methodName = method.getName();
        return methodName.contains("greetTo");
    }

    @Override
    public boolean matches(Method method, Class<?> aClass, Object... objects) {
        if (objects.length > 0) {
            Object arg0 = objects[0];
            if (arg0 instanceof String) {
                String arg0Str = (String) arg0;
                if (specialCustomer.contains(arg0Str)) {
                    return true;
                }
            }
        }
        return false;
    }
}
