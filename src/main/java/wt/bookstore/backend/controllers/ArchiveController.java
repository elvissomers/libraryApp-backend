package wt.bookstore.backend.controllers;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import wt.bookstore.backend.domains.User;
import wt.bookstore.backend.repository.IUserRepository;

@RestController
public class ArchiveController {

    @Autowired
    private IUserRepository userRepository;
    
}
