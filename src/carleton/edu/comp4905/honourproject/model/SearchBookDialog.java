/*
 * Carleton University - School of Computer Science Honours Project 
 * Winter 2014
 * PDF Book Organizer and page Viewer
 * AUTHOR: Zhangda Yang
 * SUPERVISOR: Professor Louis Nel
 * 
 */
package carleton.edu.comp4905.honourproject.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import carleton.edu.comp4905.honourproject.main.Book;
import carleton.edu.comp4905.honourproject.viewer.SearchBookPanel;
import java.awt.event.MouseAdapter;

/**
 * this class represents view of search book dialog
 *
 * @author Zhangda Yang
 */
public class SearchBookDialog extends JDialog {

    SearchBookPanel mainPanel;
    ActionListener seachButtonListener;
    MouseAdapter doubleClickedonList;
    KeyListener searchKeyListener;
    Connecter theConnecter;
    Controller theController;
    ArrayList resultCollection;
    // constructor

    public SearchBookDialog(JFrame parent, String title, Connecter con, Controller c, boolean modal) {
        super(parent, title, modal);
        mainPanel = new SearchBookPanel();
        theConnecter = con;
        theController = c;
        init();

    }
    // initialize components

    private void init() {


        seachButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchActionMap();
            }
        };

        doubleClickedonList = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    JList theList = (JList) e.getSource();
                    int index = theList.locationToIndex(e.getPoint());
                    Book selectedBook = (Book) theList.getModel().getElementAt(index);
                    if (selectedBook != null) {
                        openPageList(selectedBook);
                    }

                }
            }
        };

        searchKeyListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                updateButton();

            }
        };

        enableListener();

        this.add(mainPanel);
        this.setSize(500, 450);
        this.setResizable(false);
        this.setAlwaysOnTop(true);

        update();
    }
    // display page list view

    private void openPageList(Book b) {
        if (theController != null) {
            theController.setSelectedBook(b);
            theController.openPageListFrame(b);
            theController.closeBookSearchDialog();
        } else {
            this.setVisible(false);
            this.dispose();
        }
    }
    // add listener to components

    private void enableListener() {

        mainPanel.getSubmitButton().addActionListener(seachButtonListener);
        mainPanel.getResult().addMouseListener(doubleClickedonList);
        mainPanel.getSearchContentField().addKeyListener(searchKeyListener);

    }
    // remove listener from components

    private void disableListener() {

        mainPanel.getSubmitButton().removeActionListener(seachButtonListener);
        mainPanel.getResult().removeMouseListener(doubleClickedonList);
        mainPanel.getSearchContentField().removeKeyListener(searchKeyListener);
    }
    // action performers for search button    

    private void searchActionMap() {

        String searchContent = mainPanel.getSearchContentField().getText().toString().trim();
        //System.out.println(.toString());
        if (mainPanel.getTitleRadioButton().isSelected()) {
            resultCollection = theConnecter.searchBook(searchContent, "title");
            update();
        } else if (mainPanel.getCodeRadioButton().isSelected()) {
            resultCollection = theConnecter.searchBook(searchContent, "code");
            update();
        } else if (mainPanel.getPathRadioButton().isSelected()) {
            resultCollection = theConnecter.searchBook(searchContent, "path");
            update();
        } else if (mainPanel.getAuthorRadioButton().isSelected()) {

            resultCollection = theConnecter.searchBook(searchContent, "author");
            update();

        }
    }

    private void updateList() {

        Book bookArray[] = new Book[1];
        if (resultCollection != null && !resultCollection.isEmpty()) {
            mainPanel.getResult().setListData(resultCollection.toArray(bookArray));
        }

    }
    // update button status

    private void updateButton() {

        if (mainPanel.getSearchContentField().getText().toString().trim().length() <= 2) {
            mainPanel.getSubmitButton().setEnabled(false);
        } else {
            mainPanel.getSubmitButton().setEnabled(true);
        }

        if (resultCollection == null || resultCollection.isEmpty()) {
            if (mainPanel.getResult().isVisible()) {
                mainPanel.getResult().setVisible(false);
            }
        } else {
            if (mainPanel.getResult().isVisible()) {
            } else {
                mainPanel.getResult().setVisible(true);
            }
        }

    }

    public void update() {
        disableListener();
        updateList();
        updateButton();
        enableListener();
    }
}
