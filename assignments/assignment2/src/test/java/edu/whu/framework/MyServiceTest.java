package edu.whu.framework;


import edu.whu.demo.MyClass;
import edu.whu.demo.PrivateMethod;
import edu.whu.demo.StaticMethod;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyServiceTest {

    @Test
    public void testClass() throws Exception{
        Object object = MyService.start("/myapp.properties");
        assertNotNull(object);
        assertEquals(object.getClass(), MyClass.class);
        assertEquals("ok",((MyClass)object).getPst());
    }

    @Test
    public void testAnotation() throws Exception{
        Object object = MyService.start("/static-method.properties");
        assertEquals(object.getClass(), StaticMethod.class);
        object = MyService.start("/private-method.properties");
        assertEquals(object.getClass(), PrivateMethod.class);
        Exception e = assertThrows(Exception.class,()->{
            MyService.start("/para-method.properties");
        });
        assertTrue(e.getMessage().equals("方法参数非0"));
        e = assertThrows(Exception.class,()->{
            MyService.start("/none-initAnotation.properties");
        });
        assertTrue(e.getMessage().equals("未找到目标方法"));
    }
}
