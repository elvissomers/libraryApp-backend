package wt.bookstore.backend.mapping;

import wt.bookstore.backend.domains.*;
import wt.bookstore.backend.dto.*;
import wt.bookstore.backend.repository.*;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KeywordDtoMapper {

	@Autowired
	private IUserRepository userRepository;

	@Autowired
	private ICopyRepository copyRepository;

    @Autowired
    private IBookRepository bookRepository;

    public Keyword dtoToKeyword(SaveKeywordDto saveKeywordDto){
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


    public KeywordDto keywordToDto(Keyword keyword){
        /*
         * Used to create a KeywordDto object from a Keyword object
         */
        KeywordDto keywordDto = new KeywordDto();

        keywordDto.setName(keyword.getName());

        return keywordDto;
    }
}
