package wt.bookstore.backend.mapping;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import wt.bookstore.backend.domains.Book;
import wt.bookstore.backend.domains.Copy;
import wt.bookstore.backend.domains.Loan;
import wt.bookstore.backend.domains.User;
import wt.bookstore.backend.dto.LoanDto;
import wt.bookstore.backend.dto.SaveLoanDto;
import wt.bookstore.backend.repository.IBookRepository;
import wt.bookstore.backend.repository.ICopyRepository;
import wt.bookstore.backend.repository.IUserRepository;

@Component
public class LoanDtoMapper {

	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private ICopyRepository copyRepository;

    @Autowired
    private IBookRepository bookRepository;
	
	public Loan dtoToLoan(SaveLoanDto saveLoanDto) {
        /*
         * Used to create a Loan object from a saveLoanDto object
         */
        Optional<User> userOptional = userRepository.findById(saveLoanDto.getUserId());
        Optional<Book> bookOptional = bookRepository.findById(saveLoanDto.getBookId());
        Optional<Copy> copyOptional = copyRepository.findByBookAndNumber(bookOptional.get(),
                saveLoanDto.getCopyNumber()
        );

        /*
         * Check whether all necessary fields are present in the post DTO, e.g. You can not make a loan object without
         * knowing which copy is loaned
         */
        if (userOptional.isEmpty() || copyOptional.isEmpty()){
            return null;
        }

        Loan loan = new Loan();
        loan.setStartDate(saveLoanDto.getStartDate()); //Possibly Null
        loan.setUser(userOptional.get());
        loan.setCopy(copyOptional.get());

        return loan;
    }
	
    public LoanDto loanToDto(Loan loan){
        /*
         * Used to create a LoanDto object from a Loan object
         */
        LoanDto loanDto = new LoanDto();
        /*
         * The loan get DTO only has to contain information usefull to the user, e.g. Can contain the copy name instead
         * of the copy id
         */
        loanDto.setId(loan.getId());
        loanDto.setStartDate(loan.getStartDate());
        loanDto.setEndDate(loan.getEndDate());
//        loanDto.setUserFirstName(loan.getUser().getFirstName());
//        loanDto.setUserLastName(loan.getUser().getLastName());
        loanDto.setBookTitle(loan.getCopy().getBook().getTitle());
        loanDto.setBookAuthor(loan.getCopy().getBook().getAuthor());
        loanDto.setBookIsbn(loan.getCopy().getBook().getIsbn());
        loanDto.setBookId(loan.getCopy().getBook().getId());
        loanDto.setId(loan.getId());
        return loanDto;

    }

	
}
