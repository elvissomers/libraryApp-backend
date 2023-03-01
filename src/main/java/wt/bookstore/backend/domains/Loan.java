package wt.bookstore.backend.domains;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Loan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long iD;
	private long copyId;
	private long reservationId;
	private long userId;
	private String startDate;
	private String endDate;
	
	public Loan() {
		
	}
	
	public Loan(long copyId, long reservationId, String startDate, String endDate) {
		this.copyId = copyId;
		this.reservationId = reservationId;
		this.startDate = startDate;
		this.endDate = endDate;
	}



	public long getiD() {
		return iD;
	}
	public void setiD(long iD) {
		this.iD = iD;
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

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	
	
}
