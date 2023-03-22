package wt.bookstore.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import wt.bookstore.backend.domains.Book;
import wt.bookstore.backend.domains.Reservation;
import wt.bookstore.backend.dto.*;
import wt.bookstore.backend.mapping.BookDtoMapper;
import wt.bookstore.backend.mapping.CopyDtoMapper;
import wt.bookstore.backend.mapping.LoanDtoMapper;
import wt.bookstore.backend.mapping.ReservationDtoMapper;
import wt.bookstore.backend.repository.IBookRepository;
import wt.bookstore.backend.repository.ICopyRepository;
import wt.bookstore.backend.repository.ILoanRepository;
import wt.bookstore.backend.repository.IReservationRepository;


import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * The controller class that sets the API endpoints for the CRUD operations of the database that handles the books.
 */
@RestController
@CrossOrigin(maxAge = 3600)
public class BookController {

    @Autowired
    private IBookRepository bookRepository;
    
    @Autowired
    private ICopyRepository copyRepository;

    @Autowired
    private ILoanRepository loanRepository;
    
    @Autowired
    private IReservationRepository reservationRepository;

    @Autowired
    private BookDtoMapper bookMapper;

    @Autowired
    private CopyDtoMapper copyMapper;

    @Autowired
    private LoanDtoMapper loanMapper;

    @Autowired
    private ReservationDtoMapper reservationMapper;


    /*
     * GET endpoints from here
     * /


    /**
     * Returns a Stream of {@link wt.bookstore.backend.dto.BookDto} for a GET request to {database_location}/book.
     * @return Stream of {@link wt.bookstore.backend.dto.BookDto}'s
     */
    @GetMapping("book/get")
    public Stream<BookDto> findAll() {
        return bookRepository.findAll().stream().map(bookMapper::bookToDto);
    }


    /**
     * Returns a single {@link wt.bookstore.backend.dto.BookDto} with a certain id for a GET request to {database_location}/book/{id}.
     * @param id (long) of the book you want to get.
     * @return Single {@link wt.bookstore.backend.dto.BookDto}
     */
    @GetMapping("book/get/{id}")
    public Optional<BookDto> find(@PathVariable long id) {
        return Optional.of(bookMapper.bookToDto(bookRepository.findById(id).get()));
    }



    /*
     * POST endpoints from here
     */
    /**
     * Creates a {@link wt.bookstore.backend.domains.Book} object from a {@link wt.bookstore.backend.dto.SaveBookDto} and saves it to the database for a POST request to {database_location}/book/create. The id is autogenerated.
     * @param saveBookDto ({@link wt.bookstore.backend.dto.SaveBookDto}) is generated from the json body in the POST request and contains the information needed to create a {@link wt.bookstore.backend.domains.Book} object.
     */
    @PostMapping("book/create")
    public void create(@RequestBody SaveBookDto saveBookDto) {
        Book book = bookMapper.dtoToBook(saveBookDto);
        bookRepository.save(book);
    }

