/*
 * Carleton University - School of Computer Science Honours Project 
 * Winter 2014
 * PDF Book Organizer and page Viewer
 * AUTHOR: Zhangda Yang
 * SUPERVISOR: Professor Louis Nel
 * 
 */
package carleton.edu.comp4905.honourproject.model;

import java.io.File;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import carleton.edu.comp4905.honourproject.main.Book;
import carleton.edu.comp4905.honourproject.main.Page;

/**
 * this Class is the database controller for this application. this class will
 * handle the major activities related with application database.
 *
 * @author zhangda Yang
 */
public class Connecter {

    private Connection database; // the database connection for this application
    private Statement stat; // database statement of database connection
    private ResultSet rs; // result set from the query
    private String dbAddress = null; // the file path of database file

    // default constructor
    public Connecter() {
        database = null;
        stat = null;
        rs = null;
        createConnection();

    }

    // create connection with database file
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

    // return if database is connected with database file and is active
    public boolean isDatabaseActive() {
        try {
            return !database.isClosed();
        } catch (SQLException ex) {
            Logger.getLogger(Connecter.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    // connect database to another database file

    public boolean changeDatabase(File f) {
        try {
            if (database != null && isDatabaseActive()) {
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
    // close database connection

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

    // get a list of all the book collections from database file
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

    // return all the book pages from database file
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

    // search book collection from database file
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

    // search book page from database file
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

    // add new book collection to database file
    public boolean addBook(Book b) {
        String sqlQuery = "INSERT INTO bookcodes(code,title,path,author,startpage) "
                + "values('" + b.getBookCode() + "','" + b.getBookName() + "','" + b.getBookPath() + "','" + b.getAuthor() + "'," + b.getInitPage() + ");";
        try {
            int executeUpdate = stat.executeUpdate(sqlQuery);

            return executeUpdate == 1;

        } catch (SQLException ex) {
            Logger.getLogger(Connecter.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    // update an existing book collection info from database file
    public boolean updateBook(Book b) {
        String sqlQuery = "update bookcodes set title = '"
                + b.getBookName() + "',path ='" + b.getBookPath() + "',author = '"
                + b.getAuthor() + "',startpage = " + b.getInitPage()
                + " where code ='" + b.getBookCode() + "';";
        try {
            System.out.println(sqlQuery);
            int executeUpdate = stat.executeUpdate(sqlQuery);

            return executeUpdate == 1;
        } catch (SQLException ex) {
            Logger.getLogger(Connecter.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    // remove an existing book collection and related pages from database file

    public boolean deleteBook(Book b) {
        String sqlQuery = "delete from bookcodes where code = '" + b.getBookCode() + "';";
        try {
            int executeUpdate = stat.executeUpdate(sqlQuery);
            if (executeUpdate < 0) {
                return false;
            }
            sqlQuery = "delete from pagelist where bookcode = '" + b.getBookCode() + "';";
            System.err.println(sqlQuery);
            executeUpdate = stat.executeUpdate(sqlQuery);
            return executeUpdate >= 0;

        } catch (SQLException ex) {
            System.err.println("sql Expection: " + sqlQuery);
            ex.printStackTrace();
            return false;
        }
    }

    // add new page to database file;
    public boolean addPage(Page p) {

        String sqlQuery = "INSERT INTO pagelist(title,bookcode,page) "
                + "values('" + p.getPageTitle() + "','" + p.getBookCode() + "','" + p.getPageNum() + "');";
        try {
            int executeUpdate = stat.executeUpdate(sqlQuery);

            return executeUpdate == 1;

        } catch (SQLException ex) {
            Logger.getLogger(Connecter.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    // update book page records on database
    public boolean updatePage(Page p) {
        String sqlQuery = "update pagelist set title = '"
                + p.getPageTitle() + "',bookcode ='" + p.getBookCode() + "',page = " + p.getPageNum()
                + " where id ='" + p.getPageID() + "';";
        try {
            int executeUpdate = stat.executeUpdate(sqlQuery);

            return executeUpdate == 1;

        } catch (SQLException ex) {
            Logger.getLogger(Connecter.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    // remove an existing page record from database

    public boolean deletePage(Page p) {
        String sqlQuery = "delete from pagelist where id = " + p.getPageID() + ";";
        try {
            int executeUpdate = stat.executeUpdate(sqlQuery);

            return executeUpdate == 1;

        } catch (SQLException ex) {
            Logger.getLogger(Connecter.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    // save all database records to a XML file

    public void saveDatabase(File f) {

        new SavetoXML(getBookList(), getPageList(), f);

    }

    // return file path for database file
    public String getDbAdress() {
        return dbAddress;
    }

    // set file path for database file
    public void setDbAdress(String dbAdress) {
        this.dbAddress = dbAdress;
    }
}
