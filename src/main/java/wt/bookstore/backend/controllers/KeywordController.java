package wt.bookstore.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import wt.bookstore.backend.domains.Keyword;
import wt.bookstore.backend.dto.KeywordDto;
import wt.bookstore.backend.dto.SaveKeywordDto;
import wt.bookstore.backend.mapping.KeywordDtoMapper;
import wt.bookstore.backend.repository.IBookRepository;
import wt.bookstore.backend.repository.IKeywordRepository;
import wt.bookstore.backend.domains.Book;

import java.util.Optional;
import java.util.stream.Stream;

@RestController
@CrossOrigin(maxAge = 3600)
public class KeywordController {

    @Autowired
    private IKeywordRepository keywordRepository;

    @Autowired
    private IBookRepository bookRepository;

    @Autowired
    private KeywordDtoMapper keywordMapper;

    @GetMapping("keyword")
    public Stream<KeywordDto> findAll() {
        return keywordRepository.findAll().stream().map(keywordMapper::keywordToDto);
    }

    @GetMapping("keyword/{id}")
    public Optional<KeywordDto> find(@PathVariable long id) {
        return Optional.of(keywordMapper.keywordToDto(keywordRepository.findById(id).get()));
    }

    /**
     * Used to create/modify a keyword in the keyword table from a saveKeyWordDto object.
     *
     * If the keyword is already present in the table, it will append the book in the
     * given dto to the existing keyword.
     * If not, it will create a new Keyword object.
     */
    @PostMapping("keyword/create")
    public boolean create(@RequestBody SaveKeywordDto saveKeywordDto) {

    	long bookId = saveKeywordDto.getBookId();
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        Optional<Keyword> keywordInTable = keywordRepository.findByName(saveKeywordDto.getName());


        if (keywordInTable.isPresent()) {
            optionalBook.get().addKeyword(keywordInTable.get());
            keywordInTable.get().addBook(optionalBook.get());

            bookRepository.save(optionalBook.get()); // Misschien is één van de twee overbodig,
            keywordRepository.save(keywordInTable.get()); // maar het veroorzaakt geen problemen
            return true;
        } else {
            //}
            Keyword keyword = keywordMapper.dtoToKeyword(saveKeywordDto);
            if (keyword != null) {
                keywordRepository.save(keyword);
                return true;
            } else {
                return false;
            }
        }
    }

//
//    @RequestMapping(value = "keyword/{id}", method = RequestMethod.PUT)
//    public void update(@PathVariable long id, @RequestBody Keyword keyword) {
//        Optional<Keyword> optional = keywordRepository.findById(id);
////        optional.get().setBookId(keyword.getBookId());
////        optional.get().setKeywordId(keyword.getKeywordId());
//        keywordRepository.save(optional.get());
//    }

    @DeleteMapping("keyword/{id}")
    public void delete(@PathVariable long id) {
    	keywordRepository.deleteById(id);
    }


}