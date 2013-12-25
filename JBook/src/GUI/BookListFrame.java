/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;
import java.awt.*;

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Source.Book;
import Source.Page;

/**
 *
 * @author brianyang
 * @param <bookListPannel>
 */
@SuppressWarnings("serial")
public class BookListFrame extends mainFrame {

	BookListFrame view;
	public int GUI_DISPLAY_LIMIT = 100;

	
	Connection databaseConnection;
	Statement stat;

	ArrayList<Book> bookList = new ArrayList<Book>();
	ArrayList<Page> pageList = new ArrayList<Page>();


	private Page    selectedPage; //page currently selected in the GUI list
	private Book	selectedBook; //book currently selected in the GUI list
	
	


	// Here are the component listeners
	ActionListener			theSearchButtonListener;
	ListSelectionListener	pageListSelectionListener;
	ListSelectionListener	bookListSelectionListener;
	MouseListener			doubleClickPageListListener;
	MouseListener 			doubleClickBookListListener;
	KeyListener             keyListener;
	
	public BookListFrame(String title, Connection aDB, Statement aStatement, ArrayList<Book> initialBooks, ArrayList<Page> initialpages) {
		super(title);
		databaseConnection = aDB;
		stat = aStatement;
        bookList = initialBooks;
        pageList = initialpages;
		selectedBook = null;
		selectedPage = null;
		view = this;
		 initComponents();
		 
		 addWindowListener(
					new WindowAdapter() {
		 				public void windowClosing(WindowEvent e) {
		 					try {
		 						System.out.println("Closing Database Connection");
								databaseConnection.close();
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
							System.exit(0);
						}
					}
				);
	}
    

    private void initComponents() {
        GridBagConstraints gridBagConstraints;
        initListeners();
        bookListPannel = new BookListPannel(theSearchButtonListener,pageListSelectionListener,
        		                            bookListSelectionListener,doubleClickBookListListener,doubleClickPageListListener,keyListener);
        getContentPane().setLayout(new GridBagLayout());   
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.anchor =GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        getContentPane().add(bookListPannel, gridBagConstraints);

              setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
              update();
    }
    
    private void initListeners(){
    	theSearchButtonListener = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				search();
			}
    	};
    	pageListSelectionListener =new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent e) {
				selectPage();
	
			}
    	
    	};
    	bookListSelectionListener =new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent e) {
				selectBook();
	
			}
    	
    	};
    	doubleClickBookListListener = new MouseAdapter(){
    		public void mouseClicked(MouseEvent e){
    			if(e.getClickCount()==2){
    				Book viewedbook;
    				JList theList = (JList) e.getSource();
    				int index = theList.locationToIndex(e.getPoint());
    				viewedbook= (Book)theList.getModel().getElementAt(index);
    				
    				searchBookPage(viewedbook.getBookCode());
    			}
    		}
    	};
    	
    	doubleClickPageListListener = new MouseAdapter(){
    		public void mouseClicked(MouseEvent e){
    			if(e.getClickCount()== 2){
    				@SuppressWarnings("rawtypes")
					JList theList = (JList) e.getSource();
    				int index = theList.locationToIndex(e.getPoint());
    				//(Page)theList.getModel().getElementAt(index);
    					
    				/*
    				pageDetailsDialog dialog = new pageDetailsDialog(thisFrame, thisFrame, "page Details Dialog", true, pageBeingEdited);         
					dialog.setVisible(true);
    				*/
    			}
    		}
    	};
    	keyListener = new KeyListener(){

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				int keyChar = e.getKeyChar();

		        if (keyChar == KeyEvent.VK_ENTER)  search();
			
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
    		
    	};
    	
    }
   
    private void selectBook(){
    	
    	selectedBook =(Book) (bookListPannel.getbookList().getSelectedValue());
    	System.out.println("book Selected: "+selectedBook);
    	
    }
    
    private void selectPage(){
    	selectedPage = (Page)(bookListPannel.getPageList().getSelectedValue());
    	System.out.println("page Selected: "+selectedPage);
    }
    private void searchBookPage(String t){
    	
	
        String sqlQueryString = "select * from songs3005F2013 where bookcode like '%" + t + "%' order by title asc" + ";";
        //check some special cases
        if(t.equals("*")) sqlQueryString = "select * from songs3005F2013" + ";";
        else if(t.equals("%")) sqlQueryString = "select * from songs3005F2013" + ";";
        else if(t.equals("")) sqlQueryString = "select * from songs3005F2013" + ";";

	    try {
			ResultSet rs = stat.executeQuery(sqlQueryString);
			
            ArrayList<Page> pageSearchResults = new ArrayList<Page>();

	        int count = 0;
	        while (rs.next() && count < GUI_DISPLAY_LIMIT){
	        	Page page = new Page(
	        			rs.getInt("id"),
	        			rs.getString("bookcode"),
	        			rs.getString("title"),
	        			rs.getInt("page")
	        			);
	        	
	            pageSearchResults.add(page);
            count++;
	        }
	        rs.close(); //close the query result table
	        pageList = pageSearchResults;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		update();
    }
    @SuppressWarnings({ "unused" })
	private void search(){
    	
    	String searchPrototype = this.bookListPannel.getSearchText().getText().trim();
    	System.out.println(searchPrototype);
	
        String sqlQueryString = "select * from songs3005F2013 where title like '%" + searchPrototype + "%' order by title asc" + ";";
        //check some special cases
        if(searchPrototype.equals("*")) sqlQueryString = "select * from songs3005F2013" + ";";
        else if(searchPrototype.equals("%")) sqlQueryString = "select * from songs3005F2013" + ";";
        else if(searchPrototype.equals("")) sqlQueryString = "select * from songs3005F2013" + ";";

	    try {
			ResultSet rs = stat.executeQuery(sqlQueryString);
			
            ArrayList<Page> pageSearchResults = new ArrayList<Page>();

	        int count = 0;
	        while (rs.next() && count < GUI_DISPLAY_LIMIT){
	        	Page page = new Page(
	        			rs.getInt("id"),
	        			rs.getString("bookcode"),
	        			rs.getString("title"),
	        			rs.getInt("page")
	        			);
	        	
	            pageSearchResults.add(page);
            count++;
	        }
	        rs.close(); //close the query result table
	        Page pageArray[] = new Page[1]; //just to establish array type
	        pageList = pageSearchResults;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Search clicked");
		update();
    }
    
    
    private void updateSearchButton(){
    	bookListPannel.getsearchButton().setEnabled(true);
    }
    
    @SuppressWarnings("unchecked")
  	private void updateList(){
      	//boolean foundSelected =false;
      	Book bookArray[] = new Book[1];
      	bookListPannel.getbookList().setListData(bookList.toArray(bookArray));
      	
      	
      	Page pageArray[] =new Page[1];
      	
      	bookListPannel.getPageList().setListData(pageList.toArray(pageArray));
      	
      	if(selectedBook !=null){
      		bookListPannel.getbookList().setSelectedValue(selectedBook, true);
      	}
      	if(selectedPage !=null){
      		bookListPannel.getPageList().setSelectedValue(selectedPage, true);
      	}
      	
    }

    private void update(){
      	bookListPannel.removeListener();
      	updateList();
      	updateSearchButton();
      	bookListPannel.addListener();
      	}
    
   
    private GUI.BookListPannel bookListPannel;
   




	
}
