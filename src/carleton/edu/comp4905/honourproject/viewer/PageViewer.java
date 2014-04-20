/*
 * Carleton University - School of Computer Science Honours Project 
 * Winter 2014
 * PDF Book Organizer and page Viewer
 * AUTHOR: Zhangda Yang
 * SUPERVISOR: Professor Louis Nel
 * 
 */
package carleton.edu.comp4905.honourproject.viewer;

import java.awt.GridBagConstraints;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 * this class represents view of page content display panel
 *
 * @author zhangda yang
 */
public class PageViewer extends javax.swing.JPanel {

    private GridBagConstraints gridBagConstraints;

    // constructor
    public PageViewer() {
        initComponents();
    }

    public JList getPageList() {
        return PageList;
    }

    public void setTittle(String t) {
        BookName.setText("Page : " + t);
    }

    public void setMainPanel(JPanel p) {
        remove(mainPanel);
        mainPanel = p;
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
        add(mainPanel, gridBagConstraints);


    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        BookListScroll = new javax.swing.JScrollPane();
        PageList = new javax.swing.JList();
        BookLabel = new javax.swing.JLabel();
        BookName = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();

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

        BookLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(BookLabel, gridBagConstraints);

        BookName.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
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
        add(mainPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BookLabel;
    private javax.swing.JScrollPane BookListScroll;
    private javax.swing.JLabel BookName;
    private javax.swing.JList PageList;
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables
}