    @PutMapping("book/update/{id}")
    public void update(@PathVariable long id, @RequestBody ChangeBookDto changeBookDto) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isEmpty())
            return;

        optionalBook.get().setIsbn(changeBookDto.getIsbn());
        optionalBook.get().setTitle(changeBookDto.getTitle());
        optionalBook.get().setAuthor(changeBookDto.getAuthor());
        optionalBook.get().setArchived(changeBookDto.getArchived());

        bookRepository.save(optionalBook.get());
    }

    @PutMapping("book/archive/{id}")
    public boolean archive(@PathVariable long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isEmpty())
            return false;
        optionalBook.get().setArchived(!optionalBook.get().getArchived());

        bookRepository.save(optionalBook.get());
        return true;
    }

    /*
     * DELETE endpoints from here
     */
    @DeleteMapping("book/delete/{id}")
    public void delete(@PathVariable long id) {
        bookRepository.deleteById(id);
    }


    @RequestMapping(value = "book/pageable/search/{propertyToSearchBy}/{directionOfSort}/{pageNumber}/{numberPerPage}/{archived}", method = RequestMethod.GET)
    public Stream<BookDto> sortNormalBooksPageable(@PathVariable String propertyToSearchBy, @PathVariable String directionOfSort, @PathVariable int pageNumber, @PathVariable int numberPerPage, @PathVariable boolean archived) {
        Pageable pageableAsc = PageRequest.of(pageNumber, numberPerPage, Sort.by(propertyToSearchBy).ascending());
        Pageable pageableDesc = PageRequest.of(pageNumber, numberPerPage, Sort.by(propertyToSearchBy).descending());
        if (directionOfSort.equals("asc") && !archived) {
            return bookRepository.findByArchivedFalse(pageableAsc).stream().map(bookMapper::bookToDto);
        }
        if (directionOfSort.equals("asc")) {
            return bookRepository.findAll(pageableAsc).stream().map(bookMapper::bookToDto);
        }
        if (directionOfSort.equals("desc") && !archived) {
            return bookRepository.findByArchivedFalse(pageableDesc).stream().map(bookMapper::bookToDto);
        }
        if (directionOfSort.equals("desc")) {
            return bookRepository.findAll(pageableDesc).stream().map(bookMapper::bookToDto);
        }
        return null;
    }

    @RequestMapping(value = "book/pageable/search/{searchTerm}/{propertyToSearchBy}/{directionOfSort}/{pageNumber}/{numberPerPage}/{archived}", method = RequestMethod.GET)
    public Stream<BookDto> sortSearchBooksPageable(@PathVariable String searchTerm, @PathVariable String propertyToSearchBy, @PathVariable String directionOfSort, @PathVariable int pageNumber, @PathVariable int numberPerPage, @PathVariable boolean archived) {
        Pageable pageableAsc = PageRequest.of(pageNumber, numberPerPage, Sort.by(propertyToSearchBy).ascending());
        Pageable pageableDesc = PageRequest.of(pageNumber, numberPerPage, Sort.by(propertyToSearchBy).descending());
        if (directionOfSort.equals("asc") && !archived) {
            return bookRepository.findByArchivedFalseAndTitleContainingOrAuthorContaining(searchTerm, searchTerm, pageableAsc).stream().map(bookMapper::bookToDto);
        }
        if (directionOfSort.equals("asc")) {
            return bookRepository.findByTitleContainingOrAuthorContaining(searchTerm, searchTerm, pageableAsc).stream().map(bookMapper::bookToDto);
        }
        if (directionOfSort.equals("desc") && !archived) {
            return bookRepository.findByArchivedFalseAndTitleContainingOrAuthorContaining(searchTerm, searchTerm, pageableDesc).stream().map(bookMapper::bookToDto);
        }
        if (directionOfSort.equals("desc")) {
            return bookRepository.findByTitleContainingOrAuthorContaining(searchTerm, searchTerm, pageableAsc).stream().map(bookMapper::bookToDto);
        }
        return null;
    }

    @GetMapping("book/copies/{id}")
    public Stream<CopyDto> findCopies(@PathVariable long id){
    	/**
    	 * Used to find all copies of a specific book
    	 */
    	Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isEmpty()){
            return null;
        }
        return copyRepository.findByBookAndArchivedFalse(optionalBook.get()).stream().map(copyMapper::copyToDto);
    }

    @GetMapping("book/copies/archived/{id}")
    public Stream<CopyDto> findCopiesArchived(@PathVariable long id){
        /**
         * Used to find all copies of a specific book
         */
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isEmpty()){
            return null;
        }
        return copyRepository.findByBook(optionalBook.get()).stream().map(copyMapper::copyToDto);
    }


    @GetMapping("book/loans/{id}")
    public Stream<LoanDto> findLoans(@PathVariable long id){
        /**
         * Used to find all "open" loans on a specific book
         */
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isEmpty()){
            return null;
        }

        return loanRepository.findByCopy_BookAndEndDateNull(optionalBook.get()).stream().map(loanMapper::loanToDto);
    }

    @GetMapping("book/reservations/{id}")
    public Stream<ReservationAvailabilityDto> findReservations(@PathVariable long id){
        /**
         * Used to find all reservations on a specific book
         */
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isEmpty()){
            return null;
        }

        return reservationRepository.findByBook(optionalBook.get()).stream().map(reservationMapper::reservationToAvailabilityDto);
    }
}
