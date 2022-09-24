package edu.whu.framework;



import edu.whu.Application;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.Properties;

public class MyService {
    private static final String classKey = "myclass";

    /**
     * 启动服务
     * @param propFile 资源文件位置
     * @throws Exception
     */
    public static Object start(String propFile) throws Exception{
        Properties properties = loadProperties(propFile);
        Class claobj = getMyClass(properties);
        Method method =getMyMethod(claobj);
        Object obj = createObj(claobj);
        invokeMethod(obj,method);
        return obj;
    }

    /**
     * 加载资源文件
     * @param propFile
     * @return
     * @throws Exception
     */
    private static Properties loadProperties(String propFile) throws Exception{
        Properties properties = new Properties();
        try(InputStream is = Application.class.getResourceAsStream(propFile)){
            if(is==null){
                throw new Exception("资源加载出错");
            }
            properties.load(is);
            return properties;
        }catch(Exception e){
            throw new Exception("资源读取失败:"+e.getMessage());
        }
    }

    /**
     * 反射获得类对象
     * @param properties
     * @return 反射结果
     * @throws Exception
     */
    private static Class getMyClass(Properties properties) throws Exception{
        String myClass = properties.getProperty(classKey);
        try{
            return Class.forName(myClass);
        }catch(Exception e){
            throw new Exception("反射出错"+e.getMessage());
        }
    }

    /**
     * 反射获得目标方法
     * @param myclass
     * @return 目标方法
     * @throws Exception
     */
    private static Method getMyMethod(Class myclass) throws Exception{
        for(Method method:myclass.getDeclaredMethods()){
            if(!method.isAnnotationPresent(InitMethod.class)){
                continue;
            }
            if(method.getParameterCount()>0) {
                throw new Exception("方法参数非0");
            }
            return method;
        }
        throw new Exception("未找到目标方法");
    }

    /**
     * 反射创建对象
     * @param myclass
     * @return 新建的对象
     * @throws Exception
     */
    private static Object createObj(Class myclass) throws Exception{
        try{
            return myclass.newInstance();
        }catch (Exception e){
            throw new Exception("创建对象失败:"+e.getMessage());
        }
    }

    /**
     * 调用反射得到的方法
     * @param object
     * @param method
     * @throws Exception
     */
    private static void invokeMethod(Object object,Method method) throws Exception{
        try{
            method.setAccessible(true);
            method.invoke(object);
        }catch (Exception e){
            throw new Exception("调用方法失败："+e.getMessage());
        }
    }


}
