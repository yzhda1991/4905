/*
 * Carleton University - School of Computer Science Honours Project 
 * Winter 2014
 * PDF Book Organizer and page Viewer
 * AUTHOR: Zhangda Yang
 * SUPERVISOR: Professor Louis Nel
 * 
 */
package carleton.edu.comp4905.honourproject.model;

import carleton.edu.comp4905.honourproject.main.Page;
import java.awt.Frame;
import java.util.Arrays;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * this class represents view of page info dialog
 *
 * @author zhangda yang
 */
public class PageInfoDialog extends javax.swing.JDialog {

    private final Controller theController;
    private Page editedPage;
    private Controller.operation mode;
    private Frame thisframe;
    private DocumentListener theDocumentListener;
    private final int MINSTRINGLENGTH = 5;
    private final int MAXSTRINGLENGTH = 20;
    private boolean[] formchecker = null;

    // constructor
    public PageInfoDialog(java.awt.Frame parent, String title, Controller theclient, Page p, Controller.operation aopertion, boolean modal) {
        super(parent, "page info", modal);
        theController = theclient;
        editedPage = p;
        mode = aopertion;
        initEnvironment();
        titleLabel.setText(title);
    }
    // update component of view

    private void initEnvironment() {
        initComponents();

        //change the submit button text cosponding to the opertion;
        submitButton.setText(mode.toString());
        pageIDField.setEditable(false);

        //build GUI with book info if thePage is not Null;
        //otherwise build GUI with empty book info
        if (editedPage == null) {
            pageIDField.setText(null);
            if (theController != null) {
                bookCodeField.setSelectedItem(theController.getSelectedBook().getBookCode());
            } else {
                bookCodeField.setSelectedItem(null);
            }
            pageTitleField.setText(null);
            pageNumField.setText(null);
            formchecker = new boolean[2];
            Arrays.fill(formchecker, Boolean.FALSE);

        } else {
            pageIDField.setText(editedPage.getPageID() + "");
            bookCodeField.setSelectedItem(editedPage.getBookCode());
            pageTitleField.setText(editedPage.getPageTitle());
            pageNumField.setText(editedPage.getPageNum() + "");

            formchecker = new boolean[2];
            Arrays.fill(formchecker, Boolean.TRUE);

        }

        theDocumentListener = new DocumentListener() {
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
        pageTitleField.getDocument().addDocumentListener(theDocumentListener);
        pageNumField.getDocument().addDocumentListener(theDocumentListener);

        this.setSize(600, 250);
        this.setResizable(false);
    }
    // Violated form input elements

    private void formVaildation(DocumentEvent e) {
        if (e.getDocument().equals(pageTitleField.getDocument())) {

            if (pageTitleField.getText().trim().length() < MINSTRINGLENGTH || pageTitleField.getText().trim().length() > MAXSTRINGLENGTH) {
                nameStatus.setText("page Title should be 5-20 charaters !");
                if (formchecker[0] == true) {
                    formchecker[0] = false;
                }
            } else {
                nameStatus.setText("vaild page Title.");
                if (formchecker[0] == false) {
                    formchecker[0] = true;
                }
            }
        } else if (e.getDocument().equals(pageNumField.getDocument())) {
            if (pageNumField.getText().trim().length() < 1) {
                pageNumStatus.setText("input is empty!");
                if (formchecker[1] == true) {
                    formchecker[1] = false;
                }
            } else {
                try {
                    int num = Integer.valueOf(pageNumField.getText().trim());
                    if (num > 0) {
                        pageNumStatus.setText("valild page Number.");
                        if (formchecker[1] == false) {
                            formchecker[1] = true;
                        }
                    }

                } catch (java.lang.NumberFormatException nfe) {
                    pageNumStatus.setText("input is not a Integer!");
                    if (formchecker[1] == true) {
                        formchecker[1] = false;
                    }

                }
            }
        }
    }
    // initialized components and view layout
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
        codeStatus = new javax.swing.JLabel();
        pageNumLabel = new javax.swing.JLabel();
        pageNumField = new javax.swing.JTextField();
        pageNumStatus = new javax.swing.JLabel();
        submitButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        bookCodeField = new javax.swing.JComboBox();
        description = new javax.swing.JTextArea();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 400));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        titleLabel.setFont(new java.awt.Font("Wawati TC", 0, 36)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        titleLabel.setText("Page Info");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(titleLabel, gridBagConstraints);

        pageIDLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        pageIDLabel.setLabelFor(pageIDField);
        pageIDLabel.setText("Page ID : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(pageIDLabel, gridBagConstraints);

        pageIDField.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.weightx = 2.0;
        getContentPane().add(pageIDField, gridBagConstraints);

        IDStatus.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        IDStatus.setText("*Auto Complete");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(IDStatus, gridBagConstraints);

        pageTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        pageTitleLabel.setLabelFor(pageTitleField);
        pageTitleLabel.setText("Page Title:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(pageTitleLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.weightx = 2.0;
        getContentPane().add(pageTitleField, gridBagConstraints);

        nameStatus.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        nameStatus.setText("* required");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(nameStatus, gridBagConstraints);

        bookCodeLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        bookCodeLabel.setLabelFor(bookCodeField);
        bookCodeLabel.setText("Book Code : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(bookCodeLabel, gridBagConstraints);

        codeStatus.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        codeStatus.setText("* required");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(codeStatus, gridBagConstraints);

        pageNumLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        pageNumLabel.setLabelFor(pageNumField);
        pageNumLabel.setText("Page Number : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(pageNumLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.weightx = 2.0;
        getContentPane().add(pageNumField, gridBagConstraints);

        pageNumStatus.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        pageNumStatus.setText("* required");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(pageNumStatus, gridBagConstraints);

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
        gridBagConstraints.insets = new java.awt.Insets(10, 13, 10, 27);
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
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 11);
        getContentPane().add(cancelButton, gridBagConstraints);

        bookCodeField.setModel(
            new javax.swing.DefaultComboBoxModel(theController.getbookCode()));
        bookCodeField.setSelectedItem(" ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 15;
        getContentPane().add(bookCodeField, gridBagConstraints);

        description.setColumns(12);
        description.setRows(5);
        description.setText("please enter your page information below:\npageID : the index number in Database\nPage Title: title of the Page\nBook Code: book code for the book that the page is from");
        description.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        description.setFocusable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(description, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // action perfumes when user clicked submit button
    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed

        //if(errorfound){
        // JOptionPane.showMessageDialog(this," form complete with error input!,please try again");
        // return;
        //}
        if (mode.equals(Controller.operation.ADD)) {

            //if there is no error found in the form, create book with book info;
            //if thePage is empty object, create new Book with book info provided;
            //otherwise update thePage info cosponding the book info provide;
            editedPage = new Page(pageTitleField.getText().trim(),
                    String.valueOf((String) bookCodeField.getSelectedItem()),
                    Integer.parseInt(pageNumField.getText()));


        } else if (mode.equals(Controller.operation.UPDATE)) {

            //if there is no error found in the form, create book with book info;
            //if thePage is empty object, create new Book with book info provided;
            //otherwise update thePage info cosponding the book info provide;
            editedPage.setPageTitle(pageTitleField.getText());
            editedPage.setBookCode(this.bookCodeField.getSelectedItem().toString());
            editedPage.setPageNum(Integer.parseInt(pageNumField.getText()));


        }
        if (theController != null) {
            theController.closePageInfoDialog(mode, editedPage);
        }

        this.setVisible(false);
        dispose();


    }//GEN-LAST:event_submitButtonActionPerformed
    // action perfumes when user clicked cancel button
private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
// TODO add your handling code here:
    if (theController != null) {
        theController.closePageInfoDialog(null, editedPage);
    }
    dispose();
}//GEN-LAST:event_CancelButtonActionPerformed
    // update page info and operation mode

    protected void updateInfo(Page p, Controller.operation aopertion) {
        if (!mode.equals(aopertion)) {

            mode = aopertion;
            submitButton.setText(mode.toString());
        }

        editedPage = p;
        if (editedPage == null) {

            titleLabel.setText(" ");
            pageIDField.setText(null);
            bookCodeField.setSelectedItem(null);
            pageTitleField.setText(null);
            pageNumField.setText(null);

        } else {
            titleLabel.setText(mode.toString() + ": " + editedPage.toString());
            pageIDField.setText(editedPage.getPageID() + "");
            bookCodeField.setSelectedItem(editedPage.getBookCode());
            pageTitleField.setText(editedPage.getPageTitle());
            pageNumField.setText(editedPage.getPageNum() + "");
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IDStatus;
    private javax.swing.JComboBox bookCodeField;
    private javax.swing.JLabel bookCodeLabel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel codeStatus;
    private javax.swing.JTextArea description;
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
