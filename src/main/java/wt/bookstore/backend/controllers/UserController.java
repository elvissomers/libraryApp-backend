package wt.bookstore.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import wt.bookstore.backend.domains.Loan;
import wt.bookstore.backend.domains.Reservation;
import wt.bookstore.backend.domains.User;
import wt.bookstore.backend.dto.*;
import wt.bookstore.backend.mapping.UserDtoMapper;
import wt.bookstore.backend.repository.ILoanRepository;
import wt.bookstore.backend.repository.IReservationRepository;
import wt.bookstore.backend.repository.IUserRepository;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;


/**
 * The controller class that sets the API endpoints for the CRUD operations of the database that handles the users.
 */
@RestController
@CrossOrigin(maxAge = 3600)
public class UserController {

    @Autowired
    private IUserRepository userRepository;
    
    @Autowired
    private ILoanRepository loanRepository;
    
    @Autowired
    private IReservationRepository reservationRepository;

    @Autowired
    private UserDtoMapper userMapper;


    /*
     * GET endpoints from here
     */
     
    /**
     * Returns a Stream of {@link wt.bookstore.backend.dto.UserDto} for a GET request to {database_location}/user.
     * @return Stream of {@link wt.bookstore.backend.dto.UserDto}'s
     */
    @GetMapping("user/get")
    public Stream<UserDto> findAll() {
        return userRepository.findAll().stream().map(userMapper::userToDto);
    }

    /**
     * Returns a single {@link wt.bookstore.backend.dto.UserDto} with a certain id for a GET request to {database_location}/user/{id}.
     * @param id (long) of the user you want to get.
     * @return Single {@link wt.bookstore.backend.dto.UserDto}
     */
    @GetMapping("user/get/{id}")
    public Optional<UserDto> find(@PathVariable long id) {
        return Optional.of(userMapper.userToDto(userRepository.findById(id).get()));
    }


    /*
     * POST endpoints from here
     */
     
    /**
     * Creates a {@link wt.bookstore.backend.domains.User} object from a {@link wt.bookstore.backend.dto.SaveUserDto} and saves it to the database for a POST request to {database_location}/user/create. The id is autogenerated.
     * @param saveUserDto ({@link wt.bookstore.backend.dto.SaveUserDto}) is generated from the json body in the POST request and contains the information needed to create a {@link wt.bookstore.backend.domains.User} object.
     */
    @PostMapping("user/create")
    public void create(@RequestBody SaveUserDto saveUserDto) {
        User user = userMapper.dtoToUser(saveUserDto);
        userRepository.save(user);
    }

    /*
     * PUT endpoints
     */
    @PutMapping("user/{id}")
    public void update(@PathVariable long id, @RequestBody ChangeUserDto changeUserDto){
        Optional<User> optionalUser = userRepository.findById(id);
        String newFirstName = changeUserDto.getFirstName();
        String newLastName = changeUserDto.getLastName();
        String newEmailAddress = changeUserDto.getEmailAddress();
        String newPassword = changeUserDto.getPassword();
        boolean newAdmin = changeUserDto.isAdmin();

        // TODO - haal if statements ook weg uit andere put endpoints
        // TODO - maakt dit korter door bovenstaande regels in onderstaande te plaatsen
        optionalUser.get().setFirstName(newFirstName);
        optionalUser.get().setLastName(newLastName);
        optionalUser.get().setEmailAddress(newEmailAddress);
        optionalUser.get().setPassword(newPassword);
        optionalUser.get().setAdmin(newAdmin);

        userRepository.save(optionalUser.get());
    }
    
    /*
     * Uit gecomment omdat we put pas later gaan implementeren
     */

//    @RequestMapping(value = "user/{id}", method = RequestMethod.PUT)
//    public void update(@PathVariable long id, @RequestBody SaveUserDto saveUserDto) {
//        Optional<User> optional = userRepository.findById(id);
//        optional.get().setName(saveUserDto.getName());
//        optional.get().seteMailAddress(saveUserDto.geteMailAddress());
//        userRepository.save(optional.get());
//    }

