/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

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
    public void openBookInfoDialog(Book b);
    public void closeBookInfoDialog(operation anOperation);
    /**
     *
     * @param anOperation
     */
    public void openPageInfoDialog (Page p);
    public void closePageInfoDialog(operation anOperation);
    
    /**
     *
     */
    public void exitProgram();
    public void dialogCancelled();
    
    
}
