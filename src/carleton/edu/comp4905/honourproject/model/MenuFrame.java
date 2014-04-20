/*
 * Carleton University - School of Computer Science Honours Project 
 * Winter 2014
 * PDF Book Organizer and page Viewer
 * AUTHOR: Zhangda Yang
 * SUPERVISOR: Professor Louis Nel
 * 
 */
package carleton.edu.comp4905.honourproject.model;

import java.awt.Toolkit;
import java.awt.event.*;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.filechooser.FileNameExtensionFilter;
import carleton.edu.comp4905.honourproject.main.Book;
import carleton.edu.comp4905.honourproject.main.Page;

/**
 * this class represent the view of the detailed book info screen
 *
 * @author Zhangd Yang
 */
public class MenuFrame extends javax.swing.JFrame {

    private static Controller theController;
    private static ActionListener bookMenuListener;
    private static ActionListener pageMenuListener;
    private static ActionListener toolMenuListener;
    private static ActionListener aboutMenuListener;
    private static ActionListener fileMenuListener;

    // Contractor with title ;
    public MenuFrame(String t) {
        super(t);
        initListener();
        initComponents();
        enableListener();
        updateButton();
    }

    // Contractor
    public MenuFrame(String t, Controller c) {
        super(t);
        theController = c;

        initListener();
        initComponents();
        enableListener();
        updateButton();

    }

    //update Status Message;
    public void setStatus(String s) {
        statusBar.setText("Status : " + s);
    }
    // updtae view of the content panel

