package Source;


public class Book {

	private String bookname;
	private String bookCode;
	private int    totalNumber;
	
	public Book(String name, String code, int num){
		bookname = name;
		bookCode =code;
		totalNumber =num;
	}
	
	
	public String getName(){
		return bookname;
	}
	
	
	public String getBookCode(){
		return bookCode;
	}
	public int getTotalPage(){
		return totalNumber;
	}
	
	public String toString(){
			
		//return "" +bookCode +":  "+bookname;
		String keyIndent = "";
		int max_key_digits = 6;
		for(int i=0; i< max_key_digits-(""+bookCode).length(); i++ ) keyIndent = keyIndent + " ";
		
		
		return  " " +   bookCode +keyIndent  + "  "+bookname;
	}
	
}
