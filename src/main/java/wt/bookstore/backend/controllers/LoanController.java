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

import wt.bookstore.backend.domains.Loan;
import wt.bookstore.backend.domains.User;
import wt.bookstore.backend.dto.LoanDto;
import wt.bookstore.backend.dto.SaveLoanDto;
import wt.bookstore.backend.mapping.DtoMapper;
import wt.bookstore.backend.repository.ILoanRepository;
import wt.bookstore.backend.repository.IUserRepository;

@RestController
@CrossOrigin(maxAge = 3600)
public class LoanController {

	@Autowired
	private ILoanRepository loanRepository;

	@Autowired
	private IUserRepository userRepository;

	@RequestMapping(value = "loan", method = RequestMethod.GET)
	public Stream<LoanDto> findAll() {
		// Loan omzetten naar LoanDto
		return loanRepository.findAll().stream().map( l -> {
			return DtoMapper.loanToDto(l);
		});
	}

	@RequestMapping(value = "loan/create", method = RequestMethod.POST)
	public void create(@RequestBody SaveLoanDto saveLoanDto) {
		Loan loan = DtoMapper.dtoToLoan(saveLoanDto);
		loanRepository.save(loan);
	}

	@RequestMapping(value = "loan/{id}", method = RequestMethod.GET)
	public Optional<Loan> find(@PathVariable long id) {
		return loanRepository.findById(id);
	}

	@RequestMapping(value = "loan/{id}", method = RequestMethod.PUT)
	public boolean update(@PathVariable long id, @RequestBody SaveLoanDto saveLoanDto) {
		Optional<User> userOptional = userRepository.findById(saveLoanDto.getUserId());
		if (userOptional.isEmpty())
			return false;

		Optional<Loan> optional = loanRepository.findById(id);

		optional.get().setEndDate(saveLoanDto.getEndDate());
		optional.get().setStartDate(saveLoanDto.getStartDate());
		optional.get().setUser(userOptional.get());
		loanRepository.save(optional.get());

		return true;
	}

	@RequestMapping(value = "loan/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		loanRepository.deleteById(id);
	}

}