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

    List<Loan> findAllByOrderByUser_FirstNameAsc(Pageable pageable);
    List<Loan> findAllByOrderByStartDateAsc(Pageable pageable);
    List<Loan> findAllByOrderByUser_LastNameAsc(Pageable pageable);
    List<Loan> findAllByOrderByCopy_Book_TitleAsc(Pageable pageable);

    List<Loan> findAllByOrderByUser_FirstNameDesc(Pageable pageable);
    List<Loan> findAllByOrderByStartDateDesc(Pageable pageable);
    List<Loan> findAllByOrderByUser_LastNameDesc(Pageable pageable);
    List<Loan> findAllByOrderByCopy_Book_TitleDesc(Pageable pageable);


    List<Loan> findByUser_FirstNameOrUser_LastNameOrCopy_Book_TitleContainingOrderByUser_LastNameAsc(String lastName, String firstName, String bookTitle, Pageable pageable);
    List<Loan> findByUser_FirstNameOrUser_LastNameOrCopy_Book_TitleContainingOrderByUser_FirstNameAsc(String lastName, String firstName, String bookTitle, Pageable pageable);
    List<Loan> findByUser_FirstNameOrUser_LastNameOrCopy_Book_TitleContainingOrderByStartDateAsc(String lastName, String firstName, String bookTitle, Pageable pageable);
    List<Loan> findByUser_FirstNameOrUser_LastNameOrCopy_Book_TitleContainingOrderByCopy_Book_TitleAsc(String lastName, String firstName, String bookTitle, Pageable pageable);


    List<Loan> findByUser_FirstNameOrUser_LastNameOrCopy_Book_TitleContainingOrderByUser_LastNameDesc(String lastName, String firstName, String bookTitle, Pageable pageable);
    List<Loan> findByUser_FirstNameOrUser_LastNameOrCopy_Book_TitleContainingOrderByUser_FirstNameDesc(String lastName, String firstName, String bookTitle, Pageable pageable);
    List<Loan> findByUser_FirstNameOrUser_LastNameOrCopy_Book_TitleContainingOrderByStartDateDesc(String lastName, String firstName, String bookTitle, Pageable pageable);
    List<Loan> findByUser_FirstNameOrUser_LastNameOrCopy_Book_TitleContainingOrderByCopy_Book_TitleDesc(String lastName, String firstName, String bookTitle, Pageable pageable);
}
