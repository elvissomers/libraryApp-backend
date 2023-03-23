package wt.bookstore.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import wt.bookstore.backend.domains.Copy;
import wt.bookstore.backend.domains.Loan;
import wt.bookstore.backend.domains.User;
import wt.bookstore.backend.domains.Book;

public interface ILoanRepository extends JpaRepository<Loan, Long>{

    List<Loan> findByUser_FirstNameOrUser_LastNameOrCopy_Book_TitleContaining(String firstName, String lastName, String title, Pageable pageable);

    List<Loan> findByUser(User user);

    // Used to find all "open" loans (that are not yet returned) for a specific user
    List<Loan> findByUserAndEndDateNull(User user);

    // Used to find the history of a user
    List<Loan> findByUserAndEndDateNotNull(User user);

    // Used to find all "open" loans (that are not yet returned) for a specific book
    List<Loan> findByCopy_BookAndEndDateNull(Book book);

    // Used to find all "open" loans (that are not yet returned)
    List<Loan> findByEndDateNull();

    List<Loan> findByEndDateNull(Pageable pageable);

    List<Loan> findByEndDateNullAndUser_FirstNameOrEndDateNullAndUser_LastNameOrEndDateNullAndCopy_Book_TitleContaining(String firstName, String lastName, String title, Pageable pageable);

    Optional<Loan> findByCopyAndEndDateNull(Copy copy);

}
