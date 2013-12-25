/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.WindowConstants;

import Source.Book;

/**
 *
 * @author brianyang
 */
@SuppressWarnings("serial")
public class AddBookDialog extends javax.swing.JDialog {

    /**
     * Creates new form AddBookDialog
     */
    DialogClient theClient;
    public AddBookDialog(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    public AddBookDialog(Frame owner, DialogClient aclient,String title, boolean modal) {
        super(owner,title,modal);
        theClient = aclient;
       
    	initComponents();
    }

   
    private void initComponents() {
        header = new javax.swing.JPanel();
        Title = new javax.swing.JLabel();
        Content = new javax.swing.JPanel();
        BookTitleLabel = new javax.swing.JLabel();
        AuthorLabel = new javax.swing.JLabel();
        PathLabel = new javax.swing.JLabel();
        TotalPageLabel = new javax.swing.JLabel();
        BookTitleField = new javax.swing.JTextField();
        AuthorField = new javax.swing.JTextField();
        PathField = new javax.swing.JTextField();
        TotalPageField = new javax.swing.JTextField();
        ButtonPannel = new javax.swing.JPanel();
        ResetButton = new javax.swing.JButton();
        SubmitButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();

       getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));

        Title.setText("Add New Book ");

     
        header.add(Title);
        getContentPane().add(header);

        BookTitleLabel.setText("BookTitle :");
        AuthorLabel.setText("Author ");
        PathLabel.setText("Path");
        TotalPageLabel.setText("TotalPage");
        BookTitleField.setText("BookTitle");
        AuthorField.setText("Author");
        PathField.setText("BookPath");
        TotalPageField.setText("TotalPage");
        

        Content.add(BookTitleLabel);
        Content.add(BookTitleField);
        Content.add(AuthorLabel);
        Content.add(AuthorField);
        Content.add(PathLabel);
        Content.add(PathField);
        Content.add(TotalPageLabel);
        Content.add(TotalPageField); 
        getContentPane().add(Content);

        ResetButton.setText("Reset");       
        ButtonPannel.add(ResetButton);
        SubmitButton.setText("Submit");
       
        
        ButtonPannel.add(SubmitButton);
        CancelButton.setText("Cancel");
        
        
        ButtonPannel.add(CancelButton);
        getContentPane().add(ButtonPannel);
       
        ResetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ResetButton();
            }
        });
        
        CancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	CancelButton();
            }
        });
        
        SubmitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	SubmitButton();
            }
        });
        pack();
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);
      
    }
    
    
    private void SubmitButton(){
    	String title,path;
    	int page;
    	title= BookTitleField.getText();
    	//author = AuthorField.getText();
    	path = PathField.getText();
    	page = 00;
    	Book temp = new Book(title,path,page);
    	
    	if(theClient !=null){
    		theClient.AddBookdialogFinished(DialogClient.operation.AddBook,temp);
    		
    	}
    	dispose();
    	
    }
    
    private void ResetButton(){
    	
    	this.AuthorField.setText(" ");
    	this.TotalPageField.setText(" ");
    	this.BookTitleField.setText(" ");
    	this.PathField.setText(" ");
    	
    }
    private void CancelButton() {
        if (theClient != null) {
            theClient.AddBookdialogCancelled();
        }
        dispose();
    }
    

    private javax.swing.JTextField AuthorField;
    private javax.swing.JLabel AuthorLabel;
    private javax.swing.JTextField BookTitleField;
    private javax.swing.JLabel BookTitleLabel;
    private javax.swing.JPanel ButtonPannel;
    private javax.swing.JButton CancelButton;
    private javax.swing.JPanel Content;
    private javax.swing.JTextField PathField;
    private javax.swing.JLabel PathLabel;
    private javax.swing.JButton ResetButton;
    private javax.swing.JButton SubmitButton;
    private javax.swing.JLabel Title;
    private javax.swing.JTextField TotalPageField;
    private javax.swing.JLabel TotalPageLabel;
    private javax.swing.JPanel header;
  }
