package wt.bookstore.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wt.bookstore.backend.domains.Book;
import wt.bookstore.backend.domains.Copy;
import wt.bookstore.backend.domains.Reservation;
import wt.bookstore.backend.dto.BookDto;
import wt.bookstore.backend.dto.SaveBookDto;
import wt.bookstore.backend.mapping.DtoMapper;
import wt.bookstore.backend.repository.IBookRepository;
import wt.bookstore.backend.repository.ICopyRepository;
import wt.bookstore.backend.repository.IReservationRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
@CrossOrigin(maxAge = 3600)
public class BookController {

    @Autowired
    private IBookRepository bookRepository;
    
    @Autowired
    private ICopyRepository copyRepository;
    
    @Autowired
    private IReservationRepository reservationRepository;
    

    /*
     * GET endpoints from here
     */
    @RequestMapping(value = "book", method = RequestMethod.GET)
    public Stream<BookDto> findAll() {
        return bookRepository.findAll().stream().map(DtoMapper::bookToDto);
    }

    @RequestMapping(value = "book/{id}", method = RequestMethod.GET)
    public Optional<BookDto> find(@PathVariable long id) {
        return Optional.of(DtoMapper.bookToDto(bookRepository.findById(id).get()));
    }


    /*
     * POST endpoints from here
     */
    @RequestMapping(value="book/create", method = RequestMethod.POST)
    public void create(@RequestBody SaveBookDto saveBookDto) {
        Book book = DtoMapper.dtoToBook(saveBookDto);
        bookRepository.save(book);
    }
    

    /*
     * PUT endpoints from here
     */
    @RequestMapping(value="book/{id}/isbn", method = RequestMethod.PUT)
    public void updateIsbn(@PathVariable long id, @RequestBody long isbn){
        Optional<Book> optionalBook = bookRepository.findById(id);
        optionalBook.get().setIsbn(isbn);

        bookRepository.save(optionalBook.get());
    }

    @RequestMapping(value="book/{id}/title", method = RequestMethod.PUT)
    public void updateTitle(@PathVariable long id, @RequestBody String title){
        Optional<Book> optionalBook = bookRepository.findById(id);
        optionalBook.get().setTitle(title);

        bookRepository.save(optionalBook.get());
    }

    @RequestMapping(value="book/{id}/author", method = RequestMethod.PUT)
    public void updateAuthor(@PathVariable long id, @RequestBody String author){
        Optional<Book> optionalBook = bookRepository.findById(id);
        optionalBook.get().setAuthor(author);

        bookRepository.save(optionalBook.get());
    }


//    @RequestMapping(value = "book/{id}", method = RequestMethod.PUT)
//    public void update(@PathVariable long id, @RequestBody Book book) {
//        Optional<Book> optional = bookRepository.findById(id);
//        optional.get().setTitle(book.getTitle());
//        optional.get().setIsbn(book.getIsbn());
//        optional.get().setAuthor(book.getAuthor());
//
//        bookRepository.save(optional.get());
//    }


    /*
     * DELETE endpoints from here
     */
    @RequestMapping(value = "book/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        bookRepository.deleteById(id);
    }
    
    @RequestMapping(value = "book/{id}/copies", method = RequestMethod.GET)
    public List<Copy> findCopies(@PathVariable long id){
    	/**
    	 * Used to find all copies of a specific book
    	 */
    	return copyRepository.findByBookId(id);
    }
    
    @RequestMapping(value = "book/{id}/reservations", method = RequestMethod.GET)
    public List<Reservation> findReservations(@PathVariable long id){
    	/**
    	 * Used to find all reservations of a specific book
    	 */
    	return reservationRepository.findByBookId(id);
    }
    

}