    public void updateMainPanel(JPanel panel) {
        java.awt.GridBagConstraints gridBagConstraints;
        getContentPane().remove(mainPannel);
        mainPannel = new JPanel();
        mainPannel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));
        mainPannel.setLayout(new java.awt.BorderLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.ipady = 200;
        gridBagConstraints.weightx = 2.0;
        gridBagConstraints.weighty = 2.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        getContentPane().add(mainPannel, gridBagConstraints);
        mainPannel.add(panel, java.awt.BorderLayout.CENTER);

        update();
    }

    //return status;
    public JLabel getStatus() {
        return statusBar;
    }

    //return main panel;
    public JPanel getMainPanel() {
        return mainPannel;
    }

    // set up and define all listener;
    private void initListener() {

        //Listener: clicked add button in tool bar or select addbook opotion in edit menu 
        bookMenuListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookActionMap(e);
            }
        };

        pageMenuListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pageActionMap(e);

            }
        };

        toolMenuListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toolActionMap(e);
            }
        };

        aboutMenuListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aboutActionMap(e);

            }
        };

        fileMenuListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileActionmap(e);
            }
        };

    }

    //add all listener to frame;
    private void enableListener() {

        addBookMenuItem.addActionListener(bookMenuListener);
        editBookMenuItem.addActionListener(bookMenuListener);
        deleteBookMenuItem.addActionListener(bookMenuListener);

        openMenuItem.addActionListener(fileMenuListener);
        saveMenuItem.addActionListener(fileMenuListener);
        DatabaseCloseMenuItem.addActionListener(fileMenuListener);
        exitMenuItem.addActionListener(fileMenuListener);

        addPageMenuItem.addActionListener(pageMenuListener);
        editPageMenuItem.addActionListener(pageMenuListener);
        deletePageMenuItem.addActionListener(pageMenuListener);

        About.addActionListener(aboutMenuListener);

        addnewBookButton.addActionListener(toolMenuListener);
        removeBookButton.addActionListener(toolMenuListener);
        ViewBookButton.addActionListener(toolMenuListener);

    }

    //remove all listener from frame;
    private void disableListsener() {
        About.removeActionListener(aboutMenuListener);

        openMenuItem.removeActionListener(fileMenuListener);
        saveMenuItem.removeActionListener(fileMenuListener);
        DatabaseCloseMenuItem.removeActionListener(fileMenuListener);

        exitMenuItem.removeActionListener(fileMenuListener);

        addBookMenuItem.removeActionListener(bookMenuListener);
        deleteBookMenuItem.removeActionListener(bookMenuListener);
        editBookMenuItem.removeActionListener(bookMenuListener);

        addPageMenuItem.removeActionListener(pageMenuListener);
        editPageMenuItem.removeActionListener(pageMenuListener);
        deletePageMenuItem.removeActionListener(pageMenuListener);

        addnewBookButton.removeActionListener(toolMenuListener);
        removeBookButton.removeActionListener(MenuFrame.toolMenuListener);
        ViewBookButton.removeActionListener(MenuFrame.toolMenuListener);

    }
    // action performers for file menu item

    private void fileActionmap(ActionEvent ae) {

        if (ae.getSource().equals(exitMenuItem)) {
            if (theController != null) {
                theController.exitProgram();
            }
        } else if (ae.getSource().equals(openMenuItem)) {
            setStatus("opening file.....");
            JFileChooser chooser = new JFileChooser();
            int returnVal = chooser.showOpenDialog(null);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                setStatus("opening file: " + chooser.getSelectedFile().getPath());

                if (theController != null) {
                    if (theController.openNewDataBase(chooser.getSelectedFile())) {
                        Enumeration<AbstractButton> elements = databaseRequired.getElements();

                        while (elements.hasMoreElements()) {
                            elements.nextElement().getModel().setEnabled(true);
                        }
                    }
                }
            }

        } else if (ae.getSource().equals(saveMenuItem)) {
            setStatus("save system data info");
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("xml", "XML");
            chooser.setFileFilter(filter);

            int returnVal = chooser.showSaveDialog(null);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                if (theController != null) {
                    theController.SaveDatabaseAs(chooser.getSelectedFile());
                }
                setStatus("save file: " + chooser.getSelectedFile().getPath());
            }
        } else if (ae.getSource().equals(DatabaseCloseMenuItem)) {
            if (theController != null) {
                if (theController.closeDatabase()) {
                    JOptionPane.showMessageDialog(this, " database Closed");

                }
            }
        }
    }
    // action performers for book menu item

    private void bookActionMap(ActionEvent ae) {
        if (ae.getSource().equals(addBookMenuItem)) {

            if (theController != null) {
                theController.openBookInfoDialog(this, Controller.operation.ADD, null);
                setStatus("add new book");
            }

        } else {

            if (theController.getSelectedBook() == null) {
                JOptionPane.showMessageDialog(this, " System did not find a selected Book information");
                return;
            }

            if (ae.getSource().equals(editBookMenuItem)) {
                if (theController != null) {
                    setStatus("Update book info: " + theController.getSelectedBook().getBookName());
                    theController.openBookInfoDialog(this, Controller.operation.UPDATE, theController.getSelectedBook());
                }
            } else if (ae.getSource().equals(deleteBookMenuItem)) {
                setStatus("delete book : " + theController.getSelectedBook().getBookName());

                Book temp;

                temp = theController.getSelectedBook();
                if (temp == null) {
                    JOptionPane.showMessageDialog(this, " System did not found a selected Book information");

                } else if (theController != null) {
//                 theController.openBookInfoDialog(this, Controller.operation.DELETE, theController.getSelectedBook());

                    int dialogButton = JOptionPane.YES_NO_OPTION;
                    int dialogResult = JOptionPane.showConfirmDialog(this, "do you want to delete book "
                            + temp.getBookName() + " ?", "Delete Book: " + temp.getBookName(), dialogButton);
                    if (dialogResult == 1) {
                        setStatus("Operation Cancelled");
                    } else {
                        theController.closeBookInfoDialog(Controller.operation.DELETE, temp);
                        setStatus(theController.getSelectedBook().getBookName() + " deleted! ");

                    }
                }
            }
        }

    }
    // action performers for page menu item

    private void pageActionMap(ActionEvent ae) {
        if (theController == null) {
            return;
        }
        Page editedPage = theController.getSelectedPage();

        if (ae.getSource().equals(addPageMenuItem)) {
            setStatus("add new page: ");
            theController.openPageInfoDialog(this, Controller.operation.ADD, null);


        } else if (editedPage == null) {
            JOptionPane.showMessageDialog(this, " System did not found a selected page information");
            return;
        }

        if (ae.getSource().equals(editPageMenuItem)) {
            setStatus("Update page info: " + theController.getSelectedPage().getPageTitle());

            theController.openPageInfoDialog(this, Controller.operation.UPDATE, theController.getSelectedPage());
        } else if (ae.getSource().equals(deletePageMenuItem)) {
            setStatus("delete page : " + theController.getSelectedPage().getPageTitle());

            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(this, "do you want to delete Page "
                    + editedPage.getPageTitle() + " ?", "Delete Book: " + editedPage.getPageTitle(), dialogButton);
            if (dialogResult == 1) {
                setStatus("Operation Cancelled");
            } else {
                theController.closePageInfoDialog(Controller.operation.DELETE, editedPage);
                setStatus(theController.getSelectedPage().getPageTitle() + " has deleted! ");

            }
        }

    }

    // action performers for tool bar buttons
    private void toolActionMap(ActionEvent ae) {

        if (ae.getSource().equals(addnewBookButton)) {

            if (theController != null) {
                setStatus("add new book");
                theController.openBookInfoDialog(this, Controller.operation.ADD, null);

            }

        } else if (ae.getSource().equals(removeBookButton)) {
            setStatus("delete book : " + theController.getSelectedBook().getBookName());
            Book temp;

            temp = theController.getSelectedBook();
            if (temp == null) {
                JOptionPane.showMessageDialog(this, " System did not found a selected Book information");

            } else if (theController != null) {
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog(this, "do you want to delete book "
                        + temp.getBookName() + " ?", "Delete Book: " + temp.getBookName(), dialogButton);
                if (dialogResult == 1) {
                    setStatus("Operation Cancelled");
                } else {
                    theController.closeBookInfoDialog(Controller.operation.DELETE, temp);
                    setStatus(theController.getSelectedBook().getBookName() + " deleted! ");
                }
            }
        } else if (ae.getSource().equals(ViewBookButton)) {
            setStatus("view  colletion list ");
            if (theController != null) {
                theController.OpenBookListFrame();
            }
        }

    }
    // action performers for about menu item

    private void aboutActionMap(ActionEvent ae) {
        if (ae.getSource().equals(About)) {
            if (theController != null) {
                theController.openAboutDialog(this);
            }
        }
    }
    // update button status

    private void updateButton() {
        if (theController == null) {
            theController = new Modeling();
        }
        if (theController.getSelectedBook() != null) {
            Pages.setEnabled(true);
            editBookMenuItem.setEnabled(true);
            deleteBookMenuItem.setEnabled(true);
            removeBookButton.setEnabled(true);

        } else {
            Pages.setEnabled(false);
            Pages.setEnabled(false);
            editBookMenuItem.setEnabled(false);
            deleteBookMenuItem.setEnabled(false);
            removeBookButton.setEnabled(false);
        }
        if (theController.getSelectedPage() != null) {
            editPageMenuItem.setEnabled(true);
            deletePageMenuItem.setEnabled(true);
        } else {
            editPageMenuItem.setEnabled(false);
            deletePageMenuItem.setEnabled(false);
        }

    }

    public void update() {
        disableListsener();
        updateButton();
        enableListener();

    }
    // get tool bar

    protected JToolBar getToolBar() {
        return bookToolBar;
    }

    protected void addTools(JToolBar jtb) {
    }

