package com.passerbywhu.waiter;

import javax.swing.plaf.TextUI;

public class NaiveWaiter implements Waiter{
    public void greetTo(String name) {
        System.out.println("greet to "+name+"...");
        privateGreetTo(name);
    }

    public void serveTo(String name){
        if (name == null || name.trim().equals("")) {
            throw new IllegalArgumentException("I don't want to serve to person with empty name");
        }
        System.out.println("serving "+name+"...");
    }

    public void privateGreetTo(String name) {
        System.out.println("private greet to " + name);
    }
}
