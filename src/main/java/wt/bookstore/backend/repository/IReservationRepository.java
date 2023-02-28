package wt.bookstore.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import wt.bookstore.backend.domains.Reservation;

public interface IReservationRepository extends JpaRepository<Reservation, Long>{

}
