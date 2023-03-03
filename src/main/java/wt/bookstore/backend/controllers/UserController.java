package wt.bookstore.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import wt.bookstore.backend.domains.Loan;
import wt.bookstore.backend.domains.Reservation;
import wt.bookstore.backend.domains.User;
import wt.bookstore.backend.dto.SaveUserDto;
import wt.bookstore.backend.mapping.DtoMapper;
import wt.bookstore.backend.repository.ILoanRepository;
import wt.bookstore.backend.repository.IReservationRepository;
import wt.bookstore.backend.repository.IUserRepository;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(maxAge = 3600)
public class UserController {

    @Autowired
    private IUserRepository userRepository;
    
    @Autowired
    private ILoanRepository loanRepository;
    
    @Autowired
    private IReservationRepository reservationRepository;

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public Optional<User> find(@PathVariable long id) {
        return userRepository.findById(id);
    }

    @RequestMapping(value="user/create", method = RequestMethod.POST)
    public void create(@RequestBody SaveUserDto saveUserDto) {
        User user = DtoMapper.dtoToUser(saveUserDto);
        userRepository.save(user);
    }
    


    @RequestMapping(value = "user/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable long id, @RequestBody SaveUserDto saveUserDto) {
        Optional<User> optional = userRepository.findById(id);
        optional.get().setName(saveUserDto.getName());
        optional.get().seteMailAddress(saveUserDto.geteMailAddress());
        optional.get().setAdmin(saveUserDto.isAdmin());
        userRepository.save(optional.get());
    }

    @RequestMapping(value = "user/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        userRepository.deleteById(id);
    }
    
    @RequestMapping(value = "user/{id}/loans", method = RequestMethod.GET)
    public List<Loan> findLoans(@PathVariable long id){
    	/**
    	 * Used to find all loans of a user
    	 */
    	return loanRepository.findByUserId(id);
    }
    
    @RequestMapping(value = "user/{id}/reservations", method = RequestMethod.GET)
    public List<Reservation> findReservations(@PathVariable long id){
    	/**
    	 * Used to find all reservations of a user
    	 */
    	return reservationRepository.findByUserId(id);
    }

}