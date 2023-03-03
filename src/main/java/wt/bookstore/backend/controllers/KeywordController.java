package wt.bookstore.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import wt.bookstore.backend.domains.Keyword;
import wt.bookstore.backend.dto.SaveKeywordDto;
import wt.bookstore.backend.mapping.DtoMapper;
import wt.bookstore.backend.repository.IBookRepository;
import wt.bookstore.backend.repository.IKeywordRepository;
import wt.bookstore.backend.domains.Book;

import java.security.Key;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(maxAge = 3600)
public class KeywordController {

    @Autowired
    private IKeywordRepository keywordRepository;

    @Autowired
    private IBookRepository bookRepository;

    @RequestMapping(value = "keyword", method = RequestMethod.GET)
    public List<Keyword> findAll() {
        return keywordRepository.findAll();
    }

    @RequestMapping(value="keyword/create", method = RequestMethod.POST)
    public boolean create(@RequestBody SaveKeywordDto saveKeywordDto) {
        /**
         * Used to create/modify a keyword in the keyword table from a saveKeyWordDto object.
         *
         * If the keyword is already present in the table, it will append the book in the
         * given dto to the existing keyword.
         * If not, it will create a new Keyword object.
         */
    	long bookId = saveKeywordDto.getBookId();
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        Optional<Keyword> keywordInTable = keywordRepository.findByName(saveKeywordDto.getName());
        if (keywordInTable.isPresent()) {
            keywordInTable.get().getBooks().add(optionalBook.get());
            return true;
        } else {
            Keyword keyword = DtoMapper.dtoToKeyword(saveKeywordDto, bookRepository);
            if (keyword != null) {
                keywordRepository.save(keyword);
                return true;
            } else {
                return false;
            }
        }

    }
    
    @RequestMapping(value = "keyword/{id}", method = RequestMethod.GET)
    public Optional<Keyword> find(@PathVariable long id) {
        return keywordRepository.findById(id);
    }

    @RequestMapping(value = "keyword/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable long id, @RequestBody Keyword keyword) {
        Optional<Keyword> optional = keywordRepository.findById(id);
//        optional.get().setBookId(keyword.getBookId());
//        optional.get().setKeywordId(keyword.getKeywordId());
        keywordRepository.save(optional.get());
    }

    @RequestMapping(value = "keyword/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
    	keywordRepository.deleteById(id);
    }


}