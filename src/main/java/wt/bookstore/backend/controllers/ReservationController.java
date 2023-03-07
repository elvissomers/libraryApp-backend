package wt.bookstore.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.web.bind.annotation.*;

import wt.bookstore.backend.domains.*;
import wt.bookstore.backend.dto.ReservationDto;
import wt.bookstore.backend.dto.SaveReservationDto;
import wt.bookstore.backend.mapping.DtoMapper;
import wt.bookstore.backend.repository.IBookRepository;
import wt.bookstore.backend.repository.ILoanRepository;
import wt.bookstore.backend.repository.IReservationRepository;
import wt.bookstore.backend.repository.IUserRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
@CrossOrigin(maxAge = 3600)
public class ReservationController {

    @Autowired
    private IReservationRepository reservationRepository;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IBookRepository bookRepository;

    @Autowired
    private ILoanRepository loanRepository;


    /*
     * GET endpoints from here
     */
    @RequestMapping(value = "reservation", method = RequestMethod.GET)
    public Stream<ReservationDto> findAll() {
        return reservationRepository.findAll().stream().map(DtoMapper::reservationToDto);
    }

    @RequestMapping(value = "reservation/{id}", method = RequestMethod.GET)
    public Optional<ReservationDto> find(@PathVariable long id) {
        Optional<Reservation> optionalReservation = reservationRepository.findById(id);
        return Optional.of(DtoMapper.reservationToDto(optionalReservation.get()));
    }


    /*
     * POST endpoints from here
     */
    @RequestMapping(value="reservation/create", method = RequestMethod.POST)
    public boolean create(@RequestBody SaveReservationDto saveReservationDto) {
        Reservation reservation = DtoMapper.dtoToReservation(saveReservationDto, userRepository, bookRepository);
        if (reservation != null) {
            reservationRepository.save(reservation);
            return true;
        }
        return false;
    }
    

    /*
     * PUT endpoints from here
     */
    @RequestMapping(value = "reservation/{id}/date", method = RequestMethod.PUT)
    public void updateDate(@PathVariable long id, @RequestBody LocalDate date){
        Optional<Reservation> optionalReservation = reservationRepository.findById(id);
        optionalReservation.get().setDate(date);

        reservationRepository.save(optionalReservation.get());
    }


    @RequestMapping(value = "reservation/{id}", method = RequestMethod.PUT)
    public boolean update(@PathVariable long id, @RequestBody SaveReservationDto saveReservationDto) {
        Optional<User> userOptional = userRepository.findById(saveReservationDto.getUserId());
        Optional<Book> bookOptional = bookRepository.findById(saveReservationDto.getBookId());
        /*
         * Converts a post DTO to a loan object, if the post DTO misses a userId, loanId
         * or reservationId it returns null, since it will not be a valid data entry
         */


        /*
         * Checks whether the id given in the url is a valid loanId
         */
        Optional<Reservation> optionalReservation = reservationRepository.findById(id);
        if (optionalReservation.isEmpty())
            return false;

        /*
         * Overwrites all the existing fields (except the ID) of the loan with the given loadId for the
         * values given in the post DTO and saves it back in the database
         */
        Reservation reservation = optionalReservation.get();

        userOptional.ifPresent(reservation::setUser);
        bookOptional.ifPresent(reservation::setBook);
        if (saveReservationDto.getDate() != null) {
            reservation.setDate(saveReservationDto.getDate());
        }

        reservationRepository.save(reservation);
        return true;
    }

    @RequestMapping(value = "reservation/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        reservationRepository.deleteById(id);
    }


}