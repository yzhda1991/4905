/*
 * Carleton University - School of Computer Science Honours Project 
 * Winter 2014
 * PDF Book Organizer and page Viewer
 * AUTHOR: Zhangda Yang
 * SUPERVISOR: Professor Louis Nel
 * 
 */
package carleton.edu.comp4905.honourproject.model;

import java.awt.*;

/**
 * this class represents view of about dialog
 *
 * @author Zhangda Yang
 */
public class AboutDialog extends javax.swing.JDialog {

    // default constructor
    public AboutDialog(Frame parent, String title, boolean modal) {
        super(parent, title, modal);

        initComponents();
    }

    // initialize view of dialog
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TitleLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        versionLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("AboutDialog"); // NOI18N

        TitleLabel.setFont(new java.awt.Font("Mistral", 0, 48)); // NOI18N
        TitleLabel.setText("BookViewer ");

        jTextArea1.setColumns(20);
        jTextArea1.setEditable(false);
        jTextArea1.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("Product Version: BookViewer v1.0\nDatabase name:\nDatabase type:\nIcePdf version: 5.0\n \n");
        jTextArea1.setEditable(false);
        jScrollPane1.setViewportView(jTextArea1);

        versionLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        versionLabel.setText("Version 1.0");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(TitleLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 197, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(versionLabel))
                    .add(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(layout.createSequentialGroup()
                        .add(24, 24, 24)
                        .add(jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, versionLabel)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, TitleLabel))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel versionLabel;
    // End of variables declaration//GEN-END:variables
}
