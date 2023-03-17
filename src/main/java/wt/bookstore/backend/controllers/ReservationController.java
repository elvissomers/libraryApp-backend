package wt.bookstore.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import wt.bookstore.backend.domains.*;
import wt.bookstore.backend.dto.ChangeReservationDto;
import wt.bookstore.backend.dto.ReservationAvailabilityDto;
import wt.bookstore.backend.dto.ReservationDto;
import wt.bookstore.backend.dto.SaveReservationDto;
import wt.bookstore.backend.mapping.ReservationDtoMapper;
import wt.bookstore.backend.repository.IBookRepository;
import wt.bookstore.backend.repository.ILoanRepository;
import wt.bookstore.backend.repository.IReservationRepository;
import wt.bookstore.backend.repository.IUserRepository;

import java.util.Optional;
import java.util.stream.Stream;


/**
 * The controller class that sets the API endpoints for the CRUD operations of the database that handles the reservations.
 */
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

    @Autowired
    private ReservationDtoMapper reservationMapper;


    /*
     * GET endpoints from here
     */
     
    /**
     * Returns a Stream of {@link wt.bookstore.backend.dto.ReservationDto} for a GET request to {database_location}/reservation.
     * @return Stream of {@link wt.bookstore.backend.dto.ReservationDto}'s
     */
    @GetMapping("reservation/get")
    public Stream<ReservationDto> findAll() {
        return reservationRepository.findAll().stream().map(reservationMapper::reservationToDto);
    }

    /**
     * Returns a single {@link wt.bookstore.backend.dto.ReservationDto} with a certain id for a GET request to {database_location}/reservation/{id}.
     * @param id (long) of the reservation you want to get.
     * @return Single {@link wt.bookstore.backend.dto.ReservationDto}
     */
    @GetMapping("reservation/get/{id}")
    public Optional<ReservationDto> find(@PathVariable long id) {
        Optional<Reservation> optionalReservation = reservationRepository.findById(id);
        return Optional.of(reservationMapper.reservationToDto(optionalReservation.get()));
    }


    /*
     * POST endpoints from here
     */
     
    /**
     * Creates a {@link wt.bookstore.backend.domains.Reservation} object from a {@link wt.bookstore.backend.dto.SaveReservationDto} and saves it to the database for a POST request to {database_location}/reservation/create. The id is autogenerated.
     * @param saveReservationDto ({@link wt.bookstore.backend.dto.SaveReservationDto}) is generated from the json body in the POST request and contains the information needed to create a {@link wt.bookstore.backend.domains.Reservation} object.
     */
    @PostMapping("reservation/create")
    public boolean create(
    		@RequestBody SaveReservationDto saveReservationDto,
    		@RequestHeader("Authentication") String token

    ) {
    	Optional<User> userOptional = this.userRepository.findByToken(token);
    	if (userOptional.isEmpty()) {
            return false;
        }

    	User user = userOptional.get();

        Reservation reservation = reservationMapper.dtoToReservation(saveReservationDto);
        if (reservation != null) {
            reservationRepository.save(reservation);
            return true;
        }
        return false;
    }
    

    /*
     * PUT endpoints from here
     */


    @PutMapping("reservation/update/{id}")
    public boolean update(@PathVariable long id, @RequestBody SaveReservationDto saveReservationDto,
                          @RequestHeader("Authentication") String token

    ) {
        // User moeten opvragen
        Optional<User> userOptional = this.userRepository.findByToken(token);
        if (userOptional.isEmpty()) {
            return false;
        }

        User user = userOptional.get();
        Optional<Book> bookOptional = bookRepository.findById(saveReservationDto.getBookId());

        /*
         * Checks whether the id given in the url is a valid loanId
         */
        Optional<Reservation> optionalReservation = reservationRepository.findById(id);
        if (optionalReservation.isEmpty()) {
            return false;
        }
        Reservation reservation = optionalReservation.get();

        reservation.setUser(user);
        bookOptional.ifPresent(reservation::setBook);
        if (saveReservationDto.getDate() != null) {
            reservation.setDate(saveReservationDto.getDate());
        }

        reservationRepository.save(reservation);
        return true;
    }

    @RequestMapping(value = "reservation/delete/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable long id,
                          @RequestHeader("Authentication") String token

    ) {
        Optional<User> userOptional = this.userRepository.findByToken(token);
        if (userOptional.isEmpty()) {
            return false;
        }
        User user = userOptional.get();
        if (!user.isAdmin()){
            return false;
        }
        reservationRepository.deleteById(id);
        return true;
    }


    @RequestMapping(value = "reservation/pageable/search/{propertyToSortBy}/{directionOfSort}/{pageNumber}/{numberPerPage}", method = RequestMethod.GET)
    public Stream<ReservationAvailabilityDto> sortNormalBooksPageable(@PathVariable String propertyToSortBy, @PathVariable String directionOfSort, @PathVariable int pageNumber, @PathVariable int numberPerPage) {
        Pageable pageableAsc = PageRequest.of(pageNumber, numberPerPage, Sort.by(propertyToSortBy).ascending());
        Pageable pageableDesc = PageRequest.of(pageNumber, numberPerPage, Sort.by(propertyToSortBy).descending());
        if (directionOfSort.equals("asc")) {
            return reservationRepository.findAll(pageableAsc).stream().map(reservationMapper::reservationToAvailabilityDto);
        }
        if (directionOfSort.equals("desc")) {
            return reservationRepository.findAll(pageableDesc).stream().map(reservationMapper::reservationToAvailabilityDto);
        }
        return null;
    }

    @RequestMapping(value = "reservation/pageable/search/{searchTerm}/{propertyToSortBy}/{directionOfSort}/{pageNumber}/{numberPerPage}", method = RequestMethod.GET)
    public Stream<ReservationAvailabilityDto> sortSearchBooksPageable(@PathVariable String searchTerm, @PathVariable String propertyToSortBy, @PathVariable String directionOfSort, @PathVariable int pageNumber, @PathVariable int numberPerPage) {
        Pageable pageableAsc = PageRequest.of(pageNumber, numberPerPage, Sort.by(propertyToSortBy).ascending());
        Pageable pageableDesc = PageRequest.of(pageNumber, numberPerPage, Sort.by(propertyToSortBy).descending());
        if (directionOfSort.equals("asc")) {
            return reservationRepository.findByUser_FirstNameOrUser_LastNameOrBook_TitleContaining(searchTerm, searchTerm, searchTerm, pageableAsc).stream().map(reservationMapper::reservationToAvailabilityDto);
        }
        if (directionOfSort.equals("desc")) {
            return reservationRepository.findByUser_FirstNameOrUser_LastNameOrBook_TitleContaining(searchTerm, searchTerm, searchTerm, pageableDesc).stream().map(reservationMapper::reservationToAvailabilityDto);
        }
        return null;
    }


}