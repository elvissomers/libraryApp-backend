package wt.bookstore.backend.domains;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ID;
	private long ISBN;
	private String title;
	private String author;

	public Book(long ISBN, String title, String author) {
		this.ISBN = ISBN;
		this.title = title;
		this.author = author;
	}

	public Book() {
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
	
}
