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

    @Column(nullable = false)
    private int number;

    @Column(columnDefinition = "boolean default false")
    private boolean archived;

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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean getArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }
}
