package edu.whu.service.Impl;

import edu.whu.dao.BookDao;
import edu.whu.dao.UserDao;
import edu.whu.service.BookService;

public class BookServiceImpl implements BookService {
    private BookDao bookDao;
    private UserDao userDao;

    BookServiceImpl(BookDao bookDao,UserDao userDao){
        this.bookDao=bookDao;
        this.userDao=userDao;
    }

    public void save(){
        System.out.println("book service save...");
        bookDao.save();
        userDao.save();
    }

    public void setBookDao(BookDao bookDao){this.bookDao=bookDao;}

    public void setUserDao(UserDao userDao){this.userDao=userDao;}
}
