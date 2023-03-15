package wt.bookstore.backend.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import wt.bookstore.backend.domains.*;
import wt.bookstore.backend.dto.*;
import wt.bookstore.backend.mapping.LoanDtoMapper;
import wt.bookstore.backend.repository.IBookRepository;
import wt.bookstore.backend.repository.ICopyRepository;
import wt.bookstore.backend.repository.ILoanRepository;
import wt.bookstore.backend.repository.IUserRepository;

/**
 * The controller class that sets the API endpoints for the CRUD operations of the database that handles the loans.
 */
@RestController
@CrossOrigin(maxAge = 3600)
public class LoanController {

	@Autowired
	private ILoanRepository loanRepository;

	@Autowired
	private IUserRepository userRepository;

	@Autowired
	private IBookRepository bookRepository;

	@Autowired
	private ICopyRepository copyRepository;

	@Autowired
	private LoanDtoMapper loanMapper;

	/*
	 * GET endpoints from here
   */
   
	/**
	 * Returns a Stream of {@link wt.bookstore.backend.dto.LoanDto} for a GET request to {database_location}/loan.
	 * @return Stream of {@link wt.bookstore.backend.dto.LoanDto}'s
	 */
   
	@GetMapping("loan")
	public Stream<LoanDto> findAll() {
		// Loan omzetten naar LoanDto
		return loanRepository.findAll().stream().map(loanMapper::loanToDto);
	}

	@GetMapping("loan/open")
	public Stream<LoanDto> findAllAvailable() {
		return loanRepository.findByEndDateNull().stream().map(loanMapper::loanToDto);
	}

	/**
	 * Returns a single {@link wt.bookstore.backend.dto.LoanDto} with a certain id for a GET request to {database_location}/loan/{id}.
	 * @param id (long) of the loan you want to get.
	 * @return Single {@link wt.bookstore.backend.dto.LoanDto}
	 */
	@GetMapping("loan/{id}")
	public Optional<LoanDto> find(@PathVariable long id) {
		return Optional.of(loanMapper.loanToDto(loanRepository.findById(id).get()));
	}


	/*
	 * POST endpoints from here
   */


	/**
	 * Saves a loan from a given loan dto
	 * -> A loan dto has a start date, bookId, usedId and copyNumber
	 *
	 *  -- Returns false if one of the Id's refers to a non-existing object,
	 *  or if the provided copy is not available.
	 *  -- Also sets the provided copy to not available if loan is created.
	 *  -- Should be used in combination with findByBook from CopyController
	 */
	@PostMapping("loan/create")
	public boolean createNew(@RequestBody SaveLoanDto saveLoanDto) {
		Loan loan = loanMapper.dtoToLoan(saveLoanDto);
		if (loan != null) {
			Copy copy = loan.getCopy();
			if (!copy.isAvailable()){
				return false;
			}
			copy.setAvailable(false);
			copyRepository.save(copy);
			loanRepository.save(loan);
			return true;
		}
		return false;
	}


	/**
	 * Used to create a Loan from a reservation Dto object.
	 * If no copies of the reserved book are available, it gives a 500 http error
	 * @param saveReservationDto
	 */
	@PostMapping("loan/create/fromreservation")
	public boolean createFromReservation(@RequestBody SaveReservationDto saveReservationDto){
		Loan loan = new Loan();

		Optional<User> user = userRepository.findById(saveReservationDto.getUserId());
		Optional<Book> book = bookRepository.findById(saveReservationDto.getBookId());
		List<Copy> copyList = copyRepository.findByAvailableTrueAndBook(book.get());


		if (user.isEmpty() || book.isEmpty()){
			return false;
		}
		if (copyList.isEmpty()){
			return false;
		}

		Copy copy = getRandomElement(copyList);
		Optional<Copy> copyOptional = copyRepository.findById(copy.getId());
		copyOptional.get().setAvailable(false);
		copyRepository.save(copyOptional.get());

		loan.setStartDate(saveReservationDto.getDate());
		loan.setCopy(copy);
		loan.setUser(user.get());

		loanRepository.save(loan);
		return true;
	}


	/*
	 * PUT endpoints from here
	 */

	/**
	 * Used to "change" a loan - in the frontend this will be used to end a loan,
	 * which means changing its end date. No other attributes are changed.
	 *  -- It also sets the copy back to available.
	 *
	 * @param id the id of the loan to change
	 * @param changeLoanDto contains only an end date as of now (should be today)
	 * @return true if change was succesful, false otherwise
	 */
	@PutMapping("loan/{id}")
	public boolean update(@PathVariable long id, @RequestBody ChangeLoanDto changeLoanDto){
		Optional<Loan> optionalLoan = loanRepository.findById(id);

		if (optionalLoan.isEmpty()){
			return false;
		}

		// We will also set the used copy back to available
		Copy copy = optionalLoan.get().getCopy();
		copy.setAvailable(true);
		copyRepository.save(copy);

		// Should be set to current date in the front end
		LocalDate newEndDate = changeLoanDto.getEndDate();

		if (newEndDate != null){
			optionalLoan.get().setEndDate(newEndDate);
		}

		loanRepository.save(optionalLoan.get());
		return true;
	}




	/*
	 * DELETE endpoints from here
	 */
	@DeleteMapping("loan/{id}")
	public void delete(@PathVariable long id) {
		loanRepository.deleteById(id);
	}


	// TODO : move "misc" functions to separate file ?
	public Copy getRandomElement(List<Copy> list){
		Random rand = new Random();

		Copy randomCopy = list.get(rand.nextInt(list.size()));

		return randomCopy;
	}

	@RequestMapping(value = "loansearch/{query}/{pageNumber}/{numberPerPage}", method = RequestMethod.GET)
	public Stream<LoanDto> searchLoans(@PathVariable String query, @PathVariable int pageNumber, @PathVariable int numberPerPage) {
		Pageable pageable = PageRequest.of(pageNumber, numberPerPage);
		return loanRepository.findByUser_FirstNameOrUser_LastNameOrCopy_Book_TitleContaining(query, query, query, pageable).stream().map(loanMapper::loanToDto);
	}

}