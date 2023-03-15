package wt.bookstore.backend.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import wt.bookstore.backend.domains.Reservation;
import wt.bookstore.backend.domains.User;

public interface IReservationRepository extends JpaRepository<Reservation, Long>{

    List<Reservation> findByUser_FirstNameOrUser_LastName(String firstName, String lastName, Pageable pageable);

    List<Reservation> findByUser(User user);

    List<Reservation> findByUser_FirstNameOrUser_LastNameOrBook_TitleContaining(String firstName, String lastName, String bookTitle, Pageable pageable);
    List<Reservation> findAllByOrderByUser_FirstNameAsc(Pageable pageable);
    List<Reservation> findAllByOrderByDateAsc(Pageable pageable);
    List<Reservation> findAllByOrderByUser_LastNameAsc(Pageable pageable);
    List<Reservation> findAllByOrderByBook_TitleAsc(Pageable pageable);

    List<Reservation> findAllByOrderByUser_FirstNameDesc(Pageable pageable);
    List<Reservation> findAllByOrderByDateDesc(Pageable pageable);
    List<Reservation> findAllByOrderByUser_LastNameDesc(Pageable pageable);
    List<Reservation> findAllByOrderByBook_TitleDesc(Pageable pageable);


    List<Reservation> findByUser_FirstNameOrUser_LastNameOrBook_TitleContainingOrderByUser_LastNameAsc(String lastName, String firstName, String bookTitle, Pageable pageable);
    List<Reservation> findByUser_FirstNameOrUser_LastNameOrBook_TitleContainingOrderByUser_FirstNameAsc(String lastName, String firstName, String bookTitle, Pageable pageable);
    List<Reservation> findByUser_FirstNameOrUser_LastNameOrBook_TitleContainingOrderByDateAsc(String lastName, String firstName, String bookTitle, Pageable pageable);
    List<Reservation> findByUser_FirstNameOrUser_LastNameOrBook_TitleContainingOrderByBook_TitleAsc(String lastName, String firstName, String bookTitle, Pageable pageable);


    List<Reservation> findByUser_FirstNameOrUser_LastNameOrBook_TitleContainingOrderByUser_LastNameDesc(String lastName, String firstName, String bookTitle, Pageable pageable);
    List<Reservation> findByUser_FirstNameOrUser_LastNameOrBook_TitleContainingOrderByUser_FirstNameDesc(String lastName, String firstName, String bookTitle, Pageable pageable);
    List<Reservation> findByUser_FirstNameOrUser_LastNameOrBook_TitleContainingOrderByDateDesc(String lastName, String firstName, String bookTitle, Pageable pageable);
    List<Reservation> findByUser_FirstNameOrUser_LastNameOrBook_TitleContainingOrderByBook_TitleDesc(String lastName, String firstName, String bookTitle, Pageable pageable);

}
