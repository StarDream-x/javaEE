package edu.whu;

import edu.whu.framework.MyService;


public class Application {
    public static void main(String[] args) {
        try{
            MyService.start("/myapp.properties");
        }catch (Exception e){
            System.out.println("发现错误："+e.getMessage());
        }
    }
}
