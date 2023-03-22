package wt.bookstore.backend.dto;

import java.time.LocalDate;

/**
 * Data Transfer Object for the {@link wt.bookstore.backend.domains.Loan} class that is sent to the frontend. The
 * fields in this class contain the information of a loan object that is deemed relevant to the user and are determined
 * by the needs of the frontend.
 */
public class LoanDto {
	// Attributes
	private long id;

	private LocalDate startDate;

	private LocalDate endDate;

	private String userFirstName;

	private String userLastName;

	private long bookId;

	private String bookTitle;

	private String bookAuthor;

	private long bookIsbn;

	private int copyNumber;

	//	Methods
	
	public long getId() {
		return id;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
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

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
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

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public long getBookIsbn() {
		return bookIsbn;
	}

	public void setBookIsbn(long bookIsbn) {
		this.bookIsbn = bookIsbn;
	}
}
