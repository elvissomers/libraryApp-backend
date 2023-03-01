package wt.bookstore.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import wt.bookstore.backend.domains.Book;
import wt.bookstore.backend.domains.Copy;
import wt.bookstore.backend.repository.ICopyRepository;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(maxAge = 3600)
public class copyController {

    @Autowired
    private ICopyRepository copyRepository;

    @RequestMapping(value = "copy", method = RequestMethod.GET)
    public List<Copy> findAll() {
        return copyRepository.findAll();
    }

    @RequestMapping(value="copy/create", method = RequestMethod.POST)
    public void create(@RequestBody Copy copy) {
        copyRepository.save(copy);
    }
    
    @RequestMapping(value = "copy/{id}", method = RequestMethod.GET)
    public Optional<Copy> find(@PathVariable long id) {
        return copyRepository.findById(id);
    }

    @RequestMapping(value = "copy/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable long id, @RequestBody Copy copy) {
        Optional<Copy> optional = copyRepository.findById(id);
        optional.get().setAvailable(copy.isAvailable());
        optional.get().setHeldByUserId(copy.getHeldByUserId());
        optional.get().setBookId(copy.getBookId());
        copyRepository.save(optional.get());
    }

    @RequestMapping(value = "copy/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        copyRepository.deleteById(id);
    }


}