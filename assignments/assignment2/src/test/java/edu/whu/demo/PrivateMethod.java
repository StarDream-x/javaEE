package edu.whu.demo;

import edu.whu.framework.InitMethod;

public class PrivateMethod {

    @InitMethod
    private void init(){
        System.out.println("私有init()被调用");
    }
}
