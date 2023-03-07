package wt.bookstore.backend.controllers;

import java.time.LocalDate;
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
import wt.bookstore.backend.dto.ChangeLoanDto;
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


	/*
	 * GET endpoints from here
	 */
	@RequestMapping(value = "loan", method = RequestMethod.GET)
	public Stream<LoanDto> findAll() {
		// Loan omzetten naar LoanDto
		return loanRepository.findAll().stream().map(DtoMapper::loanToDto);
	}

	@RequestMapping(value = "loan/{id}", method = RequestMethod.GET)
	public Optional<LoanDto> find(@PathVariable long id) {
		return Optional.of(DtoMapper.loanToDto(loanRepository.findById(id).get()));
	}


	/*
	 * POST endpoints from here
	 */
	@RequestMapping(value = "loan/create", method = RequestMethod.POST)
	public boolean create(@RequestBody SaveLoanDto saveLoanDto) {
		Loan loan = DtoMapper.dtoToLoan(saveLoanDto,userRepository,  copyRepository);
		if (loan != null) {
			loanRepository.save(loan);
			return true;
		}
		return false;
	}


	/*
	 * PUT endpoints from here
	 */
	@RequestMapping(value="loan/{id}/startdate", method = RequestMethod.PUT)
	public void updateStartDate(@PathVariable long id, @RequestBody LocalDate startDate){
		Optional<Loan> optionalLoan = loanRepository.findById(id);
		optionalLoan.get().setStartDate(startDate);

		loanRepository.save(optionalLoan.get());
	}

	@RequestMapping(value="loan/{id}/enddate", method = RequestMethod.PUT)
	public void updateEndDate(@PathVariable long id, @RequestBody LocalDate endDate){
		Optional<Loan> optionalLoan = loanRepository.findById(id);
		optionalLoan.get().setEndDate(endDate);

		loanRepository.save(optionalLoan.get());
	}

	@RequestMapping(value = "loan/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable long id, @RequestBody ChangeLoanDto changeLoanDto){
		Optional<Loan> optionalLoan = loanRepository.findById(id);
		LocalDate newEndDate = changeLoanDto.getEndDate();
		LocalDate newStartDate = changeLoanDto.getStartDate();

		if (newEndDate != null){
			optionalLoan.get().setEndDate(newEndDate);
		}
		if (newStartDate != null){
			optionalLoan.get().setStartDate(newStartDate);
		}

		loanRepository.save(optionalLoan.get());
	}


	/*
	 * DELETE endpoints from here
	 */
	@RequestMapping(value = "loan/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		loanRepository.deleteById(id);
	}



}