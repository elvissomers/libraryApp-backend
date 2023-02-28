package wt.bookstore.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wt.bookstore.backend.domains.Book;
import wt.bookstore.backend.repository.IBookRepository;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(maxAge = 3600)
public class bookController {

    @Autowired
    private IBookRepository repository;

    @RequestMapping(value = "book", method = RequestMethod.GET)
    public List<Book> findAll() {
        return repository.findAll();
    }

    @RequestMapping(value="book/create", method = RequestMethod.POST)
    public void create(@RequestBody Book book) {
        repository.save(book);
    }

    @RequestMapping(value = "book/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable long id, @RequestBody Book book) {
        Optional<Book> optional = repository.findById(id);
        optional.get().setTitle(book.getTitle());
        optional.get().setISBN(book.getISBN());
        //optional.get().setKeywords(book.getKeywords());
        optional.get().setAuthor(book.getAuthor());


        repository.save(optional.get());
    }

    @RequestMapping(value = "book/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        repository.deleteById(id);
    }

    
}
