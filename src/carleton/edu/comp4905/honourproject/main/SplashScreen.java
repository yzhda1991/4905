/*
 * Carleton University - School of Computer Science Honours Project 
 * Winter 2014
 * PDF Book Organizer and page Viewer
 * AUTHOR: Zhangda Yang
 * SUPERVISOR: Professor Louis Nel
 * 
 */
package carleton.edu.comp4905.honourproject.main;

import java.util.List;
import javax.swing.SwingWorker;
import carleton.edu.comp4905.honourproject.model.MainFrame;
import carleton.edu.comp4905.honourproject.model.Modeling;
import carleton.edu.comp4905.honourproject.model.PathSelectionDialog;
import carleton.edu.comp4905.honourproject.viewer.SplashScreenPanel;

/**
 * The Class is represent the view of the splash screen.
 *
 * @author Zhangda Yang
 */
public class SplashScreen extends javax.swing.JDialog {

    SplashScreenPanel splashPanel;
    MainFrame theMain;
    Modeling theController;
    PathSelectionDialog psd;

    //initialize splash view
    protected void initUI() {
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
                psd = new PathSelectionDialog(new javax.swing.JFrame(), theController, true);
                psd.setVisible(true);
                psd.setLocationRelativeTo(splashPanel);
                while (!psd.getdialogstatus()) {
                    Thread.sleep(1);
                }
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

    // display splash screen
    protected void showSplashScreen() {

        this.setModal(false);
        this.setUndecorated(true);
        splashPanel = new SplashScreenPanel();
        add(splashPanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    // dispose splash screen
    protected void hideSplashScreen() {

        this.setVisible(false);
        this.dispose();
    }

    // display main frame
    protected void showFrame() {

        if (theController == null) {
            theController = new Modeling();
        }
        if (theMain == null) {
            theMain = new MainFrame("View Book Appilcaition", theController);
        }

        theMain.pack();
        this.setLocationRelativeTo(null);
        theMain.setVisible(true);
    }
}
