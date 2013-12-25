/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;


import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;
import Source.Book;
import Source.Page;


@SuppressWarnings("serial")
public class AddPageDialog extends JDialog {

    DialogClient theClient;
    Book 		 thebook ;
    
    
    public AddPageDialog(Frame owner, DialogClient aclient,Book abook,String title, boolean modal) {
        super(owner,title,modal);
        theClient = aclient;
        thebook= abook;
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
        ResetButton = new JButton();
        SubmitButton = new JButton();
        CancelButton = new JButton();
        NextButton = new JButton();

        
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));

        titleLabel.setText("Add Pages for Book : ");
        BookNameLabel.setText(thebook.getName());
        HeaderPanel.add(titleLabel);
        HeaderPanel.add(BookNameLabel);
        getContentPane().add(HeaderPanel);

        IndexLabel.setText("Index");

        IndexField.setText("00");
        IndexField.setEnabled(false);    

        BookCodeLabel.setText("BookCode");
        BookCodeField.setText(thebook.getBookCode());
        BookCodeField.setEnabled(false);

        PageLabel.setText("Page");
        PageField.setText("PageNumber");
        
        TitleLabel.setText("Title");
        TitleField.setText("PageTitle");

       ContentPanel.add(IndexLabel);
       ContentPanel.add(IndexField);
       ContentPanel.add(BookCodeLabel);
       ContentPanel.add(BookCodeField);
       ContentPanel.add(PageLabel);
       ContentPanel.add(PageField);
       ContentPanel.add(TitleLabel);
       ContentPanel.add(TitleField);

       getContentPane().add(ContentPanel);

        ResetButton.setText("Reset");
        SubmitButton.setText("Submit");
        CancelButton.setText("Cancel");
        NextButton.setText("Submit and Add Next Page");
       

        BottomPanel.add(NextButton);
        BottomPanel.add(SubmitButton);
        BottomPanel.add(CancelButton);
        BottomPanel.add(ResetButton);
        

        getContentPane().add(BottomPanel);

        pack();
        
        NextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	 submitandNext(evt);
            }
        });
        
        SubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit(evt);
            }
        });
        
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel(evt);
            }
        });
        
        ResetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset(evt);
            }
        });
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);
    }
      
    private void submitandNext(ActionEvent evt){
    	String bookCode,title;
    	int page;
    	title= TitleField.getText();
    	bookCode = BookCodeField.getText();
    	page = 00;
    	Page temp = new Page(1, bookCode,title,page);
    	
    	if(theClient !=null){
    		theClient.AddPagedialogFinished(DialogClient.operation.AddPage,temp);
    	}
    	reset(evt);
    	
    }
    private void submit(ActionEvent evt){
    	String bookCode,title;
    	int page;
    	title= TitleField.getText();
    	bookCode = BookCodeField.getText();
    	page = 00;
    	Page temp = new Page(1,bookCode,title,page);
    	
    	if(theClient !=null){
    		theClient.AddPagedialogFinished(DialogClient.operation.AddPage,temp);
    	}
    	dispose();
    }
    private void reset(ActionEvent evt){
    	IndexField.setText("00");
        BookCodeField.setText(thebook.getBookCode());
        PageField.setText(" ");  
        TitleField.setText(" ");
    }
    private void cancel(ActionEvent evt){
    	if (theClient != null) {
            theClient.addPageDialogCancelled();
        }
        dispose();
    	
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
    private JButton ResetButton;
    private JButton SubmitButton;
    private JButton CancelButton;
    private JButton NextButton;
    private JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
