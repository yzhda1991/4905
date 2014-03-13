/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Frame;
import java.io.File;
import java.util.Arrays;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import main.Book;

/**
 *
 * @author brianyang
 */
public class BookInfoDialog extends javax.swing.JDialog {

    private static Controller theController;
    private Book theBook;
    private Controller.operation mode;
    private Frame thisframe;

    private DocumentListener textChenageListener;
    private boolean[] formChecker = null;
    private String[] bookCodes = null;

    private final int MAXNAMESTRINGLENGTH = 20;
    private final int MINNAMESTRINGLENGTH = 5;
    private final int MAXCODESTRINGLENGTH = 10;
    private final int MINCODESTRINGLENGTH = 3;
    

    //
    public BookInfoDialog(String title, Frame parent, Controller c, Book b, Controller.operation anOperation, boolean modal) {
        super(parent, title, modal);
        thisframe = parent;
        theController = c;
        mode = anOperation;
        theBook = b;
        initEnvironment();
        titleLabel.setText(title);

    }

    @Override
    public void setTitle(String t) {
        titleLabel.setText(t);
    }

    
    private void initEnvironment() {

        initComponents();
        formChecker = new boolean[5];
        //change the submit button text cosponding to the opertion;
        submitButton.setText(mode.toString());
        if (theController != null) {
            
            bookCodes = theController.getbookCode();
        }
        //build GUI with book info if thebook is not Null;
        //otherwise build GUI with empty book info
        if (theBook == null) {

            bookCodeField.setText(null);
            bookNameField.setText(null);
            bookPathField.setText(null);
            bookAuthorField.setText(null);
            pageNumField.setText(null);
            
             Arrays.fill(formChecker, Boolean.FALSE);
            
        } else {

            bookCodeField.setText(theBook.getBookCode());
            bookNameField.setText(theBook.getBookName());
            bookPathField.setText(theBook.getBookPath());
            bookAuthorField.setText(theBook.getAuthor());
            pageNumField.setText(theBook.getInitPage() + "");
            Arrays.fill(formChecker, Boolean.TRUE);
        }
        
        textChenageListener =new DocumentListener(){

            @Override
            public void insertUpdate(DocumentEvent e) {
                formVaildation(e);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                formVaildation(e);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                formVaildation(e);
            }
            
        };
        
        bookNameField.getDocument().addDocumentListener(textChenageListener);
        bookCodeField.getDocument().addDocumentListener(textChenageListener);
        bookAuthorField.getDocument().addDocumentListener(textChenageListener);
        bookPathField.getDocument().addDocumentListener(textChenageListener);
        pageNumField.getDocument().addDocumentListener(textChenageListener);
    
        this.setSize(600, 250);
        this.setResizable(false);
    }
    
    
    private void formVaildation(DocumentEvent e){
               
                if (e.getDocument().equals(bookNameField.getDocument())) {

                    if (bookNameField.getText().trim().length() < MINNAMESTRINGLENGTH || bookNameField.getText().trim().length() > MAXNAMESTRINGLENGTH) {
                        nameStatus.setText("Book Title should be 5-20 charaters  !");
                        if (formChecker[0] == true) {
                            formChecker[0] = false;
                        }
                    } else {
                        nameStatus.setText("Vaild Book Name!");
                        if (formChecker[0] == false) {
                            formChecker[0] = true;
                        }
                    }
                }else if (e.getDocument().equals(bookCodeField.getDocument())) {
                    String content =bookCodeField.getText().trim().toUpperCase();
                    if (content.length() < MINCODESTRINGLENGTH || content.length() > MAXCODESTRINGLENGTH) {
                        codeStatus.setText("Book Code should be 3-10 characters  !");
                        if (formChecker[1] == true) {
                            formChecker[1] = false;
                        }

                    } else if (bookCodes != null && Arrays.toString(bookCodes).contains(content)) {
                        if(mode.equals(Controller.operation.UPDATE)&&theBook.getBookCode().equalsIgnoreCase(content)){
                            codeStatus.setText("unchanged Book Code!");
                        if (formChecker[1] == false) {
                            formChecker[1] = true;
                        }
                        return;
                        }else{

                        codeStatus.setText("Book Code already exists !");
                        if (formChecker[1] == true) {
                            formChecker[1] = false;
                        }
                    }
                    }else {
                        codeStatus.setText("Vaild Book Code!");
                        if (formChecker[1] == false) {
                            formChecker[1] = true;
                        }
                    }

                } else if (e.getDocument().equals(bookAuthorField.getDocument())) {
                    String content =bookAuthorField.getText().trim();
                     content =bookAuthorField.getText().trim();
                    if (content.length() < MINNAMESTRINGLENGTH || content.length() > MAXNAMESTRINGLENGTH) {
                        authorStatus.setText("book Author should be 5-20 charaters !");
                        if (formChecker[2] == true) {
                            formChecker[2] = false;
                        }
                    } else {
                        authorStatus.setText("vaild book Author!");
                        if (formChecker[2] == false) {
                            formChecker[2] = true;
                        }
                    }
                } else if (e.getDocument().equals(bookPathField.getDocument())) {
                       String content =bookPathField.getText().trim();
                   
                    File temp = new File(content);
                    if (!content.endsWith(".pdf") || !temp.isFile()) {
                        pathStatus.setText("invaild file path ");
                        if (formChecker[3] == true) {
                            formChecker[3] = false;
                        }
                    } else {
                        pathStatus.setText("vaild book path");
                        if (formChecker[3] == false) {
                            formChecker[3] = true;
                        }
                    }

                } else if (e.getDocument().equals(pageNumField.getDocument())) {
                     String content =pageNumField.getText().trim();
                   
                    if (content.length() < 1) {
                        pageNumStatus.setText("Empty Input!");
                        if (formChecker[4] == true) {
                            formChecker[4] = false;
                        }
                    }
                    try {
                        int num = Integer.parseInt(content);
                        if (num > 0) {
                            pageNumStatus.setText("vaild book start page number !");
                            if (formChecker[4] == false) {
                            formChecker[4] = true;
                        }
                        }
                    } catch (java.lang.NumberFormatException nfe) {
                        pageNumStatus.setText("Input is not an Integer!");
                        if (formChecker[4] == true) {
                            formChecker[4] = false;
                        }
                    }
                }

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
        browserButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionText = new javax.swing.JTextArea();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setMinimumSize(new java.awt.Dimension(300, 500));
        setPreferredSize(new java.awt.Dimension(300, 500));
        setResizable(false);
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
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(bookNameField, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(bookCodeField, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(bookAuthorField, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
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
        gridBagConstraints.insets = new java.awt.Insets(0, 100, 0, 7);
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
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 10, 100);
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
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 10, 11);
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
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(pageNumField, gridBagConstraints);

        pageNumStatus.setText("* required");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(pageNumStatus, gridBagConstraints);

        browserButton.setText("browser");
        browserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browserButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(browserButton, gridBagConstraints);

        descriptionText.setEditable(false);
        descriptionText.setColumns(20);
        descriptionText.setRows(5);
        descriptionText.setText("please enter your Book information below:\n\nBook Name: the name of the book;\nBook Code: the book code for the book\nBook Author:  the Author for the book\nBook Path:  the PDF file Path for the book;\nStart Page Number: the number of page before content;");
        descriptionText.setFocusable(false);
        jScrollPane1.setViewportView(descriptionText);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 60;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 10, 10, 10);
        getContentPane().add(jScrollPane1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Action performs when user clicked Submit button
    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed

        if (Arrays.toString(formChecker).contains("f")) {
            JOptionPane.showMessageDialog(this, " form complete with error input!,please try again");
            return;
        } else if (mode.equals(Controller.operation.ADD)) {

            //if there is no error found in the form, create book with book info;
            //if thebook is empty object, create new Book with book info provided;
            //otherwise update theBook info cosponding the book info provide;
            theBook = new Book(bookCodeField.getText(), bookNameField.getText(), bookPathField.getText(), bookAuthorField.getText(), Integer.parseInt(pageNumField.getText()));

        } else if (mode.equals(Controller.operation.UPDATE)) {

            //if there is no error found in the form, create book with book info;
            //if thebook is empty object, create new Book with book info provided;
            //otherwise update theBook info cosponding the book info provide;
            theBook.setBookName(bookNameField.getText());
            theBook.setBookCode(bookCodeField.getText());
            theBook.setBookPath(bookPathField.getText());
            theBook.setAuthor(bookAuthorField.getText());
            theBook.setPage(Integer.parseInt(pageNumField.getText()));

        } else {

        }
        
        if (theController != null) {
                theController.closeBookInfoDialog(mode, theBook);
            }

        this.setVisible(false);
        dispose();


    }//GEN-LAST:event_submitButtonActionPerformed

    //action perfoms when user clicked Cancel button;
    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed

        if (theController != null) {
            theController.closeBookInfoDialog(null, theBook);
        }
        this.setVisible(false);
        dispose();


    }//GEN-LAST:event_CancelButtonActionPerformed

