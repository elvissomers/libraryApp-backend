package wt.bookstore.backend.dto;

import java.time.LocalDate;

public class SaveLoanDto {

	private LocalDate startDate;
	
	private LocalDate endDate;
	
	private long userId;

	private long reservationId;

	private long copyId;


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

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getReservationId() {
		return reservationId;
	}

	public void setReservationId(long reservationId) {
		this.reservationId = reservationId;
	}

	public long getCopyId() {
		return copyId;
	}

	public void setCopyId(long copyId) {
		this.copyId = copyId;
	}


}
