
package model;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author brianyang
 */
public class MainFrame extends javax.swing.JFrame {

    protected Controller theController;
    public MainFrame() {
        initComponents();
    }
    public MainFrame(String title,Controller c){
        super(title);
        theController =c;
        initComponents();
        
        addWindowListener(
                  new WindowAdapter(){
                      public void WindowClosing(WindowEvent e){
                          
                          if(theController !=null){
                             
                              theController.exitProgram();
                          } 
                          else System.exit(0);
                      }
                  }
                  );
        update();
        this.setSize(700,500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // Already there
        
    }
    

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        databaseRequired = new javax.swing.ButtonGroup();
        page_viewListButton = new javax.swing.JButton();
        page_addPageButton = new javax.swing.JButton();
        page_searchPageButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        book_addBookButton = new javax.swing.JButton();
        book_viewListButton = new javax.swing.JButton();
        book_searchButton = new javax.swing.JButton();
        database_viewButton = new javax.swing.JButton();
        Database_CloseButton = new javax.swing.JButton();
        database_newConnectButton = new javax.swing.JButton();
        aboutButton = new javax.swing.JButton();
        bookLabel = new javax.swing.JLabel();
        pageLabel = new javax.swing.JLabel();
        databaseLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setForeground(new java.awt.Color(204, 204, 0));
        setName("main Frame"); // NOI18N
        getContentPane().setLayout(new java.awt.GridBagLayout());

        page_viewListButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/book.png"))); // NOI18N
        page_viewListButton.setText("View PageList");
        databaseRequired.add(page_viewListButton);
        page_viewListButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        page_viewListButton.setIconTextGap(8);
        page_viewListButton.setMaximumSize(new java.awt.Dimension(128, 128));
        page_viewListButton.setMinimumSize(new java.awt.Dimension(64, 64));
        page_viewListButton.setPreferredSize(new java.awt.Dimension(100, 100));
        page_viewListButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        page_viewListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                page_viewListButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 2.0;
        gridBagConstraints.weighty = 2.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(page_viewListButton, gridBagConstraints);

        page_addPageButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/book.png"))); // NOI18N
        page_addPageButton.setText("Add New Page");
        databaseRequired.add(page_addPageButton);
        page_addPageButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        page_addPageButton.setIconTextGap(8);
        page_addPageButton.setMaximumSize(new java.awt.Dimension(128, 128));
        page_addPageButton.setMinimumSize(new java.awt.Dimension(64, 64));
        page_addPageButton.setPreferredSize(new java.awt.Dimension(100, 100));
        page_addPageButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        page_addPageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                page_addPageButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 2.0;
        gridBagConstraints.weighty = 2.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(page_addPageButton, gridBagConstraints);

        page_searchPageButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/book.png"))); // NOI18N
        page_searchPageButton.setText("SearchPage");
        databaseRequired.add(page_searchPageButton);
        page_searchPageButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        page_searchPageButton.setIconTextGap(8);
        page_searchPageButton.setMaximumSize(new java.awt.Dimension(128, 128));
        page_searchPageButton.setMinimumSize(new java.awt.Dimension(64, 64));
        page_searchPageButton.setPreferredSize(new java.awt.Dimension(100, 100));
        page_searchPageButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        page_searchPageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                page_searchPageButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 2.0;
        gridBagConstraints.weighty = 2.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 20);
        getContentPane().add(page_searchPageButton, gridBagConstraints);

