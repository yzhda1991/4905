/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;


import java.awt.*;
import javax.swing.*;
import Source.Book;



public class AddPageDialog extends JDialog {

    DialogClient theClient;
    Book 		 thebook ;
    
    
    public AddPageDialog(Frame owner, DialogClient aclient,Book abook,String title, boolean modal) {
        super(owner,title,modal);
        theClient = aclient;
        thebook= abook;
    	initComponents();
    }
    public AddPageDialog(Frame owner, boolean modal){
    	super(owner,modal);
    	initComponents();
    }
  

      private void initComponents() {

        HeaderPanel = new JPanel();
        titleLabel = new JLabel();
        BookNameLabel = new JLabel();
        ContentPanel = new JPanel();
        IndexLabel = new JLabel();
        IndexField = new JTextField();
        BookCodeLabel = new JLabel();
        BookCodeField = new JTextField();
        PageLabel = new JLabel();
        PageField = new JTextField();
        TitleLabel = new JLabel();
        TitleField = new JTextField();
        BottomPanel = new JPanel();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jButton4 = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));

        titleLabel.setText("Add Pages for Book : ");

        BookNameLabel.setText(thebook.getName());

        GroupLayout HeaderPanelLayout = new GroupLayout(HeaderPanel);
        HeaderPanel.setLayout(HeaderPanelLayout);
        HeaderPanelLayout.setHorizontalGroup(
            HeaderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(HeaderPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(titleLabel)
                .addGap(28, 28, 28)
                .addComponent(BookNameLabel)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        HeaderPanelLayout.setVerticalGroup(
            HeaderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(HeaderPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(HeaderPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(titleLabel)
                    .addComponent(BookNameLabel))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(HeaderPanel);

        IndexLabel.setText("Index");

        IndexField.setText("Index");
        IndexField.setEnabled(false);
        IndexField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IndexFieldActionPerformed(evt);
            }
        });

        BookCodeLabel.setText("BookCode");

        BookCodeField.setText(thebook.getBookCode());
        BookCodeField.setEnabled(false);

        PageLabel.setText("Page");

        PageField.setText("jTextField3");

        TitleLabel.setText("Title");

        TitleField.setText("jTextField4");

        GroupLayout ContentPanelLayout = new GroupLayout(ContentPanel);
        ContentPanel.setLayout(ContentPanelLayout);
        ContentPanelLayout.setHorizontalGroup(
            ContentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(ContentPanelLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(ContentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(BookCodeLabel)
                    .addComponent(PageLabel)
                    .addComponent(IndexLabel)
                    .addComponent(TitleLabel))
                .addGap(23, 23, 23)
                .addGroup(ContentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(IndexField)
                    .addComponent(BookCodeField, GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                    .addComponent(PageField)
                    .addComponent(TitleField))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        ContentPanelLayout.setVerticalGroup(
            ContentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, ContentPanelLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ContentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(IndexField, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(IndexLabel, GroupLayout.Alignment.TRAILING))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ContentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(BookCodeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(BookCodeLabel))
                .addGap(8, 8, 8)
                .addGroup(ContentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(PageField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(PageLabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ContentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(TitleLabel)
                    .addComponent(TitleField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(ContentPanel);

        jButton1.setText("Reset");

        jButton2.setText("Submit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cancel");

        jButton4.setText("Submit and Add Next Page");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        GroupLayout BottomPanelLayout = new GroupLayout(BottomPanel);
        BottomPanel.setLayout(BottomPanelLayout);
        BottomPanelLayout.setHorizontalGroup(
            BottomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, BottomPanelLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap())
        );
        BottomPanelLayout.setVerticalGroup(
            BottomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, BottomPanelLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(BottomPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(jButton4))
                .addContainerGap())
        );

        getContentPane().add(BottomPanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void IndexFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IndexFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IndexFieldActionPerformed

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
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddPageDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddPageDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddPageDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddPageDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddPageDialog dialog = new AddPageDialog(new JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JTextField BookCodeField;
    private JLabel BookCodeLabel;
    private JLabel BookNameLabel;
    private JPanel BottomPanel;
    private JPanel ContentPanel;
    private JPanel HeaderPanel;
    private JTextField IndexField;
    private JLabel IndexLabel;
    private JTextField PageField;
    private JLabel PageLabel;
    private JTextField TitleField;
    private JLabel TitleLabel;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
