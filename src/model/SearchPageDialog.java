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
import javax.swing.JOptionPane;
import main.Page;
import viewer.SearchPagePanel;

/**
 *
 * @author brianyang
 */
public class SearchPageDialog extends JDialog{
    
    SearchPagePanel         mainPanel;
    ActionListener          seachButtonListener;
    MouseListener           doubleClickedonList;
    KeyListener             searchKeyListener;
    Connecter               theConnecter;
    Controller              theController;
    ArrayList               resultCollection;
    
    public SearchPageDialog(JFrame parent, String title, Connecter con,Controller c,boolean modal){
     super(parent,title,modal);
     mainPanel = new SearchPagePanel();
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
                    Page findPage = (Page)theList.getModel().getElementAt(index);
                    if(findPage!=null) openPage(findPage);
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
    private void openPage(Page p){
        
        if(theController!=null){
                        theController.setSelectedPage(p);
                        theController.openPageViewer(p);
                        theController.closePageSearchDialog();
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
        if(mainPanel.getTitleRadioButton().isSelected()){
            resultCollection = theConnecter.searchPage(searchContent, "title");
            update();
        }
        
        else if(mainPanel.getCodeRadioButton().isSelected()){
            resultCollection = theConnecter.searchPage(searchContent, "bookcode");
            update();
        }
        
        else if(mainPanel.getNumRadioButton().isSelected()){
            try{
                Integer.parseInt(searchContent);
                resultCollection = theConnecter.searchPage(searchContent, "page");
               }
            catch(NumberFormatException e){
                
                JOptionPane.showMessageDialog(this,"search input is not a vaild number!",
                        "Inane error",JOptionPane.ERROR_MESSAGE);
                return;
                
            }

            update();
        }
        
      
    }
    
    private void updateList(){
           
        Page pageArray[] = new Page[1];
            if(resultCollection!=null && !resultCollection.isEmpty()){
            mainPanel.getResult().setListData(resultCollection.toArray(pageArray));
            }
 
    }
    
    private void updateButton(){
        
        if(mainPanel.getSearchContentField().getText().toString().trim().length()<1) mainPanel.getSubmitButton().setEnabled(false);
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
