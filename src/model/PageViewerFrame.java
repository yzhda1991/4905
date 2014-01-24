
package model;

import main.Book;
import main.Connecter;
import main.Page;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.JPanel;
import main.Controller;
import main.ViewBooksMain;
import org.icepdf.ri.common.ComponentKeyBinding;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;

import viewer.PageViewer;


public class PageViewerFrame extends MenuFrame {
    private PageViewer          theviewer;
    private MouseListener       doubleClickedPage;
    private SwingController theSwingController;
    private ArrayList<Page>     pageCollection;
    private Page                selectedPage;
    private Connecter           theConnecter;
    private Controller          theController;
    
    
    public PageViewerFrame(){
        super("view page");
        theConnecter   = new Connecter();
        
       
        pageCollection = new ArrayList<Page>();
        selectedPage   = null;
        initComplent();
    }
    
    public PageViewerFrame(Page p){
        super("view page");
        theConnecter   = new Connecter();
        pageCollection = null;
        selectedPage   = p;
      
        
        initComplent();
    }
    
     public PageViewerFrame(String title,ViewBooksMain m,Controller c,Connecter con,Page p){
        super(title,c);
        theConnecter   = con;
        theController  = c;
        pageCollection = null;
        selectedPage   = p;
      
        
        initComplent();
    }
    
    private void initComplent(){
        
        theviewer      = new PageViewer();
        
        
        if(selectedPage !=null)pageCollection = theConnecter.searchPage(selectedPage.getBookCode(), "bookcode");
        else pageCollection = theConnecter.getPageList();
        
        theSwingController = new SwingController();
        SwingViewBuilder factory = new SwingViewBuilder(theSwingController);

        JPanel newViewer = factory.buildViewerPanel();
        
        ComponentKeyBinding.install(theSwingController, newViewer);
        theSwingController.getDocumentViewController().setAnnotationCallback(
                new org.icepdf.ri.common.MyAnnotationCallback(
                   theSwingController.getDocumentViewController())
                       );
        
        newViewer.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        theviewer.setMainPanel(newViewer);
        if(selectedPage!=null)openPage(selectedPage);
        
        doubleClickedPage = new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()==2){
                    JList theList =  (JList) e.getSource();
                    int index = theList.locationToIndex(e.getPoint());
                    openPage((Page) theList.getModel().getElementAt(index));
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
               
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
            }
            
        };
        
         this.addWindowListener(new WindowAdapter(){
              public void WindowClosing(WindowEvent e){
                  if(theController !=null)theController.closePageViewer();
                  else System.exit(0);
              }
         });
        enableListener();
        super.updateMainPanel(theviewer);
        
        update();
       
    }
    private void openPage(Page p){
        if(p == null) {
            super.setStatus("Null page"); 
            return;
        }
        
       super.setStatus("opening page :"+p.getPageTitle());
       
        ArrayList<Book> bookFound = theConnecter.searchBook(p.getBookCode(), "code");
        try{
       
            if(bookFound.size()==1) theSwingController.openDocument(bookFound.get(0).getBookPath());        
            else super.setStatus("more than one book found;");
            theviewer.setTittle(p.getPageTitle());
        }catch(Exception  e){
            super.setStatus("Error :" +e.toString());
        }
    }
    
    private void enableListener(){
        theviewer.getPageList().addMouseListener(doubleClickedPage);
        
    }   
    private void disableListener(){
        theviewer.getPageList().removeMouseListener(doubleClickedPage);
    }
    
    private void updateList(){
        Page pageArray[] = new Page[1]; //just to establish array type
	    theviewer.getPageList().setListData(((Page []) pageCollection.toArray(pageArray)));
            
           
		if (selectedPage != null)
			 theviewer.getPageList().setSelectedValue(selectedPage, true);
    }
    @Override
    public void update(){
        disableListener();
        updateList();
        enableListener();
        super.update();
    }
    
    public static void main(String args[])  {
       
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PageViewerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PageViewerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PageViewerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PageViewerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                ViewBooksMain main = new ViewBooksMain();
                new PageViewerFrame().setVisible(true);
            }
        });
    }
}
