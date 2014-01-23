/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PageListPanel.java
 *
 * Created on Jan 7, 2014, 6:27:53 PM
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
public final class PageListPanel extends javax.swing.JPanel {

    /** Creates new form PageListPanel */
    
    
    
    
    public PageListPanel() {
        initComponents();
    }
    
    public JList getBookList(){
        return BookList;
    }
    
    public JList getPageList(){
        return PageList;
    }
    
    public JTextField getSearchField(){
        return SeachTextField;
    }
    
    public JButton  getSearchButton(){
        return seachButton;
    }
    
    public JComboBox getTypeBox(){
        return TypeBox;
    }
    
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        BookList = new javax.swing.JList();
        Book = new javax.swing.JLabel();
        SeachTextField = new javax.swing.JTextField();
        seachButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        PageList = new javax.swing.JList();
        TypeBox = new javax.swing.JComboBox();

        BookList.setBorder(javax.swing.BorderFactory.createTitledBorder("Book List"));
        BookList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(BookList);

        Book.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Book.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/book.png"))); // NOI18N

        seachButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/search32.png"))); // NOI18N
        seachButton.setText("Search Page");
        seachButton.setToolTipText("Search Page");

        PageList.setBorder(javax.swing.BorderFactory.createTitledBorder("Page List"));
        PageList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(PageList);

        TypeBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Page ID", "Book Code", "Page Title" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(Book)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SeachTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TypeBox, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seachButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Book)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(TypeBox, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(SeachTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(seachButton)))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Book;
    private javax.swing.JList BookList;
    private javax.swing.JList PageList;
    private javax.swing.JTextField SeachTextField;
    private javax.swing.JComboBox TypeBox;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton seachButton;
    // End of variables declaration//GEN-END:variables
}
