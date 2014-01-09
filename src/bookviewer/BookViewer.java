/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bookviewer;


import GUI.BookListPannel;
import GUI.MainMenuFrame;
import GUI.PageListPannel;

import GUI.PageViewer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JList;

/**
 *
 * @author byang1
 *
 */

public class BookViewer {

    /**
     * @param args the command line arguments
     */
    private static MainMenuFrame   mainFrame;
    private static BookListPannel  booklistPanel;
    private static PageListPannel  pagelistPanel;
    private static PageViewer      pageViewerPanel;
    private static ActionListener  addnewBookListener;
    private static ActionListener  editBookListener;
    private static ActionListener  removeBookListener;
    private static ActionListener  searchBookListener;
    private static MouseListener   doubleClickBookListListener;
    private static MouseListener   doubleClickBooktitleListener;
    private static MouseListener   doubleClickPageTitleListener;
    private static KeyListener     keyListstener;   
    private static String          editedItem;
     
    public static void initComponents(){
       initListener();
        booklistPanel = new BookListPannel(doubleClickBookListListener,keyListstener);
        
        
    }
    public static void initListener(){
        
       //Listener: clicked add button in tool bar or select addbook opotion in edit menu 
        addnewBookListener =new ActionListener(){
          
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setStatus("add new books");
            }
        };
        
        //Listener : select edit book option in edit menu
         editBookListener =new ActionListener(){
          
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setStatus("edit book");
            }
        };
         
         //Listener: clicked remove button in tool bar or select deletebook in edit menu
         removeBookListener =new ActionListener(){
          
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setStatus("remove book");
            }
        };
         
         //Listener: clicked seach book in tool bar
         searchBookListener =new ActionListener(){
          
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setStatus("search book");
                searchbook();
                
            }
        };
         
         //Listener : double clicked book title in BookListPannel
         doubleClickBookListListener = new MouseAdapter() { 
            @Override
            public void mouseClicked(MouseEvent event) { 
                if (event.getClickCount() == 2) { 
                    JList theList = (JList) event.getSource(); 
                    int index = theList.locationToIndex(event.getPoint()); 
                    editedItem = (String) theList.getModel().getElementAt(index); 
                   mainFrame.setStatus("Double Click on: " + editedItem); 
                   viewPageList(editedItem);
                }  
                      
            }}; 
         
         //Listener: double clicked book title in PageListPannel
         doubleClickBooktitleListener = new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent event) { 
                if (event.getClickCount() == 2) { 
                    JList theList = (JList) event.getSource(); 
                    int index = theList.locationToIndex(event.getPoint()); 
                    editedItem = (String) theList.getModel().getElementAt(index); 
                   mainFrame.setStatus("Double Click on Book : " + editedItem); 
                  
                }  
                      
            }}; 
         //Listener: doubleClicked page Title in PageListPannel
            doubleClickPageTitleListener = new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent event) { 
                if (event.getClickCount() == 2) { 
                    JList theList = (JList) event.getSource(); 
                    int index = theList.locationToIndex(event.getPoint()); 
                    editedItem = (String) theList.getModel().getElementAt(index); 
                   mainFrame.setStatus("Double Click on Page: " + editedItem); 
                   viewPage(editedItem);
                 }  
                      
            }}; 
    }
    
    // display pagelist from t book;
    public static void viewPageList(String t){
        
        mainFrame.initMainPanel();
        if(pagelistPanel ==null){
            pagelistPanel = new PageListPannel(doubleClickPageTitleListener,doubleClickBooktitleListener);
        }
        mainFrame.getMainPanel().add(pagelistPanel, java.awt.BorderLayout.CENTER);
        }
    

    // search book which contain t , and update list
    public static void searchbook(){
        mainFrame.initMainPanel();
        mainFrame.getMainPanel().add(booklistPanel, java.awt.BorderLayout.CENTER);
       
    }
    
    public static void viewPage(String t){
        String path = "src/Resources/test.pdf";
        mainFrame.initMainPanel();
        if(pageViewerPanel ==null){
            pageViewerPanel = new PageViewer(doubleClickPageTitleListener,keyListstener);
        }
        pageViewerPanel.setTittle(t);
        pageViewerPanel.openPage(path);
         mainFrame.getMainPanel().add(pageViewerPanel, java.awt.BorderLayout.CENTER);
       
   
      
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        initComponents();   
        mainFrame = new MainMenuFrame(addnewBookListener,editBookListener,removeBookListener,searchBookListener);
        mainFrame.pack();
        mainFrame.setVisible(true);
          
    }
    
    
    
}
