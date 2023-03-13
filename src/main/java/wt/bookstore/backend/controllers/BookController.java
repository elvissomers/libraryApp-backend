package wt.bookstore.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import wt.bookstore.backend.domains.Book;
import wt.bookstore.backend.dto.BookDto;
import wt.bookstore.backend.dto.ChangeBookDto;
import wt.bookstore.backend.dto.SaveBookDto;
import wt.bookstore.backend.mapping.BookDtoMapper;
import wt.bookstore.backend.repository.IBookRepository;
import wt.bookstore.backend.repository.ICopyRepository;
import wt.bookstore.backend.repository.IReservationRepository;


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
    private IReservationRepository reservationRepository;

    @Autowired
    private BookDtoMapper bookMapper;


    /*
     * GET endpoints from here
     * /


    /**
     * Returns a Stream of {@link wt.bookstore.backend.dto.BookDto} for a GET request to {database_location}/book.
     * @return Stream of {@link wt.bookstore.backend.dto.BookDto}'s
     */
    @GetMapping("book")
    public Stream<BookDto> findAll() {
        return bookRepository.findAll().stream().map(bookMapper::bookToDto);
    }

    @RequestMapping(value = "bookPage/{pageNumber}/{numberPerPage}", method = RequestMethod.GET)
    public Stream<BookDto> findAllByPage(@PathVariable int pageNumber, @PathVariable int numberPerPage) {
        Pageable pageable = PageRequest.of(pageNumber, numberPerPage);
        return bookRepository.findAll(pageable).stream().map(bookMapper::bookToDto);
    }

    /**
     * Returns a single {@link wt.bookstore.backend.dto.BookDto} with a certain id for a GET request to {database_location}/book/{id}.
     * @param id (long) of the book you want to get.
     * @return Single {@link wt.bookstore.backend.dto.BookDto}
     */
    @GetMapping("book/{id}")
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

    @PutMapping("book/{id}")
    public void update(@PathVariable long id, @RequestBody ChangeBookDto changeBookDto) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isEmpty())
            return;

        optionalBook.get().setIsbn(changeBookDto.getIsbn());
        optionalBook.get().setTitle(changeBookDto.getTitle());
        optionalBook.get().setAuthor(changeBookDto.getAuthor());

        bookRepository.save(optionalBook.get());
    }

    /*
     * DELETE endpoints from here
     */
    @DeleteMapping("book/{id}")
    public void delete(@PathVariable long id) {
        bookRepository.deleteById(id);
    }

    @RequestMapping(value = "booksearch/{query}/{pageNumber}/{numberPerPage}", method = RequestMethod.GET)
    public Stream<BookDto> searchBooks(@PathVariable String query, @PathVariable int pageNumber, @PathVariable int numberPerPage) {
        Pageable pageable = PageRequest.of(pageNumber, numberPerPage);
        return bookRepository.findByTitleContainingOrAuthorContaining(query, query, pageable).stream().map(bookMapper::bookToDto);
    }



    //TODO: implementeer deze met DTO's
//    @RequestMapping(value = "book/{id}/copies", method = RequestMethod.GET)
//    public List<Copy> findCopies(@PathVariable long id){
//    	/**
//    	 * Used to find all copies of a specific book
//    	 */
//    	return copyRepository.findByBookId(id);
//    }
//
//    @RequestMapping(value = "book/{id}/reservations", method = RequestMethod.GET)
//    public List<Reservation> findReservations(@PathVariable long id){
//    	/**
//    	 * Used to find all reservations of a specific book
//    	 */
//    	return reservationRepository.findByBookId(id);
//    }
//
}
