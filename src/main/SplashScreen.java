/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Toolkit;
import java.net.MalformedURLException;
import java.util.List;


import javax.swing.SwingWorker;
import model.MainFrame;
import model.Modeling;
import viewer.SplashScreenPanel;

/**
 *
 * @author brianyang
 */
public class SplashScreen extends javax.swing.JDialog{

    SplashScreenPanel splashPanel;
    MainFrame         theMain;
    Modeling     theController;
    
    
    
    protected void initUI()  {
        showSplashScreen();
        SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>() {

            @Override
            protected Void doInBackground() throws Exception {
                splashPanel.getMessage().setText("Welcome to Book View Pdf reader Appication;");
                Thread.sleep(10);
                splashPanel.getMessage().setText("loading program......");
                Thread.sleep(10);
                publish(20);
                splashPanel.getMessage().setText("initializing program controller......");
                theController = new Modeling();
                publish(40);
                splashPanel.getMessage().setText("initializing  program Viewers......");
                theController.initFrame();
                
                publish(60);
                splashPanel.getMessage().setText("connect to database......");
                Thread.sleep(20);
                publish(80);
                splashPanel.getMessage().setText("finished building. start program...");
                Thread.sleep(20);
                publish(100);

                return null;
                   
            }
 
        
            @Override
            protected void process(List<Integer> chunks) {
                splashPanel.getProgress().setValue(chunks.get(chunks.size() - 1));
            }

            @Override
            protected void done() {
                showFrame();
                hideSplashScreen();
               }

        };
        worker.execute();
    }
    
    protected void showSplashScreen() {
       
        this.setModal(false);
        this.setUndecorated(true);
        splashPanel = new SplashScreenPanel();
        add(splashPanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
   
    }
      protected void hideSplashScreen() {
        
        this.setVisible(false);
        this.dispose();
    }
      protected void showFrame() {
         
          if(theController == null) theController = new Modeling();
          if(theMain ==null)  theMain = new MainFrame("View Book Appilcaition",theController);
          
          theMain.pack();
          this.setLocationRelativeTo(null);
          theMain.setVisible(true);
      }
}
