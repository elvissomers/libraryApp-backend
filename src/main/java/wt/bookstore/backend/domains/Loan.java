package wt.bookstore.backend.domains;

import java.time.LocalDate;

import jakarta.persistence.*;

/**
 * The entity used for the loans database
 */
@Entity
public class Loan {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

	@Column(nullable = false)
	private LocalDate startDate;

	private LocalDate endDate;
	
	@ManyToOne(optional = false)
	private User user;

	@ManyToOne(optional = false)
	@JoinColumn(name = "copy_id")
	private Copy copy;


	public Loan() {
		
	}
	
	public Loan(long copyId, long reservationId, LocalDate startDate, LocalDate endDate) {
//		this.copyId = copyId;
//		this.reservationId = reservationId;
		this.startDate = startDate;
		this.endDate = endDate;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Copy getCopy() {
		return copy;
	}

	public void setCopy(Copy copy) {
		this.copy = copy;
	}
}
