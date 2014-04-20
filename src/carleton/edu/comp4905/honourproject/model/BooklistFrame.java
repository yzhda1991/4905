/*
 * Carleton University - School of Computer Science Honours Project 
 * Winter 2014
 * PDF Book Organizer and page Viewer
 * AUTHOR: Zhangda Yang
 * SUPERVISOR: Professor Louis Nel
 * 
 */
package carleton.edu.comp4905.honourproject.model;

/**
 * this class is controlling view of book list frame.
 *
 * @author zhangda Yang
 */
import java.awt.event.MouseEvent;
import carleton.edu.comp4905.honourproject.main.Book;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import carleton.edu.comp4905.honourproject.viewer.BookListPanel;

public class BooklistFrame extends MenuFrame {

    // the complement of the class.
    private static BookListPanel mainPanel;
    private ActionListener seachButtonListener;
    private MouseListener doubleClickedonbook;
    private ListSelectionListener listSelection;
    private Connecter theConnecter;
    private Controller theController;
    private ArrayList<Book> bookCollection;

    // default constructor
    public BooklistFrame(String title, Modeling view, Controller c, Connecter conn) {
        super(title, c);
        theConnecter = conn;
        theController = c;
        initComponents();

    }
    // initialize complements

    private void initComponents() {
        mainPanel = new BookListPanel();

        bookCollection = theConnecter.getBookList();

        seachButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                searchBook();
            }
        };
        doubleClickedonbook = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    JList theList = (JList) e.getSource();
                    int index = theList.locationToIndex(e.getPoint());
                    Book selectedBook = (Book) theList.getModel().getElementAt(index);
                    if (selectedBook != null) {
                        doubleClickedBook(selectedBook);
                    }
                }
            }
        };
        listSelection = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                selectedBook();
            }
        };

        super.updateMainPanel(mainPanel);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        update();
    }

    // update selected book
    private void selectedBook() {
        theController.setSelectedBook((Book) mainPanel.getBookList().getSelectedValue());
        super.setStatus("selected book:" + theController.getSelectedBook());
        update();

    }
    // action performer for user double clicked on book title

    private void doubleClickedBook(Book b) {
        super.setStatus("opening book" + b.getBookName());
        if (theController != null) {
            theController.setSelectedBook(b);
            theController.openPageListFrame(b);
        }
    }

    // add listener to related components
    private void enableListener() {
        mainPanel.getSearchButton().addActionListener(seachButtonListener);
        mainPanel.getBookList().addMouseListener(doubleClickedonbook);
        mainPanel.getBookList().addListSelectionListener(listSelection);
    }
    // remove listener to related components

    private void disableListener() {
        mainPanel.getSearchButton().removeActionListener(seachButtonListener);
        mainPanel.getBookList().removeMouseListener(doubleClickedonbook);
        mainPanel.getBookList().removeListSelectionListener(listSelection);
    }
// search book

    private void searchBook() {

        super.setStatus("searching book :");
        String searchContent = mainPanel.getSearchField().getText().trim();
        String mode = (String) mainPanel.getSelectedType().getSelectedItem();
        ArrayList<Book> searchBook = new ArrayList<Book>();

        if (searchContent.equals("*") || searchContent.equals("%") || searchContent.equals("")) {
            searchBook = theConnecter.getBookList();
        } else if (mode.equals(BookListPanel.searchType.BookCode.toString())) {
            searchBook = theConnecter.searchBook(searchContent, "code");
        } else if (mode.equals(BookListPanel.searchType.BookTitle.toString())) {
            searchBook = theConnecter.searchBook(searchContent, "title");
        } else if (mode.equals(BookListPanel.searchType.BookAuthor.toString())) {
            searchBook = theConnecter.searchBook(searchContent, "author");
        }

        bookCollection = searchBook;

        System.out.println(bookCollection.size());

        update();
    }
    // update book list

    protected boolean setCollection(ArrayList<Book> newCollection) {
        bookCollection = newCollection;
        return false;
    }

    // update book list in the view
    private void updateList() {
        if (bookCollection != null && !bookCollection.isEmpty()) {
            Book bookArray[] = new Book[1];
            mainPanel.getBookList().setListData((Book[]) bookCollection.toArray(bookArray));
        } else {
            String[] empty = {};
            mainPanel.getBookList().setListData(empty);
        }
    }

    @Override
    public void update() {
        disableListener();
        updateList();
        enableListener();
        super.update();
    }
}