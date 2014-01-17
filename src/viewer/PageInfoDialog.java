
package viewer;

import javax.swing.JDialog;


/**
 *
 * @author brianyang
 */
public class PageInfoDialog extends JDialog {

  
   public PageInfoDialog() {
        initComponents();
    }
    
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jTextField1 = new javax.swing.JTextField();
        titleLabel = new javax.swing.JLabel();
        pageIDLabel = new javax.swing.JLabel();
        pageIDField = new javax.swing.JTextField();
        IDStatus = new javax.swing.JLabel();
        pageTitleLabel = new javax.swing.JLabel();
        pageTitleField = new javax.swing.JTextField();
        nameStatus = new javax.swing.JLabel();
        bookCodeLabel = new javax.swing.JLabel();
        bookCodeField = new javax.swing.JTextField();
        codeStatus = new javax.swing.JLabel();
        pageNumLabel = new javax.swing.JLabel();
        pageNumField = new javax.swing.JTextField();
        pageNumStatus = new javax.swing.JLabel();
        submitButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        titleLabel.setFont(new java.awt.Font("Wawati TC", 0, 36)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        titleLabel.setText("Page Info");
        titleLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        getContentPane().add(titleLabel, gridBagConstraints);

        pageIDLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        pageIDLabel.setLabelFor(pageIDField);
        pageIDLabel.setText("Page ID : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(pageIDLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.weightx = 2.0;
        getContentPane().add(pageIDField, gridBagConstraints);

        IDStatus.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        IDStatus.setText("* required");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(IDStatus, gridBagConstraints);

        pageTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        pageTitleLabel.setLabelFor(pageTitleField);
        pageTitleLabel.setText("Page Title:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(pageTitleLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.weightx = 2.0;
        getContentPane().add(pageTitleField, gridBagConstraints);

        nameStatus.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        nameStatus.setText("* required");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(nameStatus, gridBagConstraints);

        bookCodeLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        bookCodeLabel.setLabelFor(bookCodeField);
        bookCodeLabel.setText("Book Code : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(bookCodeLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.weightx = 2.0;
        getContentPane().add(bookCodeField, gridBagConstraints);

        codeStatus.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        codeStatus.setText("* required");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(codeStatus, gridBagConstraints);

        pageNumLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        pageNumLabel.setLabelFor(pageNumField);
        pageNumLabel.setText("Page Number : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(pageNumLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.weightx = 2.0;
        getContentPane().add(pageNumField, gridBagConstraints);

        pageNumStatus.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        pageNumStatus.setText("* required");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(pageNumStatus, gridBagConstraints);

        submitButton.setText("Submit");
        submitButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 13, 10, 27);
        getContentPane().add(submitButton, gridBagConstraints);

        cancelButton.setText("Cancel");
        cancelButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 11);
        getContentPane().add(cancelButton, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

   

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IDStatus;
    private javax.swing.JTextField bookCodeField;
    private javax.swing.JLabel bookCodeLabel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel codeStatus;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel nameStatus;
    private javax.swing.JTextField pageIDField;
    private javax.swing.JLabel pageIDLabel;
    private javax.swing.JTextField pageNumField;
    private javax.swing.JLabel pageNumLabel;
    private javax.swing.JLabel pageNumStatus;
    private javax.swing.JTextField pageTitleField;
    private javax.swing.JLabel pageTitleLabel;
    private javax.swing.JButton submitButton;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
