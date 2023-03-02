package wt.bookstore.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import wt.bookstore.backend.domains.BookKeyword;
import wt.bookstore.backend.repository.IBookKeywordRepository;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(maxAge = 3600)
public class BookKeywordController {

    @Autowired
    private IBookKeywordRepository bookKeywordRepository;

    @RequestMapping(value = "bookkeyword", method = RequestMethod.GET)
    public List<BookKeyword> findAll() {
        return bookKeywordRepository.findAll();
    }

    @RequestMapping(value="bookkeyword/create", method = RequestMethod.POST)
    public void create(@RequestBody BookKeyword bookKeyword) {
    	bookKeywordRepository.save(bookKeyword);
    }
    
    @RequestMapping(value = "bookkeyword/{id}", method = RequestMethod.GET)
    public Optional<BookKeyword> find(@PathVariable long id) {
        return bookKeywordRepository.findById(id);
    }

    @RequestMapping(value = "bookkeyword/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable long id, @RequestBody BookKeyword bookKeyword) {
        Optional<BookKeyword> optional = bookKeywordRepository.findById(id);
//        optional.get().setBookId(bookKeyword.getBookId());
//        optional.get().setKeywordId(bookKeyword.getKeywordId());
        bookKeywordRepository.save(optional.get());
    }

    @RequestMapping(value = "bookkeyword/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
    	bookKeywordRepository.deleteById(id);
    }


}