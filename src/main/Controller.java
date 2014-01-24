/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javax.swing.JFrame;

/**
 *
 * @author byang1
 */
public interface Controller {
 
    /**
     *
     */
    public static enum operation {ADD,UPDATE, DELETE};

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
    public void closeBookListFrame();
    /**
     *
     * @param b
     */
    public void openPageListFrame(Book b);
    public void closePageListFrame();
    /**
     *
     * @param p
     */
    public void openPageViewer(Page p);
    public void closePageViewer();
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
    
    
}
