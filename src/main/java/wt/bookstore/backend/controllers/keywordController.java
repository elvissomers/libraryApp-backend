package wt.bookstore.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wt.bookstore.backend.domains.Keyword;
import wt.bookstore.backend.repository.IKeywordRepository;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(maxAge = 3600)
public class keywordController {

    @Autowired
    private IKeywordRepository repository;

    @RequestMapping(value = "keyword", method = RequestMethod.GET)
    public List<Keyword> findAll() {
        return repository.findAll();
    }

    @RequestMapping(value="keyword/create", method = RequestMethod.POST)
    public void create(@RequestBody Keyword keyword) {
        repository.save(keyword);
    }

    @RequestMapping(value = "keyword/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable long id, @RequestBody Keyword keyword) {
        Optional<Keyword> optional = repository.findById(id);
        optional.get().setKeyword(keyword.getKeyword());
        optional.get().setKeywordGroup(keyword.getKeywordGroup());
        repository.save(optional.get());
    }

    @RequestMapping(value = "keyword/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        repository.deleteById(id);
    }


}