package wt.bookstore.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wt.bookstore.backend.domains.Book;
import wt.bookstore.backend.domains.Copy;
import wt.bookstore.backend.repository.IBookRepository;
import wt.bookstore.backend.repository.ICopyRepository;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(maxAge = 3600)
public class bookController {

    @Autowired
    private IBookRepository bookRepository;
    
    @Autowired
    private ICopyRepository copyRepository;

    @RequestMapping(value = "book", method = RequestMethod.GET)
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @RequestMapping(value="book/create", method = RequestMethod.POST)
    public void create(@RequestBody Book book) {
        bookRepository.save(book);
    }

    @RequestMapping(value = "book/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable long id, @RequestBody Book book) {
        Optional<Book> optional = bookRepository.findById(id);
        optional.get().setTitle(book.getTitle());
        optional.get().setISBN(book.getISBN());
        optional.get().setAuthor(book.getAuthor());


        bookRepository.save(optional.get());
    }

    @RequestMapping(value = "book/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        bookRepository.deleteById(id);
    }
    
    @RequestMapping(value = "book/{id}/copies", method = RequestMethod.GET)
    public List<Copy> findCopies(@PathVariable long id){
    	return copyRepository.findByBookId(id);
    }

    
}