    private void browserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browserButtonActionPerformed

        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("pdf", "PDF");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            bookPathField.setText(chooser.getSelectedFile().getPath());
        }
    }//GEN-LAST:event_browserButtonActionPerformed

    protected void updateInfo(Book b, Controller.operation anOperation) {
        theBook = b;
        if(formChecker==null)formChecker = new boolean[5];
        if (theBook != null) {
            setTitle(theBook.getBookName());

            bookCodeField.setText(theBook.getBookCode());
            bookNameField.setText(theBook.getBookName());
            bookPathField.setText(theBook.getBookPath());
            bookAuthorField.setText(theBook.getAuthor());
            pageNumField.setText(theBook.getInitPage() + "");
            
            Arrays.fill(formChecker, Boolean.TRUE);
        } else {
            setTitle(anOperation.toString() + " ");
            bookCodeField.setText(null);
            bookNameField.setText(null);
            bookPathField.setText(null);
            bookAuthorField.setText(null);
            pageNumField.setText(null);
            Arrays.fill(formChecker, Boolean.FALSE);
            
        }
        submitButton.setText(mode.toString());

    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BookInfoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookInfoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookInfoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookInfoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                Modeling main = new Modeling();
                MainFrame m = new MainFrame("viewer", main);
                new BookInfoDialog("add new book", m, main, null, Controller.operation.ADD, true).setVisible(true);
            }
        });
    }
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
    private javax.swing.JButton browserButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel codeStatus;
    private javax.swing.JTextArea descriptionText;
    private javax.swing.JScrollPane jScrollPane1;
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