//    public static void main(String args[]) {
//
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(MenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                Modeling main = new Modeling();
//                new MenuFrame("test", main).setVisible(true);
//            }
//        });
//    }
    // Initialize components and view layout
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        databaseRequired = new javax.swing.ButtonGroup();
        bookToolBar = new javax.swing.JToolBar();
        addnewBookButton = new javax.swing.JButton();
        removeBookButton = new javax.swing.JButton();
        ViewBookButton = new javax.swing.JButton();
        separator = new javax.swing.JToolBar.Separator();
        mainPannel = new javax.swing.JPanel();
        statusBar = new javax.swing.JLabel();
        topMenuBar = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        DatabaseCloseMenuItem = new javax.swing.JMenuItem();
        fileMenuSeparator = new javax.swing.JPopupMenu.Separator();
        exitMenuItem = new javax.swing.JMenuItem();
        Edit = new javax.swing.JMenu();
        addBookMenuItem = new javax.swing.JMenuItem();
        editBookMenuItem = new javax.swing.JMenuItem();
        deleteBookMenuItem = new javax.swing.JMenuItem();
        Pages = new javax.swing.JMenu();
        addPageMenuItem = new javax.swing.JMenuItem();
        editPageMenuItem = new javax.swing.JMenuItem();
        deletePageMenuItem = new javax.swing.JMenuItem();
        Help = new javax.swing.JMenu();
        About = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("MenuFrame"); // NOI18N
        getContentPane().setLayout(new java.awt.GridBagLayout());

        bookToolBar.setForeground(new java.awt.Color(240, 240, 240));
        bookToolBar.setRollover(true);

        addnewBookButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        addnewBookButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/add.png"))); // NOI18N
        addnewBookButton.setToolTipText("Add New Book");
        addnewBookButton.setFocusable(false);
        addnewBookButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addnewBookButton.setMargin(new java.awt.Insets(3, 5, 3, 3));
        addnewBookButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bookToolBar.add(addnewBookButton);

        removeBookButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/remove.png"))); // NOI18N
        removeBookButton.setFocusable(false);
        removeBookButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        removeBookButton.setMargin(new java.awt.Insets(3, 5, 3, 3));
        removeBookButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bookToolBar.add(removeBookButton);

        ViewBookButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/search.png"))); // NOI18N
        ViewBookButton.setFocusable(false);
        ViewBookButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ViewBookButton.setMargin(new java.awt.Insets(3, 5, 3, 3));
        ViewBookButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bookToolBar.add(ViewBookButton);
        bookToolBar.add(separator);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 752;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(bookToolBar, gridBagConstraints);

        mainPannel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));
        mainPannel.setLayout(new java.awt.BorderLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.ipady = 200;
        gridBagConstraints.weightx = 2.0;
        gridBagConstraints.weighty = 2.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        getContentPane().add(mainPannel, gridBagConstraints);

        statusBar.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        statusBar.setText("Status:");
        statusBar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 80;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(statusBar, gridBagConstraints);

        topMenuBar.setMargin(new java.awt.Insets(10, 10, 10, 10));

        FileMenu.setText("File");
        FileMenu.setAlignmentY(1.0F);
        databaseRequired.add(FileMenu);
        FileMenu.setFocusable(false);
        FileMenu.setFont(new java.awt.Font("Agency FB", 0, 16)); // NOI18N
        FileMenu.setMargin(new java.awt.Insets(3, 3, 3, 3));

        openMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openMenuItem.setFont(new java.awt.Font("Agency FB", 0, 16)); // NOI18N
        openMenuItem.setText("Open");
        openMenuItem.setMargin(new java.awt.Insets(2, 2, 2, 2));
        FileMenu.add(openMenuItem);

        saveMenuItem.setFont(new java.awt.Font("Agency FB", 0, 16)); // NOI18N
        saveMenuItem.setText("Save");
        databaseRequired.add(saveMenuItem);
        saveMenuItem.setMargin(new java.awt.Insets(2, 2, 2, 2));
        FileMenu.add(saveMenuItem);

        DatabaseCloseMenuItem.setFont(getFont());
        DatabaseCloseMenuItem.setText("Close Database");
        databaseRequired.add(DatabaseCloseMenuItem);
        FileMenu.add(DatabaseCloseMenuItem);
        FileMenu.add(fileMenuSeparator);

        exitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        exitMenuItem.setFont(new java.awt.Font("Agency FB", 0, 16)); // NOI18N
        exitMenuItem.setText("Exit");
        exitMenuItem.setMargin(new java.awt.Insets(2, 2, 2, 2));
        FileMenu.add(exitMenuItem);

        topMenuBar.add(FileMenu);

        Edit.setText("Books");
        Edit.setAlignmentY(1.0F);
        Edit.setFont(new java.awt.Font("Agency FB", 0, 16)); // NOI18N
        Edit.setMargin(new java.awt.Insets(3, 3, 3, 3));

        addBookMenuItem.setFont(new java.awt.Font("Agency FB", 0, 16)); // NOI18N
        addBookMenuItem.setText("AddBook");
        databaseRequired.add(addBookMenuItem);
        addBookMenuItem.setMargin(new java.awt.Insets(2, 2, 2, 2));
        Edit.add(addBookMenuItem);

        editBookMenuItem.setFont(new java.awt.Font("Agency FB", 0, 16)); // NOI18N
        editBookMenuItem.setText("EditBook");
        databaseRequired.add(editBookMenuItem);
        editBookMenuItem.setMargin(new java.awt.Insets(2, 2, 2, 2));
        Edit.add(editBookMenuItem);

        deleteBookMenuItem.setFont(new java.awt.Font("Agency FB", 0, 16)); // NOI18N
        deleteBookMenuItem.setText("DeleteBook");
        databaseRequired.add(deleteBookMenuItem);
        deleteBookMenuItem.setMargin(new java.awt.Insets(2, 2, 2, 2));
        Edit.add(deleteBookMenuItem);

        topMenuBar.add(Edit);

        Pages.setText("Pages");
        Pages.setAlignmentY(1.0F);
        databaseRequired.add(Pages);
        Pages.setFont(new java.awt.Font("Agency FB", 0, 16)); // NOI18N
        Pages.setMargin(new java.awt.Insets(3, 3, 3, 3));

        addPageMenuItem.setFont(new java.awt.Font("Agency FB", 0, 16)); // NOI18N
        addPageMenuItem.setText("Add Page");
        databaseRequired.add(addPageMenuItem);
        addPageMenuItem.setMargin(new java.awt.Insets(2, 2, 2, 2));
        Pages.add(addPageMenuItem);

        editPageMenuItem.setFont(new java.awt.Font("Agency FB", 0, 16)); // NOI18N
        editPageMenuItem.setText("Edit Page");
        databaseRequired.add(editPageMenuItem);
        editPageMenuItem.setMargin(new java.awt.Insets(2, 2, 2, 2));
        Pages.add(editPageMenuItem);

        deletePageMenuItem.setFont(new java.awt.Font("Agency FB", 0, 16)); // NOI18N
        deletePageMenuItem.setText("Delete Page");
        databaseRequired.add(deletePageMenuItem);
        deletePageMenuItem.setMargin(new java.awt.Insets(2, 2, 2, 2));
        Pages.add(deletePageMenuItem);

        topMenuBar.add(Pages);

        Help.setText("Help");
        Help.setAlignmentY(1.0F);
        Help.setFont(new java.awt.Font("Agency FB", 0, 16)); // NOI18N
        Help.setMargin(new java.awt.Insets(3, 3, 3, 3));

        About.setFont(new java.awt.Font("Agency FB", 0, 16)); // NOI18N
        About.setText("About");
        About.setMargin(new java.awt.Insets(2, 2, 2, 2));
        Help.add(About);

        topMenuBar.add(Help);

        setJMenuBar(topMenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem About;
    private javax.swing.JMenuItem DatabaseCloseMenuItem;
    private javax.swing.JMenu Edit;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JMenu Help;
    private javax.swing.JMenu Pages;
    private javax.swing.JButton ViewBookButton;
    private javax.swing.JMenuItem addBookMenuItem;
    private javax.swing.JMenuItem addPageMenuItem;
    private javax.swing.JButton addnewBookButton;
    private javax.swing.JToolBar bookToolBar;
    private javax.swing.ButtonGroup databaseRequired;
    private javax.swing.JMenuItem deleteBookMenuItem;
    private javax.swing.JMenuItem deletePageMenuItem;
    private javax.swing.JMenuItem editBookMenuItem;
    private javax.swing.JMenuItem editPageMenuItem;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JPopupMenu.Separator fileMenuSeparator;
    private javax.swing.JPanel mainPannel;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JButton removeBookButton;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JToolBar.Separator separator;
    private javax.swing.JLabel statusBar;
    private javax.swing.JMenuBar topMenuBar;
    // End of variables declaration//GEN-END:variables
}
