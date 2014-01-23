/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MenuFrame.java
 *
 * Created on Jan 7, 2014, 4:01:21 PM
 */
package model;


import java.awt.event.*;

import main.Book;
import javax.swing.JLabel;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import main.Controller;
import main.Page;
import main.ViewBooksMain;


//basic viewer for BookViewer;
public class MenuFrame extends javax.swing.JFrame  {


    
    
    private static Controller      theController;
    private static MenuFrame   theFrame;
    private static ActionListener  addnewBookListener;
    private static ActionListener  editBookListener;
    private static ActionListener  removeBookListener;
    
    private static ActionListener  addnewPageListener;
    private static ActionListener  editPageListener;
    private static ActionListener  removePageListener;
    
    private static ActionListener  viewBookListener;
    private static ActionListener  aboutMenuListener;
    
    private static Book            editedBook;
    private static Page            editedPage;
    

    
     //constractor with title;
    /**
     *
     * @param t
     */
    public MenuFrame(String t){
        super(t);
        theFrame = this;
        initListener();
        initComponents();
        enableListener();
        updateButton();
    }
    
    /**
     *
     * @param t
     * @param c
     */
    public MenuFrame(String t,Controller c){
        super(t);
        theController = c;
        theFrame = this;
        initListener();
        initComponents();
        enableListener();
        updateButton();
        
    }
    
    
    
    
   
    //update Status Message;
    public void setStatus(String s){
    statusBar.setText("Status : "+s);
    } 
    
