package edu.whu;

import edu.whu.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApplicationContext {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("MiniApplicationContext.xml");

        BookService bookService = (BookService) ctx.getBean("bookService");
        bookService.save();
    }
}
