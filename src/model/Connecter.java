/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.Book;
import main.Page;

/**
 *
 * @author byang1
 */
public class Connecter {

    private Connection database;
    private Statement stat;
    private ResultSet rs;
    private String dbAddress = null;

    public Connecter() {
        database = null;
        stat = null;
        rs = null;
        createConnection();

    }

    private void createConnection() {
        try {
            if (dbAddress == null || dbAddress.isEmpty()) {
                dbAddress = "src/database/db_books";
            }
            Class.forName("org.sqlite.JDBC");
            database = DriverManager.getConnection("jdbc:sqlite:" + getDbAdress());
            stat = database.createStatement();

        } catch (ClassNotFoundException e) {
            Logger.getLogger(Connecter.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException ex) {
            Logger.getLogger(Connecter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean isDatabaseActive() {
        try {
            return !database.isClosed();
        } catch (SQLException ex) {
            Logger.getLogger(Connecter.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean changeDatabase(File f) {
        try {
            if (isDatabaseActive()) {
                database.close();
            }
            setDbAdress(f.getPath());
            createConnection();
            return isDatabaseActive();

        } catch (SQLException e) {

            Logger.getLogger(Connecter.class.getName()).log(Level.SEVERE, null, e);
            return false;

        }
    }

    public boolean closeConnection() {
        try {
            System.out.println("Closing DataBase Connection");
            database.close();
            return database.isClosed();

        } catch (SQLException ex) {
            Logger.getLogger(Connecter.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    //return book search result from databse 
    public ArrayList<Book> getBookList() {
        String sqlQueryString = "Select * from bookcodes order by code asc";
        ArrayList<Book> searchResult = new ArrayList<Book>();
        try {
            rs = stat.executeQuery(sqlQueryString);

            while (rs.next()) {
                Book theBook = new Book(rs.getString("code"), rs.getString("title"), rs.getString("path"), rs.getString("author"), rs.getInt("startpage"));
                searchResult.add(theBook);
            }

            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(Connecter.class.getName()).log(Level.SEVERE, null, ex);
        }

        return searchResult;
    }

    //return page search result from database
    public ArrayList<Page> getPageList() {
        String sqlQueryString = "select * from pagelist;";
        ArrayList<Page> searchResult = new ArrayList<Page>();

        try {
            rs = stat.executeQuery(sqlQueryString);

            while (rs.next()) {
                Page thePage = new Page(rs.getInt("id"), rs.getString("title"), rs.getString("bookcode"), rs.getInt("page"));
                searchResult.add(thePage);
            }

            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(Connecter.class.getName()).log(Level.SEVERE, null, ex);
        }

        return searchResult;
    }

    //return search book result
    public ArrayList<Book> searchBook(String s, String type) {
        String sqlQueryString = "select * from bookcodes where " + type + " like '%" + s + "%' order by " + type + " asc" + ";";
        ArrayList<Book> searchResult = new ArrayList<Book>();
        try {
            rs = stat.executeQuery(sqlQueryString);

            while (rs.next()) {
                Book theBook = new Book(rs.getString("code"), rs.getString("title"), rs.getString("path"), rs.getString("author"), rs.getInt("startpage"));
                searchResult.add(theBook);
            }

            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(Connecter.class.getName()).log(Level.SEVERE, null, ex);
        }

        return searchResult;
    }

    //return search result for page from database
    public ArrayList<Page> searchPage(String s, String type) {

        String sqlQueryString;
        if (!"page".equals(type)) {
            sqlQueryString = "select * from pagelist where " + type + " like '%" + s + "%' order by " + type + " asc" + ";";

        } else {
            sqlQueryString = "select * from pagelist where " + type + " like " + s + " order by " + type + " asc" + ";";
        }
        ArrayList<Page> searchResult = new ArrayList<Page>();

        try {
            rs = stat.executeQuery(sqlQueryString);

            while (rs.next()) {
                Page thePage = new Page(rs.getInt("id"), rs.getString("title"), rs.getString("bookcode"), rs.getInt("page"));
                searchResult.add(thePage);
            }

            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(Connecter.class.getName()).log(Level.SEVERE, null, ex);
        }

        return searchResult;
    }

    //add Book to database;
    public boolean addBook(Book b) {
        String sqlQuery = "INSERT INTO bookcodes(code,title,path,author,startpage) "
                + "values('" + b.getBookCode() + "','" + b.getBookName() + "','" + b.getBookPath() + "','" + b.getAuthor() + "'," + b.getInitPage() + ");";
        try {
            int executeUpdate = stat.executeUpdate(sqlQuery);

            if (executeUpdate == 1) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Connecter.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    //update book from database;
    public boolean updateBook(Book b) {
        String sqlQuery = "update bookcodes set title = '"
                + b.getBookName() + "',path ='" + b.getBookPath() + "',author = '"
                + b.getAuthor() + "',startpage = " + b.getInitPage()
                + " where code ='" + b.getBookCode() + "';";
        try {
            System.out.println(sqlQuery);
            int executeUpdate = stat.executeUpdate(sqlQuery);

            if (executeUpdate == 1) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connecter.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean deleteBook(Book b) {
        String sqlQuery = "delete from bookcodes where code = '" + b.getBookCode() + "';";
        try {
            int executeUpdate = stat.executeUpdate(sqlQuery);

            if (executeUpdate == 1) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connecter.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    //add page to database;
    public boolean addPage(Page p) {

        String sqlQuery = "INSERT INTO pagelist(title,bookcode,page) "
                + "values('" + p.getPageTitle() + "','" + p.getBookCode() + "');";
        try {
            int executeUpdate = stat.executeUpdate(sqlQuery);

            if (executeUpdate == 1) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Connecter.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    //update book from database;
    public boolean updatePage(Page p) {
        String sqlQuery = "update pagelist set title = '"
                + p.getPageTitle() + "',bookcode ='" + p.getBookCode() + "',page = " + p.getPageNum()
                + "where id ='" + p.getPageID() + "';";
        try {
            int executeUpdate = stat.executeUpdate(sqlQuery);

            if (executeUpdate == 1) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Connecter.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean deletePage(Page p) {
        String sqlQuery = "delete from pagelist where id = " + p.getPageID() + ";";
        try {
            int executeUpdate = stat.executeUpdate(sqlQuery);

            if (executeUpdate == 1) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Connecter.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public void saveDatabase(File f) {

        SavetoXML save = new SavetoXML(getBookList(), getPageList(), f);

    }

    /**
     * @return the dbAdress
     */
    public String getDbAdress() {
        return dbAddress;
    }

    /**
     * @param dbAdress the dbAdress to set
     */
    public void setDbAdress(String dbAdress) {
        this.dbAddress = dbAdress;
    }
}
