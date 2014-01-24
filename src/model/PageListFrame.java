/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import main.Book;
import main.Connecter;
import main.Page;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.event.ListSelectionListener;
import main.Controller;
import main.ViewBooksMain;
import viewer.PageListPanel;

/**
 *
 * @author byang1
 */
public class PageListFrame  extends MenuFrame{
    PageListPanel           mainPanel;
    
    ActionListener          seachButtonListener;
    MouseListener           doubleClickedonBook;
    MouseListener           doubleClickedonPage;
    ListSelectionListener   pagelistSelection;
    ListSelectionListener   booklistSelection;
    
    Connecter               theConnecter;
    Controller              theController;
    
    ArrayList<Book>         bookCollection;
    ArrayList<Page>         pageCollection;
    
    Book                    theBook;
    

    
    public PageListFrame(){
        
        super("Page List");
        theConnecter = new Connecter();
        initComponents();
    }
    
    public PageListFrame(String title,ViewBooksMain viewer, Controller c, Connecter conn,Book initBook){
        
        super(title,c);
        theConnecter = conn;
        theController = c;
        theBook = initBook;
        initComponents();
    }
    
    private void initComponents(){
        
        mainPanel = new PageListPanel();
        super.updateMainPanel(mainPanel);
        bookCollection  = theConnecter.getBookList(); 
        if(theBook==null)pageCollection = theConnecter.getPageList(); 
        else pageCollection = theConnecter.searchPage(theBook.getBookCode(), "bookcode");
        seachButtonListener = new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
               
                searchPage();
            }
        };
        
       
        
        update();
    }
    
    private void searchPage(){
        super.setStatus("searching page ....");
        String searchContent = mainPanel.getSearchField().getText().trim();
        String mode  = (String)mainPanel.getTypeBox().getSelectedItem();
        ArrayList<Page> searchPage = new ArrayList<Page>();
        
        if(searchContent.equals("*") ||searchContent.equals("%") ||searchContent.equals("") )
            searchPage = theConnecter.getPageList();
    
        else if(mode.equals("Page ID")){
             searchPage = theConnecter.searchPage(searchContent, "id");
        }
       
        else if(mode.equals("Book Code")){
            searchPage =theConnecter.searchPage(searchContent, "bookcode");
        }
       
        else if(mode.equals("Page Title")){
             searchPage =theConnecter.searchPage(searchContent, "title");
        }
        
         pageCollection = searchPage;
         update();
    }
    
    
    private void enableListener(){
       
        mainPanel.getSearchButton().addActionListener(seachButtonListener);
        mainPanel.getBookList().addMouseListener(doubleClickedonBook);
        mainPanel.getPageList().addMouseListener(doubleClickedonPage);
        mainPanel.getBookList().addListSelectionListener(booklistSelection);
        mainPanel.getPageList().addListSelectionListener(pagelistSelection);
        
    }
    private void disableListener(){
       
        mainPanel.getSearchButton().removeActionListener(seachButtonListener);
        mainPanel.getBookList().removeMouseListener(doubleClickedonBook);
        mainPanel.getPageList().removeMouseListener(doubleClickedonPage);
        mainPanel.getBookList().removeListSelectionListener(booklistSelection);
        mainPanel.getPageList().removeListSelectionListener(pagelistSelection);
    }
    
    private void update(){
        disableListener();
        updateList();
        enableListener();
      
      
    }
    private void updateList(){
        
        Book bookArray[] =new Book[1];
        mainPanel.getBookList().setListData((Book []) bookCollection.toArray(bookArray));
        Page pageArray[]  = new Page[1];
        mainPanel.getPageList().setListData(pageCollection.toArray(pageArray));
        
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
            java.util.logging.Logger.getLogger(PageListFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PageListFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PageListFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PageListFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new PageListFrame().setVisible(true);
            }
        });
    }
}

