/*
 * Carleton University - School of Computer Science Honours Project 
 * Winter 2014
 * PDF Book Organizer and page Viewer
 * AUTHOR: Zhangda Yang
 * SUPERVISOR: Professor Louis Nel
 * 
 */
package carleton.edu.comp4905.honourproject.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import carleton.edu.comp4905.honourproject.main.Book;
import carleton.edu.comp4905.honourproject.main.Page;

/**
 * this class represents the major control of the application logic modeling.
 *
 * @author Zhangda Yang
 */
public class Modeling implements Controller {

    protected Connecter theConnecter;
    private Book selectedBook;
    private final Book editedBook;
    private Page selectedPage;
    private final Page editedPage;
    private BooklistFrame bookListviewer;
    private PageListFrame pageListviewer;
    private PageViewerFrame pageviewer;
    private final MainFrame mainFrame;
    private BookInfoDialog bookDialog;
    private PageInfoDialog pageDialog;
    private AboutDialog theaboutDialog;
    private SearchBookDialog theBookSearchDialog;
    private SearchPageDialog thePageSearchDialog;

    // constructor
    public Modeling() {

        theConnecter = new Connecter();
        mainFrame = new MainFrame("Book viewer", this);
        selectedBook = null;
        editedBook = null;
        selectedPage = null;
        editedPage = null;

    }

    public void initFrame() {
    }
    // start application

    public void startProgram() {
        update();
        mainFrame.setVisible(true);
    }
    // return edited book

    public Book getEditedBook() {
        return editedBook;
    }
    // return edited page

    public Page getEditedPage() {
        return editedPage;
    }
    // update selected book collection

    @Override
    public void setSelectedBook(Book b) {
        if (b == null) {
            return;
        }
        if (b.getClass().equals(Book.class)) {
            selectedBook = b;
        }

        update();
    }
    // update selected book page

    @Override
    public void setSelectedPage(Page p) {
        if (p == null) {
            return;
        }
        if (p.getClass().equals(Page.class)) {
            selectedPage = p;
        }

    }
    // return selected page

    @Override
    public Page getSelectedPage() {
        return selectedPage;
    }
    // return selected book

    @Override
    public Book getSelectedBook() {
        return selectedBook;
    }
    // method for display book list view

    @Override
    public void OpenBookListFrame() {

        if (bookListviewer == null) {
            bookListviewer = new BooklistFrame("view book list", this, this, theConnecter);
        } else {
            bookListviewer.update();
        }

        if (!bookListviewer.isVisible()) {
            bookListviewer.setVisible(true);
        }

        if (pageListviewer != null && pageListviewer.isVisible()) {
            pageListviewer.setVisible(false);
            pageListviewer.dispose();
        }

        if (pageviewer != null && pageviewer.isVisible()) {
            pageviewer.setVisible(false);
            pageListviewer.dispose();
        }
    }
    // method for closing all the application screen

    @Override
    public void closeFrame() {

        if (mainFrame.isVisible()) {
            mainFrame.setVisible(true);
        }
        if (pageListviewer != null && pageListviewer.isVisible()) {
            pageListviewer.setVisible(false);
            pageListviewer.dispose();
        }
        if (bookListviewer != null && bookListviewer.isVisible()) {
            bookListviewer.setVisible(false);
            bookListviewer.dispose();
        }
        if (pageviewer != null && pageviewer.isVisible()) {
            pageviewer.setVisible(false);
            pageviewer.dispose();
        }
    }
    // method for open page list view

    @Override
    public void openPageListFrame(Book b) {

        if (pageListviewer == null) {
            pageListviewer = new PageListFrame("view page list", this, this, theConnecter, b);
        } else {
            pageListviewer.updateinfo(b);
        }

        if (!pageListviewer.isVisible()) {
            pageListviewer.setVisible(true);
        }
        if (bookListviewer != null && bookListviewer.isVisible()) {
            bookListviewer.setVisible(false);
            bookListviewer.dispose();
        }
        if (pageviewer != null && pageviewer.isVisible()) {
            pageviewer.setVisible(false);
            pageviewer.dispose();
        }

    }
    // method for open page content view

