package wt.bookstore.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wt.bookstore.backend.domains.Book;
import wt.bookstore.backend.domains.Copy;
import wt.bookstore.backend.domains.Reservation;
import wt.bookstore.backend.repository.IBookRepository;
import wt.bookstore.backend.repository.ICopyRepository;
import wt.bookstore.backend.repository.IReservationRepository;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(maxAge = 3600)
public class BookController {

    @Autowired
    private IBookRepository bookRepository;
    
    @Autowired
    private ICopyRepository copyRepository;
    
    @Autowired
    private IReservationRepository reservationRepository;
    


    @RequestMapping(value = "book", method = RequestMethod.GET)
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @RequestMapping(value="book/create", method = RequestMethod.POST)
    public void create(@RequestBody Book book) {
        bookRepository.save(book);
    }
    
    @RequestMapping(value = "book/{id}", method = RequestMethod.GET)
    public Optional<Book> find(@PathVariable long id) {
        return bookRepository.findById(id);
    }

    @RequestMapping(value = "book/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable long id, @RequestBody Book book) {
        Optional<Book> optional = bookRepository.findById(id);
        optional.get().setTitle(book.getTitle());
        optional.get().setIsbn(book.getIsbn());
        optional.get().setAuthor(book.getAuthor());

        bookRepository.save(optional.get());
    }

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
