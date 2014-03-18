
package model;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import main.Book;
import main.Page;
import org.icepdf.ri.common.ComponentKeyBinding;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;
import org.icepdf.ri.common.views.DocumentViewController;
import viewer.PageViewer;


public class PageViewerFrame extends MenuFrame {
    private PageViewer          theviewer;
    private MouseListener       doubleClickedPage;
    private SwingController     theSwingController;
    private ArrayList<Page>     pageCollection;
    private Page                selectedPage;
    private final Connecter     theConnecter;
    private Controller          theController;
    private SwingViewBuilder    factory;
    private JPanel              newViewer;
    
    
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
    
     public PageViewerFrame(String title,Modeling m,Controller c,Connecter con,Page p){
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

        customized();
         if(selectedPage!=null)try {
             openPage(selectedPage);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PageViewerFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        doubleClickedPage = new MouseAdapter(){

            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()==2){
                    JList theList =  (JList) e.getSource();
                    int index = theList.locationToIndex(e.getPoint());
                    try {
                        openPage((Page) theList.getModel().getElementAt(index));
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(PageViewerFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        };
        

        super.updateMainPanel(theviewer);
        enableListener();
        update();
       
    }
    
    private void customized(){
        theSwingController = new SwingController();
        factory = new SwingViewBuilder(theSwingController);
        
        newViewer = factory.buildViewerPanel();
        
        ComponentKeyBinding.install(theSwingController, newViewer);
        theSwingController.getDocumentViewController().setAnnotationCallback(
                new org.icepdf.ri.common.MyAnnotationCallback(
                   theSwingController.getDocumentViewController())
                       );
        theSwingController.setToolBarVisible(false);
        theSwingController.setPageFitMode(DocumentViewController.PAGE_FIT_WINDOW_WIDTH, true);
        addTools(factory.buildUtilityToolBar(true));
        addTools(factory.buildPageNavigationToolBar());
        addTools(factory.buildRotateToolBar());
        addTools(factory.buildToolToolBar());
        addTools(factory.buildZoomToolBar());
        
        newViewer.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        theviewer.setMainPanel(newViewer);
       
        update();
    }
    
    @Override
    protected void  addTools(JToolBar jtb){
        if(jtb==null) return;
        for(Component c:jtb.getComponents()){
            c.setSize(64,64);
            super.getToolBar().add(c);
        }
        
    }
   
    private void openPage (Page p)throws FileNotFoundException{
        if(p == null) {
            super.setStatus("Null page"); 
            return;
        }
        
       super.setStatus("opening page :"+p.getPageTitle());
       
        ArrayList<Book> bookFound = theConnecter.searchBook(p.getBookCode(), "code");
       
            if(bookFound.size()==1) 
            {
                theSwingController.openDocument(bookFound.get(0).getBookPath()); 
                
                theSwingController.setToolBarVisible(false);
                theSwingController.setPageFitMode(DocumentViewController.PAGE_FIT_WINDOW_WIDTH, true);
                theSwingController.showPage(p.getPageNum()-1+bookFound.get(0).getInitPage()-1);
                
              }
            else super.setStatus("more than one book found;");
            theviewer.setTittle(p.getPageTitle());
       
    }
    


    private void enableListener(){
        theviewer.getPageList().addMouseListener(doubleClickedPage);
        
    }   
    private void disableListener(){
        theviewer.getPageList().removeMouseListener(doubleClickedPage);

    
    }
    protected void updateInfo(Page p) throws FileNotFoundException{
        if(p==null) {
            selectedPage = p;
            return;
        }
        if(selectedPage ==null || !p.getBookCode().equals(selectedPage.getBookCode())){
            selectedPage = p;
            pageCollection = theConnecter.searchPage(selectedPage.getBookCode(), "bookcode");
            if(selectedPage !=null)openPage(selectedPage);
        }
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
                Modeling main = new Modeling();
                new PageViewerFrame().setVisible(true);
            }
        });
    }
}
