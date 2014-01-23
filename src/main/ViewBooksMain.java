/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import model.BooklistFrame;
import model.MainFrame;
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
    private MainFrame       mainFrame;
    
    public ViewBooksMain(){
       theConnecter = new Connecter();
       mainFrame = new MainFrame("Book viewer",this);
       selectedBook = null;
       editedBook = null;
       selectedPage = null;
       editedPage = null;
       
       
    }
    public void startProgram(){
        mainFrame.setVisible(true);
    }
    
    public Book getEditedBook() {
        return editedBook;
    }
    
    public Page getEditedPage() {
        return editedPage;
    }
    
    @Override
    public void setSelectedBook(Book b) {
        selectedBook = b;
    }

    @Override
    public void setSelectedPage(Page p) {
        throw new UnsupportedOperationException("Not supported yet.");
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
        if(pageListviewer!= null && pageListviewer.isVisible())pageListviewer.setVisible(false);
        if(pageviewer != null &&pageviewer.isVisible())pageviewer.setVisible(false);
        if(!bookListviewer.isVisible())bookListviewer.setVisible(true);
            }

    @Override
    public void closeBookListFrame() {
       
        bookListviewer.setVisible(false);
        if(mainFrame.isVisible())mainFrame.setVisible(true);
    }

    @Override
    public void openPageListFrame(Book b) {
      
      if(pageListviewer == null)pageListviewer = new PageListFrame("view page list",this,this,theConnecter,b);
      if(bookListviewer!=null && bookListviewer.isVisible()) bookListviewer.setVisible(false);
      if(pageviewer !=null && pageviewer.isVisible()) pageviewer.setVisible(false);
      if(!pageListviewer.isVisible()) pageListviewer.setVisible(true);
        
    }

    @Override
    public void closePageListFrame() {
        pageListviewer.setVisible(false);
        if(mainFrame.isVisible())mainFrame.setVisible(true);
    }

    @Override
    public void openPageViewer(Page p) {
        
        if(pageviewer == null)pageviewer = new PageViewerFrame("view page",this,this,theConnecter,p);
        if(pageListviewer !=null && pageListviewer.isVisible()) pageListviewer.setVisible(false);
        if(bookListviewer !=null && bookListviewer.isVisible()) bookListviewer.setVisible(false);
        if(!pageviewer.isVisible())pageviewer.setVisible(true);
   
    }

    @Override
    public void closePageViewer() {
        pageviewer.setVisible(false);
        if(mainFrame.isVisible())mainFrame.setVisible(true);
    }
    
    @Override
    public void openBookInfoDialog(Book b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void closeBookInfoDialog(operation anOperation) {
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

    @Override
    public void openPageInfoDialog(Page p) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
   public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        ViewBooksMain main = new ViewBooksMain();
        main.startProgram();

        
   
    }

    
}
