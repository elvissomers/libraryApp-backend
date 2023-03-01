package wt.bookstore.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wt.bookstore.backend.domains.BookKeyword;
import wt.bookstore.backend.repository.IBookKeywordRepository;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(maxAge = 3600)
public class bookKeywordController {

    @Autowired
    private IBookKeywordRepository repository;

    @RequestMapping(value = "bookKeyword", method = RequestMethod.GET)
    public List<BookKeyword> findAll() {
        return repository.findAll();
    }

    @RequestMapping(value="bookKeyword/create", method = RequestMethod.POST)
    public void create(@RequestBody BookKeyword bookKeyword) {
        repository.save(bookKeyword);
    }

    @RequestMapping(value = "bookKeyword/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable long id, @RequestBody BookKeyword bookKeyword) {
        Optional<BookKeyword> optional = repository.findById(id);
        optional.get().setBookId(bookKeyword.getBookId());
        optional.get().setKeywordId(bookKeyword.getKeywordId());
        repository.save(optional.get());
    }

    @RequestMapping(value = "bookKeyword/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        repository.deleteById(id);
    }


}