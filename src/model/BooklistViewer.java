
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
import viewer.BookListPanel;
import main.Book;

/**
 *
 * @author brianyang
 */
public class BooklistViewer {
    
    private static BookListPanel            mainPanel;
    private static ListSelectionListener    booklistSelection;
    private static MouseListener            doubleClickBookListListener;
    private static KeyListener              keyListstener;  
    private static ArrayList<Book>          bookCollection;
    private static Book                     selectedBook;
    private static Book                     editedBook;
    private static Connection               databaseConnection;
    private static Statement                stat;
    
    
    //an Empty Constrator ;
    public BooklistViewer(){
        
        mainPanel = new BookListPanel();
        bookCollection = new ArrayList<>();
        selectedBook = null;
        editedBook = null;
        
        initComplent();
        
    }

    
    //Constrator with initialized Book Arraylist;
    public BooklistViewer(ArrayList<Book> books) {
        
        mainPanel = new BookListPanel();
        bookCollection = books;
        selectedBook =null;
        editedBook = null;
        initComplent();
 
    }
    
    //Constrator with sql database connection;
    public BooklistViewer(Connection aConnection,Statement aStatement ){
        
        databaseConnection = aConnection;
        stat = aStatement;
        
        initComplent();
        
    }
    
    
    //inicialized class variables;
    private void initComplent(){
         
        setUpListener();
        initList();
    }
    //define all Listener;
    private void setUpListener(){
        
        //Listener allow selection from BookList;
         booklistSelection = new ListSelectionListener(){

            @Override
            public void valueChanged(ListSelectionEvent e) {
                selectedBook();
            }
                
            }; 
                
    //doubleClickPageListListener;
         doubleClickBookListListener = new MouseAdapter() { 
            @Override
            public void mouseClicked(MouseEvent event) { 
                if (event.getClickCount() == 2) { 
                    JList theList = (JList) event.getSource(); 
                    int index = theList.locationToIndex(event.getPoint()); 
                    selectedBook = (Book) theList.getModel().getElementAt(index); 
                   
                   //viewPageList(selectedBook);
                }  
                      
            }}; 
    //keyListstener; 
         keyListstener = new KeyListener() {

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
        
        getmain().getBookList().addListSelectionListener(booklistSelection);
        getmain().getSeachTextField().addKeyListener(keyListstener);
        getmain().getBookList().addMouseListener(doubleClickBookListListener);
    }
    
    //remove listener to main panel;
    private void disableListener(){
        
        getmain().getBookList().removeListSelectionListener(booklistSelection);
        getmain().getSeachTextField().removeKeyListener(keyListstener);
        getmain().getBookList().removeMouseListener(doubleClickBookListListener);
    }
    
    //action handler for bookSelection listener;
    private void selectedBook(){
             
        selectedBook =(Book) getmain().getBookList().getSelectedValue();
 
    }
    
    //set the booklist in main panel;
    @SuppressWarnings("empty-statement")
    private void initList(){
        
        //if book arrayList has been defined , returns;
        if(bookCollection !=null){
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
                    }
                } 
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(BooklistViewer.class.getName()).log(Level.SEVERE, null, ex);
            }
                        
}
        
    
    
    private void updateList(){
        
        if(bookCollection !=null) {
             Book bookArray[] = new Book[1]; //just to establish array type
	    getmain().getBookList().setListData(((Book []) bookCollection.toArray(bookArray)));
             
            if (selectedBook != null)
			getmain().getBookList().setSelectedValue(selectedBook, true);
	  
        } else  initList();
        
    }
    
    public void update(){
        
        disableListener();
        updateList();
        enableListener();
    }
    
    //returns main Panel;
    public BookListPanel getmain(){
        return mainPanel;
    }
    
    
}
