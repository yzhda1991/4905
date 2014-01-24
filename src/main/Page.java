/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Zhangda Yang
 */
public class Page {
    
    private int    pageID;
    private String pageTitle;
    private String bookCode;
    private int    pageNum;
    
    //Page Constructor with full paramater;
    public Page(int id,String title, String code, int num){
        pageID = id;
        bookCode = code;
        pageTitle = title;
        pageNum = num;
    }
    
    //Page Constructor with pageID, 
    public Page(String title, String code, int num){
        
        bookCode = code;
        pageTitle = title;
        pageNum = num;
    }
    
    //get page id ;
    public int getPageID(){
        return pageID;
    }    
    
    //get page title;
    public String getPageTitle(){
        return pageTitle;
    }
    
    //get book code of page;
    public String getBookCode(){
        return bookCode;
    }
    
    //get page number;
    public int getPageNum(){
        return pageNum;
        
    }
    
    //set page id;
    
    public void setPageTitle(String s){
        pageTitle = s;
    }
    //set bookCode of page;
    public void setBookCode(String code){
        bookCode = code;
    }
    //set page number;
    public void setPageNum(int i){
        pageNum = i;
    }
    
    @Override
    public String toString(){
        
        String keyIndent = "";
		int max_key_digits = 5;
		for(int i=0; i< max_key_digits-(" "+pageID).length(); i++ ) keyIndent = keyIndent + " ";
		
		String pageIndent = "";
		int max_page_digits = 80;
		for(int i=0; i< max_page_digits-(" "+pageTitle+" ("+bookCode+") ").length(); i++ ) pageIndent = pageIndent + " ";
		
                String numIndent ="";
                int max_page_num = 8;
		for(int i=0; i< max_page_num-(" "+pageNum).length(); i++ ) numIndent = numIndent + " ";
		
                return "" + pageID + keyIndent + " "+pageNum+numIndent+pageTitle+" ("+bookCode+") " ;
    }
}
