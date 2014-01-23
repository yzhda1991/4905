/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import model.BooklistFrame;
import model.PageListFrame;
import model.PageViewerFrame;

/**
 *
 * @author brianyang
 */
public class ViewBooksMain implements Controller {
    protected Connecter theConnecter;
    private Book      selectedBook;
    private Book      editedBook;
    private Page      selectedPage;
    private Page      editedPage;
    
    private BooklistFrame   bookListviewer;
    private PageListFrame   pageListviewer;
    private PageViewerFrame pageviewer;
    
    public ViewBooksMain(){
       theConnecter = new Connecter();
       selectedBook = null;
       editedBook = null;
       selectedPage = null;
       editedPage = null;
       
    }
    
    
    
    public Book getEditedBook() {
        return editedBook;
    }
    
    public Page getEditedPage() {
        return editedPage;
    }

    @Override
    public Page getSelectedPage() {
        return selectedPage;
    }

    @Override
    public Book getSelectedBook() {
         return selectedBook;    
    }

    @Override
    public void OpenBookListFrame() {
        if(bookListviewer == null) bookListviewer = new BooklistFrame("view book list",this,this,theConnecter);
        bookListviewer.setVisible(true);
            }

    @Override
    public void closeBookListFrame() {
       
        bookListviewer.setVisible(false);
    }

    @Override
    public void openPageListFrame(Book b) {
      if(pageListviewer == null)pageListviewer = new PageListFrame("view page list",this,this,theConnecter,b);
      pageListviewer.setVisible(true);
    }

    @Override
    public void closePageListFrame() {
        pageListviewer.setVisible(false);
    }

    @Override
    public void openPageViewer(Page p) {
        if(pageviewer == null)pageviewer = new PageViewerFrame("view page",this,this,theConnecter,p);
        pageviewer.setVisible(true);
    }

    @Override
    public void closePageViewer(Page p) {
        pageviewer.setVisible(false);}

    @Override
    public void openBookInfoDialog(Book b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void closeBookInfoDialog(operation anOperation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void openPageInfoDialog() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void closePageInfoDialog(operation anOperation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitProgram() {
        theConnecter.closeConnection();
        System.exit(0);
    }

    @Override
    public void dialogCancelled() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
  
   
}
