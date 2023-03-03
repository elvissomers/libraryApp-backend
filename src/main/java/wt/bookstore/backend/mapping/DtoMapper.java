package wt.bookstore.backend.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import wt.bookstore.backend.domains.Copy;
import wt.bookstore.backend.domains.Loan;
import wt.bookstore.backend.domains.Reservation;
import wt.bookstore.backend.domains.User;
import wt.bookstore.backend.dto.LoanDto;
import wt.bookstore.backend.dto.SaveCopyDto;
import wt.bookstore.backend.dto.SaveLoanDto;
import wt.bookstore.backend.repository.ICopyRepository;
import wt.bookstore.backend.repository.ILoanRepository;
import wt.bookstore.backend.repository.IReservationRepository;
import wt.bookstore.backend.repository.IUserRepository;

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
}
