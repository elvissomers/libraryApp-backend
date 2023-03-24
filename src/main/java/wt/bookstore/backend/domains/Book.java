package wt.bookstore.backend.domains;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

	@Column(columnDefinition = "boolean default false")
	private boolean archived;

	private String description;
	@ManyToMany()
	@JoinTable(
			name = "book_keywords",
			joinColumns = @JoinColumn(name = "book_id"),
			inverseJoinColumns = @JoinColumn(name = "keyword_id"))
	private List<Keyword> keywords = new ArrayList<>();

	@OneToMany(mappedBy = "book", orphanRemoval = true)
	private List<Copy> copies = new ArrayList<>();

	@OneToMany(mappedBy = "book", orphanRemoval = true)
	private List<Reservation> reservations = new ArrayList<>();

	public Book(long isbn, String title, String author, boolean archived) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.archived = archived;
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

	public boolean getArchived() {
		return archived;
	}

	public void setArchived(boolean archived) {
		this.archived = archived;
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

	public List<Keyword> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<Keyword> keywords) {
		this.keywords = keywords;
	}

	public void addKeyword(Keyword keyword) {
		keywords.add(keyword);
	}

	public void addCopy(Copy copy){
		copies.add(copy);
	}

	/**
	 * Used to get a random copy from the list of copies of this book
	 *
	 * @return Copy, a random copy from this books copies
	 */
	// TODO: Make a function that picks a random AVAILABLE copy
	public Copy getRandomCopy(){
		Random rand = new Random();

		Copy randomCopy = copies.get(rand.nextInt(copies.size()));

		return randomCopy;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
