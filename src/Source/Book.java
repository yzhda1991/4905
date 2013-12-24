package Source;


public class Book {

	private String Bookname;
	private String Author;
	private String BookCode;
	private int    TotalNumber;
	
	public Book(String name, String a, String code, int num){
		Bookname = name;
		Author = a;
		BookCode =code;
		TotalNumber =num;
	}
	
	public Book(){
		Bookname ="";
		Author = "";
		BookCode ="";
		TotalNumber= 0;
	}
	
	public String getName(){
		return Bookname;
	}
	public String getAuthor(){
		return Author;
	}
	public String getBookCode(){
		return BookCode;
	}
	public int getTotalPage(){
		return TotalNumber;
	}
	
}
