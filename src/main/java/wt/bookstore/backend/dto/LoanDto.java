package wt.bookstore.backend.dto;

import org.springframework.beans.factory.annotation.Autowired;
import wt.bookstore.backend.domains.Loan;
import wt.bookstore.backend.domains.User;
import wt.bookstore.backend.repository.IUserRepository;

import java.time.LocalDate;
import java.util.Optional;

/**
 * Data Transfer Object for the {@link wt.bookstore.backend.domains.Loan} class that is sent to the frontend. The
 * fields in this class contain the information of a loan object that is deemed relevant to the user and are determined
 * by the needs of the frontend.
 */
public class LoanDto {

	private long id;

	private LocalDate startDate;

	private LocalDate endDate;

	private String userFirstName;

	private String userLastName;

	private String bookTitle;

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

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
}
