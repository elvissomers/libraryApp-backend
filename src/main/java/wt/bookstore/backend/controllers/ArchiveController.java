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
    
    @PutMapping("archive/user/{id}")
    public boolean ArchiveDomain(@PathVariable long id){
        Optional<User> optionalUser = userRepository.findById(id);

        optionalUser.get().setFirstName("[Archived]");
        optionalUser.get().setLastName("[Archived]");
        optionalUser.get().setEmailAddress("[Archived]");
        optionalUser.get().setAdmin(false);
        optionalUser.get().setPassword("[Archived]");
        optionalUser.get().setArchived(true);

        if (userRepository.save(optionalUser.get()) != null){
            return true;
        }
        else{
            return false;
        }
    }
}
