package wt.bookstore.backend.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wt.bookstore.backend.domains.Book;
import wt.bookstore.backend.domains.Reservation;
import wt.bookstore.backend.domains.User;
import wt.bookstore.backend.dto.ReservationDto;
import wt.bookstore.backend.dto.SaveReservationDto;
import wt.bookstore.backend.repository.IBookRepository;
import wt.bookstore.backend.repository.IUserRepository;

import java.util.Optional;

@Component
public class ReservationDtoMapper {

    @Autowired
    private IBookRepository bookRepository;

    @Autowired
    private IUserRepository userRepository;

    public Reservation dtoToReservation(SaveReservationDto saveReservationDto){
        /*
         * Used to create a Reservation object from a saveReservationDto object
         */
        Optional<User> userOptional = userRepository.findById(saveReservationDto.getUserId());
        Optional<Book> bookOptional = bookRepository.findById(saveReservationDto.getBookId());

        /*
         * Check whether all necessary fields are present in the post DTO, e.g. You can not make a loan object without
         * knowing which copy is loaned
         */
        if (userOptional.isEmpty() || bookOptional.isEmpty())
            return null;

        Reservation reservation = new Reservation();
        reservation.setDate(saveReservationDto.getDate());
        reservation.setBook(bookOptional.get());
        reservation.setUser(userOptional.get());

        return reservation;
    }

    public ReservationDto reservationToDto(Reservation reservation){
        /*
         * Used to create a ReservationDto object from a Reservation object
         */
        ReservationDto reservationDto = new ReservationDto();

        reservationDto.setBookTitle(reservation.getBook().getTitle());
        reservationDto.setUserFirstName(reservation.getUser().getFirstName());
        reservationDto.setUserLastName(reservation.getUser().getLastName());
        reservationDto.setDate(reservation.getDate());

        return reservationDto;
    }
}
