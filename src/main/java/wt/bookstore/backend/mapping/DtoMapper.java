package wt.bookstore.backend.mapping;

import wt.bookstore.backend.domains.*;
import wt.bookstore.backend.dto.*;
import wt.bookstore.backend.repository.*;

import java.util.Optional;

public class DtoMapper {

//    @Autowired
//    private static IUserRepository userRepository;
//
//    @Autowired
//    private static ILoanRepository loanRepository;
//
//    @Autowired
//    private static IReservationRepository reservationRepository;
//
//    @Autowired
//    private static ICopyRepository copyRepository;

    public static Loan dtoToLoan(SaveLoanDto saveLoanDto, IUserRepository userRepository, IReservationRepository reservationRepository, ICopyRepository copyRepository){
        /*
         * Used to create a Loan object from a saveLoanDto object
         */
        Optional<User> userOptional = userRepository.findById(saveLoanDto.getUserId());
        Optional<Reservation> reservationOptional = reservationRepository.findById(saveLoanDto.getReservationId());
        Optional<Copy> copyOptional = copyRepository.findById(saveLoanDto.getCopyId());

        /*
         * Check whether all necessary fields are present in the post DTO, e.g. You can not make a loan object without
         * knowing which copy is loaned
         */
        if (userOptional.isEmpty() || reservationOptional.isEmpty() || copyOptional.isEmpty())
            return null;

        Loan loan = new Loan();
        loan.setStartDate(saveLoanDto.getStartDate()); //Possibly Null
        loan.setEndDate(saveLoanDto.getEndDate()); //Possibly Null
        loan.setUser(userOptional.get());
        loan.setCopy(copyOptional.get());
        loan.setReservation(reservationOptional.get());

        return loan;
    }

    public static Reservation dtoToReservation(SaveReservationDto saveReservationDto, IUserRepository userRepository, IBookRepository bookRepository, ILoanRepository loanRepository){
        /*
         * Used to create a Reservation object from a saveReservationDto object
         */
        Optional<User> userOptional = userRepository.findById(saveReservationDto.getUserId());
        Optional<Loan> loanOptional = loanRepository.findById(saveReservationDto.getLoanId());
        Optional<Book> bookOptional = bookRepository.findById(saveReservationDto.getBookId());

        /*
         * Check whether all necessary fields are present in the post DTO, e.g. You can not make a loan object without
         * knowing which copy is loaned
         */
        if (userOptional.isEmpty() || bookOptional.isEmpty())
            return null;

        Reservation reservation = new Reservation();
        reservation.setDate(saveReservationDto.getDate());
        if (loanOptional.isPresent()) {
            reservation.setLoan(loanOptional.get());
        }
        reservation.setBook(bookOptional.get());
        reservation.setUser(userOptional.get());

        return reservation;
    }

    public static LoanDto loanToDto(Loan loan){
        /*
         * Used to create a LoanDto object from a Loan object
         */
        LoanDto loanDto = new LoanDto();
        /*
         * The loan get DTO only has to contain information usefull to the user, e.g. Can contain the copy name instead
         * of the copy id
         */
        loanDto.setStartDate(loan.getStartDate());
        loanDto.setEndDate(loan.getEndDate());
        loanDto.setUserName(loan.getUser().getName());
        loanDto.setCopyName(loan.getCopy().getBook().getTitle());
        loanDto.setReservationId(loan.getReservation().getId());
        return loanDto;

    }

    public static ReservationDto reservationToDto(Reservation reservation){
        /*
         * Used to create a ReservationDto object from a Reservation object
         */
        ReservationDto reservationDto = new ReservationDto();

        reservationDto.setBookTitle(reservation.getBook().getTitle());
        reservationDto.setUserName(reservation.getUser().getName());
        reservationDto.setDate(reservation.getDate());

        return reservationDto;
    }
}
