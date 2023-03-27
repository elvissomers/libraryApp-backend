package wt.bookstore.backend.mapping;

import org.springframework.stereotype.Component;
import wt.bookstore.backend.domains.Book;
import wt.bookstore.backend.domains.Keyword;
import wt.bookstore.backend.dto.BookDto;
import wt.bookstore.backend.dto.SaveBookDto;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookDtoMapper {
    /**
     * Method that transforms a DTO from a post request to an object that can be used for a database
     * @param saveBookDto ({@link wt.bookstore.backend.dto.SaveBookDto}) DTO to be transformed to an object
     * @return book ({@link wt.bookstore.backend.domains.Book}) object that can serve as entity for a database
     */
    public Book dtoToBook(SaveBookDto saveBookDto){
        /*
         * Used to create a Book object from a Dto
         */
        Book book = new Book();

        book.setAuthor(saveBookDto.getAuthor());
        book.setIsbn(saveBookDto.getIsbn());
        book.setTitle(saveBookDto.getTitle());
        book.setArchived(saveBookDto.getArchived());
        book.setDescription(saveBookDto.getDescription());
        book.setInLanguage(saveBookDto.getInLanguage());
        return book;
    }

    public BookDto bookToDto(Book book){
        /*
         * Used to create a dto object from a book
         */
        BookDto bookDto = new BookDto();

        bookDto.setAuthor(book.getAuthor());
        bookDto.setIsbn(book.getIsbn());
        bookDto.setId(book.getId());
        bookDto.setTitle(book.getTitle());
        bookDto.setArchived(book.getArchived());
        bookDto.setDescription(book.getDescription());
        bookDto.setLanguage(book.getInLanguage());

        List<String> nameList = new ArrayList<String>();
        for (Keyword keyword : book.getKeywords()) {
            nameList.add(keyword.getName());
        }
        bookDto.setKeywords(nameList);
        return bookDto;
    }
}
