package wt.bookstore.backend.domains;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Loan {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

	private long copyId;
	private long reservationId;
	private String startDate;
	private String endDate;
	
	@ManyToOne(optional = false)
	private User user;
	
	public Loan() {
		
	}
	
	public Loan(long copyId, long reservationId, String startDate, String endDate) {
		this.copyId = copyId;
		this.reservationId = reservationId;
		this.startDate = startDate;
		this.endDate = endDate;
	}


	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getCopyId() {
		return copyId;
	}
	public void setCopyId(long copyId) {
		this.copyId = copyId;
	}
	public long getReservationId() {
		return reservationId;
	}
	public void setReservationId(long reservationId) {
		this.reservationId = reservationId;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
}
