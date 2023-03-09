package wt.bookstore.backend.mapping;

import wt.bookstore.backend.domains.*;
import wt.bookstore.backend.dto.*;
import wt.bookstore.backend.repository.*;

import java.util.Optional;

public class DtoMapper {

    public static Loan dtoToLoan(SaveLoanDto saveLoanDto, IUserRepository userRepository, ICopyRepository copyRepository){
        /*
         * Used to create a Loan object from a saveLoanDto object
         */
        Optional<User> userOptional = userRepository.findById(saveLoanDto.getUserId());
        Optional<Copy> copyOptional = copyRepository.findById(saveLoanDto.getCopyId());

        /*
         * Check whether all necessary fields are present in the post DTO, e.g. You can not make a loan object without
         * knowing which copy is loaned
         */

        Loan loan = new Loan();
        loan.setStartDate(saveLoanDto.getStartDate()); //Possibly Null
        loan.setEndDate(saveLoanDto.getEndDate()); //Possibly Null
        loan.setUser(userOptional.get());
        loan.setCopy(copyOptional.get());

        return loan;
    }

    public static Reservation dtoToReservation(SaveReservationDto saveReservationDto, IUserRepository userRepository, IBookRepository bookRepository){
        /*
         * Used to create a Reservation object from a saveReservationDto object
         */
        Optional<User> userOptional = userRepository.findById(saveReservationDto.getUserId());
        Optional<Book> bookOptional = bookRepository.findById(saveReservationDto.getBookId());

        /*
         * Check whether all necessary fields are present in the post DTO, e.g. You can not make a loan object without
         * knowing which copy is loaned
         */
        if (userOptional.isEmpty() || bookOptional.isEmpty())
            return null;

        Reservation reservation = new Reservation();
        reservation.setDate(saveReservationDto.getDate());
        reservation.setBook(bookOptional.get());
        reservation.setUser(userOptional.get());

        return reservation;
    }

    public static User dtoToUser(SaveUserDto saveUserDto){
        /*
         * Used to create a User object from a SaveUserDto object
         */
        User user = new User();
        user.setFirstName(saveUserDto.getFirstName());
        user.setLastName(saveUserDto.getLastName());
        user.seteMailAddress(saveUserDto.geteMailAddress());
        user.setAdmin(saveUserDto.isAdmin());

        return user;
    }

    /**
     * Method that transforms a DTO from a post request to an object that can be used for a database
     * @param saveCopyDto ({@link wt.bookstore.backend.dto.SaveCopyDto}) DTO to be transformed to an object
     * @param bookRepository ({@link wt.bookstore.backend.repository.IBookRepository}) Access to Book database necessary to check if bookdata in DTO is valid
     * @return copy ({@link wt.bookstore.backend.domains.Copy}) object that can serve as entity for a database
     */
    public static Copy dtoToCopy(SaveCopyDto saveCopyDto, IBookRepository bookRepository) {
        /*
         * Used to create a Copy obejct from a SaveCopyDto object
         */
        Copy copy = new Copy();
        // We always set to true because a newly created copy is always available
        copy.setAvailable(true);
        Optional<Book> optionalBook = bookRepository.findById(saveCopyDto.getBookId());

        if (optionalBook.isPresent()) {
            copy.setBook(optionalBook.get());
            return copy;
        } else {
            return null;
        }
    }

    /**
     * Method that transforms a DTO from a post request to an object that can be used for a database
     * @param saveBookDto ({@link wt.bookstore.backend.dto.SaveBookDto}) DTO to be transformed to an object
     * @return book ({@link wt.bookstore.backend.domains.Book}) object that can serve as entity for a database
     */
    public static Book dtoToBook(SaveBookDto saveBookDto){
        /*
         * Used to create a Book object from a Dto
         */
        Book book = new Book();

        book.setAuthor(saveBookDto.getAuthor());
        book.setIsbn(saveBookDto.getIsbn());
        book.setTitle(saveBookDto.getTitle());

        return book;
    }

    public static Keyword dtoToKeyword(SaveKeywordDto saveKeywordDto, IBookRepository bookRepository){
        /*
         * Used to create a Keyword object from a SaveKeywordDto object
         */
        Keyword keyword = new Keyword();
        keyword.setName(saveKeywordDto.getName());

        // Creates an empty booklist to append the book corresponding to the id in the
        // saveKeywordDto object, so a keyword object can be created
        Optional<Book> bookOptional = bookRepository.findById(saveKeywordDto.getBookId());
        if (bookOptional.isPresent()) {
            keyword.addBook(bookOptional.get());
            bookOptional.get().addKeyword(keyword);
            //bookRepository.save(bookOptional.get()); - causes error?
        } else {
            return null;
        }

        return keyword;
    }

    public static LoanDto loanToDto(Loan loan){
        /*
         * Used to create a LoanDto object from a Loan object
         */
        LoanDto loanDto = new LoanDto();
        /*
         * The loan get DTO only has to contain information usefull to the user, e.g. Can contain the copy name instead
         * of the copy id
         */
        loanDto.setStartDate(loan.getStartDate());
        loanDto.setEndDate(loan.getEndDate());
        loanDto.setUserFirstName(loan.getUser().getFirstName());
        loanDto.setUserLastName(loan.getUser().getLastName());
        loanDto.setBookTitle(loan.getCopy().getBook().getTitle());
        return loanDto;

    }

    public static ReservationDto reservationToDto(Reservation reservation){
        /*
         * Used to create a ReservationDto object from a Reservation object
         */
        ReservationDto reservationDto = new ReservationDto();

        reservationDto.setBookTitle(reservation.getBook().getTitle());
        reservationDto.setUserFirstName(reservation.getUser().getFirstName());
        reservationDto.setUserLastName(reservationDto.getUserLastName());
        reservationDto.setDate(reservation.getDate());

        return reservationDto;
    }

    public static UserDto userToDto(User user){
        /*
         * Used to create a UserDto object from a User object
         */
        UserDto userDto = new UserDto();

        userDto.setAdmin(user.isAdmin());
        userDto.seteMailAddress(user.geteMailAddress());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());

        return userDto;
    }

    public static CopyDto copyToDto(Copy copy){
        /*
         * Used to create a dto object from a copy
         */
        CopyDto copyDto = new CopyDto();

        copyDto.setAvailable(copy.isAvailable());
        copyDto.setBookTitle(copy.getBook().getTitle());
        copyDto.setId(copy.getId());

        return copyDto;
    }

    public static BookDto bookToDto(Book book){
        /*
         * Used to create a dto object from a book
         */
        BookDto bookDto = new BookDto();

        bookDto.setAuthor(book.getAuthor());
        bookDto.setIsbn(book.getIsbn());
        bookDto.setId(book.getId());
        bookDto.setTitle(book.getTitle());

        return bookDto;
    }


    public static KeywordDto keywordToDto(Keyword keyword){
        /*
         * Used to create a KeywordDto object from a Keyword object
         */
        KeywordDto keywordDto = new KeywordDto();

        keywordDto.setName(keyword.getName());

        return keywordDto;
    }
}
