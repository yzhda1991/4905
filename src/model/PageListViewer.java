/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import main.Book;
import main.Page;
import viewer.PageListPanel;

/**
 *
 * @author brianyang
 */
public class PageListViewer {
    
    private static PageListPanel         mainPanel;
    private static ListSelectionListener bookListSelection;
    private static ListSelectionListener pageListSelection;
    private static KeyListener           searchKeyListener;
    private static MouseListener         doubleClickedList;
   
    private static ArrayList<Book>       bookCollection;
    private static ArrayList<Page>       pageCollection;
    
    private static Page                  selectedPage;
    private static Book                  selectedBook;
    
    private static Connection            databaseConnection;
    private static Statement             stat;

    public PageListViewer(ArrayList<Book> books, Book theBook, ArrayList<Page> pages) {
        
        mainPanel = new PageListPanel();
        bookCollection = books;
        selectedBook = theBook;
        pageCollection = pages;
        
        databaseConnection = null;
        stat = null;
        selectedPage = null;
        
        initComplent();
        
    }

    public PageListViewer(ArrayList<Book> books, Book theBook, Connection aConnnetion, Statement aStat) {
        
        mainPanel = new PageListPanel();
        
        bookCollection = books;
        selectedBook = theBook;
        
        pageCollection = null;
        selectedPage = null;
        
        databaseConnection = aConnnetion;
        stat = aStat;
        
        initComplent();
        
    }
    
    public PageListViewer(Connection aConnnetion, Statement aStat){
       
        mainPanel = new PageListPanel();
        
        bookCollection = null;
        selectedBook = null;
        
        pageCollection = null;
        selectedPage = null;
        
        databaseConnection = aConnnetion;
        stat = aStat;
        
        initComplent();
    }
    
    //inicialized class variables;
    private void initComplent(){
         
        setUpListener();
        //initList();
    }
    
    //define all Listener;
    private void setUpListener(){
        //Listener allow selection from BookList;
         bookListSelection = new ListSelectionListener(){

            @Override
            public void valueChanged(ListSelectionEvent e) {
                selectedBook();
            }
                
            }; 
        //Listener allow selection from PageList; 
         pageListSelection = new ListSelectionListener(){

             @Override
             public void valueChanged(ListSelectionEvent e) {
                  selectedPage();
             }
             
         }; 
        //doubleClickPageListListener;
         doubleClickedList = new MouseAdapter() { 
            @Override
            public void mouseClicked(MouseEvent event) { 
                if (event.getClickCount() == 2) { 
                    JList theList = (JList) event.getSource(); 
                    int index = theList.locationToIndex(event.getPoint()); 
                    
                    if(theList.equals(getMain().getBookList())){
                        selectedBook = (Book)theList.getModel().getElementAt(index);
                        selectedPage =null;
                    }
                    else if(theList.equals(getMain().getPageList())){
                        selectedPage = (Page)theList.getModel().getElementAt(index);
                    }
                   
                  
                }  
                      
            }}; 
         //keyListstener; 
         searchKeyListener = new KeyListener() {

             @Override
             public void keyTyped(KeyEvent e) {
                 throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
             }

             @Override
             public void keyPressed(KeyEvent e) {
                 throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
             }

             @Override
             public void keyReleased(KeyEvent e) {
                 throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
             }
         };
         enableListener();
    }
    
    //add listener to main panel;
    private void enableListener(){
        
        getMain().getBookList().addListSelectionListener(bookListSelection);
        getMain().getPageList().addListSelectionListener(pageListSelection);
        getMain().getSeachTextField().addKeyListener(searchKeyListener);
        getMain().getBookList().addMouseListener(doubleClickedList);
        getMain().getPageList().addMouseListener(doubleClickedList);
        
    }
    //remove listener to main panel;
    private void disableListener(){
        
        getMain().getBookList().removeListSelectionListener(bookListSelection);
        getMain().getPageList().removeListSelectionListener(pageListSelection);
        getMain().getSeachTextField().removeKeyListener(searchKeyListener);
        getMain().getBookList().removeMouseListener(doubleClickedList);
        getMain().getPageList().removeMouseListener(doubleClickedList);
        
    }
    
    //set the booklist in main panel;
    private void initList(){
        //if book arrayList has been defined , returns;
        if(bookCollection !=null && pageCollection !=null){
                    return;
            }
            //if database connection is not defined , return error
            if(databaseConnection == null) {
                System.out.print("unable to found datable information !");
                return;   
            }
            
            //if database connection is found, but book ArrayList has not been defined;
            //defined book ArrayList as new  ArrayList;
               
            
            try{
                
            //connected with database by using JDBC
            Class.forName("org.sqlite.JDBC");
            String databaseName = "jdbc:sqlite:src/data/db_books";
            
            //defined Connection to database
            databaseConnection = DriverManager.getConnection(databaseName);
            //define statement cosponding to database;
            stat =  databaseConnection.createStatement();
            
            if(bookCollection == null){
                 //sql command to selected all bookcode from query;
                String sqlQueryString = "select * from bookcodes order by code asc;";
            
                System.out.println("");
                System.out.println(sqlQueryString);
            
                 bookCollection = new ArrayList<>();
            
                //restore all the book from result set to book ArrayList;
                    try (ResultSet rs = stat.executeQuery(sqlQueryString)) {
                        while(rs.next()){
                            Book thebook = new Book(rs.getString("code"),rs.getString("title"),rs.getString("path"),rs.getString("author"),rs.getInt("startpage"));
                            bookCollection.add(thebook);
                        }} 
                }
            
            if(pageCollection == null){
                 String sqlQueryString = "select * from pagelist order by code asc;";
            
                System.out.println("");
                System.out.println(sqlQueryString);
            
                pageCollection = new ArrayList<>();
                int DISPLAY_LIMIT =100;
                int count = 0;
            
                try(ResultSet rs = stat.executeQuery(sqlQueryString);){
                    while(rs.next() && count<DISPLAY_LIMIT){
                        Page thePage = new Page(rs.getInt("id"),rs.getString("title"),rs.getString("bookcode"),rs.getInt("page"));
                        pageCollection.add(thePage);
                        count++;
            
                    }
                }
            
            }
            
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(BooklistViewer.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    //action handler for bookSelection listener;
    private void selectedBook(){
             
        selectedBook =(Book) getMain().getBookList().getSelectedValue();
 
    }
    //action handler for pageSelection listener;
    private void selectedPage(){
             
        selectedPage =(Page) getMain().getPageList().getSelectedValue();
 
    }

    private void updateList(){
        
        if(bookCollection !=null && pageCollection != null) {
            Book bookArray[] = new Book[1]; //just to establish array type
	    getMain().getBookList().setListData(((Book []) bookCollection.toArray(bookArray)));
             
            if (selectedBook != null)
			getMain().getBookList().setSelectedValue(selectedBook, true);
	  
             Page pageArray[] = new Page[1]; //just to establish array type
	     getMain().getPageList().setListData(((Page []) pageCollection.toArray(pageArray)));
            
            
		if (selectedPage != null)
			getMain().getPageList().setSelectedValue(selectedPage, true);
        }
       
        else  initList();

    }

    public void update(){
        
        disableListener();
        updateList();
        enableListener();
    }
   
    /**
     * Get the value of mainPanel
     *
     * @return the value of mainPanel
     */
    public PageListPanel getMain() {
        return mainPanel;
    }

}
