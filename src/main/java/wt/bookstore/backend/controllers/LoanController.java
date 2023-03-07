package wt.bookstore.backend.controllers;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import wt.bookstore.backend.domains.Copy;
import wt.bookstore.backend.domains.Loan;
import wt.bookstore.backend.domains.Reservation;
import wt.bookstore.backend.domains.User;
import wt.bookstore.backend.dto.LoanDto;
import wt.bookstore.backend.dto.SaveLoanDto;
import wt.bookstore.backend.mapping.DtoMapper;
import wt.bookstore.backend.repository.ICopyRepository;
import wt.bookstore.backend.repository.ILoanRepository;
import wt.bookstore.backend.repository.IReservationRepository;
import wt.bookstore.backend.repository.IUserRepository;

@RestController
@CrossOrigin(maxAge = 3600)
public class LoanController {

	@Autowired
	private ILoanRepository loanRepository;

	@Autowired
	private IUserRepository userRepository;

	@Autowired
	private ICopyRepository copyRepository;


	@RequestMapping(value = "loan", method = RequestMethod.GET)
	public Stream<LoanDto> findAll() {
		// Loan omzetten naar LoanDto
		return loanRepository.findAll().stream().map(DtoMapper::loanToDto);
	}

	@RequestMapping(value = "loan/{id}", method = RequestMethod.GET)
	public Optional<LoanDto> find(@PathVariable long id) {
		return Optional.of(DtoMapper.loanToDto(loanRepository.findById(id).get()));
	}

	@RequestMapping(value = "loan/create", method = RequestMethod.POST)
	public boolean create(@RequestBody SaveLoanDto saveLoanDto) {
		Loan loan = DtoMapper.dtoToLoan(saveLoanDto,userRepository,  copyRepository);
		if (loan != null) {
			loanRepository.save(loan);
			return true;
		}
		return false;
	}

	@RequestMapping(value = "loan/{id}", method = RequestMethod.PUT)
	public boolean update(@PathVariable long id, @RequestBody SaveLoanDto saveLoanDto) {

		Optional<User> userOptional = userRepository.findById(saveLoanDto.getUserId());
		Optional<Copy> copyOptional = copyRepository.findById(saveLoanDto.getCopyId());
		/*
		 * Converts a post DTO to a loan object, if the post DTO misses a userId, loanId
		 * or reservationId it returns null, since it will not be a valid data entry
		 */


		/*
		 * Checks whether the id given in the url is a valid loanId
		 */
		Optional<Loan> optional = loanRepository.findById(id);
		if (optional.isEmpty())
			return false;

		/*
		 * Overwrites all the existing fields (except the ID) of the loan with the given loadId for the
		 * values given in the post DTO and saves it back in the database
		 */
		Loan existingLoan = optional.get();

		userOptional.ifPresent(existingLoan::setUser);
		copyOptional.ifPresent(existingLoan::setCopy);
		if (saveLoanDto.getStartDate() != null) {
			existingLoan.setStartDate(saveLoanDto.getStartDate());
		}
		if (saveLoanDto.getEndDate() != null) {
			existingLoan.setEndDate(saveLoanDto.getEndDate());
		}

		loanRepository.save(existingLoan);
		return true;
	}

	@RequestMapping(value = "loan/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		loanRepository.deleteById(id);
	}



}