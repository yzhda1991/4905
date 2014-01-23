
package model;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import main.Controller;
import main.ViewBooksMain;

/**
 *
 * @author byang1
 */
public class MainFrame extends JFrame {
    
       private Controller  theController ;

    /** Creates new form MainFrame */
    public MainFrame(String title, Controller c) {
        super(title);
        theController = c;
        initComponents();
        
        
        this.addWindowListener(new WindowAdapter(){
              public void WindowClosing(WindowEvent e){
                  if(theController !=null)theController.exitProgram();
                  else System.exit(0);
              }
         });
    }

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        databaseViewButton = new javax.swing.JButton();
        BookTitleLabel = new javax.swing.JLabel();
        addNewBookButton = new javax.swing.JButton();
        viewBookListButton = new javax.swing.JButton();
        searchBookListButton = new javax.swing.JButton();
        pageTitleLabel = new javax.swing.JLabel();
        addNewPageButton = new javax.swing.JButton();
        searchPageButton = new javax.swing.JButton();
        viewPageListButton = new javax.swing.JButton();
        databaselabel = new javax.swing.JLabel();
        executeButton = new javax.swing.JButton();
        viewDatabase = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        helpButton = new javax.swing.JButton();
        aboutButton = new javax.swing.JButton();

        databaseViewButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        databaseViewButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/book.png"))); // NOI18N
        databaseViewButton.setText("View Database");
        databaseViewButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        databaseViewButton.setIconTextGap(6);
        databaseViewButton.setMaximumSize(new java.awt.Dimension(128, 128));
        databaseViewButton.setMinimumSize(new java.awt.Dimension(64, 64));
        databaseViewButton.setName(""); // NOI18N
        databaseViewButton.setPreferredSize(new java.awt.Dimension(128, 128));
        databaseViewButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("MainFrame"); // NOI18N
        getContentPane().setLayout(new java.awt.GridBagLayout());

        BookTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BookTitleLabel.setText("BOOK");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(BookTitleLabel, gridBagConstraints);

        addNewBookButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        addNewBookButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/book.png"))); // NOI18N
        addNewBookButton.setText("Add New");
        addNewBookButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addNewBookButton.setIconTextGap(6);
        addNewBookButton.setMaximumSize(new java.awt.Dimension(128, 128));
        addNewBookButton.setMinimumSize(new java.awt.Dimension(64, 64));
        addNewBookButton.setName(""); // NOI18N
        addNewBookButton.setPreferredSize(new java.awt.Dimension(128, 128));
        addNewBookButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        addNewBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewBookButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(addNewBookButton, gridBagConstraints);

        viewBookListButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        viewBookListButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/book.png"))); // NOI18N
        viewBookListButton.setText("view book List");
        viewBookListButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        viewBookListButton.setIconTextGap(6);
        viewBookListButton.setMaximumSize(new java.awt.Dimension(128, 128));
        viewBookListButton.setMinimumSize(new java.awt.Dimension(64, 64));
        viewBookListButton.setName(""); // NOI18N
        viewBookListButton.setPreferredSize(new java.awt.Dimension(128, 128));
        viewBookListButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        viewBookListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewBookListButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(viewBookListButton, gridBagConstraints);

        searchBookListButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        searchBookListButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/book.png"))); // NOI18N
        searchBookListButton.setText("Search book");
        searchBookListButton.setToolTipText("search Book List");
        searchBookListButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        searchBookListButton.setIconTextGap(6);
        searchBookListButton.setMaximumSize(new java.awt.Dimension(128, 128));
        searchBookListButton.setMinimumSize(new java.awt.Dimension(64, 64));
        searchBookListButton.setName(""); // NOI18N
        searchBookListButton.setPreferredSize(new java.awt.Dimension(128, 128));
        searchBookListButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(searchBookListButton, gridBagConstraints);

