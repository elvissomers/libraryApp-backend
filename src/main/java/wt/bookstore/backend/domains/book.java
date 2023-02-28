package wt.bookstore.backend.domains;

import java.util.List;

public class Book {
	private long ID;
	private long ISBN;
	private String title;
	private String author;
	private List<String> keywords;
	
	public Book(long iSBN, String title, String author, List<String> keywords) {
		ISBN = iSBN;
		this.title = title;
		this.author = author;
		this.keywords = keywords;
	}

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public long getISBN() {
		return ISBN;
	}

	public void setISBN(long iSBN) {
		ISBN = iSBN;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public List<String> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}
	
	
}
