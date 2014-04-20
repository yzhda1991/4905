/*
 * Carleton University - School of Computer Science Honours Project 
 * Winter 2014
 * PDF Book Organizer and page Viewer
 * AUTHOR: Zhangda Yang
 * SUPERVISOR: Professor Louis Nel
 * 
 */
package carleton.edu.comp4905.honourproject.model;

import carleton.edu.comp4905.honourproject.main.Book;
import carleton.edu.comp4905.honourproject.main.Page;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import carleton.edu.comp4905.honourproject.viewer.PageListPanel;

/**
 * this class represents view of page list frame
 *
 * @author zhangda Yang
 */
public class PageListFrame extends MenuFrame {

    PageListPanel mainPanel;
    private ActionListener seachButtonListener;
    private MouseListener doubleClickedonBook;
    private MouseListener doubleClickedonPage;
    private ListSelectionListener pagelistSelection;
    private ListSelectionListener booklistSelection;
    Connecter theConnecter;
    Controller theController;
    ArrayList<Book> bookCollection;
    ArrayList<Page> pageCollection;
    Book editedBook;

    // constructor
    public PageListFrame() {

        super("Page List");
        theConnecter = new Connecter();
        initComponents();
    }

    // constructor
    public PageListFrame(String title, Modeling viewer, Controller c, Connecter conn, Book initBook) {

        super(title, c);
        theConnecter = conn;
        theController = c;
        editedBook = initBook;
        initComponents();
    }
    // update book collection list

    protected void setBookCollection(ArrayList<Book> b) {

        bookCollection = b;
    }
    // update page list collection

    protected void setPageCollection(ArrayList<Page> p) {

        pageCollection = p;
    }
    // initialize components

    private void initComponents() {


        mainPanel = new PageListPanel();
        bookCollection = theConnecter.getBookList();
        pageCollection = new ArrayList<Page>();
        if (editedBook != null) {
            pageCollection = theConnecter.searchPage(editedBook.getBookCode(), "bookcode");
        }

        seachButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                searchPage();
            }
        };

        pagelistSelection = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                changeselectedPage((Page) mainPanel.getPageList().getSelectedValue());

            }
        };

        booklistSelection = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                changeselectedBook((Book) mainPanel.getBookList().getSelectedValue());

            }
        };

        doubleClickedonBook = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    JList theList = (JList) e.getSource();
                    int index = theList.locationToIndex(e.getPoint());
                    Book findBook = (Book) theList.getModel().getElementAt(index);
                    if (findBook != null) {
                        searchPage(findBook);
                    }
                }
            }
        };

        doubleClickedonPage = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    JList theList = (JList) e.getSource();
                    int index = theList.locationToIndex(e.getPoint());
                    Page findPage = (Page) theList.getModel().getElementAt(index);
                    if (findPage != null) {
                        if (theController != null) {
                            theController.openPageViewer(findPage);
                        }
                    }
                }
            }
        };

        super.updateMainPanel(mainPanel);
        //this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        update();
    }
    //update selected page

    private void changeselectedPage(Page p) {
        if (p != null) {
            theController.setSelectedPage(p);
            super.setStatus("selected Page: " + p.getPageTitle());
            update();
        }
    }
    //update selected book

    private void changeselectedBook(Book b) {
        if (b != null) {
            theController.setSelectedBook(b);
            super.setStatus("selected Book: " + b.getBookName());
            update();
        }
    }
    // update page list with search reuslt

    private void searchPage() {
        super.setStatus("searching page ....");
        String searchContent = mainPanel.getSearchField().getText().trim();
        String mode = (String) mainPanel.getTypeBox().getSelectedItem();
        ArrayList<Page> searchPage = new ArrayList<Page>();

        if (searchContent.equals("*") || searchContent.equals("%") || searchContent.equals("")) {
            searchPage = theConnecter.getPageList();
        } else if (mode.equals("Page ID")) {
            searchPage = theConnecter.searchPage(searchContent, "id");
        } else if (mode.equals("Book Code")) {
            searchPage = theConnecter.searchPage(searchContent, "bookcode");
        } else if (mode.equals("Page Title")) {
            searchPage = theConnecter.searchPage(searchContent, "title");
        }

        pageCollection = searchPage;
        update();
    }
    // method for search page with book

    private void searchPage(Book b) {
        ArrayList<Page> searchPage = new ArrayList<Page>();
        searchPage = theConnecter.searchPage(b.getBookCode(), "bookcode");

        pageCollection = searchPage;
        update();
    }
    // add listener to components

    private void enableListener() {

        mainPanel.getSearchButton().addActionListener(seachButtonListener);
        mainPanel.getBookList().addMouseListener(doubleClickedonBook);
        mainPanel.getPageList().addMouseListener(doubleClickedonPage);
        mainPanel.getBookList().addListSelectionListener(booklistSelection);
        mainPanel.getPageList().addListSelectionListener(pagelistSelection);

    }
    // remove listener to components

    private void disableListener() {

        mainPanel.getSearchButton().removeActionListener(seachButtonListener);
        mainPanel.getBookList().removeMouseListener(doubleClickedonBook);
        mainPanel.getPageList().removeMouseListener(doubleClickedonPage);
        mainPanel.getBookList().removeListSelectionListener(booklistSelection);
        mainPanel.getPageList().removeListSelectionListener(pagelistSelection);
    }
    // update view's collection

    private void updateList() {
        if (bookCollection != null && !bookCollection.isEmpty()) {
            Book bookArray[] = new Book[1];
            mainPanel.getBookList().setListData((Book[]) bookCollection.toArray(bookArray));
        } else {
            String[] empty = {};
            mainPanel.getBookList().setListData(empty);
        }
        if (pageCollection != null && !pageCollection.isEmpty()) {
            Page pageArray[] = new Page[1];
            mainPanel.getPageList().setListData(pageCollection.toArray(pageArray));
        } else {
            String[] empty = {};
            mainPanel.getPageList().setListData(empty);
        }

    }
    // update page list and edited book

    protected void updateinfo(Book b) {

        editedBook = b;

        if (b == null) {
            pageCollection = new ArrayList<Page>();
        } else {
            pageCollection = theConnecter.searchPage(editedBook.getBookCode(), "bookcode");

        }
        update();
    }

    @Override
    public void update() {
        disableListener();
        updateList();
        enableListener();
        super.update();


    }
//    public static void main(String args[]) {
//
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(PageListFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(PageListFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(PageListFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(PageListFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new PageListFrame().setVisible(true);
//            }
//        });
//    }
}
