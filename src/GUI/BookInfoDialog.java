/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import bookviewer.Book;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.lang.NullPointerException;
import java.text.NumberFormat;
import java.text.ParseException;
import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;

/**
 *
 * @author brianyang
 */
public class BookInfoDialog extends javax.swing.JDialog {

    /**
     * Creates new form BookInforDialog
     */
    
    dialogClient thedialogClient;
    Book theBook;
    dialogClient.operation mode;
    Frame thisframe;
    FocusListener textFieldListener;
    FocusListener  numberFieldListener;
 
    public BookInfoDialog(dialogClient client,Frame parent,String title, Book b, dialogClient.operation aoperation,boolean modal){
        super(parent,title,modal);
        thisframe = parent;
        thedialogClient =client;
        mode =aoperation;
        theBook = b;
        initComponents();
        buildbookInfo(theBook);
        submitButton.setText(mode.toString());
        initFocusLost();
        enableFocusLost();
        this.setSize(500,300);
        this.setResizable(false);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jTextField1 = new javax.swing.JTextField();
        titleLabel = new javax.swing.JLabel();
        bookNameLabel = new javax.swing.JLabel();
        bookCodeLabel = new javax.swing.JLabel();
        bookAuthorLabel = new javax.swing.JLabel();
        bookIDLabel = new javax.swing.JLabel();
        bookPathLabel = new javax.swing.JLabel();
        bookIDField = new javax.swing.JTextField();
        bookNameField = new javax.swing.JTextField();
        bookCodeField = new javax.swing.JTextField();
        bookAuthorField = new javax.swing.JTextField();
        bookPathField = new javax.swing.JTextField();
        nameStatus = new javax.swing.JLabel();
        pathStatus = new javax.swing.JLabel();
        IDStatus = new javax.swing.JLabel();
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
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        getContentPane().add(titleLabel, gridBagConstraints);

        bookNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        bookNameLabel.setLabelFor(bookNameField);
        bookNameLabel.setText("Book Name : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 25, 0, 0);
        getContentPane().add(bookNameLabel, gridBagConstraints);

        bookCodeLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        bookCodeLabel.setLabelFor(bookCodeField);
        bookCodeLabel.setText("Book Code : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 25, 0, 0);
        getContentPane().add(bookCodeLabel, gridBagConstraints);

        bookAuthorLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        bookAuthorLabel.setLabelFor(bookAuthorField);
        bookAuthorLabel.setText("Book Author : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 25, 0, 0);
        getContentPane().add(bookAuthorLabel, gridBagConstraints);

        bookIDLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        bookIDLabel.setLabelFor(bookIDField);
        bookIDLabel.setText("Book ID : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 25, 0, 0);
        getContentPane().add(bookIDLabel, gridBagConstraints);

        bookPathLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        bookPathLabel.setLabelFor(bookPathField);
        bookPathLabel.setText("Book Path : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 25, 0, 0);
        getContentPane().add(bookPathLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.weightx = 2.0;
        getContentPane().add(bookIDField, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.weightx = 2.0;
        getContentPane().add(bookNameField, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.weightx = 2.0;
        getContentPane().add(bookCodeField, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.weightx = 2.0;
        getContentPane().add(bookAuthorField, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.weightx = 2.0;
        getContentPane().add(bookPathField, gridBagConstraints);

        nameStatus.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        nameStatus.setText("* required");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(nameStatus, gridBagConstraints);

        pathStatus.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        pathStatus.setText("* required");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(pathStatus, gridBagConstraints);

        IDStatus.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        IDStatus.setText("* required");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(IDStatus, gridBagConstraints);

        authorStatus.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        authorStatus.setText("* required");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(authorStatus, gridBagConstraints);

        codeStatus.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        codeStatus.setText("* required");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(codeStatus, gridBagConstraints);

        submitButton.setText("Submit");
        submitButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(2, 13, 2, 27);
        getContentPane().add(submitButton, gridBagConstraints);

        cancelButton.setText("Cancel");
        cancelButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });
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
        gridBagConstraints.insets = new java.awt.Insets(0, 25, 0, 0);
        getContentPane().add(pageNumLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.weightx = 2.0;
        getContentPane().add(pageNumField, gridBagConstraints);

        pageNumStatus.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        pageNumStatus.setText("* required");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(pageNumStatus, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void initFocusLost(){
        textFieldListener = new FocusListener(){
            
            @Override
            public void focusGained(FocusEvent e) {
                final JTextComponent c = (JTextComponent)e.getSource(); 
                c.setForeground(Color.BLACK);
                
                  }

            @Override
            public void focusLost(FocusEvent e) {
            if(!e.isTemporary()){
                final JTextComponent c = (JTextComponent) e.getSource();
                String s = c.getText();
                if(e.isTemporary()) return;
                else if (s.length()<2){
                    c.setForeground(Color.red);
                if (c.equals(bookNameField))   nameStatus.setText("input is too Short !");
                else if (c.equals(bookCodeField))   codeStatus.setText("input is too Short !");
                else if (c.equals(bookPathField))    pathStatus.setText("input is too Short !");
                else if (c.equals(bookAuthorField)) authorStatus.setText("input is too Short !");
                }
          
            }
        }
        };
                
        numberFieldListener =new FocusListener(){

            @Override
            public void focusGained(FocusEvent e) {
                 final JTextComponent c = (JTextComponent)e.getSource();
                 c.setForeground(new java.awt.Color(153, 204, 255));
                }

            @Override
            public void focusLost(FocusEvent e) {
                int num =0;
                NumberFormat numberFormat = NumberFormat.getNumberInstance();
                numberFormat.setParseIntegerOnly(true);
                if(!e.isTemporary()){
                final JTextComponent c = (JTextComponent) e.getSource();
                String s = c.getText();
                if(e.isTemporary()) return;
                
                try{
                    num = numberFormat.parse(s).intValue();
                    
                }catch(ParseException pe){
                    pe.printStackTrace();
                }
            }
            }
            
        };
    }
    private void enableFocusLost(){
        bookIDField.addFocusListener(numberFieldListener);
        bookNameField.addFocusListener(textFieldListener);
        bookCodeField.addFocusListener(textFieldListener);
    }
    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        // TODO add your handling code here:
      
    }//GEN-LAST:event_submitButtonActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        // TODO add your handling code here:
        if(thedialogClient !=null) thedialogClient.dialogCancelled();
        dispose();
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void buildbookInfo(Book b){
        if(b== null){
            bookIDField.setText(null);
            bookCodeField.setText(null);
            bookNameField.setText(null);
            bookPathField.setText(null);
            bookAuthorField.setText(null);
        }
        else {
            bookIDField.setText(b.getBookID()+"");
            bookCodeField.setText(b.getBookCode());
            bookNameField.setText(b.getBookName());
            bookPathField.setText(b.getBookPath());
            bookAuthorField.setText(b.getAuthor());
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IDStatus;
    private javax.swing.JLabel authorStatus;
    private javax.swing.JTextField bookAuthorField;
    private javax.swing.JLabel bookAuthorLabel;
    private javax.swing.JTextField bookCodeField;
    private javax.swing.JLabel bookCodeLabel;
    private javax.swing.JTextField bookIDField;
    private javax.swing.JLabel bookIDLabel;
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
