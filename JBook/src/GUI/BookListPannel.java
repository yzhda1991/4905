/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;



/**
 *
 * @author brianyang
 */
@SuppressWarnings("serial")
public class BookListPannel extends JPanel {
	
	
	private JList bookList;
    private JScrollPane BookScrollPannel;
    private JButton searchButton;
    private JTextField SearchTextField;
	private JList pageList;
    private JScrollPane SongScrollPannel;
    

	ActionListener			thesearchButtonListener;
	ListSelectionListener	pageListSelectionListener;
	ListSelectionListener	bookListSelectionListener;
	MouseListener			doubleClickPageListListener;
	MouseListener 			doubleClickBookListListener;
	KeyListener             keyListener;
	
	
    public BookListPannel(ActionListener search,ListSelectionListener page,ListSelectionListener book,
    						MouseListener doubleClickBook,MouseListener doubleclickpage,KeyListener key) {
    	
    	thesearchButtonListener =search;
    	pageListSelectionListener=page;
    	bookListSelectionListener=book;
    	doubleClickBookListListener =doubleClickBook;
    	doubleClickPageListListener=doubleclickpage;
    	keyListener= key;
    	initComponents();
    }

    public JList getbookList(){return bookList; }
   	public JList getPageList(){return pageList;} 
    public JTextField getSearchText (){return SearchTextField;}
    public JButton getsearchButton(){return searchButton;}
    
     @SuppressWarnings("rawtypes")
	private void initComponents() {
        GridBagConstraints gridBagConstraints;

        BookScrollPannel = new JScrollPane();
        bookList = new JList();
        SearchTextField = new JTextField();
        searchButton = new JButton();
        SongScrollPannel = new JScrollPane();
        pageList = new JList();

        setLayout(new GridBagLayout());

        BookScrollPannel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        BookScrollPannel.setViewportView(bookList);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(BookScrollPannel, gridBagConstraints);

        SearchTextField.setText("Search Contents");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(SearchTextField, gridBagConstraints);

        searchButton.setText("Search");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(searchButton, gridBagConstraints);

        SongScrollPannel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        pageList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        SongScrollPannel.setViewportView(pageList);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 2.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(SongScrollPannel, gridBagConstraints);
        
        addListener();
    }
    public void addListener(){
    	searchButton.addActionListener(thesearchButtonListener);
    	bookList.addListSelectionListener(bookListSelectionListener);
    	pageList.addListSelectionListener(pageListSelectionListener);
    	pageList.addMouseListener(doubleClickPageListListener);
    	bookList.addMouseListener(doubleClickBookListListener);
    	SearchTextField.addKeyListener(keyListener);
    }
    public void removeListener(){
    	searchButton.removeActionListener(thesearchButtonListener);
    	bookList.removeListSelectionListener(bookListSelectionListener);
    	pageList.removeListSelectionListener(pageListSelectionListener);
    	pageList.removeMouseListener(doubleClickPageListListener);
    	SearchTextField.removeKeyListener(keyListener);
    }
 }
