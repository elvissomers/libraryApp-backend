package wt.bookstore.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import wt.bookstore.backend.domains.Loan;

public interface ILoanRepository extends JpaRepository<Loan, Long>{
	List<Loan> findByUserId(long userId);
}
