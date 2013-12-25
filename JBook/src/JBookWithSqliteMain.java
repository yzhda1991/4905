
import java.awt.GraphicsEnvironment;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import GUI.BookListFrame;
import Source.Book;
import Source.Page;


public class JBookWithSqliteMain {
	public static void main(String[] args) throws SQLException, ClassNotFoundException{
		
		System.out.println("Jbook Main Class");
		BookListFrame frame = null;
		
		//connect to database
		//direct java to the sqlite-jdbc driver jar code
    	// load the sqlite-JDBC driver using the current class loader
		try {
		Class.forName("org.sqlite.JDBC");
		
		//create connection to a database in the project home directory.
		//if the database does not exist one will be created in the home directory
	    
		//Connection conn = DriverManager.getConnection("jdbc:sqlite:mytest.db");
		Connection database = DriverManager.getConnection("jdbc:sqlite:db_fake_books_3005_Fall2013");
	       //create a statement object which will be used to relay a
	       //sql query to the database
	     Statement stat = database.createStatement();

	    /*
	     * SQLite supports in-memory databases, which does not create any database files
	     * To use in memory database in your Java code, get the database connection as follows:
	     *
	     * Connection connection = DriverManager.getConnection("jdbc:sqlite::memory:");
	     * 
	    */
		
	   
            //Query database for initial contents for GUI

            String sqlQueryString = "select * from bookcodes order by code asc;";
            System.out.println("");
            System.out.println(sqlQueryString);

            ArrayList<Book> books = new ArrayList<Book>();

	        ResultSet rs = stat.executeQuery(sqlQueryString);
	        
	        while (rs.next()) {
	            //System.out.print("code: " + rs.getString("code"));
	           // System.out.println(" title = " + rs.getString("title"));
	            Book book = new Book(rs.getString("title"), rs.getString("code"),  100);
	            books.add(book);
	        }
	        
	        rs.close(); //close the query result table
	        
	        sqlQueryString = "select * from songs3005F2013;";
	        rs = stat.executeQuery(sqlQueryString);
            System.out.println("");
            System.out.println(sqlQueryString);
            
            ArrayList<Page> PageResult = new ArrayList<Page>();
            int DISPLAY_LIMIT = 100;
	        int count = 0;
	        
	        while (rs.next() && count < DISPLAY_LIMIT){
	            //System.out.print("id: " + rs.getString("id"));
	            //System.out.print("book: " + rs.getString("bookcode"));
	            //System.out.print(" page: " + rs.getInt("page"));
	            //System.out.println(" song: " + rs.getString("title"));
	            
	            Page page = new Page(
	            		rs.getInt("id"),
	            		rs.getString("bookcode"),
	            		rs.getString("title"),
	            		rs.getInt("page")
	            		);
	            PageResult.add(page);
            
	            count++;
	       
	        }
    
	        rs.close(); //close the query result table
    
    
	        Page[] pageArray = new Page[1]; //just to establish array type
    
	        pageArray =  PageResult.toArray(pageArray);
	
	
	        //Create GUI with knowledge of database and initial query content 
	        frame =  new BookListFrame("Fake Book Index Fall2013", database, stat, books, PageResult); //create GUI frame with knowledge of the database
    
	        //Leave it to GUI to close database
	        //conn.close(); //close connection to database			
									


		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		//make GUI visible

		frame.setVisible(true);
		GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(frame);
          

	}	
}