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
import javax.swing.JFrame;
import carleton.edu.comp4905.honourproject.main.Book;
import carleton.edu.comp4905.honourproject.main.Page;

/**
 * this class represents the interface of program modeling functions
 *
 * @author Zhangda Yang
 */
public interface Controller {

    public static enum operation {

        ADD, UPDATE, DELETE
    };

    public static enum type {

        BOOK, PAGE
    };

    public Page getSelectedPage();

    public Book getSelectedBook();

    public void setSelectedBook(Book b);

    public void setSelectedPage(Page p);

    public void OpenBookListFrame();

    public void openPageListFrame(Book b);

    public void openPageViewer(Page p);

    public void closeFrame();

    public void openBookInfoDialog(JFrame parent, operation anOperation, Book b);

    public void closeBookInfoDialog(operation anOperation, Book b);

    public void openPageInfoDialog(JFrame parent, operation anOperation, Page p);

    public void closePageInfoDialog(operation anOperation, Page p);

    public void openAboutDialog(JFrame parent);

    public void exitProgram();

    public void dialogCancelled();

    public void openBookSearchDialog(JFrame parent);

    public void closeBookSearchDialog();

    public void OpenPageSearchDialog(JFrame parent);

    public void closePageSearchDialog();

    public String[] getbookCode();

    public void SaveDatabaseAs(File f);

    public boolean closeDatabase();

    public boolean openNewDataBase(File f);
}