        exitButton.setText("Exit");
        exitButton.setToolTipText("Exit Program");
        exitButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        exitButton.setMaximumSize(new java.awt.Dimension(128, 64));
        exitButton.setMinimumSize(new java.awt.Dimension(128, 64));
        exitButton.setPreferredSize(new java.awt.Dimension(128, 40));
        exitButton.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 5, 10);
        getContentPane().add(exitButton, gridBagConstraints);

        book_addBookButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/book.png"))); // NOI18N
        book_addBookButton.setText("Add New Book");
        databaseRequired.add(book_addBookButton);
        book_addBookButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        book_addBookButton.setIconTextGap(10);
        book_addBookButton.setMaximumSize(new java.awt.Dimension(128, 128));
        book_addBookButton.setMinimumSize(new java.awt.Dimension(64, 64));
        book_addBookButton.setPreferredSize(new java.awt.Dimension(100, 100));
        book_addBookButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        book_addBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                book_addBookButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 2.0;
        gridBagConstraints.weighty = 2.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(book_addBookButton, gridBagConstraints);

        book_viewListButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/book.png"))); // NOI18N
        book_viewListButton.setText("View BookList");
        databaseRequired.add(book_viewListButton);
        book_viewListButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        book_viewListButton.setIconTextGap(8);
        book_viewListButton.setMaximumSize(new java.awt.Dimension(128, 128));
        book_viewListButton.setMinimumSize(new java.awt.Dimension(64, 64));
        book_viewListButton.setPreferredSize(new java.awt.Dimension(100, 100));
        book_viewListButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        book_viewListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                book_viewListButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 2.0;
        gridBagConstraints.weighty = 2.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(book_viewListButton, gridBagConstraints);

        book_searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/book.png"))); // NOI18N
        book_searchButton.setText("SearchBook");
        databaseRequired.add(book_searchButton);
        book_searchButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        book_searchButton.setIconTextGap(8);
        book_searchButton.setMaximumSize(new java.awt.Dimension(128, 128));
        book_searchButton.setMinimumSize(new java.awt.Dimension(64, 64));
        book_searchButton.setPreferredSize(new java.awt.Dimension(100, 100));
        book_searchButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        book_searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                book_searchButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 2.0;
        gridBagConstraints.weighty = 2.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 20);
        getContentPane().add(book_searchButton, gridBagConstraints);

        database_viewButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/book.png"))); // NOI18N
        database_viewButton.setText("Save Database");
        databaseRequired.add(database_viewButton);
        database_viewButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        database_viewButton.setIconTextGap(8);
        database_viewButton.setMaximumSize(new java.awt.Dimension(128, 128));
        database_viewButton.setMinimumSize(new java.awt.Dimension(64, 64));
        database_viewButton.setPreferredSize(new java.awt.Dimension(100, 100));
        database_viewButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        database_viewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                database_saveButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 2.0;
        gridBagConstraints.weighty = 2.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(database_viewButton, gridBagConstraints);

        Database_CloseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/book.png"))); // NOI18N
        Database_CloseButton.setText("Close Database");
        databaseRequired.add(Database_CloseButton);
        Database_CloseButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Database_CloseButton.setIconTextGap(8);
        Database_CloseButton.setMaximumSize(new java.awt.Dimension(128, 128));
        Database_CloseButton.setMinimumSize(new java.awt.Dimension(64, 64));
        Database_CloseButton.setPreferredSize(new java.awt.Dimension(100, 100));
        Database_CloseButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Database_CloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Database_CloseButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weightx = 2.0;
        gridBagConstraints.weighty = 2.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(Database_CloseButton, gridBagConstraints);

        database_newConnectButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/book.png"))); // NOI18N
        database_newConnectButton.setText("Connect new DataBase");
        database_newConnectButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        database_newConnectButton.setIconTextGap(8);
        database_newConnectButton.setMaximumSize(new java.awt.Dimension(128, 128));
        database_newConnectButton.setMinimumSize(new java.awt.Dimension(64, 64));
        database_newConnectButton.setPreferredSize(new java.awt.Dimension(100, 100));
        database_newConnectButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        database_newConnectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                database_newConnectButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        gridBagConstraints.weightx = 2.0;
        gridBagConstraints.weighty = 2.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 20);
        getContentPane().add(database_newConnectButton, gridBagConstraints);

        aboutButton.setText("About");
        aboutButton.setMaximumSize(new java.awt.Dimension(128, 40));
        aboutButton.setMinimumSize(new java.awt.Dimension(10, 10));
        aboutButton.setPreferredSize(new java.awt.Dimension(128, 40));
        aboutButton.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        aboutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 5, 0);
        getContentPane().add(aboutButton, gridBagConstraints);

        bookLabel.setFont(new java.awt.Font("OCR A Std", 1, 18)); // NOI18N
        bookLabel.setText("Book");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 5);
        getContentPane().add(bookLabel, gridBagConstraints);

        pageLabel.setFont(new java.awt.Font("OCR A Std", 1, 18)); // NOI18N
        pageLabel.setText("Page");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 5);
        getContentPane().add(pageLabel, gridBagConstraints);

        databaseLabel.setFont(new java.awt.Font("OCR A Std", 1, 18)); // NOI18N
        databaseLabel.setText("database");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 5);
        getContentPane().add(databaseLabel, gridBagConstraints);

        titleLabel.setFont(new java.awt.Font("OCR A Std", 2, 18)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("View Book Application");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 18, 10, 15);
        getContentPane().add(titleLabel, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void book_addBookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_book_addBookButtonActionPerformed
        // TODO add your handling code here:
        theController.openBookInfoDialog(this,Controller.operation.ADD,null);
    }//GEN-LAST:event_book_addBookButtonActionPerformed

    private void book_viewListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_book_viewListButtonActionPerformed
        // TODO add your handling code here:
        theController.OpenBookListFrame();
    }//GEN-LAST:event_book_viewListButtonActionPerformed

    private void book_searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_book_searchButtonActionPerformed
        // TODO add your handling code here:
       theController.openBookSearchDialog(this);
    }//GEN-LAST:event_book_searchButtonActionPerformed

    private void page_addPageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_page_addPageButtonActionPerformed
        // TODO add your handling code here:
        theController.openPageInfoDialog(this,Controller.operation.ADD,null);
    }//GEN-LAST:event_page_addPageButtonActionPerformed

    private void page_viewListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_page_viewListButtonActionPerformed
        // TODO add your handling code here:
         theController.openPageListFrame(null);
        
    }//GEN-LAST:event_page_viewListButtonActionPerformed

    private void page_searchPageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_page_searchPageButtonActionPerformed
        // TODO add your handling code here:
         theController.OpenPageSearchDialog(this);
    
    }//GEN-LAST:event_page_searchPageButtonActionPerformed

    private void database_saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_database_saveButtonActionPerformed
        // TODO add your handling code here:
         JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("xml","XML");
                 chooser.setFileFilter(filter);
                 
                 int returnVal = chooser.showSaveDialog(null);
                 
                    if(returnVal == JFileChooser.APPROVE_OPTION) {
                            theController.SaveDatabaseAs(chooser.getSelectedFile());
                    }
    
    }//GEN-LAST:event_database_saveButtonActionPerformed

    private void Database_CloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Database_CloseButtonActionPerformed
        // TODO add your handling code here:
        if(theController.closeDatabase()){
        Enumeration<AbstractButton> elements = databaseRequired.getElements();
        
            while(elements.hasMoreElements()){
                
                    elements.nextElement().getModel().setEnabled(false);
            }
        }

    }//GEN-LAST:event_Database_CloseButtonActionPerformed

    private void database_newConnectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_database_newConnectButtonActionPerformed
        // TODO add your handling code here:
           JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("","db");
                 chooser.setFileFilter(filter);
                 
                 int returnVal = chooser.showOpenDialog(null);
                 
                    if(returnVal == JFileChooser.APPROVE_OPTION) {
                        
                        if(theController.openNewDataBase(chooser.getSelectedFile())){
                            Enumeration<AbstractButton> elements = databaseRequired.getElements();
                            
                            while(elements.hasMoreElements()){
                               
                                
                                elements.nextElement().getModel().setEnabled(true);
                            }
                        }
                    }
                    
                   
    
    }//GEN-LAST:event_database_newConnectButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        // TODO add your handling code here:
        theController.exitProgram();
    }//GEN-LAST:event_exitButtonActionPerformed

    private void aboutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutButtonActionPerformed
        // TODO add your handling code here:
        theController.openAboutDialog(this);
    }//GEN-LAST:event_aboutButtonActionPerformed
    protected void update(){
        if(theController==null) theController = new Modeling();
        if(theController.getSelectedBook()!=null){
            this.page_viewListButton.setEnabled(true);
        }
        else{
            this.page_viewListButton.setEnabled(false);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
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
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Database_CloseButton;
    private javax.swing.JButton aboutButton;
    private javax.swing.JLabel bookLabel;
    private javax.swing.JButton book_addBookButton;
    private javax.swing.JButton book_searchButton;
    private javax.swing.JButton book_viewListButton;
    private javax.swing.JLabel databaseLabel;
    private javax.swing.ButtonGroup databaseRequired;
    private javax.swing.JButton database_newConnectButton;
    private javax.swing.JButton database_viewButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel pageLabel;
    private javax.swing.JButton page_addPageButton;
    private javax.swing.JButton page_searchPageButton;
    private javax.swing.JButton page_viewListButton;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
