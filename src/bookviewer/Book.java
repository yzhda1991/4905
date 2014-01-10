/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bookviewer;

/**
 *
 * @author Zhangda Yang
 */
public class Book {
    
    private int bookId;
    private String bookName;  //  title of Book
    private String bookCode;  //  BookCode of Book
    private String bookPath;  // File Path of Boook
    private String author;    // Author of Book
    private int initPageNum;  // first start page of Book
    
    
    //constructor with full paramater;
    public  Book(int id,String name, String code, String path, String a , int page){
        bookId = id;
        bookName = name;
        bookCode = code;
        bookPath = path;
        author   = a;
        initPageNum = page;
    }
    
    //constructor with bookName, BookCode, BookPath,Author 
     public  Book(String name, String code, String path, String a){
        bookName = name;
        bookCode = code;
        bookPath = path;
        author   = a;
        initPageNum = 1;
    }
    
    //constructor with bookName, BookCode, BookPath;
     public  Book(String name, String code, String path){
        bookName = name;
        bookCode = code;
        bookPath = path;
        author   = "unKnown Author";
        initPageNum = 1;
    }
   
     //constructor with bookName, BookCode, 
     public  Book(String name, String code){
        bookName = name;
        bookCode = code;
        bookPath = "./"+name;
        author   = "unKnown Author";
        initPageNum = 1;
    }
     
     //get bookName;
     public String getBookName(){
         return bookName;
     }
     
     //get bookCode;
     public String getBookCode(){
         return bookCode;
     }
     
     //get bookPath;
     public String getBookPath(){
         return bookPath;
     }
     
     //get author;
     public String getAuthor(){
         return author;
     }
     
     //get start page number;
     public int getInitPage(){
         return initPageNum;
     } 
     
     //set Book name;
     public void setBookName(String name){
         bookName = name;
     }
     
     //set Book code;
     public void setBookCode(String code){
         bookCode = code;
     }
     
     //set author;
     public void setAuthor(String a){
         author = a;
     }
     
     //set start page;
     public void setPage(int page){
         initPageNum =page;
     }
     
    @Override
     public String toString(){
         String keyIndent = "";
		int max_key_digits = 5;
		for(int i=0; i< max_key_digits-(" "+bookId).length(); i++ ) keyIndent = keyIndent + " ";
		
		String pageIndent = "";
		int max_page_digits = 20;
		for(int i=0; i< max_page_digits-(" "+bookName+" ("+bookCode+") ").length(); i++ ) pageIndent = pageIndent + " ";
		
                return "" + bookId + keyIndent + " "+bookName+" ("+bookCode+") " ;
    
     }
    
}
