/*
 * Carleton University - School of Computer Science Honours Project 
 * Winter 2014
 * PDF Book Organizer and page Viewer
 * AUTHOR: Zhangda Yang
 * SUPERVISOR: Professor Louis Nel
 * 
 */
package carleton.edu.comp4905.honourproject.model;

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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import carleton.edu.comp4905.honourproject.main.Book;
import carleton.edu.comp4905.honourproject.main.Page;
import org.icepdf.ri.common.ComponentKeyBinding;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;
import org.icepdf.ri.common.views.DocumentViewController;
import carleton.edu.comp4905.honourproject.viewer.PageViewer;

/**
 * this class represents view of page content display
 *
 * @author zhangda yang
 */
public class PageViewerFrame extends MenuFrame {

    private PageViewer theviewer;
    private MouseListener doubleClickedPage;
    private ListSelectionListener pagelistSelection;
    private SwingController theSwingController;
    private ArrayList<Page> pageCollection;
    private Page selectedPage;
    private final Connecter theConnecter;
    private Controller theController;
    private SwingViewBuilder factory;
    private JPanel newViewer;

    // constructor
    public PageViewerFrame() {
        super("view page");
        theConnecter = new Connecter();


        pageCollection = new ArrayList<Page>();
        selectedPage = null;
        initComplent();
    }
    // constructor

    public PageViewerFrame(Page p) {
        super("view page");
        theConnecter = new Connecter();
        pageCollection = null;
        selectedPage = p;


        initComplent();
    }
    // constructor

    public PageViewerFrame(String title, Modeling m, Controller c, Connecter con, Page p) {
        super(title, c);
        theConnecter = con;
        theController = c;
        pageCollection = null;
        selectedPage = p;


        initComplent();
    }
    // initialize components and view layout

    private void initComplent() {

        theviewer = new PageViewer();


        if (selectedPage != null) {
            pageCollection = theConnecter.searchPage(selectedPage.getBookCode(), "bookcode");
        } else {
            pageCollection = theConnecter.getPageList();
        }

        customized();
        if (selectedPage != null) {
            try {
                openPage(selectedPage);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(PageViewerFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        doubleClickedPage = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    JList theList = (JList) e.getSource();
                    int index = theList.locationToIndex(e.getPoint());
                    try {
                        openPage((Page) theList.getModel().getElementAt(index));
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(PageViewerFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        pagelistSelection = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                changeselectedPage((Page) theviewer.getPageList().getSelectedValue());
            }
        };


        super.updateMainPanel(theviewer);
        enableListener();
        update();

    }

    // change view with ICE PDF engine.
    private void customized() {
        theSwingController = new SwingController();
        factory = new SwingViewBuilder(theSwingController);

        newViewer = factory.buildViewerPanel();

        ComponentKeyBinding.install(theSwingController, newViewer);
        theSwingController.getDocumentViewController().setAnnotationCallback(
                new org.icepdf.ri.common.MyAnnotationCallback(
                theSwingController.getDocumentViewController()));
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
    // add ICE PDF tool bar to view

    @Override
    protected void addTools(JToolBar jtb) {
        if (jtb == null) {
            return;
        }
        for (Component c : jtb.getComponents()) {
            c.setSize(64, 64);
            super.getToolBar().add(c);
        }

    }
    // dispay page content

    private void openPage(Page p) throws FileNotFoundException {
        if (p == null) {
            super.setStatus("Null page");
            return;
        }

        super.setStatus("opening page :" + p.getPageTitle());

        ArrayList<Book> bookFound = theConnecter.searchBook(p.getBookCode(), "code");

        if (bookFound.size() == 1) {
            theSwingController.openDocument(bookFound.get(0).getBookPath());

            theSwingController.setToolBarVisible(false);
            theSwingController.setPageFitMode(DocumentViewController.PAGE_FIT_WINDOW_WIDTH, true);
            theSwingController.showPage(p.getPageNum() - 1 + bookFound.get(0).getInitPage() - 1);

        } else {
            super.setStatus("more than one book found;");
        }
        theviewer.setTittle(p.getPageTitle());

    }
    // update page collection 

    protected void setPageCollection(ArrayList<Page> p) {

        pageCollection = p;
    }

    //update selected page
    private void changeselectedPage(Page p) {
        if (p != null) {
            theController.setSelectedPage(p);
            super.setStatus("selected Page: " + p.getPageTitle());
            update();
        }
    }
    // add listener to components

    private void enableListener() {
        theviewer.getPageList().addMouseListener(doubleClickedPage);
        theviewer.getPageList().addListSelectionListener(pagelistSelection);

    }
    // remove listener to components

    private void disableListener() {
        theviewer.getPageList().removeMouseListener(doubleClickedPage);
        theviewer.getPageList().removeListSelectionListener(pagelistSelection);


    }
    // update page

    protected void updateInfo(Page p) throws FileNotFoundException {
        if (p == null) {
            selectedPage = p;
            return;
        }
        if (selectedPage == null || !p.getBookCode().equals(selectedPage.getBookCode())) {
            selectedPage = p;
            pageCollection = theConnecter.searchPage(selectedPage.getBookCode(), "bookcode");
            if (selectedPage != null) {
                openPage(selectedPage);
            }
        }
        update();
    }
    // update list

    private void updateList() {
        if (pageCollection != null && !pageCollection.isEmpty()) {
            Page pageArray[] = new Page[1];
            theviewer.getPageList().setListData(pageCollection.toArray(pageArray));
        } else {
            String[] empty = {};
            theviewer.getPageList().setListData(empty);
        }
    }

    @Override
    public void update() {
        disableListener();
        updateList();
        enableListener();
        super.update();
    }
//    public static void main(String args[])  {
//       
//        
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(PageViewerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(PageViewerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(PageViewerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(PageViewerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        java.awt.EventQueue.invokeLater(new Runnable() {
//
//            @Override
//            public void run() {
//                Modeling main = new Modeling();
//                new PageViewerFrame().setVisible(true);
//            }
//        });
//    }
}
