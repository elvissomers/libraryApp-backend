package wt.bookstore.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import wt.bookstore.backend.domains.Keyword;
import wt.bookstore.backend.repository.IKeywordRepository;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(maxAge = 3600)
public class KeywordController {

    @Autowired
    private IKeywordRepository keywordRepository;

    @RequestMapping(value = "keyword", method = RequestMethod.GET)
    public List<Keyword> findAll() {
        return keywordRepository.findAll();
    }

    @RequestMapping(value="keyword/create", method = RequestMethod.POST)
    public void create(@RequestBody Keyword keyword) {
    	keywordRepository.save(keyword);
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