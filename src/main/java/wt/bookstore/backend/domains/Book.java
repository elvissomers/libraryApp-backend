package wt.bookstore.backend.domains;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

/**
 * The entity used for the books database
 */
@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false, length = 13)
	private long isbn;

	@Column(nullable = false, length = 100)
	private String title;

	@Column(nullable = false, length = 100)
	private String author;

	@OneToMany(mappedBy = "book", orphanRemoval = true)
	private List<Copy> copies = new ArrayList<>();

	@OneToMany(mappedBy = "book", orphanRemoval = true)
	private List<Reservation> reservations = new ArrayList<>();

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

	public List<Copy> getCopies() {
		return copies;
	}

	public void setCopies(List<Copy> copies) {
		this.copies = copies;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
}
