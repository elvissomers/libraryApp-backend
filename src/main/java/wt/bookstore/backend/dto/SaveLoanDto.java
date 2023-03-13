package wt.bookstore.backend.dto;

import java.time.LocalDate;

/**
 * Data Transfer Object for the {@link wt.bookstore.backend.domains.Loan} class that is sent from the frontend to the
 * backend. The fields in this class should contain the information needed to create a loan object.
 */
public class SaveLoanDto {

	// TODO: make start date the current date - wordt gedaan in frontend
	private LocalDate startDate;
	
	private long userId;

	private long bookId;

	private int copyNumber;


	public LocalDate getStartDate() {
		return startDate;
	}
	
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public int getCopyNumber() {
		return copyNumber;
	}

	public void setCopyNumber(int copyNumber) {
		this.copyNumber = copyNumber;
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
}
