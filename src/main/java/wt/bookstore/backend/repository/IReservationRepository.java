package wt.bookstore.backend.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import wt.bookstore.backend.domains.Book;
import wt.bookstore.backend.domains.Reservation;
import wt.bookstore.backend.domains.User;

public interface IReservationRepository extends JpaRepository<Reservation, Long>{

    List<Reservation> findByUser_FirstNameOrUser_LastName(String firstName, String lastName, Pageable pageable);

    List<Reservation> findByUser(User user);

    List<Reservation> findByBook(Book book);

    @Query("select r from Reservation r, User u, Book b where r.book = b and r.user = u and u.archived = false and (u.firstName LIKE %?1% or u.lastName LIKE %?1% or b.title LIKE %?1%)")
    Page<Reservation> search(String searchTerm, Pageable pageable);

}
