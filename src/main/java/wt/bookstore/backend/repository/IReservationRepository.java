package wt.bookstore.backend.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import wt.bookstore.backend.domains.Reservation;
import wt.bookstore.backend.domains.User;

public interface IReservationRepository extends JpaRepository<Reservation, Long>{

    List<Reservation> findByUser_FirstNameOrUser_LastName(String firstName, String lastName, Pageable pageable);

    List<Reservation> findByUser(User user);

}
