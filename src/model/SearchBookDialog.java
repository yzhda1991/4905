/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import main.Book;
import viewer.SearchBookPanel;

/**
 *
 * @author brianyang
 */
public class SearchBookDialog extends JDialog{
    
    SearchBookPanel         mainPanel;
    ActionListener          seachButtonListener;
    MouseListener           doubleClickedonList;
    KeyListener             searchKeyListener;
    Connecter               theConnecter;
    Controller              theController;
    ArrayList               resultCollection;
    
    public SearchBookDialog(JFrame parent, String title, Connecter con,Controller c,boolean modal){
     super(parent,title,modal);
     mainPanel = new SearchBookPanel();
     theConnecter = con;
     theController = c;
     init();
    
    }
    private void init(){
        
        
        seachButtonListener = new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                searchActionMap();
            }
            
        };
        
        doubleClickedonList = new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {
               if(e.getClickCount()==2){
                    JList theList =(JList) e.getSource();
                    int index =  theList.locationToIndex(e.getPoint());
                    Book selectedBook = (Book)theList.getModel().getElementAt(index);
                    if(selectedBook !=null)openPageList(selectedBook);
                    
                    
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
        
        searchKeyListener = new KeyListener(){

            @Override
            public void keyTyped(KeyEvent e) {
                
                 }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
             updateButton();
                
            }
            
        };
        
        enableListener();
        
        this.add(mainPanel);
        this.setSize(500,450);
        this.setResizable(false);
        this.setAlwaysOnTop(true);
        
        update();
    }
    private void openPageList(Book b){
        if(theController!=null){
                        theController.setSelectedBook(b);
                        theController.openPageListFrame(b);
                        theController.closeBookSearchDialog();
                    }
        else{
        this.setVisible(false);
        this.dispose();
        }
    }
    private void enableListener(){
        
        mainPanel.getSubmitButton().addActionListener(seachButtonListener);
        mainPanel.getResult().addMouseListener(doubleClickedonList);
        mainPanel.getSearchContentField().addKeyListener(searchKeyListener);
        
    }
    private void disableListener(){
        
        mainPanel.getSubmitButton().removeActionListener(seachButtonListener);
        mainPanel.getResult().removeMouseListener(doubleClickedonList);
        mainPanel.getSearchContentField().removeKeyListener(searchKeyListener);
    }
    
    private void searchActionMap(){
        
        String searchContent = mainPanel.getSearchContentField().getText().toString().trim();
        //System.out.println(.toString());
        if(mainPanel.getTitleRadioButton().isSelected()){
            resultCollection = theConnecter.searchBook(searchContent, "title");
            update();
        }
        
        else if(mainPanel.getCodeRadioButton().isSelected()){
            resultCollection = theConnecter.searchBook(searchContent, "code");
            update();
        }
        
        else if(mainPanel.getPathRadioButton().isSelected()){
            resultCollection = theConnecter.searchBook(searchContent, "path");
            update();
        }
        
        else if(mainPanel.getAuthorRadioButton().isSelected()){
            
            resultCollection = theConnecter.searchBook(searchContent, "author");
            update();
            
        }
    }
    
    private void updateList(){
           
        Book bookArray[] = new Book[1];
            if(resultCollection!=null && !resultCollection.isEmpty()){
            mainPanel.getResult().setListData(resultCollection.toArray(bookArray));
            }
 
    }
    
    private void updateButton(){
        
        if(mainPanel.getSearchContentField().getText().toString().trim().length()<=2) mainPanel.getSubmitButton().setEnabled(false);
        else mainPanel.getSubmitButton().setEnabled(true);
        
        if(resultCollection ==null || resultCollection.isEmpty()) {
            if(mainPanel.getResult().isVisible())mainPanel.getResult().setVisible(false);
        }
        
        else {
            if(mainPanel.getResult().isVisible()) {
            } 
            else {
            mainPanel.getResult().setVisible(true);
            }   
        }
        
    }
    
    public void update(){
        disableListener();
        updateList();
        updateButton();
        enableListener();
    }
}
