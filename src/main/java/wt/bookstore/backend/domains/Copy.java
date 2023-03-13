package wt.bookstore.backend.domains;

import jakarta.persistence.*;
import java.util.List;

/**
 * The entity used for the copies database
 */
@Entity
public class Copy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

    @Column(nullable = false)
	private boolean available;

    @ManyToOne(optional = false)
    private Book book;

    @OneToMany(mappedBy = "copy", orphanRemoval = true)
    private List<Loan> loans;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }
}
