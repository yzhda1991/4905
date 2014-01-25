/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import javax.swing.JFrame;
import main.Book;
import main.Page;

/**
 *
 * @author byang1
 */
public interface Controller {
 
    /**
     *
     */
    public static enum operation {ADD,UPDATE, DELETE};
    public static enum type      {BOOK,PAGE};

    /**
     *
     * @return
     */
    public Page getSelectedPage();
    /**
     *
     * @return
     */
    public Book getSelectedBook();
    /**
     *
     */
    
    public void setSelectedBook(Book b);
    public void setSelectedPage(Page p);
    public void OpenBookListFrame();
   
    /**
     *
     * @param b
     */
    public void openPageListFrame(Book b);
    /**
     *
     * @param p
     */
    public void openPageViewer(Page p);
    
     public void closeFrame();
    /**
     *
     * @param anOperation
     */
    public void openBookInfoDialog(JFrame parent,operation anOperation,Book b);
    public void closeBookInfoDialog(operation anOperation,Book b);
    /**
     *
     * @param anOperation
     */
    public void openPageInfoDialog (JFrame parent,operation anOperation,Page p);
    public void closePageInfoDialog(operation anOperation,Page p);
    
    /**
     *
     */
    public void openAboutDialog(JFrame parent);
    public void exitProgram();
    public void dialogCancelled();
    
    public void openBookSearchDialog(JFrame parent);
    public void closeBookSearchDialog();
    
    public void OpenPageSearchDialog(JFrame parent);
    public void closePageSearchDialog();
    
    public void SaveDatabaseAs(File f);
    public boolean closeDatabase();
    public boolean openNewDataBase(File f);
    
    
}