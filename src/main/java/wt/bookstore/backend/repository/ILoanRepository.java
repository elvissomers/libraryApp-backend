package wt.bookstore.backend.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import wt.bookstore.backend.domains.Loan;
import wt.bookstore.backend.domains.User;

public interface ILoanRepository extends JpaRepository<Loan, Long>{

    List<Loan> findByUser_FirstNameOrUser_LastNameOrCopy_Book_TitleContaining(String firstName, String lastName, String title, Pageable pageable);

    List<Loan> findByUser(User user);

    // Used to find all "open" loans (that are not yet returned) for a specific user
    List<Loan> findByUserAndEndDateNull(User user);

    // Used to find all "open" loans (that are not yet returned)
    List<Loan> findByEndDateNull();
}
