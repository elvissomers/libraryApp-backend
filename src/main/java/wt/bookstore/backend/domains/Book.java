package wt.bookstore.backend.domains;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private long isbn;

	@Column(nullable = false, length = 100)
	private String title;

	private String author;
	
	@ManyToMany(mappedBy="books")
	private List<BookKeyword> keywords;

	public Book(long isbn, String title, String author) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
	}

	public Book() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
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
	
	public List<BookKeyword> getKeywords() {
		return keywords;
	}
	
	public void setKeywords(List<BookKeyword> keywords) {
		this.keywords = keywords;
	}

}
