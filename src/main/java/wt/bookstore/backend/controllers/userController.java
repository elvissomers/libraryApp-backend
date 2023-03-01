package wt.bookstore.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import wt.bookstore.backend.domains.Copy;
import wt.bookstore.backend.domains.User;
import wt.bookstore.backend.repository.ICopyRepository;
import wt.bookstore.backend.repository.IUserRepository;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(maxAge = 3600)
public class userController {

    @Autowired
    private IUserRepository userRepository;

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @RequestMapping(value="user/create", method = RequestMethod.POST)
    public void create(@RequestBody User user) {
        userRepository.save(user);
    }

    @RequestMapping(value = "user/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable long id, @RequestBody User user) {
        Optional<User> optional = userRepository.findById(id);
        optional.get().setName(user.getName());
        optional.get().seteMailAddress(user.geteMailAddress());
        optional.get().setAdmin(user.getAdmin());
        userRepository.save(optional.get());
    }

    @RequestMapping(value = "user/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        userRepository.deleteById(id);
    }

}