    public void updateMainPanel(JPanel panel){
    java.awt.GridBagConstraints gridBagConstraints;
    getContentPane().remove(mainPannel);
    mainPannel = new JPanel();
    mainPannel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));
        mainPannel.setLayout(new java.awt.BorderLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.ipady = 200;
        gridBagConstraints.weightx = 2.0;
        gridBagConstraints.weighty = 2.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        getContentPane().add(mainPannel, gridBagConstraints);
        mainPannel.add(panel, java.awt.BorderLayout.CENTER);
        
        update();
    }

    //return status;
    public JLabel getStatus(){
      return statusBar;
    }
    
    //return main panel;
    public JPanel getMainPanel(){
      return mainPannel;
    }
    
    // set up and define all listener;
    private void initListener(){
        
        //Listener: clicked add button in tool bar or select addbook opotion in edit menu 
        addnewBookListener =new ActionListener(){
          
            @Override
            public void actionPerformed(ActionEvent e) {
                setStatus("add new book option cilcked");
                if(theController !=null)theController.openBookInfoDialog(null);
            }
        };
        editBookListener =new ActionListener(){
          
            @Override
            public void actionPerformed(ActionEvent e) {
                setStatus("edit Book option cilcked");
                if(editedBook == null) 
                    JOptionPane.showMessageDialog(theFrame,"System did not found a seleced Book","Inane error",JOptionPane.ERROR_MESSAGE);
                else{
                    if(theController !=null) theController.openBookInfoDialog(editedBook);
                }
                

            }
        };
        removeBookListener =new ActionListener(){
          
            @Override
            public void actionPerformed(ActionEvent e) {
                setStatus("remove Book option cilcked");
                if(editedBook == null) JOptionPane.showMessageDialog(theFrame,"System did not found a seleced Book","Inane error",JOptionPane.ERROR_MESSAGE);
                else{
                    if(theController !=null) theController.openBookInfoDialog(editedBook);
                }
                

            }
        };
        
        addnewPageListener =new ActionListener(){
          
            @Override
            public void actionPerformed(ActionEvent e) {
                setStatus("add new page option cilcked");
                
                if(theController != null) theController.openPageInfoDialog(null);
               
            }
        };
        editPageListener =new ActionListener(){
          
            @Override
            public void actionPerformed(ActionEvent e) {
                setStatus("edit Page option cilcked");
                if(editedPage ==null) JOptionPane.showMessageDialog(theFrame,"System did not found a seleced Book","Inane error",JOptionPane.ERROR_MESSAGE);
                else{
                    if(theController !=null) theController.openPageInfoDialog(editedPage);
                }
               

            }
        };
        removePageListener =new ActionListener(){
          
            @Override
            public void actionPerformed(ActionEvent e) {
                setStatus("remove page option cilcked");
                if(editedPage ==null) JOptionPane.showMessageDialog(theFrame,"System did not found a seleced Book","Inane error",JOptionPane.ERROR_MESSAGE);
                else{
                    if(theController !=null) theController.openPageInfoDialog(editedPage);
                }
               

            }
        };
        //Listener: clicked seach book in tool bar
        viewBookListener =new ActionListener(){
          
            @Override
            public void actionPerformed(ActionEvent e) {
                setStatus("search book");
                if(theController !=null) theController.OpenBookListFrame();
                
            }
        };
        aboutMenuListener =new ActionListener(){
          
            @Override
            public void actionPerformed(ActionEvent e) {
                setStatus("about this program.... ");
               
                
            }
        };

         
        
       
      
 
    }
    
    //add all listener to frame;
    private void enableListener(){
        
        addBookMenuItem.addActionListener(addnewBookListener);
        editBookMenuItem.addActionListener(editBookListener);
        deleteBookMenuItem.addActionListener(removeBookListener);
        
        
        addPageMenuItem.addActionListener(addnewPageListener);
        editPageMenuItem.addActionListener(editPageListener);
        deletePageMenuItem.addActionListener(removePageListener);
        
        About.addActionListener(aboutMenuListener);
          
        addnewBookButton.addActionListener(addnewBookListener);
        removeBook.addActionListener(removeBookListener);
        ViewBookButton.addActionListener(viewBookListener);

       
    } 
    //remove all listener from frame;
    private void disableListsener(){
        About.removeActionListener(aboutMenuListener);
        addBookMenuItem.removeActionListener(addnewBookListener);
        deleteBookMenuItem.removeActionListener(removeBookListener);
        editBookMenuItem.removeActionListener(editBookListener);
        removeBook.removeActionListener(MenuFrame.removeBookListener);
        ViewBookButton.removeActionListener(MenuFrame.viewBookListener);

      
    }
    
    //rest Main Panel;
   
    
    
    
    
  
    private void updateButton(){
       
        if(theController.getSelectedBook() != null){
            Pages.setEnabled(true);
            editBookMenuItem.setEnabled(true);
            deleteBookMenuItem.setEnabled(true);
            removeBook.setEnabled(true);
            
        }else {
            Pages.setEnabled(false);
            Pages.setEnabled(false);
            editBookMenuItem.setEnabled(false);
            deleteBookMenuItem.setEnabled(false);
            removeBook.setEnabled(false);
        }
        if(theController.getSelectedPage() !=null){
            editPageMenuItem.setEnabled(true);
            deletePageMenuItem.setEnabled(true);
        } else{
            editPageMenuItem.setEnabled(false);
            deletePageMenuItem.setEnabled(false);
        }
    
        
    }
    private void update(){
        disableListsener();
        enableListener(); 
        updateButton();
        
    }
    
    public static void main(String args[])  {
       
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                ViewBooksMain  main = new ViewBooksMain();
                new MenuFrame("test",main).setVisible(true);
            }
        });
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        bookToolBar = new javax.swing.JToolBar();
        addnewBookButton = new javax.swing.JButton();
        removeBook = new javax.swing.JButton();
        ViewBookButton = new javax.swing.JButton();
        separator = new javax.swing.JToolBar.Separator();
        mainPannel = new javax.swing.JPanel();
        ProgressBar = new javax.swing.JProgressBar();
        statusBar = new javax.swing.JLabel();
        topMenuBar = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        fileMenuSeparator = new javax.swing.JPopupMenu.Separator();
        exitMenuItem = new javax.swing.JMenuItem();
        Edit = new javax.swing.JMenu();
        addBookMenuItem = new javax.swing.JMenuItem();
        editBookMenuItem = new javax.swing.JMenuItem();
        deleteBookMenuItem = new javax.swing.JMenuItem();
        Pages = new javax.swing.JMenu();
        addPageMenuItem = new javax.swing.JMenuItem();
        editPageMenuItem = new javax.swing.JMenuItem();
        deletePageMenuItem = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        Help = new javax.swing.JMenu();
        About = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        bookToolBar.setForeground(new java.awt.Color(240, 240, 240));
        bookToolBar.setRollover(true);

        addnewBookButton.setFont(new java.awt.Font("Tahoma", 0, 12));
        addnewBookButton.setText("Add New Book");
        addnewBookButton.setToolTipText("Add New Book");
        addnewBookButton.setFocusable(false);
        addnewBookButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addnewBookButton.setMargin(new java.awt.Insets(3, 5, 3, 3));
        addnewBookButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bookToolBar.add(addnewBookButton);

        removeBook.setFont(new java.awt.Font("Tahoma", 0, 12));
        removeBook.setText("Edit Book");
        removeBook.setToolTipText("Edited Selected Book");
        removeBook.setFocusable(false);
        removeBook.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        removeBook.setMargin(new java.awt.Insets(3, 5, 3, 3));
        removeBook.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bookToolBar.add(removeBook);

        ViewBookButton.setText("View Book List");
        ViewBookButton.setToolTipText("viewBookList");
        ViewBookButton.setFocusable(false);
        ViewBookButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ViewBookButton.setMargin(new java.awt.Insets(3, 5, 3, 3));
        ViewBookButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bookToolBar.add(ViewBookButton);
        bookToolBar.add(separator);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 752;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(bookToolBar, gridBagConstraints);

        mainPannel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));
        mainPannel.setLayout(new java.awt.BorderLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.ipady = 200;
        gridBagConstraints.weightx = 2.0;
        gridBagConstraints.weighty = 2.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        getContentPane().add(mainPannel, gridBagConstraints);

        ProgressBar.setMaximum(200);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        getContentPane().add(ProgressBar, gridBagConstraints);

        statusBar.setFont(new java.awt.Font("Agency FB", 0, 18));
        statusBar.setText("Status:");
        statusBar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 80;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(statusBar, gridBagConstraints);

        topMenuBar.setMargin(new java.awt.Insets(10, 10, 10, 10));

        FileMenu.setText("File");
        FileMenu.setAlignmentY(1.0F);
        FileMenu.setFocusable(false);
        FileMenu.setFont(new java.awt.Font("Agency FB", 0, 16));
        FileMenu.setMargin(new java.awt.Insets(3, 3, 3, 3));

        openMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openMenuItem.setFont(new java.awt.Font("Agency FB", 0, 16));
        openMenuItem.setText("Open");
        openMenuItem.setMargin(new java.awt.Insets(2, 2, 2, 2));
        FileMenu.add(openMenuItem);

        saveMenuItem.setFont(new java.awt.Font("Agency FB", 0, 16));
        saveMenuItem.setText("Save");
        saveMenuItem.setMargin(new java.awt.Insets(2, 2, 2, 2));
        FileMenu.add(saveMenuItem);
        FileMenu.add(fileMenuSeparator);

        exitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        exitMenuItem.setFont(new java.awt.Font("Agency FB", 0, 16));
        exitMenuItem.setText("Exit");
        exitMenuItem.setMargin(new java.awt.Insets(2, 2, 2, 2));
        FileMenu.add(exitMenuItem);

        topMenuBar.add(FileMenu);

        Edit.setText("Books");
        Edit.setAlignmentY(1.0F);
        Edit.setFont(new java.awt.Font("Agency FB", 0, 16));
        Edit.setMargin(new java.awt.Insets(3, 3, 3, 3));

        addBookMenuItem.setFont(new java.awt.Font("Agency FB", 0, 16));
        addBookMenuItem.setText("AddBook");
        addBookMenuItem.setMargin(new java.awt.Insets(2, 2, 2, 2));
        Edit.add(addBookMenuItem);

        editBookMenuItem.setFont(new java.awt.Font("Agency FB", 0, 16));
        editBookMenuItem.setText("EditBook");
        editBookMenuItem.setMargin(new java.awt.Insets(2, 2, 2, 2));
        Edit.add(editBookMenuItem);

        deleteBookMenuItem.setFont(new java.awt.Font("Agency FB", 0, 16));
        deleteBookMenuItem.setText("DeleteBook");
        deleteBookMenuItem.setMargin(new java.awt.Insets(2, 2, 2, 2));
        Edit.add(deleteBookMenuItem);

        topMenuBar.add(Edit);

        Pages.setText("Pages");
        Pages.setAlignmentY(1.0F);
        Pages.setFont(new java.awt.Font("Agency FB", 0, 16));
        Pages.setMargin(new java.awt.Insets(3, 3, 3, 3));

        addPageMenuItem.setFont(new java.awt.Font("Agency FB", 0, 16));
        addPageMenuItem.setText("Add Page");
        addPageMenuItem.setMargin(new java.awt.Insets(2, 2, 2, 2));
        Pages.add(addPageMenuItem);

        editPageMenuItem.setFont(new java.awt.Font("Agency FB", 0, 16));
        editPageMenuItem.setText("Edit Page");
        editPageMenuItem.setMargin(new java.awt.Insets(2, 2, 2, 2));
        Pages.add(editPageMenuItem);

        deletePageMenuItem.setFont(new java.awt.Font("Agency FB", 0, 16));
        deletePageMenuItem.setText("Delete Page");
        deletePageMenuItem.setMargin(new java.awt.Insets(2, 2, 2, 2));
        Pages.add(deletePageMenuItem);

        topMenuBar.add(Pages);

        jMenu1.setText("Database");
        jMenu1.setAlignmentY(1.0F);
        jMenu1.setFont(new java.awt.Font("Agency FB", 0, 16));
        jMenu1.setMargin(new java.awt.Insets(3, 3, 3, 3));
        topMenuBar.add(jMenu1);

        Help.setText("Help");
        Help.setAlignmentY(1.0F);
        Help.setFont(new java.awt.Font("Agency FB", 0, 16));
        Help.setMargin(new java.awt.Insets(3, 3, 3, 3));

        About.setFont(new java.awt.Font("Agency FB", 0, 16));
        About.setText("About");
        About.setMargin(new java.awt.Insets(2, 2, 2, 2));
        Help.add(About);

        topMenuBar.add(Help);

        setJMenuBar(topMenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem About;
    private javax.swing.JMenu Edit;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JMenu Help;
    private javax.swing.JMenu Pages;
    private javax.swing.JProgressBar ProgressBar;
    private javax.swing.JButton ViewBookButton;
    private javax.swing.JMenuItem addBookMenuItem;
    private javax.swing.JMenuItem addPageMenuItem;
    private javax.swing.JButton addnewBookButton;
    private javax.swing.JToolBar bookToolBar;
    private javax.swing.JMenuItem deleteBookMenuItem;
    private javax.swing.JMenuItem deletePageMenuItem;
    private javax.swing.JMenuItem editBookMenuItem;
    private javax.swing.JMenuItem editPageMenuItem;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JPopupMenu.Separator fileMenuSeparator;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel mainPannel;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JButton removeBook;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JToolBar.Separator separator;
    private javax.swing.JLabel statusBar;
    private javax.swing.JMenuBar topMenuBar;
    // End of variables declaration//GEN-END:variables

}
