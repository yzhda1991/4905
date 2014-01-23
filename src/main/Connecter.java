/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author byang1
 */

    

public class Connecter {
    
    
    private Connection  database;
    private Statement   stat;
    private ResultSet   rs;
    
    public Connecter(){
         database = null;
         stat = null;
         rs = null;
         createConnection();
         
    }
    private void createConnection(){
        try{
            Class.forName("org.sqlite.JDBC"); 
            database = DriverManager.getConnection("jdbc:sqlite:src/database/db_books");
            
                stat = database.createStatement();
             
            
                
        }catch(  ClassNotFoundException e){
            Logger.getLogger(Connecter.class.getName()).log(Level.SEVERE, null, e);
        }catch (SQLException ex) {
                Logger.getLogger(Connecter.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public void changeDatabase(String path){
        try{
            database = DriverManager.getConnection(path);
        }catch(SQLException e){
            
        }
    }
    
    public void closeConnection(){
         try{
                              System.out.println("Closing DataBase Connection");
                              database.close();
                            
                          } catch (SQLException ex) {
            Logger.getLogger(Connecter.class.getName()).log(Level.SEVERE, null, ex);
        }
                          
    }
    //return book search result from databse 
    public ArrayList<Book> getBookList(){
        String sqlQueryString = "Select * from bookcodes order by code asc";
        ArrayList<Book> searchResult = new ArrayList<Book>();
        try {
            rs = stat.executeQuery(sqlQueryString);
            
            while(rs.next()){
                Book theBook = new Book(rs.getString("code"),rs.getString("title"),rs.getString("path"),rs.getString("author"),rs.getInt("startpage"));
                searchResult.add(theBook);
            }
            
            rs.close();
        
        } catch (SQLException ex) {
            Logger.getLogger(Connecter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return searchResult;
    }

    //return page search result from database
    public ArrayList<Page> getPageList(){
        String sqlQueryString = "select * from pagelist;";
        ArrayList<Page> searchResult = new ArrayList<Page>();
        
        try {
            rs = stat.executeQuery(sqlQueryString);
            
            while(rs.next()){
                 Page thePage = new Page(rs.getInt("id"),rs.getString("title"),rs.getString("bookcode"),rs.getInt("page"));
                searchResult.add(thePage);
            }
            
            rs.close();
        
        } catch (SQLException ex) {
            Logger.getLogger(Connecter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return searchResult;
    }

    //return search book result
    public ArrayList<Book> searchBook(String s,String type){
        String sqlQueryString = "select * from bookcodes where "+ type +" like '%" + s + "%' order by "+type+" asc" + ";";
        ArrayList<Book> searchResult = new ArrayList<Book>();
        try {
            rs = stat.executeQuery(sqlQueryString);
            
            while(rs.next()){
                Book theBook = new Book(rs.getString("code"),rs.getString("title"),rs.getString("path"),rs.getString("author"),rs.getInt("startpage"));
                searchResult.add(theBook);
            }
            
            rs.close();
        
        } catch (SQLException ex) {
            Logger.getLogger(Connecter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return searchResult;
    }
    //return search result for page from database
    public ArrayList<Page> searchPage(String s,String type){
        String sqlQueryString = "select * from pagelist where "+ type +" like '%" + s + "%' order by "+type+" asc" + ";";
        ArrayList<Page> searchResult = new ArrayList<Page>();
        
        try {
            rs = stat.executeQuery(sqlQueryString);
            
            while(rs.next()){
                 Page thePage = new Page(rs.getInt("id"),rs.getString("title"),rs.getString("bookcode"),rs.getInt("page"));
                searchResult.add(thePage);
            }
            
            rs.close();
        
        } catch (SQLException ex) {
            Logger.getLogger(Connecter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return searchResult;
    }
}
