package com.passerbywhu.composable;

import com.passerbywhu.controlflow.WaiterDelegate;
import com.passerbywhu.dynamic.GreetingDynamicPointCut;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.ControlFlowPointcut;
import org.springframework.aop.support.NameMatchMethodPointcut;

public class GreetingComposablePointCut extends ComposablePointcut {
    public GreetingComposablePointCut() {
        super();
        ControlFlowPointcut flowPointcut = new ControlFlowPointcut(WaiterDelegate.class, "service");
        this.intersection((Pointcut) flowPointcut);
        NameMatchMethodPointcut namePointcut = new NameMatchMethodPointcut();
        namePointcut.addMethodName("greetTo");
        this.intersection((Pointcut) namePointcut);
        GreetingDynamicPointCut specialDyanamicPointCut = new GreetingDynamicPointCut();
        this.intersection((Pointcut) specialDyanamicPointCut);
    }
}
