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
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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
     
    private static KeyListener     keyListstener;   
    
    private static String          editedItem;
    private static Book            editedBook;
    private static Page            editedPage;
    private static Book            selectedBook;
    private static Page            selectedPage;
    
    private static ArrayList<Book> bookCollection;
    private static ArrayList<Page> pageCollection;
    
  
     
    //constractor with title;
    public MainMenuFrame(String t){
        super(t);
        bookCollection =new ArrayList<Book>();
        pageCollection = new ArrayList<Page>();
        initListener();
        initComponents();
    }
    
    public MainMenuFrame(String t, ArrayList<Book> books,ArrayList<Page> pages){
         super(t);
        bookCollection =books;
        pageCollection = pages;
        editedPage = null;
        editedBook = null;
        initListener();
        initComponents();
        enableListener();
    }
    //update Status Message;
   
    
    private void initListener(){
        //Listener: clicked add button in tool bar or select addbook opotion in edit menu 
        addnewBookListener =new ActionListener(){
          
            @Override
            public void actionPerformed(ActionEvent e) {
                addNewBook();
                setStatus("add new books");
            }
        };
        
         //Listener : select edit book option in edit menu
         editBookListener =new ActionListener(){
          
            @Override
            public void actionPerformed(ActionEvent e) {
                setStatus("edit book");
            }
        };
         
         //Listener: clicked remove button in tool bar or select deletebook in edit menu
         removeBookListener =new ActionListener(){
          
            @Override
            public void actionPerformed(ActionEvent e) {
               setStatus("remove book");
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
        
}
    // display pagelist from t book;
    private void viewPageList(Book b){
        
        
        if(pagelistPanel ==null){
            pagelistPanel = new PageListPannel(doubleClickPageTitleListener,doubleClickBooktitleListener,bookCollection,pageCollection);;
        }
        initMainPanel(pagelistPanel);
        pagelistPanel.setBookList(bookCollection,b);
        pagelistPanel.setPageList(pageCollection,selectedPage);
        pagelistPanel.update();
    }
    
    // display page  
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
    
    
    //Action handle for double click book in BookPanelList;
    private void viewBookList(){
        if(booklistPanel ==null){
            booklistPanel = new BookListPannel(bookCollection,doubleClickBookListListener,keyListstener);
            }
       initMainPanel(booklistPanel);
        booklistPanel.setBookList(bookCollection, selectedBook);
        booklistPanel.update();
    }
    
    
    //Action handle for About in Menu
    private void aboutProgram(){
        if(aboutDetailDialog ==null){
            aboutDetailDialog = new aboutDialog(this,this,"about me",true);
            aboutDetailDialog.setVisible(true);
        }
    }
    
    private void enableListener(){
        this.About.addActionListener(aboutMenuListener);
    }
    
    private void disableListsener(){
        About.removeActionListener(aboutMenuListener);
    }
    
    private void addNewBook(){
        editedBook = new Book();
        if(theBookInfoDialog == null) theBookInfoDialog = new BookInfoDialog(this,this,"add new Book",editedBook,dialogClient.operation.ADD,true);
        theBookInfoDialog.setVisible(true);
        
    }
    private void setStatus(String s){
    statusBar.setText("Status : "+s);
    }
    
    public JLabel getStatus(){
      return statusBar;
    }

    public JPanel getMainPanel(){
      return mainPannel;
    }
    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        bookToolBar = new javax.swing.JToolBar();
        addnewBookButton = new javax.swing.JButton();
        separator = new javax.swing.JToolBar.Separator();
        removeBook = new javax.swing.JButton();
        separator1 = new javax.swing.JToolBar.Separator();
        searchButton = new javax.swing.JButton();
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
        deleteBookMenuItem = new javax.swing.JMenuItem();
        editBookMenuItem = new javax.swing.JMenuItem();
        Help = new javax.swing.JMenu();
        About = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        bookToolBar.setForeground(new java.awt.Color(240, 240, 240));
        bookToolBar.setRollover(true);

        addnewBookButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        addnewBookButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/add.png"))); // NOI18N
        addnewBookButton.setToolTipText("Add New Book");
        addnewBookButton.setFocusable(false);
        addnewBookButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addnewBookButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bookToolBar.add(addnewBookButton);
        addnewBookButton.addActionListener(this.addnewBookListener);

        bookToolBar.add(separator);

        removeBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/remove.png"))); // NOI18N
        removeBook.setFocusable(false);
        removeBook.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        removeBook.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bookToolBar.add(removeBook);
        removeBook.addActionListener(this.removeBookListener);
        bookToolBar.add(separator1);

        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/search.png"))); // NOI18N
        searchButton.setFocusable(false);
        searchButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        searchButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bookToolBar.add(searchButton);
        searchButton.addActionListener(this.searchBookListener);

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

        statusBar.setText("Status:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 80;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(statusBar, gridBagConstraints);

        FileMenu.setText("File");

        openMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openMenuItem.setText("Open");
        FileMenu.add(openMenuItem);

        saveMenuItem.setText("Save");
        FileMenu.add(saveMenuItem);
        FileMenu.add(fileMenuSeparator);

        exitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        exitMenuItem.setText("Exit");
        FileMenu.add(exitMenuItem);

        topMenuBar.add(FileMenu);

        Edit.setText("Edit");

        addBookMenuItem.setText("AddBook");
        Edit.add(addBookMenuItem);
        addBookMenuItem.addActionListener(this.addnewBookListener);

        deleteBookMenuItem.setText("DeleteBook");
        Edit.add(deleteBookMenuItem);
        deleteBookMenuItem.addActionListener(this.removeBookListener);

        editBookMenuItem.setText("EditBook");
        Edit.add(editBookMenuItem);

        topMenuBar.add(Edit);

        Help.setText("Help");

        About.setText("About");
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
    private javax.swing.JProgressBar ProgressBar;
    private javax.swing.JMenuItem addBookMenuItem;
    private javax.swing.JButton addnewBookButton;
    private javax.swing.JToolBar bookToolBar;
    private javax.swing.JMenuItem deleteBookMenuItem;
    private javax.swing.JMenuItem editBookMenuItem;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JPopupMenu.Separator fileMenuSeparator;
    private javax.swing.JPanel mainPannel;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JButton removeBook;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JButton searchButton;
    private javax.swing.JToolBar.Separator separator;
    private javax.swing.JToolBar.Separator separator1;
    private javax.swing.JLabel statusBar;
    private javax.swing.JMenuBar topMenuBar;
    // End of variables declaration//GEN-END:variables

    @Override
    public void bookDialogFinished(operation anOperation) {
        if(anOperation == dialogClient.operation.UPDATE){
            
        }   
        else if(anOperation == dialogClient.operation.UPDATE){
            if(editedBook !=null) 
            {
             bookCollection.add(editedBook);
             JOptionPane.showMessageDialog(this, editedItem);
             setStatus("added new Book :" +editedBook.getBookName());
            }
        }
        else if(anOperation == dialogClient.operation.DELETE){
    
        }
        editedBook = null;
        
    }

    @Override
    public void pageDialogFinished(operation anOperation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dialogCancelled() {
       
    }
}