    @Override
    public void openPageViewer(Page p) {

        if (pageviewer == null) {
            pageviewer = new PageViewerFrame("view page", this, this, theConnecter, p);
        } else {
            try {
                pageviewer.updateInfo(p);
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(pageviewer, " System can not found book file path for book: " + p.getBookCode());
                return;
            }
        }

        if (pageviewer != null) {
            if (!pageviewer.isVisible()) {
                pageviewer.setVisible(true);
            }
            pageviewer.toFront();
        }

    }
    // method for open book info dialog

    @Override
    public void openBookInfoDialog(JFrame parent, operation anOperation, Book b) {
        if (bookDialog == null) {
            String title = "";
            if (b == null) {
                title = anOperation.toString() + " New Book";
            } else {
                title = anOperation.toString() + " Book: " + b.getBookName();
            }
            bookDialog = new BookInfoDialog(title, parent, this, b, anOperation, true);
        } else {
            bookDialog.updateInfo(b, anOperation);
        }

        if (!bookDialog.isVisible()) {
            bookDialog.setVisible(true);
        }
        update();
    }
    // method for open page info dialog 

    @Override
    public void openPageInfoDialog(JFrame parent, operation anOperation, Page p) {
        if (pageDialog == null) {
            String title = "";
            if (p == null) {
                title = " New Page";
            } else {
                title = anOperation.toString() + " Page: " + p.getPageTitle();
            }
            pageDialog = new PageInfoDialog(parent, title, this, p, anOperation, true);
        } else {
            pageDialog.updateInfo(p, anOperation);
        }

        if (!pageDialog.isVisible()) {
            pageDialog.setVisible(true);
        }

    }
    // method for close book info dialog and update book info in database

    @Override
    public void closeBookInfoDialog(operation anOperation, Book b) {
        if (anOperation == null || b == null) {
            if (bookDialog != null && bookDialog.isVisible()) {

                bookDialog.setVisible(false);
                bookDialog.dispose();
            }

            bookDialog = null;
            return;
        }

        boolean successed = false;

        if (anOperation.equals(operation.ADD)) {
            successed = theConnecter.addBook(b);
        } else if (anOperation.equals(operation.UPDATE)) {
            successed = theConnecter.updateBook(b);
        } else if (anOperation.equals(operation.DELETE)) {
            successed = theConnecter.deleteBook(b);
            setSelectedBook(null);
        }

        if (successed) {

            if (bookListviewer != null) {
                bookListviewer.setCollection(theConnecter.getBookList());

            }
            if (pageListviewer != null) {
                pageListviewer.setBookCollection(theConnecter.getBookList());
            }
        } else {
            System.out.println("failed");
        }

        if (bookDialog != null && bookDialog.isVisible()) {

            bookDialog.setVisible(false);
            bookDialog.dispose();
        }
        bookDialog = null;
        update();
    }
    // method for close page info dialog and update page info in database

    @Override
    public void closePageInfoDialog(operation anOperation, Page p) {
        if (anOperation == null || p == null) {
            if (pageDialog != null && pageDialog.isVisible()) {

                pageDialog.setVisible(false);
                pageDialog.dispose();
            }
            pageDialog = null;
            return;
        }
        boolean successed = false;
        if (anOperation.equals(operation.ADD)) {
            successed = theConnecter.addPage(p);
        } else if (anOperation.equals(operation.UPDATE)) {
            successed = theConnecter.updatePage(p);
        } else if (anOperation.equals(operation.DELETE)) {
            successed = theConnecter.deletePage(p);
        }

        if (successed) {
            if (pageListviewer != null) {
                pageListviewer.setPageCollection(theConnecter.getPageList());
                pageviewer.setPageCollection(theConnecter.searchPage(selectedPage.getBookCode(), "bookcode"));
            }

        } else {
            System.out.println("failed");
        }

        if (pageDialog != null && pageDialog.isVisible()) {

            pageDialog.setVisible(false);
            pageDialog.dispose();

        }
        update();
        pageDialog = null;
    }
    // method for display about dialog

