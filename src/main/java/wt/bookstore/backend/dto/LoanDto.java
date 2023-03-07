package wt.bookstore.backend.dto;

import org.springframework.beans.factory.annotation.Autowired;
import wt.bookstore.backend.domains.Loan;
import wt.bookstore.backend.domains.User;
import wt.bookstore.backend.repository.IUserRepository;

import java.time.LocalDate;
import java.util.Optional;

public class LoanDto {

	private long id;

	private LocalDate startDate;
	
	private LocalDate endDate;
	
	private String userName;
	private String copyName;

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCopyName() {
		return copyName;
	}

	public void setCopyName(String copyName) {
		this.copyName = copyName;
	}


}
