package edu.whu;

import edu.whu.dao.BookDao;
import edu.whu.dao.impl.BookDaoImpl;
import edu.whu.service.BookService;
import edu.whu.service.Impl.BookServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MyServiceTest {

    @Test
    public void testDao() throws Exception{
        ApplicationContext ctx = new ClassPathXmlApplicationContext("MiniApplicationContext.xml");
        BookDao bookDao = (BookDao) ctx.getBean("bookDao");
        assertEquals(bookDao.getClass(), BookDaoImpl.class);
        assertNotEquals(bookDao.getClass(),BookDao.class);
    }

    @Test
    public void testService() throws Exception{
        ApplicationContext ctx = new ClassPathXmlApplicationContext("MiniApplicationContext.xml");
        BookService bookService = (BookService) ctx.getBean("bookService");
        assertEquals(bookService.getClass(), BookServiceImpl.class);
        assertNotEquals(bookService.getClass(),BookService.class);
    }
}
