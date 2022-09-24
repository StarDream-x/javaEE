package edu.whu.demo;

import edu.whu.framework.InitMethod;

public class ParaMethod {

    @InitMethod
    public void init(String para){
        System.out.println("含参方法init()被调用，参数为"+para);
    }
}
