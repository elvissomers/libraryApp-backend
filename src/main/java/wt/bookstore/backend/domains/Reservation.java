package wt.bookstore.backend.domains;

import jakarta.persistence.*;

@Entity
public class Reservation {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

	private String date;

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
