/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;
import java.awt.*;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.*;

import Source.Book;
import Source.Page;


/**
 *
 * @author brianyang
 */
@SuppressWarnings("serial")
public class PageViewerFrame extends mainFrame  {

    /**
     * Creates new form MainFrame
     */
	 PageViewerFrame pageFrame;
    public PageViewerFrame(String title, Connection aDB, Statement aStatement, ArrayList<Page> initialPages) {
    	super(title);
    	pageFrame =this;
        initComponents();
    }
    
    private void initComponents() {
        GridBagConstraints gridBagConstraints;

        pageViewPannel = new GUI.PageViewPannel();
      
         
        getContentPane().setLayout(new GridBagLayout());
        
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.anchor = GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(pageViewPannel, gridBagConstraints);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
    }
    
   

       private PageViewPannel pageViewPannel;
  	
}