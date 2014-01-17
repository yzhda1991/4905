/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viewer;

/**
 *
 * @author brianyang
 */
public class BookInfoDialog extends javax.swing.JDialog {

    public BookInfoDialog(){
        initComponents();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jTextField1 = new javax.swing.JTextField();
        titleLabel = new javax.swing.JLabel();
        bookNameLabel = new javax.swing.JLabel();
        bookCodeLabel = new javax.swing.JLabel();
        bookAuthorLabel = new javax.swing.JLabel();
        bookPathLabel = new javax.swing.JLabel();
        bookNameField = new javax.swing.JTextField();
        bookCodeField = new javax.swing.JTextField();
        bookAuthorField = new javax.swing.JTextField();
        bookPathField = new javax.swing.JTextField();
        nameStatus = new javax.swing.JLabel();
        pathStatus = new javax.swing.JLabel();
        authorStatus = new javax.swing.JLabel();
        codeStatus = new javax.swing.JLabel();
        submitButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        pageNumLabel = new javax.swing.JLabel();
        pageNumField = new javax.swing.JTextField();
        pageNumStatus = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        titleLabel.setFont(new java.awt.Font("Wawati TC", 0, 36)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        titleLabel.setText("Book Info");
        titleLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        getContentPane().add(titleLabel, gridBagConstraints);

        bookNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        bookNameLabel.setLabelFor(bookNameField);
        bookNameLabel.setText("Book Name : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(bookNameLabel, gridBagConstraints);

        bookCodeLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        bookCodeLabel.setLabelFor(bookCodeField);
        bookCodeLabel.setText("Book Code : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(bookCodeLabel, gridBagConstraints);

        bookAuthorLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        bookAuthorLabel.setLabelFor(bookAuthorField);
        bookAuthorLabel.setText("Book Author : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(bookAuthorLabel, gridBagConstraints);

        bookPathLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        bookPathLabel.setLabelFor(bookPathField);
        bookPathLabel.setText("Book Path : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(bookPathLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(bookNameField, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(bookCodeField, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(bookAuthorField, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(bookPathField, gridBagConstraints);

        nameStatus.setText("* required");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(nameStatus, gridBagConstraints);

        pathStatus.setText("* required");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(pathStatus, gridBagConstraints);

        authorStatus.setText("* required");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(authorStatus, gridBagConstraints);

        codeStatus.setText("* required");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(codeStatus, gridBagConstraints);

        submitButton.setText("Submit");
        submitButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 100);
        getContentPane().add(submitButton, gridBagConstraints);

        cancelButton.setText("Cancel");
        cancelButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 11);
        getContentPane().add(cancelButton, gridBagConstraints);

        pageNumLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        pageNumLabel.setLabelFor(pageNumField);
        pageNumLabel.setText("Start Page Number : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(pageNumLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(pageNumField, gridBagConstraints);

        pageNumStatus.setText("* required");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(pageNumStatus, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel authorStatus;
    private javax.swing.JTextField bookAuthorField;
    private javax.swing.JLabel bookAuthorLabel;
    private javax.swing.JTextField bookCodeField;
    private javax.swing.JLabel bookCodeLabel;
    private javax.swing.JTextField bookNameField;
    private javax.swing.JLabel bookNameLabel;
    private javax.swing.JTextField bookPathField;
    private javax.swing.JLabel bookPathLabel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel codeStatus;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel nameStatus;
    private javax.swing.JTextField pageNumField;
    private javax.swing.JLabel pageNumLabel;
    private javax.swing.JLabel pageNumStatus;
    private javax.swing.JLabel pathStatus;
    private javax.swing.JButton submitButton;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
