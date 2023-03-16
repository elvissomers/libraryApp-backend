package wt.bookstore.backend.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wt.bookstore.backend.domains.Book;
import wt.bookstore.backend.domains.Copy;
import wt.bookstore.backend.dto.CopyDto;
import wt.bookstore.backend.dto.SaveCopyDto;
import wt.bookstore.backend.repository.IBookRepository;
import wt.bookstore.backend.repository.ICopyRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CopyDtoMapper {

    @Autowired
    private IBookRepository bookRepository;

    @Autowired
    private ICopyRepository copyRepository;

    /**
     * Method that transforms a DTO from a post request to an object that can be used for a database
     * @param saveCopyDto ({@link wt.bookstore.backend.dto.SaveCopyDto}) DTO to be transformed to an object
     * @return copy ({@link wt.bookstore.backend.domains.Copy}) object that can serve as entity for a database
     */
    public List<Copy> dtoToCopy(SaveCopyDto saveCopyDto) {
        /*
         * Used to create a Copy obejct from a SaveCopyDto object
         */
        List<Copy> copyList = new ArrayList<>();

        Optional<Book> optionalBook = bookRepository.findById(saveCopyDto.getBookId());
        if (optionalBook.isEmpty()) {
            return null;
        }


        List<Copy> bookCopyList = copyRepository.findByBookOrderByNumberDesc(optionalBook.get());

        int copyAmount = saveCopyDto.getAmount();
        int currentNumber = 0;
        // We set the copy number to the highest currect copy number + 1, or
        // to 1 if there are no other copies of this book
        if (bookCopyList.isEmpty()) {
            currentNumber = 1;
        } else {
            currentNumber = bookCopyList.get(0).getNumber() + 1;
        }

        Copy copy = null;
        for (int j = 0; j < copyAmount; j++) {
            copy = new Copy();
            // We always set to true because a newly created copy is always available
            copy.setAvailable(true);
            copy.setBook(optionalBook.get());
            copy.setNumber(currentNumber);
            currentNumber = currentNumber + 1;
            copyList.add(copy);
        }
        return copyList;

    }

    public CopyDto copyToDto(Copy copy){
        /*
         * Used to create a dto object from a copy
         */
        CopyDto copyDto = new CopyDto();

        copyDto.setAvailable(copy.isAvailable());
        copyDto.setBookTitle(copy.getBook().getTitle());
        copyDto.setId(copy.getId());
        copyDto.setNumber(copy.getNumber());

        return copyDto;
    }
}
