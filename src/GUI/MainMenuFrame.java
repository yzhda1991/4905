/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainMenuFrame.java
 *
 * Created on Jan 7, 2014, 4:01:21 PM
 */
package GUI;

import bookviewer.Book;
import bookviewer.Page;
import java.awt.Component;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

//basic viewer for BookViewer;
public class MainMenuFrame extends javax.swing.JFrame implements dialogClient {

    private static BookListPannel  booklistPanel;
    private static PageListPannel  pagelistPanel;
    private static PageViewer      pageViewerPanel;
    private static aboutDialog     aboutDetailDialog;
    private static BookInfoDialog  theBookInfoDialog;
    
    private static ActionListener  addnewBookListener;
    private static ActionListener  editBookListener;
    private static ActionListener  removeBookListener;
    private static ActionListener  searchBookListener;
    private static ActionListener  aboutMenuListener;

    private static MouseListener   doubleClickBookListListener;
    private static MouseListener   doubleClickBooktitleListener;
    private static MouseListener   doubleClickPageTitleListener;
    
    private static ListSelectionListener bookListSelctionListener;
    private static ListSelectionListener pageListSelectionListener;
  
     
    private static KeyListener     keyListstener;   
    
    private static Book            editedBook;
    private static Page            editedPage;
    private static Book            selectedBook;
    private static Page            selectedPage;
    
    private static ArrayList<Book> bookCollection;
    private static ArrayList<Page> pageCollection;
    
    private static Connection databaseConnection;
    private static Statement stat;
    
  
     
    //constractor with title;
    public MainMenuFrame(String t){
        super(t);
        bookCollection =new ArrayList<Book>();
        pageCollection = new ArrayList<Page>();
      
        initListener();
        initComponents();
    }
    
    //constractor with bookCollection , pageCollection;
    public MainMenuFrame(String t, Connection c, Statement s,ArrayList<Book> books,ArrayList<Page> pages){
         super(t);
        bookCollection =books;
        pageCollection = pages;
        databaseConnection =c;
        stat =s;
        editedPage = null;
        editedBook = null;
      
        initListener();
        initComponents();
         enableListener();
       
    }
    
