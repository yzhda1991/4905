/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javax.swing.JFrame;
import model.BookInfoDialog;
import model.BooklistFrame;
import model.MainFrame;
import model.PageInfoDialog;
import model.PageListFrame;
import model.PageViewerFrame;
import model.AboutDialog;

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
    private BookInfoDialog  bookDialog;
    private PageInfoDialog  pageDialog;
    private AboutDialog     theaboutDialog;
    
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
        if(b==null) return;
        if(b.getClass().equals(Book.class)) {
            selectedBook = b;
        } else {
        }
    }

    @Override
    public void setSelectedPage(Page p) {
        if(p == null) return;
        if(p.getClass().equals(Page.class) )
        selectedPage = p;
        
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
    public void openBookInfoDialog(JFrame parent,operation anOperation,Book b) {
        //To change body of generated methods, choose Tools | Templates.
        if(bookDialog ==null) {
            String title = null;
            if(b == null ) title = " New Book";
            else title = anOperation.toString() +" Book: "+b.getBookName();
            bookDialog = new BookInfoDialog(title,parent,this,b,anOperation,true);
        }
        if(!bookDialog.isVisible())bookDialog.setVisible(true);
    }
     @Override
    public void openPageInfoDialog(JFrame parent,operation anOperation, Page p) {
        if(pageDialog ==null) {
            String title = null;
            if(p == null ) title = " New Page";
            else title = anOperation.toString() +" Page: "+p.getPageTitle();
            pageDialog = new PageInfoDialog(parent,title,this,p,anOperation,true);
           
            if(!pageDialog.isVisible())pageDialog.setVisible(true);
        }
    }
    

    @Override
    public void closeBookInfoDialog(operation anOperation,Book b) {
        //To change body of generated methods, choose Tools | Templates.
        boolean successed =false;
        if(anOperation.equals(operation.ADD) && b !=null)         successed = theConnecter.addBook(b);
        else if(anOperation.equals(operation.UPDATE)) successed = theConnecter.updateBook(b);
        else if(anOperation.equals(operation.DELETE)) successed = theConnecter.deleteBook(b);
        
        if(successed)System.out.println("successed");
        else System.out.println("failed");
        
        if(bookDialog.isVisible()){
            bookDialog.setVisible(false);
            bookDialog.dispose();
        }
        
    }

    @Override
    public void closePageInfoDialog(operation anOperation,Page p) {
        boolean successed =false;
        if(anOperation.equals(operation.ADD)&& p!=null)         successed = theConnecter.addPage(p);
        else if(anOperation.equals(operation.UPDATE)) successed = theConnecter.updatePage(p);
        else if(anOperation.equals(operation.DELETE)) successed = theConnecter.deletePage(p);
        
        if(successed)System.out.println("successed");
        else System.out.println("failed");
        
        if(pageDialog.isVisible()){
            pageDialog.setVisible(false);
            pageDialog.dispose();
        }
    }
    
    @Override
    public void openAboutDialog(JFrame parent) {
        if(theaboutDialog ==null) theaboutDialog = new AboutDialog(parent,"about this program",true);
        theaboutDialog.setVisible(true);
    }

    @Override
    public void exitProgram() {
        theConnecter.closeConnection();
        System.exit(0);
    }

    @Override
    public void dialogCancelled() {
         
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
