/*
 * Carleton University - School of Computer Science Honours Project 
 * Winter 2014
 * PDF Book Organizer and page Viewer
 * AUTHOR: Zhangda Yang
 * SUPERVISOR: Professor Louis Nel
 * 
 */
package carleton.edu.comp4905.honourproject.main;

/**
 * this class represent a book collection
 *
 * @author Zhangda Yang
 */
public class Book {

    private String bookName;  //  title of Book
    private String bookCode;  //  BookCode of Book
    private String bookPath;  // File Path of Boook
    private String author;    // Author of Book
    private int initPageNum;  // first start page of Book

    //default Constructor - no parameter
    public Book() {
        bookName = "";
        bookCode = "";
        bookPath = "";
        author = "";
        initPageNum = 1;
    }
    //constructor - all paramater;

    public Book(String code, String name, String path, String a, int page) {
        bookName = name;
        bookCode = code;
        bookPath = path;
        author = a;
        initPageNum = page;
    }

    //constructor with bookName, BookCode, BookPath,Author 
    public Book(String name, String code, String path, String a) {
        bookName = name;
        bookCode = code;
        bookPath = path;
        author = a;
        initPageNum = 1;
    }

    //constructor with bookName, BookCode, BookPath;
    public Book(String name, String code, String path) {
        bookName = name;
        bookCode = code;
        bookPath = path;
        author = "unKnown Author";
        initPageNum = 1;
    }

    //constructor with bookName, BookCode, 
    public Book(String name, String code) {
        bookName = name;
        bookCode = code;
        bookPath = "./" + name;
        author = "unKnown Author";
        initPageNum = 1;
    }

    //this function return the name of the book
    public String getBookName() {
        return bookName;
    }

    //this function return the book code of the book
    public String getBookCode() {
        return bookCode;
    }

    //this function return the PDF file path of the book
    public String getBookPath() {
        return bookPath;
    }

    //this function return the author of the book
    public String getAuthor() {
        return author;
    }

    //this function return the first content page number of the book
    public int getInitPage() {
        return initPageNum;
    }

    // this function reset the name of the book
    public void setBookName(String name) {
        bookName = name;
    }

    // this function reset the book code of the book
    public void setBookCode(String code) {
        bookCode = code;
    }

    // this function reset the author of the book
    public void setAuthor(String a) {
        author = a;
    }

    // this function reset the first content page number of the book
    public void setPage(int page) {
        initPageNum = page;
    }
    // this function reset the PDF file path of the book

    public void setBookPath(String p) {
        bookPath = p;
    }

    // toString method
    @Override
    public String toString() {
        String keyIndent = "";

        String pageIndent = "";
        int max_page_digits = 20;
        for (int i = 0; i < max_page_digits - (" " + bookName + " (" + bookCode + ") ").length(); i++) {
            pageIndent = pageIndent + " ";
        }

        return "" + keyIndent + " " + bookName + " (" + bookCode + ") ";

    }
}
