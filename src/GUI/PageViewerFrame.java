/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Source.Book;

/**
 *
 * @author brianyang
 */
@SuppressWarnings("serial")
public class PageViewerFrame extends JFrame implements DialogClient {

    /**
     * Creates new form MainFrame
     */
	static PageViewerFrame pageFrame;
    public PageViewerFrame(String title) {
    	super(title);
        initComponents();
    }
    
    private void initComponents() {
        GridBagConstraints gridBagConstraints;

        pageViewPannel1 = new GUI.PageViewPannel();
        BottomPanel = new JPanel();
        StatusLabel = new JLabel();
        TopMenuBar = new JMenuBar();
        File = new JMenu();
        AddBook = new JMenuItem();
        AddPage = new JMenuItem();
        Exit = new JMenuItem();
        Help = new JMenu();
        Helps = new JMenuItem();
        About = new JMenuItem();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        getContentPane().setLayout(new GridBagLayout());
        
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.anchor = GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(pageViewPannel1, gridBagConstraints);

        BottomPanel.setBorder(BorderFactory.createEtchedBorder());

        StatusLabel.setText("Status");

        GroupLayout BottomPanelLayout = new GroupLayout(BottomPanel);
        BottomPanel.setLayout(BottomPanelLayout);
        BottomPanelLayout.setHorizontalGroup(
            BottomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(BottomPanelLayout.createSequentialGroup()
                .addComponent(StatusLabel)
                .addGap(0, 571, Short.MAX_VALUE))
        );
        BottomPanelLayout.setVerticalGroup(
            BottomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, BottomPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(StatusLabel))
        );

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        getContentPane().add(BottomPanel, gridBagConstraints);
        
        

        File.setMnemonic('F');
        File.setText("File");

        AddBook.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.ALT_MASK));
        AddBook.setMnemonic('B');
        AddBook.setText("AddBooks");
        AddBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AddBook();
            }
        });
        File.add(AddBook);

        AddPage.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.ALT_MASK));
        AddPage.setMnemonic('S');
        AddPage.setText("AddPages");
        AddPage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	Book newBook =new Book("1000 Songs", "Brian", "1THS", 100);
               AddPage(newBook);
            }
        });
        File.add(AddPage);

        Exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.ALT_MASK));
        Exit.setMnemonic('E');
        Exit.setText("Exit");
        Exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
               CloseProgram();
            }
        });
        File.add(Exit);

        TopMenuBar.add(File);

        Help.setMnemonic('H');
        Help.setText("Help");

        Helps.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
        Helps.setMnemonic('H');
        Helps.setText("Helps");
        Help.add(Helps);

        About.setMnemonic('A');
        About.setText("About");
        About.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                actionPerformed(evt);
            }
        });
        Help.add(About);

        TopMenuBar.add(Help);

        setJMenuBar(TopMenuBar);

        pack();
    }
    
    private void AddPage(Book b){
    	AddPageDialog pageDialog =new AddPageDialog(pageFrame, pageFrame, b,"add Page to "+b.getName(), true);
    	pageDialog.setVisible(true);
    	
    }
    private void  AddBook(){
    	AddBookDialog bookDialog = new AddBookDialog(pageFrame,pageFrame,"Add a new Book",true);
    	bookDialog.setVisible(true);
    	
    	
    }
    private void CloseProgram(){
    	System.exit(0);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PageViewerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PageViewerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PageViewerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PageViewerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
            	 PageViewerFrame page = new PageViewerFrame("page Viwer");
            	 page.setVisible(true);
                GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(page);
            }
        });
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
    private JPanel BottomPanel;
    private PageViewPannel pageViewPannel1;
    // End of variables declaration//GEN-END:variables
	@Override
	public void dialogFinished(operation anOperation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dialogCancelled() {
		// TODO Auto-generated method stub
		
	}
}
