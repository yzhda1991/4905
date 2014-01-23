/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * BookListPannel.java
 *
 * Created on Jan 7, 2014, 5:39:01 PM
 */
package viewer;

import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author byang1
 */
public class PageViewer extends javax.swing.JPanel {
    private GridBagConstraints gridBagConstraints;
    
    /** Creates new form BookListPannel */
    public PageViewer() {
        initComponents();
    }
    
    public JList getPageList(){
        return PageList;
    }
    public JTextField getSearchField(){
        return seachTextField;
    }
    public JButton getSearchButton(){
        return seachButton;
    }
    public void setTittle(String t){
        BookName.setText("Page : "+t);
    }
    public void setMainPanel(JPanel p){
         gridBagConstraints = new java.awt.GridBagConstraints();
         gridBagConstraints.gridx = 2;
         gridBagConstraints.gridy = 2;
         gridBagConstraints.gridwidth = 4;
         gridBagConstraints.gridheight = 2;
         gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
         gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
         gridBagConstraints.weightx = 2.0;
         gridBagConstraints.weighty = 2.0;
         gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
         add(p, gridBagConstraints);
    }
    
   
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        BookListScroll = new javax.swing.JScrollPane();
        PageList = new javax.swing.JList();
        seachTextField = new javax.swing.JTextField();
        seachButton = new javax.swing.JButton();
        BookLabel = new javax.swing.JLabel();
        BookName = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        PageList.setBorder(javax.swing.BorderFactory.createTitledBorder("Page Index"));
        PageList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        BookListScroll.setViewportView(PageList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 2.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(BookListScroll, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 150);
        add(seachTextField, gridBagConstraints);

        seachButton.setText("Search");
        seachButton.setToolTipText("Search Book");
        seachButton.setMinimumSize(new java.awt.Dimension(130, 41));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(seachButton, gridBagConstraints);

        BookLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(BookLabel, gridBagConstraints);

        BookName.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24));
        BookName.setText("Page :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 2.0;
        add(BookName, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BookLabel;
    private javax.swing.JScrollPane BookListScroll;
    private javax.swing.JLabel BookName;
    private javax.swing.JList PageList;
    private javax.swing.JButton seachButton;
    private javax.swing.JTextField seachTextField;
    // End of variables declaration//GEN-END:variables

}
