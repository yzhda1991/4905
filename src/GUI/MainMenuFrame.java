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
import java.sql.ResultSet;
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
    private static PageInfoDialog  thePageInfoDialog;
    
    private static ActionListener  addnewBookListener;
    private static ActionListener  editBookListener;
    private static ActionListener  removeBookListener;
    
    private static ActionListener  addnewPageListener;
    private static ActionListener  editPageListener;
    private static ActionListener  removePageListener;
    
    private static ActionListener  viewBookListener;
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
    
    private static Connection      databaseConnection;
    private static Statement       stat;
    
    private static boolean         listenerSwitch;
    
  
     
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
        listenerSwitch = false;
      
        initListener();
        initComponents();
        enableListener();
        updateButton();
       
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
        
        addnewPageListener =new ActionListener(){
          
            @Override
            public void actionPerformed(ActionEvent e) {
                setStatus("add new page option cilcked");
                
                addNewPage();
               
            }
        };
        editPageListener =new ActionListener(){
          
            @Override
            public void actionPerformed(ActionEvent e) {
                setStatus("edit Page option cilcked");
               
                if(selectedPage ==null)
                    
                    setStatus("page not selected!");
                
                else{
                    
                    editedPage = selectedPage;
                    editPage();
                }

            }
        };
        removePageListener =new ActionListener(){
          
            @Override
            public void actionPerformed(ActionEvent e) {
                setStatus("remove page option cilcked");
                
                if(selectedPage ==null)
                    setStatus("page not selected!");
                
                else{
                    
                    editedPage = selectedPage;
                    removePage();
                }

            }
        };
        //Listener: clicked seach book in tool bar
        viewBookListener =new ActionListener(){
          
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
                   viewPageList(editedBook);
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
        addBookMenuItem.removeActionListener(addnewBookListener);
        deleteBookMenuItem.removeActionListener(removeBookListener);
        editBookMenuItem.removeActionListener(editBookListener);
        removeBook.removeActionListener(MainMenuFrame.removeBookListener);
        ViewBookButton.removeActionListener(MainMenuFrame.viewBookListener);

        
        
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
        booklistPanel.setBookList(bookCollection, selectedBook);
        booklistPanel.update();
        initMainPanel(booklistPanel);
        
    } 
    
    //Action performs for viewing page list: display pagelist from t book;
    private void viewPageList(Book b){
        
        disableListsener();
        
        String searchBookTitle = b.getBookCode().trim();
        String sqlQueryString = "select * from pagelist where bookcode like '%"+searchBookTitle +"%' order by title asc"+";";
        System.out.println("");
        System.out.println(sqlQueryString);
            
        try{
            ResultSet rs = stat.executeQuery(sqlQueryString);
            ArrayList<Page> pageSearchResults = new ArrayList<Page>();
            int count = 0;
            int GUI_DISPLAY_LIMIT =100;
            while(rs.next() && count<GUI_DISPLAY_LIMIT){
                Page thePage = new Page(rs.getInt("id"),rs.getString("title"),rs.getString("bookcode"),rs.getInt("page"));
                pageSearchResults.add(thePage);
                count++;
            }
            rs.close();
            //Page PageArray[] = new Page[1];
            pageCollection = pageSearchResults;
            if(pagelistPanel ==null){
            pagelistPanel = new PageListPannel(doubleClickPageTitleListener,doubleClickBooktitleListener,bookCollection,pageCollection);;
        }
            else{
                pagelistPanel.setBookList(bookCollection,selectedBook);
                pagelistPanel.setPageList(pageCollection);
            }
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            }
        
        pagelistPanel.update();
        initMainPanel(pagelistPanel);
       
    }
   
    //Action performs for viewing page;  
    private void viewPage(Page p){
      
        disableListsener();
        
        String path = "src/Resources/test.pdf";
        
        Book temp = null;
        for(Book b:bookCollection){
            if(b.getBookCode() == null ? p.getBookCode() == null : b.getBookCode().equals(p.getBookCode())){
                temp=b;
            break;
            }
        }
        if(temp !=null) path = temp.getBookPath();
        if(pageViewerPanel ==null){
            pageViewerPanel = new PageViewer(doubleClickPageTitleListener,keyListstener,pageCollection);
        }
        
        pageViewerPanel.setTittle(p.getPageTitle());
        pageViewerPanel.setPageList(pageCollection,p); 
        pageViewerPanel.update();
        initMainPanel(pageViewerPanel);
        pageViewerPanel.getController().openDocument(path);
        pageViewerPanel.getController().showPage((temp.getInitPage()-1)+(p.getPageNum()-1));
        
    }
    
    //Action performs for About in Menu
    private void aboutProgram(){
        disableListsener();
        
        if(aboutDetailDialog ==null){
            aboutDetailDialog = new aboutDialog(this,this,"about me",true);
            aboutDetailDialog.setVisible(true);
        }
    }
    
    //action performs for add new book;
    private void addNewBook(){
        disableListsener();
        
        editedBook = new Book();
        theBookInfoDialog = new BookInfoDialog(this,this,"add new Book",editedBook,dialogClient.operation.ADD,true);
        theBookInfoDialog.setVisible(true);
        
    }
    
    //action performs for editing book;
    private void editBook(){
        if(editedBook == null){
            
        }
        else{
        theBookInfoDialog = new BookInfoDialog(this,this,"edited Book Info: "+editedBook.getBookName(),editedBook,dialogClient.operation.UPDATE,true);
        
        theBookInfoDialog.setVisible(true);
        }
    }
   
    //action performs for remove book;
    private void removeBook(){
       theBookInfoDialog = new BookInfoDialog(this,this,"Delete Book Info: "+editedBook.getBookName(),editedBook,dialogClient.operation.DELETE,true);
        
       theBookInfoDialog.setVisible(true);
    }
    
    //action performs for add new page; 
    private void addNewPage(){
        
        disableListsener();
        
        editedPage = new Page();
        thePageInfoDialog = new PageInfoDialog(this,"add new Page",this,editedPage,dialogClient.operation.ADD,true);
        thePageInfoDialog.setVisible(true);
    }
    
    //action performs for edit page;
    private void editPage(){
        if(editedPage == null){
            
        }
        else{
            
            thePageInfoDialog = new PageInfoDialog(this,"edited Page Info:"+editedPage.getPageTitle(),this,editedPage,dialogClient.operation.UPDATE,true);
            thePageInfoDialog.setVisible(true);
        }
    }
    
    private void removePage(){
        if(editedPage == null){
            
        }
        
        else{
            
        theBookInfoDialog = new BookInfoDialog(this,this,"Delete Book Info: "+editedPage.getPageTitle(),editedBook,dialogClient.operation.DELETE,true);
        theBookInfoDialog.setVisible(true);
        }
        
    }
    private void updateList(){
        
   
         Component temp = mainPannel.getComponent(0);
         if(temp.equals(booklistPanel)) {
           //booklistPanel.update();
             if(selectedBook != null)
                 booklistPanel.getBookList().setSelectedValue(selectedBook, true);
         }
         else if (temp.equals(pagelistPanel)) {
          //   pagelistPanel.update();
             if(selectedBook != null)
                 pagelistPanel.getBookList().setSelectedValue(selectedBook, true);
         } 
         
         
    }
    
    private void updateButton(){
       
        if(selectedBook != null){
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
        if(selectedPage !=null){
            editPageMenuItem.setEnabled(true);
            deletePageMenuItem.setEnabled(true);
        } else{
            editPageMenuItem.setEnabled(false);
            deletePageMenuItem.setEnabled(false);
        }
    
        
    }
    private void update(){
        if(listenerSwitch) disableListsener();
        updateList();
        enableListener(); 
        updateButton();
        
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
    public boolean updateChange(String sql){
        try{ 
            int update =stat.executeUpdate(sql); 
            if(update ==1){ 
               setStatus(" successful Update:"); 
                return true;
                } 
             else{ 
                setStatus("not UPDATE successfully"); 
                return false;
               } 
        }catch(SQLException s){ 
            s.printStackTrace();
            return false;
        }
    }
    
    @Override
    public void pageDialogFinished(operation anOperation) {
        
        if(anOperation == dialogClient.operation.UPDATE){
                boolean updated = false;
             
              String bookcodeUpdate = "UPDATE PAGELIST SET BOOK CODE ='"+editedPage.getBookCode()+"' WHERE ID ="+editedPage.getPageID() +";";
              String pageNumUpdate  = "UPDATE PAGELIST SET PAGE ='"+editedPage.getPageNum()+"' WHERE ID ="+editedPage.getPageID() +";";
              String titleUpdate    = "UPDATE PAGELIST SET TITLE ='"+editedPage.getPageTitle()+"' WHERE ID ="+editedPage.getPageID() +";";
     
              Page temp = pageCollection.get(editedPage.getPageID());
              
              if(!temp.getBookCode().equals(editedPage.getBookCode())){ 
                    updateChange(bookcodeUpdate); 
                }
              
              if(temp.getPageNum() != editedPage.getPageNum()){ 
                    updateChange(pageNumUpdate); 
                }
              
              if(!temp.getPageTitle().equals(editedPage.getPageTitle())){ 
                    updateChange(titleUpdate); 
                }
              
            if(updated)setStatus("update Page :" +editedPage.getPageTitle());
            else setStatus("update failed");
            
        }   
        
        else if(anOperation == dialogClient.operation.ADD){
            
            if(editedPage !=null) 
            {
                try{
                   
                    pageCollection.add(editedPage);
                    setStatus("added new Book :" +editedPage.getPageTitle());
                }
                
                catch(java.lang.ArrayIndexOutOfBoundsException e){
                    setStatus(e.getMessage());
                }
            }
             else setStatus("no Page info Founds ");
        }
        
        else if(anOperation == dialogClient.operation.DELETE){
            if(editedPage !=null){
                pageCollection.remove(editedPage);
                selectedPage =null;
            }
            else setStatus(" ");
        }
        
        selectedPage = null;
        editedPage = null;
        
        update();
    }

    @Override
    public void dialogCancelled() { 
       setStatus("Canceled");
       update();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        bookToolBar.setForeground(new java.awt.Color(240, 240, 240));
        bookToolBar.setRollover(true);

        addnewBookButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        addnewBookButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/add.png"))); // NOI18N
        addnewBookButton.setToolTipText("Add New Book");
        addnewBookButton.setFocusable(false);
        addnewBookButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addnewBookButton.setMargin(new java.awt.Insets(3, 5, 3, 3));
        addnewBookButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bookToolBar.add(addnewBookButton);

        removeBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/remove.png"))); // NOI18N
        removeBook.setFocusable(false);
        removeBook.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        removeBook.setMargin(new java.awt.Insets(3, 5, 3, 3));
        removeBook.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bookToolBar.add(removeBook);

        ViewBookButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/search.png"))); // NOI18N
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
        gridBagConstraints.gridy = 2;
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
        Edit.setFont(new java.awt.Font("Agency FB", 0, 16)); // NOI18N
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
        Pages.setFont(new java.awt.Font("Agency FB", 0, 16)); // NOI18N
        Pages.setMargin(new java.awt.Insets(3, 3, 3, 3));

        addPageMenuItem.setFont(new java.awt.Font("Agency FB", 0, 16));
        addPageMenuItem.setText("Add Page");
        addPageMenuItem.setMargin(new java.awt.Insets(2, 2, 2, 2));
        Pages.add(addPageMenuItem);

        editPageMenuItem.setFont(new java.awt.Font("Agency FB", 0, 16)); // NOI18N
        editPageMenuItem.setText("Edit Page");
        editPageMenuItem.setMargin(new java.awt.Insets(2, 2, 2, 2));
        Pages.add(editPageMenuItem);

        deletePageMenuItem.setFont(new java.awt.Font("Agency FB", 0, 16)); // NOI18N
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
