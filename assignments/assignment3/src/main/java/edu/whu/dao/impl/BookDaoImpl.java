package edu.whu.dao.impl;

import edu.whu.dao.BookDao;

public class BookDaoImpl implements BookDao {

    private String databaseName;

    private int connectionNum;

    public void setDatabaseName(String databaseName){this.databaseName=databaseName;}

    public void setConnectionNum(int connectionNum){this.connectionNum=connectionNum;}

    public void save() {
        System.out.println("book dao save ..."+databaseName+","+connectionNum);
    }
}
