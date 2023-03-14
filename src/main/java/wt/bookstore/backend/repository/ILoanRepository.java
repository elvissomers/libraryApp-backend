package wt.bookstore.backend.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import wt.bookstore.backend.domains.Loan;

public interface ILoanRepository extends JpaRepository<Loan, Long>{

    List<Loan> findByUser_FirstNameOrUser_LastNameOrCopy_Book_TitleContaining(String firstName, String lastName, String title, Pageable pageable);


}
