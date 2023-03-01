package wt.bookstore.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import wt.bookstore.backend.domains.Loan;

public interface ILoanRepository extends JpaRepository<Loan, Long>{

}
