package wt.bookstore.backend.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import wt.bookstore.backend.domains.Loan;
import wt.bookstore.backend.domains.User;
import wt.bookstore.backend.dto.LoanDto;
import wt.bookstore.backend.dto.SaveCopyDto;
import wt.bookstore.backend.dto.SaveLoanDto;
import wt.bookstore.backend.repository.ILoanRepository;
import wt.bookstore.backend.repository.IUserRepository;

import java.util.Optional;

public class DtoMapper {

    @Autowired
    private static IUserRepository userRepository;

    @Autowired
    private static ILoanRepository loanRepository;

    public static Loan dtoToLoan(SaveLoanDto saveLoanDto){
        /*
         * Used to create a Loan object from a saveLoanDto object
         */
        Optional<User> userOptional = userRepository.findById(saveLoanDto.getUserId());
        if (userOptional.isEmpty())
            return null;

        Loan loan = new Loan();
        loan.setStartDate(saveLoanDto.getStartDate());
        loan.setEndDate(saveLoanDto.getEndDate());
        loan.setUser(userOptional.get());

        return loan;
    }

    public static LoanDto loanToDto(Loan loan){
        /*
         * Used to create a LoanDto object from a Loan object
         */
        LoanDto loanDto = new LoanDto();
        loanDto.setStartDate(loan.getStartDate());
        loanDto.setEndDate(loan.getEndDate());
        loanDto.setUserId(loan.getUser().getId());
        loanDto.setName(loan.getUser().getName());
        return loanDto;

    }
}