    //update Status Message;
    private void setStatus(String s){
    statusBar.setText("Status : "+s);
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
                addNewBook();
               
            }
        };
        editBookListener =new ActionListener(){
          
            @Override
            public void actionPerformed(ActionEvent e) {
                setStatus("edit Book option cilcked");
                if(selectedBook ==null)
                    setStatus("book not selected!");
                else{
                    editedBook = selectedBook;
                    editBook();
                }

            }
        };
        removeBookListener =new ActionListener(){
          
            @Override
            public void actionPerformed(ActionEvent e) {
                setStatus("remove Book option cilcked");
                if(selectedBook ==null)
                    setStatus("book not selected!");
                else{
                    editedBook = selectedBook;
                    removeBook();
                }

            }
        };
        
        
         
         //Listener: clicked seach book in tool bar
         searchBookListener =new ActionListener(){
          
            @Override
            public void actionPerformed(ActionEvent e) {
                setStatus("search book");
                viewBookList();
                
            }
        };
         aboutMenuListener =new ActionListener(){
          
            @Override
            public void actionPerformed(ActionEvent e) {
                setStatus("about this program.... ");
                aboutProgram();
                
            }
        };

         //Listener for BookListPanel;
         //Listener : double clicked book title in BookListPannel
         doubleClickBookListListener = new MouseAdapter() { 
            @Override
            public void mouseClicked(MouseEvent event) { 
                if (event.getClickCount() == 2) { 
                    JList theList = (JList) event.getSource(); 
                    int index = theList.locationToIndex(event.getPoint()); 
                    selectedBook = (Book) theList.getModel().getElementAt(index); 
                   setStatus("Double Click on: " + selectedBook); 
                   viewPageList(selectedBook);
                }  
                      
            }}; 
         
         //Listener for PageListpanel;
         //Listener: double clicked book title in PageListPannel 
         doubleClickBooktitleListener = new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent event) { 
                if (event.getClickCount() == 2) { 
                    JList theList = (JList) event.getSource(); 
                    int index = theList.locationToIndex(event.getPoint()); 
                    editedBook = (Book) theList.getModel().getElementAt(index); 
                   setStatus("Double Click on Book : " + editedBook); 
                  
                }  
                      
            }}; 
         
         //Listener: doubleClicked page Title in PageListPannel
         doubleClickPageTitleListener = new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent event) { 
                if (event.getClickCount() == 2) { 
                    JList theList = (JList) event.getSource(); 
                    int index = theList.locationToIndex(event.getPoint()); 
                    editedPage = (Page) theList.getModel().getElementAt(index); 
                   setStatus("Double Click on Page: " + editedPage); 
                   viewPage(editedPage);
                 }  
                      
            }}; 
            
          //Listener allow selection from BookList;
         bookListSelctionListener = new ListSelectionListener(){

            @Override
            public void valueChanged(ListSelectionEvent e) {
                selectedBook();
            }
                
            };
            
            //Listener allow selection from PageList;
         pageListSelectionListener = new ListSelectionListener(){

            @Override
            public void valueChanged(ListSelectionEvent e) {
                selectedPage();
            }
                
            };
            
          addWindowListener(
                  new WindowAdapter(){
                      public void WindowClosing(WindowEvent e){
                          try{
                              System.out.println("Closing DataBase Connection");
                              databaseConnection.close();
                            
                          }catch(SQLException ex){
                              ex.printStackTrace();
                          }
                          
                          System.exit(0);
                      }
                  }
                  );
 
    }
    //add all listener to frame;
    private void enableListener(){
        About.addActionListener(aboutMenuListener);
        addBookMenuItem.addActionListener(addnewBookListener);
        deleteBookMenuItem.addActionListener(removeBookListener);
        editBookMenuItem.addActionListener(editBookListener);
        removeBook.addActionListener(MainMenuFrame.removeBookListener);
        if(booklistPanel !=null) booklistPanel.getBookList().addListSelectionListener(bookListSelctionListener);
        if(pagelistPanel !=null){
            pagelistPanel.getBookList().addListSelectionListener(bookListSelctionListener);
            pagelistPanel.getPageList().addListSelectionListener(pageListSelectionListener);
        }
        if(pageViewerPanel != null) pageViewerPanel.getPageList().addListSelectionListener(pageListSelectionListener);
        
       
    } 
    //remove all listener from frame;
    private void disableListsener(){
        About.removeActionListener(aboutMenuListener);
        
        if(booklistPanel !=null) booklistPanel.getBookList().removeListSelectionListener(bookListSelctionListener);
        if(pagelistPanel !=null){
            pagelistPanel.getBookList().removeListSelectionListener(bookListSelctionListener);
            pagelistPanel.getPageList().removeListSelectionListener(pageListSelectionListener);
        }
        if(pageViewerPanel != null) pageViewerPanel.getPageList().removeListSelectionListener(pageListSelectionListener);
        
    }
    
    //rest Main Panel;
    private void initMainPanel(JPanel panel){
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
    
    private void selectedBook(){
         Component temp = mainPannel.getComponent(0);
         if(temp.equals(booklistPanel))
             selectedBook =(Book) booklistPanel.getBookList().getSelectedValue();
         
         else if (temp.equals(pagelistPanel)) 
             selectedBook =(Book) pagelistPanel.getBookList().getSelectedValue();
         
         if(selectedBook !=null) setStatus("selected book :" +selectedBook.getBookName());
         update();
    }
    private void selectedPage(){
        
        Component temp = mainPannel.getComponent(0);
         if(temp.equals(pageViewerPanel))
            selectedPage =(Page) pageViewerPanel.getPageList().getSelectedValue();
         
         else if (temp.equals(pagelistPanel)) 
             selectedPage =(Page) pagelistPanel.getPageList().getSelectedValue();
         
         if(selectedPage !=null) setStatus("selected page :" +selectedPage.getPageTitle());
         update();
    }
   
    //Action handle for double click book in BookPanelList;
    private void viewBookList(){
        if(booklistPanel ==null){
            booklistPanel = new BookListPannel(bookCollection,doubleClickBookListListener,keyListstener);
            }
        initMainPanel(booklistPanel);
        booklistPanel.setBookList(bookCollection, selectedBook);
        booklistPanel.update();
    } 
    //Action performs for viewing page list: display pagelist from t book;
    private void viewPageList(Book b){
        
        
        if(pagelistPanel ==null){
            pagelistPanel = new PageListPannel(doubleClickPageTitleListener,doubleClickBooktitleListener,bookCollection,pageCollection);;
        }
        ArrayList<Page> temp = new ArrayList<Page>();
        
        for(Page p:pageCollection){
            if(p.getBookCode().equals(b.getBookCode()))
                temp.add(p);
        }
        initMainPanel(pagelistPanel);
        pagelistPanel.setBookList(bookCollection,b);
        pagelistPanel.setPageList(temp,selectedPage);
        pagelistPanel.update();
        
    }
    //Action performs for viewing page;  
    private void viewPage(Page p){
        
        String path = "src/Resources/test.pdf";
        
        if(pageViewerPanel ==null){
            pageViewerPanel = new PageViewer(doubleClickPageTitleListener,keyListstener,pageCollection);
        }
        initMainPanel(pageViewerPanel);
        pageViewerPanel.setPageList(pageCollection,p);
        pageViewerPanel.setTittle(p.getPageTitle());
        pageViewerPanel.openPage(path);
        
        pageViewerPanel.update();

    }
    //Action performs for About in Menu
    private void aboutProgram(){
        if(aboutDetailDialog ==null){
            aboutDetailDialog = new aboutDialog(this,this,"about me",true);
            aboutDetailDialog.setVisible(true);
        }
    }
    //action performs for add new book;
    private void addNewBook(){
        editedBook = new Book();
        theBookInfoDialog = new BookInfoDialog(this,this,"add new Book",editedBook,dialogClient.operation.ADD,true);
       
        theBookInfoDialog.setVisible(true);

    }
    //action performs for editing book;
    private void editBook(){
        theBookInfoDialog = new BookInfoDialog(this,this,"edited Book Info: "+editedBook.getBookName(),editedBook,dialogClient.operation.UPDATE,true);
        
        theBookInfoDialog.setVisible(true);
    }
    //action perfomrs for remove book;
    private void removeBook(){
       theBookInfoDialog = new BookInfoDialog(this,this,"Delete Book Info: "+editedBook.getBookName(),editedBook,dialogClient.operation.DELETE,true);
        
       theBookInfoDialog.setVisible(true);
    }
    
    
    private void updateList(){
        
        disableListsener();
         Component temp = mainPannel.getComponent(0);
         if(temp.equals(booklistPanel)) {
             booklistPanel.update();
             if(selectedBook != null)
                 booklistPanel.getBookList().setSelectedValue(selectedBook, true);
         }
         else if (temp.equals(pagelistPanel)) {
             pagelistPanel.update();
             if(selectedBook != null)
                 pagelistPanel.getBookList().setSelectedValue(selectedBook, true);
         } 
         
         enableListener();   
    }
    private void update(){
        disableListsener();
       updateList();
        enableListener(); 
    }
    
    
    @Override
    public void bookDialogFinished(operation anOperation) {
        
        if(anOperation == dialogClient.operation.UPDATE){
            setStatus("added new Book :" +editedBook.getBookName());
        }   
        
        else if(anOperation == dialogClient.operation.ADD){
            
            if(editedBook !=null) 
            {
                try{
                    bookCollection.add(editedBook);
                    setStatus("added new Book :" +editedBook.getBookName());
                }
                catch(java.lang.ArrayIndexOutOfBoundsException e){
                    setStatus(e.getMessage());
                }
            }
             else setStatus(" ");
        }
        
        else if(anOperation == dialogClient.operation.DELETE){
            if(editedBook !=null){
                bookCollection.remove(editedBook);
                selectedBook =null;
            }
            else setStatus(" ");
        }
        
        selectedBook = null;
        editedBook = null;
        
        update();
        
    }

    @Override
    public void pageDialogFinished(operation anOperation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dialogCancelled() { 
       setStatus("Canceled");
    }
    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        bookToolBar = new javax.swing.JToolBar();
        addnewBookButton = new javax.swing.JButton();
        removeBook = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
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
        removePageMenuItem = new javax.swing.JMenuItem();
        deletePageMenuItem = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        Help = new javax.swing.JMenu();
        About = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        bookToolBar.setForeground(new java.awt.Color(240, 240, 240));
        bookToolBar.setRollover(true);

        addnewBookButton.setFont(new java.awt.Font("Tahoma", 0, 12));
        addnewBookButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/add.png"))); // NOI18N
        addnewBookButton.setToolTipText("Add New Book");
        addnewBookButton.setFocusable(false);
        addnewBookButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addnewBookButton.setMargin(new java.awt.Insets(3, 5, 3, 3));
        addnewBookButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bookToolBar.add(addnewBookButton);
        addnewBookButton.addActionListener(this.addnewBookListener);

        removeBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/remove.png"))); // NOI18N
        removeBook.setFocusable(false);
        removeBook.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        removeBook.setMargin(new java.awt.Insets(3, 5, 3, 3));
        removeBook.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bookToolBar.add(removeBook);

        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/search.png"))); // NOI18N
        searchButton.setFocusable(false);
        searchButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        searchButton.setMargin(new java.awt.Insets(3, 5, 3, 3));
        searchButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bookToolBar.add(searchButton);
        searchButton.addActionListener(this.searchBookListener);
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
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        getContentPane().add(ProgressBar, gridBagConstraints);

        statusBar.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        statusBar.setText("Status:");
        statusBar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
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
        FileMenu.setFont(new java.awt.Font("Agency FB", 0, 16)); // NOI18N
        FileMenu.setMargin(new java.awt.Insets(3, 3, 3, 3));

        openMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openMenuItem.setFont(new java.awt.Font("Agency FB", 0, 16)); // NOI18N
        openMenuItem.setText("Open");
        openMenuItem.setMargin(new java.awt.Insets(2, 2, 2, 2));
        FileMenu.add(openMenuItem);

        saveMenuItem.setFont(new java.awt.Font("Agency FB", 0, 16)); // NOI18N
        saveMenuItem.setText("Save");
        saveMenuItem.setMargin(new java.awt.Insets(2, 2, 2, 2));
        FileMenu.add(saveMenuItem);
        FileMenu.add(fileMenuSeparator);

        exitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        exitMenuItem.setFont(new java.awt.Font("Agency FB", 0, 16)); // NOI18N
        exitMenuItem.setText("Exit");
        exitMenuItem.setMargin(new java.awt.Insets(2, 2, 2, 2));
        FileMenu.add(exitMenuItem);

        topMenuBar.add(FileMenu);

        Edit.setText("Books");
        Edit.setAlignmentY(1.0F);
        Edit.setFont(new java.awt.Font("Agency FB", 0, 16));
        Edit.setMargin(new java.awt.Insets(3, 3, 3, 3));

        addBookMenuItem.setFont(new java.awt.Font("Agency FB", 0, 16)); // NOI18N
        addBookMenuItem.setText("AddBook");
        addBookMenuItem.setMargin(new java.awt.Insets(2, 2, 2, 2));
        Edit.add(addBookMenuItem);

        editBookMenuItem.setFont(new java.awt.Font("Agency FB", 0, 16)); // NOI18N
        editBookMenuItem.setText("EditBook");
        editBookMenuItem.setMargin(new java.awt.Insets(2, 2, 2, 2));
        Edit.add(editBookMenuItem);

        deleteBookMenuItem.setFont(new java.awt.Font("Agency FB", 0, 16)); // NOI18N
        deleteBookMenuItem.setText("DeleteBook");
        deleteBookMenuItem.setMargin(new java.awt.Insets(2, 2, 2, 2));
        Edit.add(deleteBookMenuItem);

        topMenuBar.add(Edit);

        Pages.setText("Pages");
        Pages.setAlignmentY(1.0F);
        Pages.setFont(new java.awt.Font("Agency FB", 0, 16));
        Pages.setMargin(new java.awt.Insets(3, 3, 3, 3));

        addPageMenuItem.setFont(new java.awt.Font("Agency FB", 0, 16)); // NOI18N
        addPageMenuItem.setText("AddPage");
        addPageMenuItem.setMargin(new java.awt.Insets(2, 2, 2, 2));
        addPageMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPageMenuItemActionPerformed(evt);
            }
        });
        Pages.add(addPageMenuItem);

        removePageMenuItem.setFont(new java.awt.Font("Agency FB", 0, 16)); // NOI18N
        removePageMenuItem.setText("RemovePage");
        removePageMenuItem.setMargin(new java.awt.Insets(2, 2, 2, 2));
        Pages.add(removePageMenuItem);

        deletePageMenuItem.setFont(new java.awt.Font("Agency FB", 0, 16)); // NOI18N
        deletePageMenuItem.setText("DeletePage");
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

        About.setFont(new java.awt.Font("Agency FB", 0, 16)); // NOI18N
        About.setText("About");
        About.setMargin(new java.awt.Insets(2, 2, 2, 2));
        Help.add(About);

        topMenuBar.add(Help);

        setJMenuBar(topMenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void addPageMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPageMenuItemActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_addPageMenuItemActionPerformed

  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem About;
    private javax.swing.JMenu Edit;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JMenu Help;
    private javax.swing.JMenu Pages;
    private javax.swing.JProgressBar ProgressBar;
    private javax.swing.JMenuItem addBookMenuItem;
    private javax.swing.JMenuItem addPageMenuItem;
    private javax.swing.JButton addnewBookButton;
    private javax.swing.JToolBar bookToolBar;
    private javax.swing.JMenuItem deleteBookMenuItem;
    private javax.swing.JMenuItem deletePageMenuItem;
    private javax.swing.JMenuItem editBookMenuItem;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JPopupMenu.Separator fileMenuSeparator;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel mainPannel;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JButton removeBook;
    private javax.swing.JMenuItem removePageMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JButton searchButton;
    private javax.swing.JToolBar.Separator separator;
    private javax.swing.JLabel statusBar;
    private javax.swing.JMenuBar topMenuBar;
    // End of variables declaration//GEN-END:variables

}
