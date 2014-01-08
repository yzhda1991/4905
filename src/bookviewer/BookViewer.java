/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bookviewer;


import GUI.BookListPannel;
import GUI.MainMenuFrame;
import GUI.PageListPannel;
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
    private static MainMenuFrame mainFrame;
    private static BookListPannel booklistPanel;
    private static PageListPannel  pagelistPanel;
    private static ActionListener  addnewBookListener;
    private static ActionListener  editBookListener;
    private static ActionListener  removeBookListener;
    private static ActionListener  searchBookListener;
    private static MouseListener   doubleClickBookListListener;
    private static KeyListener     keyListstener;   
    private static String          editedItem;
    
    public static void initComponents(){
       initListener();
        booklistPanel = new BookListPannel(doubleClickBookListListener,keyListstener);
        
        
    }
    public static void initListener(){
        
        //add new book listener
        addnewBookListener =new ActionListener(){
          
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setStatus("add new books");
            }
        };
        
        //edit book listener
         editBookListener =new ActionListener(){
          
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setStatus("edit book");
            }
        };
         
         //remove book listener
         removeBookListener =new ActionListener(){
          
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setStatus("remove book");
            }
        };
         
         //search book listener
         searchBookListener =new ActionListener(){
          
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setStatus("search book");
                searchbook();
                
            }
        };
         
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

    }
    public static void viewPageList(String t){
        mainFrame.initMainPanel();
        mainFrame.getMainPanel().add(pagelistPanel, java.awt.BorderLayout.CENTER);
        }
    public static void searchbook(){
        mainFrame.initMainPanel();
        mainFrame.getMainPanel().add(booklistPanel, java.awt.BorderLayout.CENTER);
       
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        initComponents();
        
        
        mainFrame = new MainMenuFrame(addnewBookListener,editBookListener,removeBookListener,searchBookListener);
        mainFrame.setVisible(true);
        
    }
    
    
    
}
