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
 
    public static enum operation {ADD,UPDATE, DELETE};

    public void openBookList();
    public void openPageList(Book b);
    public void openPage(Page p);
    public void bookDialogFinished(operation anOperation);
    public void pageDialogFinished (operation anOperation);
    public void exitProgram();
    
    
}
