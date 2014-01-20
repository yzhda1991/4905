/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bookviewer;

import GUI.MainMenuFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Toolkit;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author brianyang
 */
public class splashScreen extends javax.swing.JDialog {

    /**
     * Creates new form splashScreen
     */
    
    private static MainMenuFrame   mainFrame;
    
    private static ArrayList<Book> bookList;
    private static ArrayList<Page> pageList;
    private static String          databaseName;
    
    
   
    protected void initUI() throws MalformedURLException {
        showSplashScreen();
        SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>() {

            @Override
            protected Void doInBackground() throws Exception {
                   
                    message.setText("Book viewer appliction;");
                    Thread.sleep(10);
                    message.setText("Loading Program;");
                    
                   
                    
                    try{
                        message.setText("Connect to Database ;");
                            Class.forName("org.sqlite.JDBC");
                            databaseName = "jdbc:sqlite:src/data/db_books";            
                        Connection database = DriverManager.getConnection(databaseName);
                        message.setText("Connected to db_books");
                             
                             publish(10);
                             Thread.sleep(10);
                        message.setText("inilized Book data;");
                            Thread.sleep(10);
                            Statement stat =  database.createStatement();
                            String sqlQueryString = "select * from bookcodes order by code asc;";
                            System.out.println("");
                            System.out.println(sqlQueryString);
            
                            bookList = new ArrayList<Book>();
            
                            ResultSet rs = stat.executeQuery(sqlQueryString);
                            while(rs.next()){
                                Book thebook = new Book(rs.getString("code"),rs.getString("title"),rs.getString("path"),rs.getString("author"),rs.getInt("startpage"));
                                bookList.add(thebook);
                                 }
                             rs.close();
                             Thread.sleep(10);
                             publish(30);
                         message.setText("inilized Page Data");
                            sqlQueryString = "select * from pagelist;";
                            rs = stat.executeQuery(sqlQueryString);
                            System.out.println("");
                            System.out.println(sqlQueryString);
                            pageList = new ArrayList<Page>();
                            int DISPLAY_LIMIT = 100;
                            int count =0;
                            while(rs.next() && count<DISPLAY_LIMIT){
                                Page thePage = new Page(rs.getInt("id"),rs.getString("title"),rs.getString("bookcode"),rs.getInt("page"));
                                pageList.add(thePage);
                                 count++;
                                 if(count<60) publish(30+count);
                                 Thread.sleep(10);
                            }
                                 rs.close();
                                 publish(90);
            
                            mainFrame = new MainMenuFrame("Book Viewer",database,stat,bookList,pageList);
                                publish(100);// Notify progress
                                Thread.sleep(10);// Simulate loading
 
        }catch(ClassNotFoundException e){
            Logger.getLogger(BookViewer.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException ex) {
           
            Logger.getLogger(BookViewer.class.getName()).log(Level.SEVERE, null, ex);
        }
                     
                
                return null;
            }

            @Override
            protected void process(List<Integer> chunks) {
                progress.setValue(chunks.get(chunks.size() - 1));
            }

            @Override
            protected void done() {
                showFrame();
                hideSplashScreen();
            }

        };
        worker.execute();
    }
    
    protected void showSplashScreen() throws MalformedURLException {
       
        this.setModal(false);
        this.setUndecorated(true);
        initComponents();
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    protected void hideSplashScreen() {
        this.setVisible(false);
        this.dispose();
    }
    
       protected void showFrame() {
        if(mainFrame !=null ) {
          
           mainFrame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
           mainFrame.setVisible(true);
        }
        else{
           JFrame frame = new JFrame(splash.class.getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel ui = new JLabel("UI loaded and ready");
        ui.setBorder(BorderFactory.createEmptyBorder(300, 300, 300, 300));
        frame.add(ui);
        frame.pack();
        frame.setVisible(true);
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        progress = new javax.swing.JProgressBar();
        message = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        message.setText("jLabel1");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(progress, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(message, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 334, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(0, 55, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(126, Short.MAX_VALUE)
                .add(message)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(progress, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException,
            UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    new   splashScreen().initUI();
                } catch (MalformedURLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel message;
    private javax.swing.JProgressBar progress;
    // End of variables declaration//GEN-END:variables
}
