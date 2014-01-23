/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * BookListPanel.java
 *
 * Created on Jan 7, 2014, 5:39:01 PM
 */
package viewer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTextField;


/**
 *
 * @author byang1
 */
public class BookListPanel extends javax.swing.JPanel {
    

    public enum     searchType      {BookCode,BookTitle,BookAuthor}; 
    
    /** Creates new form BookListPanel */
    public BookListPanel() {
       
        initComponents();
        
    }

    public JTextField getSearchField(){
        return seachTextField;
    }
    
    public JButton getSearchButton(){
        return seachButton;
    }

    public JList getBookList(){
        return BookList;
    }
    public JComboBox getSelectedType(){
        return BookType;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        BookListScroll = new javax.swing.JScrollPane();
        BookList = new javax.swing.JList();
        seachTextField = new javax.swing.JTextField();
        seachButton = new javax.swing.JButton();
        Book = new javax.swing.JLabel();
        BookType = new javax.swing.JComboBox();

        setLayout(new java.awt.GridBagLayout());

        BookList.setBorder(javax.swing.BorderFactory.createTitledBorder("Book List"));
        BookList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        BookListScroll.setViewportView(BookList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(BookListScroll, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        add(seachTextField, gridBagConstraints);

        seachButton.setText("SearchBook");
        seachButton.setToolTipText("Search Book");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(seachButton, gridBagConstraints);

        Book.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(Book, gridBagConstraints);

        BookType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", searchType.BookTitle.toString(), searchType.BookCode.toString(), searchType.BookAuthor.toString() }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(BookType, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Book;
    private javax.swing.JList BookList;
    private javax.swing.JScrollPane BookListScroll;
    private javax.swing.JComboBox BookType;
    private javax.swing.JButton seachButton;
    private javax.swing.JTextField seachTextField;
    // End of variables declaration//GEN-END:variables
}
