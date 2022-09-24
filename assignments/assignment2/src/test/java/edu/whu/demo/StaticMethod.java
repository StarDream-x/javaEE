package edu.whu.demo;

import edu.whu.framework.InitMethod;

public class StaticMethod {

    @InitMethod
    public static void init(){
        System.out.println("调用静态init()");
    }
}
