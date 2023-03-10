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

	@ManyToMany()
	@JoinTable(
			name = "book_keywords",
			joinColumns = @JoinColumn(name = "book_id"),
			inverseJoinColumns = @JoinColumn(name = "keyword_id"))
	private List<Keyword> keywords = new ArrayList<>();

	@OneToMany(mappedBy = "book", orphanRemoval = true)
	private List<Copy> copies = new ArrayList<>();

	@OneToMany(mappedBy = "book", orphanRemoval = false)
	private List<Copy> availableCopies = new ArrayList<>();

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

	public List<Keyword> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<Keyword> keywords) {
		this.keywords = keywords;
	}

	public void addKeyword(Keyword keyword) {
		keywords.add(keyword);
	}

	// TODO : een call hiernaar elke keer dat een copy (un)available wordt
	// TODO - Is dit nodig?
	public void setAvailableCopies(){
		availableCopies = new ArrayList<>();
		for (Copy copy : copies){
			if (copy.isAvailable()){
				availableCopies.add(copy);
			}
		}
	}

	/**
	 * Used to get a random copy from the list of copies of this book
	 *
	 * @return Copy, a random copy from this books copies
	 */
	// TODO: Make a function that picks a random AVAILABLE copy
	public Copy getRandomAvailableCopy(){
		Random rand = new Random();
		this.setAvailableCopies();

		Copy randomCopy = availableCopies.get(rand.nextInt(copies.size()));

		return randomCopy;
	}
}