    @DeleteMapping("user/{id}")
    public void delete(@PathVariable long id) {
        userRepository.deleteById(id);
    }

    //TODO: implement the endpoints below in a proper way
    @GetMapping("user/{id}/loans")
    public List<Loan> findLoans(@PathVariable long id){
    	/**
    	 * Used to find all loans of a user
    	 */
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return loanRepository.findByUser(user.get());
        } else {
            return null;
        }
    }

    @GetMapping("user/{id}/loans/open")
    public List<Loan> findOpenLoans(@PathVariable long id){
        /**
         * Used to find "open" (not yet returned) loans of a user
         */
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return loanRepository.findByUserAndEndDateNull(user.get());
        } else {
            return null;
        }
    }

    @GetMapping("user/{id}/reservations")
    public List<Reservation> findReservations(@PathVariable long id){
    	/**
    	 * Used to find all reservations of a user
    	 */
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return reservationRepository.findByUser(user.get());
        } else {
            return null;
        }
    }

    @PostMapping("api/user/login")
    public LoginResponseDto Login(@RequestBody LoginRequestDto loginRequestDto){
        Optional<User> userOptional = userRepository.findByEmailAddressAndPassword(
                loginRequestDto.getUsername(), loginRequestDto.getPassword()
        );
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            String token = generateRandomString(60);

            // Save token to user
            user.setToken(token);
            userRepository.save(user);

            return new LoginResponseDto(token, user.isAdmin());
        }

        return null;
    }

    public String generateRandomString(int targetStringLength) {

        int leftLimit = 48; // letter 'a'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();
        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }

    public String RandomStringGenerator() {
        return "abcd";
    }

    @RequestMapping(value = "user/pageable/search/{propertyToSortBy}/{directionOfSort}/{pageNumber}/{numberPerPage}", method = RequestMethod.GET)
    public Stream<UserDto> sortNormalUsersPageable(@PathVariable String propertyToSortBy, @PathVariable String directionOfSort, @PathVariable int pageNumber, @PathVariable int numberPerPage) {
        Pageable pageableAsc = PageRequest.of(pageNumber, numberPerPage, Sort.by(propertyToSortBy).ascending());
        Pageable pageableDesc = PageRequest.of(pageNumber, numberPerPage, Sort.by(propertyToSortBy).descending());
        if (directionOfSort.equals("asc")) {
            return userRepository.findAll(pageableAsc).stream().map(userMapper::userToDto);
        }
        if (directionOfSort.equals("desc")) {
            return userRepository.findAll(pageableDesc).stream().map(userMapper::userToDto);
        }
        return null;
    }

    @RequestMapping(value = "user/pageable/search/{searchTerm}/{propertyToSortBy}/{directionOfSort}/{pageNumber}/{numberPerPage}", method = RequestMethod.GET)
    public Stream<UserDto> sortSearchUsersPageable(@PathVariable String searchTerm, @PathVariable String propertyToSortBy, @PathVariable String directionOfSort, @PathVariable int pageNumber, @PathVariable int numberPerPage) {
        Pageable pageableAsc = PageRequest.of(pageNumber, numberPerPage, Sort.by(propertyToSortBy).ascending());
        Pageable pageableDesc = PageRequest.of(pageNumber, numberPerPage, Sort.by(propertyToSortBy).descending());
        if (directionOfSort.equals("asc")) {
            return userRepository.findByFirstNameOrLastName(searchTerm, searchTerm, pageableAsc).stream().map(userMapper::userToDto);
        }
        if (directionOfSort.equals("desc")) {
            return userRepository.findByFirstNameOrLastName(searchTerm, searchTerm, pageableDesc).stream().map(userMapper::userToDto);
        }
        return null;
    }

}