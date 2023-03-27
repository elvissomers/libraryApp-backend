package wt.bookstore.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import wt.bookstore.backend.domains.Loan;
import wt.bookstore.backend.domains.User;
import wt.bookstore.backend.dto.*;
import wt.bookstore.backend.dto.searchdtos.SearchParametersDto;
import wt.bookstore.backend.dto.searchdtos.SearchResultDto;
import wt.bookstore.backend.email.EmailService;
import wt.bookstore.backend.mapping.LoanDtoMapper;
import wt.bookstore.backend.mapping.ReservationDtoMapper;
import wt.bookstore.backend.mapping.UserDtoMapper;
import wt.bookstore.backend.repository.ILoanRepository;
import wt.bookstore.backend.repository.IReservationRepository;
import wt.bookstore.backend.repository.IUserRepository;

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

    @Autowired
    private LoanDtoMapper loanMapper;

    @Autowired
    private ReservationDtoMapper reservationMapper;

    @Autowired
    private EmailService emailService;


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

    @GetMapping("user/getbytoken/{token}")
    public Optional<UserDto> findByToken(@PathVariable String token) {
        return Optional.of(userMapper.userToDto(userRepository.findByTokenAndArchivedFalse(token).get()));
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
        String subject = "Welkom bij de bibliotheek!";
        String message = "Hi " + saveUserDto.getFirstName() + ",\n\n"
                + "Een van onze admins heeft je geregistreerd voor onze bibliotheek \n"
                + "Als dit niet de bedoeling is hebben we daar nog niks voor bedacht \n\n"
                + "Met vriendelijke groet, \n\n"
                + "De Working Talent mensen";
        emailService.sendSimpleMessage("WTLibrary@workingtalent.com", saveUserDto.getEmailAddress(), subject, message);
        userRepository.save(user);
    }

    /*
     * PUT endpoints
     */
    @PutMapping("user/{id}")
    public void update(@PathVariable long id, @RequestBody ChangeUserDto changeUserDto){
        Optional<User> optionalUser = userRepository.findById(id);

        // TODO - haal if statements ook weg uit andere put endpoints
        optionalUser.get().setFirstName(changeUserDto.getFirstName());
        optionalUser.get().setLastName(changeUserDto.getLastName());
        optionalUser.get().setEmailAddress(changeUserDto.getEmailAddress());
        optionalUser.get().setAdmin(changeUserDto.isAdmin());
        optionalUser.get().setArchived(changeUserDto.isArchived());

        userRepository.save(optionalUser.get());
    }

    @PutMapping("user/self/{id}")
    public void updateSelf(@PathVariable long id, @RequestBody ChangeUserSelfDto changeUserDto){
        Optional<User> optionalUser = userRepository.findById(id);

        // TODO - haal if statements ook weg uit andere put endpoints
        optionalUser.get().setFirstName(changeUserDto.getFirstName());
        optionalUser.get().setLastName(changeUserDto.getLastName());
        optionalUser.get().setEmailAddress(changeUserDto.getEmailAddress());
        optionalUser.get().setAdmin(changeUserDto.isAdmin());
        optionalUser.get().setArchived(changeUserDto.isArchived());
        optionalUser.get().setPassword(changeUserDto.getPassword());

        userRepository.save(optionalUser.get());
    }

    @PutMapping("/user/archive/{id}")
    public boolean ArchiveDomain(@PathVariable long id){
        Optional<User> optionalUser = userRepository.findById(id);

        optionalUser.get().setFirstName("Archived");
        optionalUser.get().setLastName("Archived");
        optionalUser.get().setEmailAddress("archived@archived.com");
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
    @PutMapping("user/change-password")
    public boolean changePassword(@RequestBody ChangeUserPasswordDto changeUserPasswordDto){

        Optional<User> userOptional = userRepository.findByEmailAddressAndPasswordAndArchivedFalse(
                changeUserPasswordDto.getEmail(), changeUserPasswordDto.getOldPassword()
        );

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            user.setPassword(changeUserPasswordDto.getNewPassword());
            userRepository.save(user);

            return true;
        }
        return false;
    }

    @PutMapping("user/reset-password")
    public boolean changePassword(@RequestBody ResetUserPasswordDto resetUserPasswordDto){

        Optional<User> userOptional = userRepository.findByEmailAddressAndArchivedFalse(
                resetUserPasswordDto.getEmail()
        );

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            user.setPassword(resetUserPasswordDto.getNewPassword());
            userRepository.save(user);

            return true;
        }
        return false;
    }

    @PutMapping("user/password/{id}")
    public void updatePassword(@PathVariable long id, @RequestBody String newPassword) {
        Optional<User> optionalUser = userRepository.findById(id);
        optionalUser.get().setPassword(newPassword);

        userRepository.save(optionalUser.get());
    }
    
    @GetMapping("user/self/{id}/{password}")
    public boolean checkPassword(@PathVariable long id, @PathVariable String password){
        Optional<User> optionalUser = userRepository.findById(id);
        System.out.println(optionalUser.get().getPassword());
        System.out.println(password);
        if (optionalUser.get().getPassword().equals(password)){
            return true;
        }
        else{
            return false;
        }
    }

    @GetMapping("user/loans/{id}")
    public Stream<LoanDto> findLoans(@PathVariable long id){
    	/**
    	 * Used to find all loans of a user
    	 */
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return loanRepository.findByUserAndEndDateNotNull(user.get()).stream().map(loanMapper::loanToDto);
        } else {
            return null;
        }
    }

    @GetMapping("user/loans/open/{id}")
    public Stream<LoanDto> findOpenLoans(@PathVariable long id){
        /**
         * Used to find "open" (not yet returned) loans of a user
         */
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return loanRepository.findByUserAndEndDateNull(user.get()).stream().map(loanMapper::loanToDto);
        } else {
            return null;
        }
    }

    @GetMapping("user/reservations/{id}")
    public Stream<ReservationAvailabilityDto> findReservations(@PathVariable long id){
    	/**
    	 * Used to find all reservations of a user
    	 */
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return reservationRepository.findByUser(user.get()).stream().map(reservationMapper::reservationToAvailabilityDto);
        } else {
            return null;
        }
    }

    @PostMapping("api/user/login")
    public LoginResponseDto Login(@RequestBody LoginRequestDto loginRequestDto){
        Optional<User> userOptional = userRepository.findByEmailAddressAndPasswordAndArchivedFalse(
                loginRequestDto.getUsername(), loginRequestDto.getPassword()
        );
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            String token = generateRandomString(60);

            // Save token to user
            user.setToken(token);
            userRepository.save(user);

            return new LoginResponseDto(token, user.isAdmin(), user.getId());
        }

        return null;
    }

    @PutMapping("user/logout")
    public boolean deleteUserToken(
            @RequestHeader("Authentication") String token
    ) {
        Optional<User> optionalUser = userRepository.findByTokenAndArchivedFalse(token);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            user.setToken(null);
            userRepository.save(user);

            return true;
        }
        return false;
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

    @RequestMapping(value = "user/searchEndPoint", method = RequestMethod.POST)
    public SearchResultDto<UserDto> getUsersPageable(@RequestBody SearchParametersDto parametersDto) {
        Pageable pageable = PageRequest.of(parametersDto.getPageNumber(), parametersDto.getNumberPerPage(), Sort.by(Sort.Direction.fromString(parametersDto.getDirectionOfSort()), parametersDto.getPropertyToSortBy()));

        Page<User> page = userRepository.searchUser(parametersDto.getSearchTerm(), pageable);
        if (!page.hasContent())
            return null;

        return new SearchResultDto<>(parametersDto.getNumberPerPage(), page.getTotalPages(), page.getNumberOfElements(), page.getContent().stream().map(userMapper::userToDto).toList());
    }

}