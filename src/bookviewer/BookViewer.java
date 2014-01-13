
package bookviewer;

import GUI.MainMenuFrame;
import java.util.ArrayList;

/**
 *
 * @author byang1
 *
 */

public class BookViewer {

    
    private static MainMenuFrame   mainFrame;
    
    private static ArrayList<Book> bookList;
    private static ArrayList<Page> pageList;
    
 
    public static void main(String[] args) {
        // TODO code application logic here
          
        bookList = new ArrayList<Book>();
        pageList = new ArrayList<Page>();
        
        String path = "src/Resources/test.pdf";
        String author = "UnKnown Author";
        Book book1 = new Book(1,"SPC1","Spaces Vol1",path,author,1);
        Book book2 = new Book(2,"SPC2","Spaces Vol2",path,author,1);
        Book book3 = new Book(3,"SPC3","Spaces Vol3",path,author,1);
        Book book4 = new Book(4,"1THS","1000 Songs",path,author,1);
        
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);
        
      
        Page page1 = new Page(1,"ALFIE","SPC4",198);
        Page page2 = new Page(2,"ALICE IN WONDERLAND(FAIN/HILLARD)","SPC4",12);
        Page page3 = new Page(3,"ALL AT ONCE ITS LOVE","SPC4",196);
        Page page4 = new Page(4,"ALL MY TOMORROWS(CAHN/VAN HOUSEN)","SPC4",1);
        Page page5 = new Page(5,"ALL THE JIVE IS GONE","SPC4",262);
        Page page6 = new Page(6,"ALL THE THINGS YOU ARE(HAMMERSTEIN/KERN)","SPC4",2);

        pageList.add(page1);
        pageList.add(page2);
        pageList.add(page3);
        pageList.add(page4);
        pageList.add(page5);
        pageList.add(page6);
        System.out.print(book4);
        
        mainFrame = new MainMenuFrame("Book Viewer",bookList,pageList);
        mainFrame.pack();
        mainFrame.setVisible(true);
          
    }
    
    
    
}
