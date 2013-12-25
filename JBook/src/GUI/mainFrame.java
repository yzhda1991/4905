/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;

import Source.Book;
import Source.Page;

/**
 *
 * @author brianyang
 * @param <bookListPannel>
 */
@SuppressWarnings("serial")
public class mainFrame extends JFrame implements DialogClient{

	mainFrame main;
	public int GUI_DISPLAY_LIMIT = 100;

	// Store the model as a vector of email buddies

	Connection databaseConnection;
	Statement stat;

	ArrayList<Book> bookList = new ArrayList<Book>();
	ArrayList<Page> pageList = new ArrayList<Page>();


	

	// Store the view that contains the components
	//ListPanel 		view; //panel of GUI components for the main window
	

	// Here are the component listeners
	ActionListener			theSearchButtonListener;
	ListSelectionListener	songListSelectionListener;
	ListSelectionListener	bookListSelectionListener;
	MouseListener			doubleClickSongListListener;
	KeyListener             keyListener;
	
	public mainFrame(String title) {
		super(title);  
		
		main = this;
		 initComponents();
	}
	
	

    private void initComponents() {
         statusPanel = new JPanel();
        StatusLabel = new JLabel();
          
        getContentPane().setLayout(new GridBagLayout());

        statusPanel.setBorder(BorderFactory.createEtchedBorder());
        StatusLabel.setText("Status");
        statusPanel.add(StatusLabel);
        
        TopMenuBar = new JMenuBar();
        File = new JMenu();
        AddBook = new JMenuItem();
        AddPage = new JMenuItem();
        Exit = new JMenuItem();
        Help = new JMenu();
        Helps = new JMenuItem();
        About = new JMenuItem();
   	
   	File.setMnemonic('F');
       File.setText("File");

       AddBook.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.ALT_MASK));
       AddBook.setMnemonic('B');
       AddBook.setText("AddBooks");   
       File.add(AddBook);

       AddPage.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.ALT_MASK));
       AddPage.setMnemonic('S');
       AddPage.setText("AddPages");
       File.add(AddPage);

       Exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.ALT_MASK));
       Exit.setMnemonic('E');
       Exit.setText("Exit");
       File.add(Exit);

       TopMenuBar.add(File);
       
       Help.setMnemonic('H');
       Help.setText("Help");
       
       Helps.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
       Helps.setText("Help Guide");
       Help.add(Helps);

       About.setMnemonic('A');
       About.setText("About");
       Help.add(About);

       
       TopMenuBar.add(Help);

       setJMenuBar(TopMenuBar);

       //pack();
       
       AddBook.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent evt) {
           	AddBook(evt);
           }
       });
       
       AddPage.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent evt) {
           	Book newBook =new Book("1000 Songs",  "1THS", 100);
               AddPage(evt,newBook);
           }
       });
       
       About.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent evt) {
           	abouthandler(evt);
           }
       });
       
       Exit.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent evt) {
           	CloseProgram(evt);
           }
       });
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    

    private void abouthandler(ActionEvent evt){
    	
    }
    private void AddPage(ActionEvent evt,Book b){
    	AddPageDialog pageDialog =new AddPageDialog(main, main, b,"add Page to "+b.getName(), true);
    	pageDialog.setVisible(true);
    	
    }
    private void  AddBook(ActionEvent evt){
    	AddBookDialog bookDialog = new AddBookDialog(main, main,"Add a new Book",true);
    	bookDialog.setVisible(true);

    }
    private void CloseProgram(java.awt.event.ActionEvent evt){
    	System.exit(0);
    }
    public void  changeStatus(String s){
    	this.StatusLabel.setText(s);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JMenuItem About;
    private JMenuItem AddBook;
    private JMenuItem AddPage;
    private JMenuItem Exit;
    private JMenu File;
    private JMenu Help;
    private JMenuItem Helps;
    private JMenuBar TopMenuBar;
    private JLabel StatusLabel;
    private JPanel statusPanel;
    // End of variables declaration//GEN-END:variables

	@Override
	public void AddBookdialogFinished(operation anOperation,Book b) {
		// TODO Auto-generated method stub
		if(anOperation == DialogClient.operation.AddBook ){
		changeStatus("adding new book : "+b.getName());
		
		}
		
	}

	@Override
	public void AddPagedialogFinished(operation anOperation, Page p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addPageDialogCancelled() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void AddBookdialogCancelled() {
		// TODO Auto-generated method stub
		
	}

	
}
