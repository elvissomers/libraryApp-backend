package wt.bookstore.backend.dto;

import java.time.LocalDate;

/**
 * Data Transfer Object for the {@link wt.bookstore.backend.domains.Loan} class that is sent from the frontend to the
 * backend. The fields in this class should contain the information needed to create a loan object.
 */
public class SaveLoanDto {

	private LocalDate startDate;
	
	private LocalDate endDate;
	
	private long userId;

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

	public long getCopyId() {
		return copyId;
	}

	public void setCopyId(long copyId) {
		this.copyId = copyId;
	}


}
