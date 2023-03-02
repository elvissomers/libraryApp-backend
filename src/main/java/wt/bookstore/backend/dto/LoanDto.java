package wt.bookstore.backend.dto;

import org.springframework.beans.factory.annotation.Autowired;
import wt.bookstore.backend.domains.Loan;
import wt.bookstore.backend.domains.User;
import wt.bookstore.backend.repository.IUserRepository;

import java.time.LocalDate;
import java.util.Optional;

public class LoanDto {

	private LocalDate startDate;
	
	private LocalDate endDate;
	
	private long userId;
	
	private String name;



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
	
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public long getUserId() {
		return userId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}



}