        pageTitleLabel.setText("PAGE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(pageTitleLabel, gridBagConstraints);

        addNewPageButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        addNewPageButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/book.png"))); // NOI18N
        addNewPageButton.setText("Add New");
        addNewPageButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addNewPageButton.setIconTextGap(6);
        addNewPageButton.setMaximumSize(new java.awt.Dimension(128, 128));
        addNewPageButton.setMinimumSize(new java.awt.Dimension(64, 64));
        addNewPageButton.setName(""); // NOI18N
        addNewPageButton.setPreferredSize(new java.awt.Dimension(128, 128));
        addNewPageButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        addNewPageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewPageButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(addNewPageButton, gridBagConstraints);

        searchPageButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        searchPageButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/book.png"))); // NOI18N
        searchPageButton.setText("Search Page");
        searchPageButton.setToolTipText("search Book List");
        searchPageButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        searchPageButton.setIconTextGap(6);
        searchPageButton.setMaximumSize(new java.awt.Dimension(128, 128));
        searchPageButton.setMinimumSize(new java.awt.Dimension(64, 64));
        searchPageButton.setName(""); // NOI18N
        searchPageButton.setPreferredSize(new java.awt.Dimension(128, 128));
        searchPageButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(searchPageButton, gridBagConstraints);

        viewPageListButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        viewPageListButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/book.png"))); // NOI18N
        viewPageListButton.setText("view Page List");
        viewPageListButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        viewPageListButton.setIconTextGap(6);
        viewPageListButton.setMaximumSize(new java.awt.Dimension(128, 128));
        viewPageListButton.setMinimumSize(new java.awt.Dimension(64, 64));
        viewPageListButton.setName(""); // NOI18N
        viewPageListButton.setPreferredSize(new java.awt.Dimension(128, 128));
        viewPageListButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        viewPageListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewPageListButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(viewPageListButton, gridBagConstraints);

        databaselabel.setText("DATABASE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(databaselabel, gridBagConstraints);

        executeButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        executeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/book.png"))); // NOI18N
        executeButton.setText("Execulte SQL Comand");
        executeButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        executeButton.setIconTextGap(6);
        executeButton.setMaximumSize(new java.awt.Dimension(128, 128));
        executeButton.setMinimumSize(new java.awt.Dimension(64, 64));
        executeButton.setName(""); // NOI18N
        executeButton.setPreferredSize(new java.awt.Dimension(128, 128));
        executeButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(executeButton, gridBagConstraints);

        viewDatabase.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        viewDatabase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/book.png"))); // NOI18N
        viewDatabase.setText("Search book");
        viewDatabase.setToolTipText("search Book List");
        viewDatabase.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        viewDatabase.setIconTextGap(6);
        viewDatabase.setMaximumSize(new java.awt.Dimension(128, 128));
        viewDatabase.setMinimumSize(new java.awt.Dimension(64, 64));
        viewDatabase.setName(""); // NOI18N
        viewDatabase.setPreferredSize(new java.awt.Dimension(128, 128));
        viewDatabase.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(viewDatabase, gridBagConstraints);

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(exitButton, gridBagConstraints);

        helpButton.setText("Help");
        helpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        getContentPane().add(helpButton, gridBagConstraints);

        aboutButton.setText("About Program");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        getContentPane().add(aboutButton, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addNewBookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewBookButtonActionPerformed
        theController.closeBookInfoDialog(null);
    }//GEN-LAST:event_addNewBookButtonActionPerformed

    private void viewBookListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewBookListButtonActionPerformed
        theController.OpenBookListFrame();
    }//GEN-LAST:event_viewBookListButtonActionPerformed

    private void addNewPageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewPageButtonActionPerformed
        theController.openPageInfoDialog(null);
    }//GEN-LAST:event_addNewPageButtonActionPerformed

    private void viewPageListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewPageListButtonActionPerformed
        theController.openPageListFrame(null);
    }//GEN-LAST:event_viewPageListButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        theController.exitProgram();
    }//GEN-LAST:event_exitButtonActionPerformed

    private void helpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_helpButtonActionPerformed

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
               ViewBooksMain view = new ViewBooksMain();
                new MainFrame("Book Viewer",view).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BookTitleLabel;
    private javax.swing.JButton aboutButton;
    private javax.swing.JButton addNewBookButton;
    private javax.swing.JButton addNewPageButton;
    private javax.swing.JButton databaseViewButton;
    private javax.swing.JLabel databaselabel;
    private javax.swing.JButton executeButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton helpButton;
    private javax.swing.JLabel pageTitleLabel;
    private javax.swing.JButton searchBookListButton;
    private javax.swing.JButton searchPageButton;
    private javax.swing.JButton viewBookListButton;
    private javax.swing.JButton viewDatabase;
    private javax.swing.JButton viewPageListButton;
    // End of variables declaration//GEN-END:variables
}
