
package model;

import main.Page;
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
public class PageInfoDialog extends javax.swing.JDialog {

  
    Controller            theController;
    Page                  editedPage;
    Controller.operation  mode;
    FocusListener           textFieldListener;
    FocusListener           numberFieldListener;
    Frame                   thisframe;
    boolean                 errorfound = false;
    public PageInfoDialog(java.awt.Frame parent, boolean modal) {
        super(parent,"page info", modal);
        initEnvironment();
    }
    
    public PageInfoDialog(java.awt.Frame parent, String title,Controller theclient, Page p,Controller.operation aopertion ,boolean modal) {
        super(parent,"page info", modal);
        theController = theclient;
        editedPage = p;
        mode = aopertion;
        initEnvironment();
        titleLabel.setText(title);
    }
  
    
    private void initEnvironment(){
        initComponents();
        
        //change the submit button text cosponding to the opertion;
        submitButton.setText(mode.toString());
        pageIDField.setEditable(false);
        
        if(mode.equals(Controller.operation.DELETE)){
            //bookCodeField.setEnabled(false);
            pageTitleField.setEnabled(false);
            pageNumField.setEnabled(false);
        }
       
        
        //build GUI with book info if thePage is not Null;
        //otherwise build GUI with empty book info
       
        if(editedPage== null){
            pageIDField.setText(null);
            bookCodeField.setSelectedItem(null);
            pageTitleField.setText(null);
            pageNumField.setText(null);
        }
        else {
            pageIDField.setText(editedPage.getPageID()+"");
            bookCodeField.setSelectedItem(editedPage.getBookCode());
            pageTitleField.setText(editedPage.getPageTitle());
            pageNumField.setText(editedPage.getPageNum()+"");
        }
        
        this.setSize(600,250);
        this.setResizable(false);
        
        
        //define the FocusListener for textfiled and numberfiled;
        textFieldListener = new FocusListener(){
            
            @Override
            public void focusGained(FocusEvent e) {
                final JTextComponent c = (JTextComponent)e.getSource(); 
                 c.setForeground(new java.awt.Color(153, 204, 255));
                if (c.equals(pageTitleField))       nameStatus.setText("page Title should be 3-20 charaters !");
                  }

            @Override
            public void focusLost(FocusEvent e) {
            if(!e.isTemporary()){
                
                final JTextComponent c = (JTextComponent) e.getSource();
                String s = c.getText();
                if(e.isTemporary()) return;
                
                if (s.length()<2){
                    c.setForeground(Color.red);
                    
                    if (c.equals(pageTitleField))   nameStatus.setText("Page Title is invaild !");
                     if(!errorfound)errorfound = true;
                }
                
                else{
                     if (c.equals(pageTitleField))  nameStatus.setText("vaild PageTitle!");
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
                    if (c.equals(pageIDField))   IDStatus.setText("book id is invaild");
                     else if (c.equals(pageNumField))   pageNumStatus.setText("page number is invaild ");
                     if(!errorfound)errorfound = true;
                }
            }
            }
            
        };
         
        enableFocusLost();
    }
    
    private void enableFocusLost(){
        
        pageTitleField.addFocusListener(textFieldListener);
        pageNumField.addFocusListener(numberFieldListener);
    }
    
    private void disableFocusLost(){
        
        pageTitleField.removeFocusListener(textFieldListener);
        pageNumField.removeFocusListener(numberFieldListener);
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
        codeStatus = new javax.swing.JLabel();
        pageNumLabel = new javax.swing.JLabel();
        pageNumField = new javax.swing.JTextField();
        pageNumStatus = new javax.swing.JLabel();
        submitButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        bookCodeField = new javax.swing.JComboBox();
        jTextArea1 = new javax.swing.JTextArea();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 400));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        titleLabel.setFont(new java.awt.Font("Algerian", 0, 36)); // NOI18N
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
        gridBagConstraints.gridwidth = 2;
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
        bookCodeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookCodeFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 15;
        getContentPane().add(bookCodeField, gridBagConstraints);

        jTextArea1.setBackground(new java.awt.Color(255, 204, 204));
        jTextArea1.setColumns(10);
        jTextArea1.setRows(5);
        jTextArea1.setText("please enter your page information below:\npageID : the index number in Database\nPage Title: title of the Page\nBook Code: book code for the book that the page is from");
        jTextArea1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextArea1.setFocusable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jTextArea1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        disableFocusLost();
          if(errorfound){
              JOptionPane.showMessageDialog(this," form complete with error input!,please try again");
              return;
          }
             if(mode.equals(Controller.operation.ADD) ){
          
            //if there is no error found in the form, create book with book info;
            //if thePage is empty object, create new Book with book info provided;
            //otherwise update thePage info cosponding the book info provide;
         
                    editedPage = new Page(pageTitleField.getText().trim(),
                            String.valueOf((String)bookCodeField.getSelectedItem()),
                            Integer.parseInt(pageNumField.getText()));
                    if(theController !=null) theController.closePageInfoDialog(mode, editedPage);
                    

            }

   
            else if(mode.equals(Controller.operation.UPDATE) ){
          
            //if there is no error found in the form, create book with book info;
            //if thePage is empty object, create new Book with book info provided;
            //otherwise update thePage info cosponding the book info provide;
         

                    editedPage.setPageTitle(pageTitleField.getText());
                    editedPage.setBookCode(this.bookCodeField.getSelectedItem().toString());
                    editedPage.setPageNum(Integer.parseInt(pageNumField.getText()));
                 
                    if(theController != null) theController.closePageInfoDialog(mode, editedPage);
            
            }
            else if(mode.equals(Controller.operation.DELETE)){
                if(theController !=null) theController.closePageInfoDialog(mode, editedPage);
            }
             
             this.setVisible(false);
                    dispose();
          
          
    }//GEN-LAST:event_submitButtonActionPerformed

private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
// TODO add your handling code here:
     if(theController !=null) theController.closePageInfoDialog(null, editedPage);
        dispose();
}//GEN-LAST:event_CancelButtonActionPerformed

    private void bookCodeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookCodeFieldActionPerformed
   
        // TODO add your handling code here:}//GEN-LAST:event_bookCodeFieldActionPerformed
 }
protected void updateInfo(Page p,Controller.operation aopertion){
    if(!mode.equals(aopertion)){
        
        mode = aopertion;
        submitButton.setText(mode.toString());
    }
    
    editedPage = p;
    if(editedPage ==null){
        
            titleLabel.setText(" ");
            pageIDField.setText(null);
            bookCodeField.setSelectedItem(null);
            pageTitleField.setText(null);
            pageNumField.setText(null);
            
    }
    else{   
            titleLabel.setText(mode.toString()+": "+editedPage.toString());
            pageIDField.setText(editedPage.getPageID()+"");
            bookCodeField.setSelectedItem(editedPage.getBookCode());
            pageTitleField.setText(editedPage.getPageTitle());
            pageNumField.setText(editedPage.getPageNum()+"");
    }
      
}
   

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IDStatus;
    private javax.swing.JComboBox bookCodeField;
    private javax.swing.JLabel bookCodeLabel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel codeStatus;
    private javax.swing.JTextArea jTextArea1;
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
