
package viewer;
import javax.swing.JFrame;

//basic viewer for BookViewer;
public class MainMenuFrame extends JFrame{

     
    //constractor with title;
    public MainMenuFrame(){
      
        initComponents();
    }
    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        bookToolBar = new javax.swing.JToolBar();
        addnewBookButton = new javax.swing.JButton();
        removeBook = new javax.swing.JButton();
        ViewBookButton = new javax.swing.JButton();
        separator = new javax.swing.JToolBar.Separator();
        mainPannel = new javax.swing.JPanel();
        ProgressBar = new javax.swing.JProgressBar();
        statusBar = new javax.swing.JLabel();
        topMenuBar = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        fileMenuSeparator = new javax.swing.JPopupMenu.Separator();
        exitMenuItem = new javax.swing.JMenuItem();
        Edit = new javax.swing.JMenu();
        addBookMenuItem = new javax.swing.JMenuItem();
        editBookMenuItem = new javax.swing.JMenuItem();
        deleteBookMenuItem = new javax.swing.JMenuItem();
        Pages = new javax.swing.JMenu();
        addPageMenuItem = new javax.swing.JMenuItem();
        removePageMenuItem = new javax.swing.JMenuItem();
        deletePageMenuItem = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        Help = new javax.swing.JMenu();
        About = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        bookToolBar.setForeground(new java.awt.Color(240, 240, 240));
        bookToolBar.setRollover(true);

        addnewBookButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        addnewBookButton.setText("Add Book");
        addnewBookButton.setToolTipText("Add New Book");
        addnewBookButton.setFocusable(false);
        addnewBookButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addnewBookButton.setMargin(new java.awt.Insets(3, 5, 3, 3));
        addnewBookButton.setMaximumSize(new java.awt.Dimension(87, 24));
        addnewBookButton.setMinimumSize(new java.awt.Dimension(87, 24));
        addnewBookButton.setPreferredSize(new java.awt.Dimension(87, 24));
        addnewBookButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bookToolBar.add(addnewBookButton);

        removeBook.setText("Remove Book");
        removeBook.setToolTipText("Remove Book");
        removeBook.setFocusable(false);
        removeBook.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        removeBook.setMargin(new java.awt.Insets(3, 5, 3, 3));
        removeBook.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bookToolBar.add(removeBook);

        ViewBookButton.setText("View Book");
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

        ProgressBar.setMaximum(200);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        getContentPane().add(ProgressBar, gridBagConstraints);

        statusBar.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        statusBar.setText("Status:");
        statusBar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 80;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(statusBar, gridBagConstraints);

        topMenuBar.setMargin(new java.awt.Insets(10, 10, 10, 10));

        FileMenu.setText("File");
        FileMenu.setAlignmentY(1.0F);
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
        saveMenuItem.setMargin(new java.awt.Insets(2, 2, 2, 2));
        FileMenu.add(saveMenuItem);
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
        addBookMenuItem.setMargin(new java.awt.Insets(2, 2, 2, 2));
        Edit.add(addBookMenuItem);

        editBookMenuItem.setFont(new java.awt.Font("Agency FB", 0, 16)); // NOI18N
        editBookMenuItem.setText("EditBook");
        editBookMenuItem.setMargin(new java.awt.Insets(2, 2, 2, 2));
        Edit.add(editBookMenuItem);

        deleteBookMenuItem.setFont(new java.awt.Font("Agency FB", 0, 16)); // NOI18N
        deleteBookMenuItem.setText("DeleteBook");
        deleteBookMenuItem.setMargin(new java.awt.Insets(2, 2, 2, 2));
        Edit.add(deleteBookMenuItem);

        topMenuBar.add(Edit);

        Pages.setText("Pages");
        Pages.setAlignmentY(1.0F);
        Pages.setFont(new java.awt.Font("Agency FB", 0, 16)); // NOI18N
        Pages.setMargin(new java.awt.Insets(3, 3, 3, 3));

        addPageMenuItem.setFont(new java.awt.Font("Agency FB", 0, 16)); // NOI18N
        addPageMenuItem.setText("AddPage");
        addPageMenuItem.setMargin(new java.awt.Insets(2, 2, 2, 2));
        Pages.add(addPageMenuItem);

        removePageMenuItem.setFont(new java.awt.Font("Agency FB", 0, 16)); // NOI18N
        removePageMenuItem.setText("RemovePage");
        removePageMenuItem.setMargin(new java.awt.Insets(2, 2, 2, 2));
        Pages.add(removePageMenuItem);

        deletePageMenuItem.setFont(new java.awt.Font("Agency FB", 0, 16)); // NOI18N
        deletePageMenuItem.setText("DeletePage");
        deletePageMenuItem.setMargin(new java.awt.Insets(2, 2, 2, 2));
        Pages.add(deletePageMenuItem);

        topMenuBar.add(Pages);

        jMenu1.setText("Database");
        jMenu1.setAlignmentY(1.0F);
        jMenu1.setFont(new java.awt.Font("Agency FB", 0, 16)); // NOI18N
        jMenu1.setMargin(new java.awt.Insets(3, 3, 3, 3));
        topMenuBar.add(jMenu1);

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
    private javax.swing.JMenu Edit;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JMenu Help;
    private javax.swing.JMenu Pages;
    private javax.swing.JProgressBar ProgressBar;
    private javax.swing.JButton ViewBookButton;
    private javax.swing.JMenuItem addBookMenuItem;
    private javax.swing.JMenuItem addPageMenuItem;
    private javax.swing.JButton addnewBookButton;
    private javax.swing.JToolBar bookToolBar;
    private javax.swing.JMenuItem deleteBookMenuItem;
    private javax.swing.JMenuItem deletePageMenuItem;
    private javax.swing.JMenuItem editBookMenuItem;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JPopupMenu.Separator fileMenuSeparator;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel mainPannel;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JButton removeBook;
    private javax.swing.JMenuItem removePageMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JToolBar.Separator separator;
    private javax.swing.JLabel statusBar;
    private javax.swing.JMenuBar topMenuBar;
    // End of variables declaration//GEN-END:variables

}