    @Override
    public void openAboutDialog(JFrame parent) {
        if (theaboutDialog == null) {
            theaboutDialog = new AboutDialog(parent, "about this program", true);
        }
        theaboutDialog.setVisible(true);
    }
    // method for exiting program

    @Override
    public void exitProgram() {
        theConnecter.closeConnection();
        System.exit(0);
    }
    // method for closing dialog with click cancel button

    @Override
    public void dialogCancelled() {
    }
    // method for displaying book search dialog

    @Override
    public void openBookSearchDialog(JFrame parent) {
        if (theBookSearchDialog == null) {
            theBookSearchDialog = new SearchBookDialog(parent, "Search Books", theConnecter, this, true);
        }
        if (pageListviewer != null && pageListviewer.isVisible()) {
            pageListviewer.setVisible(false);
        }
        if (bookListviewer != null && bookListviewer.isVisible()) {
            bookListviewer.setVisible(false);
        }
        if (pageviewer != null && pageviewer.isVisible()) {
            pageviewer.setVisible(false);
        }

        if (!theBookSearchDialog.isVisible()) {
            theBookSearchDialog.setVisible(true);
        }

    }
    // method for close book search dialog

    @Override
    public void closeBookSearchDialog() {

        if (theBookSearchDialog != null && theBookSearchDialog.isVisible()) {
            theBookSearchDialog.setVisible(false);
            theBookSearchDialog.dispose();
        }
        update();
        if (!mainFrame.isVisible()) {
            mainFrame.setVisible(true);
        }

    }
    // method for open page search dialog

    @Override
    public void OpenPageSearchDialog(JFrame parent) {
        if (thePageSearchDialog == null) {
            thePageSearchDialog = new SearchPageDialog(parent, "Search Page", theConnecter, this, true);
        }

        if (pageListviewer != null && pageListviewer.isVisible()) {
            pageListviewer.setVisible(false);
        }
        if (bookListviewer != null && bookListviewer.isVisible()) {
            bookListviewer.setVisible(false);
        }
        if (pageviewer != null && pageviewer.isVisible()) {
            pageviewer.setVisible(false);
        }

        if (!thePageSearchDialog.isVisible()) {
            thePageSearchDialog.setVisible(true);
        }
    }
    // method for close page search dialog  

    @Override
    public void closePageSearchDialog() {

        if (theBookSearchDialog != null && theBookSearchDialog.isVisible()) {
            theBookSearchDialog.setVisible(false);
            theBookSearchDialog.dispose();
        }
        if (!mainFrame.isVisible()) {
            mainFrame.setVisible(true);
        }
    }
    // method for save database info as XML file

    @Override
    public void SaveDatabaseAs(File f) {

        theConnecter.saveDatabase(f);
    }
    // method for closing database

    @Override
    public boolean closeDatabase() {
        closeFrame();
        boolean result = theConnecter.closeConnection();
        update();

        return result;

    }
    // method for change database file

    @Override
    public boolean openNewDataBase(File f) {
        closeFrame();
        boolean result = theConnecter.changeDatabase(f);
        update();
        return result;

    }
    // update method    

    public void update() {
        if (mainFrame != null) {
            mainFrame.update(theConnecter.isDatabaseActive());
        }
        if (theConnecter.isDatabaseActive()) {
            if (pageListviewer != null) {
                pageListviewer.update();
            }
            if (bookListviewer != null) {
                bookListviewer.update();
            }
            if (pageviewer != null) {
                pageviewer.update();
            }
        }
    }
    // method for return all book code in database

    @Override
    public String[] getbookCode() {
        ArrayList<Book> result = theConnecter.getBookList();
        String[] bookCodeString = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            bookCodeString[i] = result.get(i).getBookCode();
        }
        return bookCodeString;
    }
}
