package Source;

public class Page {
	
	private int id; //database table primary key id
	private String bookcode; //string code for fake book
	private int pageNum; //page number of song in bookcode fakebook
	private String title; //title of song
	
	
	public Page(int a,String t, String b, int i){
		setId(a);
		setTitle(t);
		setBookCode(b);
		setPageNum(i);
	}
	public void setId(int i){
		id =i;
	}
	public int getID(){
		return id;
	}
	
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public String getBookCode() {
		return bookcode;
	}

	public void setBookCode(String bookCode) {
		this.bookcode = bookCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String toString(){
		String keyIndent = "";
		int max_key_digits = 6;
		for(int i=0; i< max_key_digits-(""+id).length(); i++ ) keyIndent = keyIndent + " ";
		
		String pageIndent = "";
		int max_page_digits = 5;
		for(int i=0; i< max_page_digits-(""+pageNum).length(); i++ ) pageIndent = pageIndent + " ";
		
		return "" + id + keyIndent + bookcode + "   " + pageNum + pageIndent + title;
		
	}
	
}
