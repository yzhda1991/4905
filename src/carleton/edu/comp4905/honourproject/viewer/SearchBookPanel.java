/*
 * Carleton University - School of Computer Science Honours Project 
 * Winter 2014
 * PDF Book Organizer and page Viewer
 * AUTHOR: Zhangda Yang
 * SUPERVISOR: Professor Louis Nel
 * 
 */
package carleton.edu.comp4905.honourproject.viewer;

/**
 * This is the Panel that represents the view of the search Book Dialog
 *
 * @author Zhangda Yang
 */
public class SearchBookPanel extends javax.swing.JPanel {

    /**
     * the default constructor
     */
    public SearchBookPanel() {
        initComponents();
    }

    /**
     * Initialed the components and the layout
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        typeButtonGroup = new javax.swing.ButtonGroup();
        searchLabel = new javax.swing.JLabel();
        searchContentField = new javax.swing.JTextField();
        submitButton = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();
        titleRadioButton = new javax.swing.JRadioButton();
        codeRadioButton = new javax.swing.JRadioButton();
        pathRadioButton = new javax.swing.JRadioButton();
        authorRadioButton = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultList = new javax.swing.JList();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchLabel.setText("Search book: ");
        add(searchLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));
        add(searchContentField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 273, 40));

        submitButton.setText("Search");
        add(submitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(402, 67, -1, -1));

        titleLabel.setText("Book Search Dialog");
        add(titleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, -1));

        typeButtonGroup.add(titleRadioButton);
        titleRadioButton.setSelected(true);
        titleRadioButton.setText("Book Title");
        add(titleRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        typeButtonGroup.add(codeRadioButton);
        codeRadioButton.setText("Book Code");
        add(codeRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, -1, -1));

        typeButtonGroup.add(pathRadioButton);
        pathRadioButton.setText("Book Path");
        add(pathRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, -1, -1));

        typeButtonGroup.add(authorRadioButton);
        authorRadioButton.setText("Book Author");
        add(authorRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, -1, -1));

        resultList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(resultList);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 470, 280));
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton authorRadioButton;
    private javax.swing.JRadioButton codeRadioButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton pathRadioButton;
    private javax.swing.JList resultList;
    private javax.swing.JTextField searchContentField;
    private javax.swing.JLabel searchLabel;
    private javax.swing.JButton submitButton;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JRadioButton titleRadioButton;
    private javax.swing.ButtonGroup typeButtonGroup;
    // End of variables declaration//GEN-END:variables

    /**
     * Get function for book author Radio Button
     *
     * @return authorRadioButton
     */
    public javax.swing.JRadioButton getAuthorRadioButton() {
        return authorRadioButton;
    }

    /**
     * get function for book code Radio Button
     *
     * @return codeRadioButton
     */
    public javax.swing.JRadioButton getCodeRadioButton() {
        return codeRadioButton;
    }

    /**
     * get function for book path RadioButton
     *
     * @return pathRadioButton
     */
    public javax.swing.JRadioButton getPathRadioButton() {
        return pathRadioButton;
    }

    /**
     * get function for search text field
     *
     * @return searchContentField
     */
    public javax.swing.JTextField getSearchContentField() {
        return searchContentField;
    }

    /**
     * get function for submit button
     *
     * @return submitButton
     */
    public javax.swing.JButton getSubmitButton() {
        return submitButton;
    }

    /**
     * get function for book title button
     *
     * @return titleRadioButton
     */
    public javax.swing.JRadioButton getTitleRadioButton() {
        return titleRadioButton;
    }

    /**
     * get function
     *
     * @return typeButtonGroup
     */
    public javax.swing.ButtonGroup getTypeButtonGroup() {
        return typeButtonGroup;
    }

    /**
     * get function for book search result
     *
     * @return resultList
     */
    public javax.swing.JList getResult() {
        return resultList;
    }
}
