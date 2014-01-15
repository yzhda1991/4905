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
import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;

/**
 *
 * @author brianyang
 */
public class BookInfoDialog extends javax.swing.JDialog {

 
    
    dialogClient            thedialogClient;
    Book                    theBook;
    dialogClient.operation  mode;
    Frame                   thisframe;
    FocusListener           textFieldListener;
    FocusListener           numberFieldListener;
    boolean                 errorfound = false;
  
    //
    public BookInfoDialog(dialogClient client,Frame parent,String title, Book b, dialogClient.operation aoperation,boolean modal){
        super(parent,"Book info",modal);
        thisframe = parent;
        thedialogClient =client;
        mode =aoperation;
        theBook = b;
        initEnvironment();
        titleLabel.setText(title);
    }
    
    @Override
    public void setTitle(String t){
        titleLabel.setText(t);
    }
    public void updateMode(dialogClient.operation amode){
        mode =amode;
    }
    public void setBook(Book b){
        theBook =b;
    }
    

    //
    private  void initEnvironment(){
        
        initComponents();
        
        //change the submit button text cosponding to the opertion;
        submitButton.setText(mode.toString());
       
        
        //build GUI with book info if thebook is not Null;
        //otherwise build GUI with empty book info
       
        if(theBook== null){
            
            bookCodeField.setText(null);
            bookNameField.setText(null);
            bookPathField.setText(null);
            bookAuthorField.setText(null);
            pageNumField.setText(null);
        }
        else {
            
            bookCodeField.setText(theBook.getBookCode());
            bookNameField.setText(theBook.getBookName());
            bookPathField.setText(theBook.getBookPath());
            bookAuthorField.setText(theBook.getAuthor());
            pageNumField.setText(theBook.getInitPage()+"");
        }
        
        //define the FocusListener for textfiled and numberfiled;
        textFieldListener = new FocusListener(){
            
            @Override
            public void focusGained(FocusEvent e) {
                final JTextComponent c = (JTextComponent)e.getSource(); 
                 c.setForeground(new java.awt.Color(153, 204, 255));
                if (c.equals(bookNameField))   nameStatus.setText("book code should be 3-20 charaters !");
                else if (c.equals(bookCodeField))   codeStatus.setText("book code should be 4-10 characters  !");
                else if (c.equals(bookPathField))    pathStatus.setText("please enter a full book path !");
                else if (c.equals(bookAuthorField)) authorStatus.setText("book code should be 10-20characters !");
                
                  }

            @Override
            public void focusLost(FocusEvent e) {
            if(!e.isTemporary()){
                
                final JTextComponent c = (JTextComponent) e.getSource();
                String s = c.getText();
                if(e.isTemporary()) return;
                
                else if (s.length()<2){
                    c.setForeground(Color.red);
                    
                if (c.equals(bookNameField))   nameStatus.setText("book code is in vaild !");
                else if (c.equals(bookCodeField))   codeStatus.setText("book code is invaild !");
                else if (c.equals(bookPathField))    pathStatus.setText("book path is invaild !");
                else if (c.equals(bookAuthorField)) authorStatus.setText("book author is invaild !");
                     if(!errorfound)errorfound = true;
                }
                
                else{
                     if (c.equals(bookNameField))   nameStatus.setText("vaild book name!");
                else if (c.equals(bookCodeField))   codeStatus.setText("vaild book code");
                else if (c.equals(bookPathField))    pathStatus.setText("vaild book path");
                else if (c.equals(bookAuthorField)) authorStatus.setText("vaild book author");
                     if(errorfound)errorfound = false;
                }
            }
        }
            
        };
                
        numberFieldListener =new FocusListener(){

            @Override
            public void focusGained(FocusEvent e) {
                 final JTextComponent c = (JTextComponent)e.getSource();
                 c.setForeground(new java.awt.Color(153, 204, 255));
                if (c.equals(pageNumField))   pageNumStatus.setText("number only");
                }

            @Override
            public void focusLost(FocusEvent e) {
                int num =0;
                if(!e.isTemporary()){
                final JTextComponent c = (JTextComponent) e.getSource();
                String s = c.getText();
                if(e.isTemporary()) return;
                
                try{
                    num = Integer.parseInt(s);
                     if (c.equals(pageNumField))   pageNumStatus.setText("vaild book page number");
                    if(errorfound)errorfound = false;
               
                }catch(java.lang.NumberFormatException nfe){
                     if (c.equals(pageNumField))   pageNumStatus.setText("page number is invaild ");
                     if(!errorfound)errorfound = true;
                }
            }
            }
            
        };
         
        enableFocusLost();
        
        this.setSize(600,250);
        this.setResizable(false);
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
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 100);
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

    //add FoucusLost to all textFiled;
    private void enableFocusLost(){
        
        bookNameField.addFocusListener(textFieldListener);
        bookCodeField.addFocusListener(textFieldListener);
        bookPathField.addFocusListener(textFieldListener);
        bookAuthorField.addFocusListener(textFieldListener);
        pageNumField.addFocusListener(numberFieldListener);
    }
    
    //remove FocusLost from all textField;
    private void disableForcusLost(){
        
        bookNameField.removeFocusListener(textFieldListener);
        bookCodeField.removeFocusListener(textFieldListener);
        bookPathField.removeFocusListener(textFieldListener);
        bookAuthorField.removeFocusListener(textFieldListener);
        pageNumField.removeFocusListener(numberFieldListener);
    }
    
    //Action performs when user clicked Submit button
    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
          disableForcusLost();
          if(errorfound){
              JOptionPane.showMessageDialog(this," form complete with error input!,please try again");
              return;
          }
             else if(mode.equals(dialogClient.operation.ADD) ){
          
            //if there is no error found in the form, create book with book info;
            //if thebook is empty object, create new Book with book info provided;
            //otherwise update theBook info cosponding the book info provide;
         

                     theBook.setBookName(bookNameField.getText());
                     theBook.setBookCode(bookCodeField.getText());
                     theBook.setBookPath(bookPathField.getText());
                     theBook.setAuthor(bookAuthorField.getText());
                     theBook.setPage(Integer.parseInt(pageNumField.getText()));
                 
          
            }

   
            else if(mode.equals(dialogClient.operation.UPDATE) ){
          
            //if there is no error found in the form, create book with book info;
            //if thebook is empty object, create new Book with book info provided;
            //otherwise update theBook info cosponding the book info provide;
         

                     theBook.setBookName(bookNameField.getText());
                     theBook.setBookCode(bookCodeField.getText());
                     theBook.setBookPath(bookPathField.getText());
                     theBook.setAuthor(bookAuthorField.getText());
                     theBook.setPage(Integer.parseInt(pageNumField.getText()));
                 
            
            }
            if(thedialogClient !=null)thedialogClient.bookDialogFinished(mode);      
                dispose();
    }//GEN-LAST:event_submitButtonActionPerformed

    
    //action perfoms when user clicked Cancel button;
    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        
        //finished the dialog with dialogCancelled massage;
        //dispose dialog;
        if(thedialogClient !=null) thedialogClient.dialogCancelled();
        dispose();
        
    }//GEN-LAST:event_CancelButtonActionPerformed

   
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
