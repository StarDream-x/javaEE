package edu.whu.demo;

import edu.whu.framework.InitMethod;

public class MyClass {
    String pst="pending";
    @InitMethod
    public void init(){
        pst="ok";
        System.out.println("Run normally");
    }

    public String getPst() {
        return pst;
    }
}
