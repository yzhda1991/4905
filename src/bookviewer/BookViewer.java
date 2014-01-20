
package bookviewer;

import GUI.MainMenuFrame;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    private static String          databaseName;
    
 /*
    public static void main(String[] args){
        // TODO code application logic here
        mainFrame = null;
        System.out.println("Book viewer appliction");
        
        try{
            Class.forName("org.sqlite.JDBC");
            databaseName = "jdbc:sqlite:src/data/db_books";
            Connection database = DriverManager.getConnection(databaseName);
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
            }
            rs.close();
            
             mainFrame = new MainMenuFrame("Book Viewer",database,stat,bookList,pageList);
       
 
        }catch(ClassNotFoundException e){
            e.printStackTrace();;
        } catch (SQLException ex) {
            ex.printStackTrace();
            //Logger.getLogger(BookViewer.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        pageList = new ArrayList<Page>();
        
        
        mainFrame.pack();
        mainFrame.setVisible(true);
          
        
    }
    
    * */
    
    
}
