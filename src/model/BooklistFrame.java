/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author byang1
 */

import java.awt.event.MouseEvent;
import main.Book;
import main.Connecter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.event.ListSelectionListener;
import main.Controller;
import main.ViewBooksMain;
import viewer.BookListPanel;

public class BooklistFrame extends MenuFrame{
    
    BookListPanel           mainPanel;
    ActionListener          seachButtonListener;
    MouseListener           doubleClickedonbook;
    ListSelectionListener   listSelection;
    Connecter               theConnecter;
    Controller              theController;
    ArrayList<Book>         bookCollection;
    
    /** Creates new form BookListFrame */
    public BooklistFrame() {
        super("book list");
       
        theConnecter = new Connecter();
        initComponents();
        
    }
    
     public BooklistFrame(String title,ViewBooksMain view, Controller c,Connecter conn) {
        super(title,c);
        theConnecter = conn;
        theController = c;
        initComponents();
        
    }
   
    private void initComponents(){
        mainPanel = new BookListPanel();
        super.updateMainPanel(mainPanel);
        bookCollection = theConnecter.getBookList(); 

        seachButtonListener = new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                
                searchBook();
            }
        };
        doubleClickedonbook = new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()==2){
                    JList theList =(JList) e.getSource();
                    int index =  theList.locationToIndex(e.getPoint());
                    Book selectedBook = (Book)theList.getModel().getElementAt(index);
                    if(selectedBook!= null)doubleClickedBook(selectedBook);
                  
                   
                    
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
               
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
            }
            
        };
        this.addWindowListener(new WindowAdapter(){
              public void WindowClosing(WindowEvent e){
                  if(theController !=null)theController.closeBookListFrame();
                  else System.exit(0);
              }
         });
        
        update();
    }
    
    private void doubleClickedBook(Book b){
          super.setStatus("opening book" +b.getBookName());
                    if(theController !=null){
                        theController.setSelectedBook(b);
                        theController.openPageListFrame(b);
                    }
    }
    
    private void enableListener(){
        mainPanel.getSearchButton().addActionListener(seachButtonListener);
        mainPanel.getBookList().addMouseListener(doubleClickedonbook);
    }
    private void disableListener(){
        mainPanel.getSearchButton().removeActionListener(seachButtonListener);
        mainPanel.getBookList().removeMouseListener(doubleClickedonbook);
    }
    
    private void searchBook(){
        
        super.setStatus("searching book :");
        String searchContent = mainPanel.getSearchField().getText().trim();
        String mode  = (String)mainPanel.getSelectedType().getSelectedItem();
        ArrayList<Book> searchBook = new ArrayList<Book>();
        
        if(searchContent.equals("*") ||searchContent.equals("%") ||searchContent.equals("") )
            searchBook = theConnecter.getBookList();
       
        else if(mode.equals(BookListPanel.searchType.BookCode.toString())){
             searchBook = theConnecter.searchBook(searchContent, "code");
        }
       
        else if(mode.equals(BookListPanel.searchType.BookTitle.toString())){
            searchBook =theConnecter.searchBook(searchContent, "title");
        }
       
        else if(mode.equals(BookListPanel.searchType.BookAuthor.toString())){
             searchBook =theConnecter.searchBook(searchContent, "author");
        }
        
        bookCollection = searchBook;
        
        update();
    }
    
    private void updateList(){
        Book bookArray[] = new Book[1];
        mainPanel.getBookList().setListData((Book [])bookCollection.toArray(bookArray));   
    }
    
    private void update(){
        disableListener();
        updateList();
        enableListener();
    }
            
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BooklistFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BooklistFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BooklistFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BooklistFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new BooklistFrame().setVisible(true);
            }
        });
    }
}
