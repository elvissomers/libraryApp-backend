package wt.bookstore.backend.domains;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
public class Reservation {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

	private LocalDate date;

    @ManyToOne(optional = false)
    private Book book;

    @ManyToOne(optional = false)
    private User user;
    @OneToOne(mappedBy = "reservation")
    private Loan loan;



	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
