package wt.bookstore.backend.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import wt.bookstore.backend.domains.Book;

import java.util.List;

public interface IBookRepository extends JpaRepository<Book, Long> {

    List<Book> findByTitleContainingOrAuthorContaining(String title, String Author, Pageable pageable);

    List<Book> findByTitleContainingOrAuthorContainingOrKeywords_NameContaining(String title, String Author, String Keyword);
    List<Book> findAllByOrderByTitleAsc(Pageable pageable);
    List<Book> findAllByOrderByIsbnAsc(Pageable pageable);
    List<Book> findAllByOrderByAuthorAsc(Pageable pageable);
    List<Book> findAllByOrderByTitleDesc(Pageable pageable);
    List<Book> findAllByOrderByIsbnDesc(Pageable pageable);
    List<Book> findAllByOrderByAuthorDesc(Pageable pageable);

    List<Book> findByTitleContainingOrAuthorContainingOrderByAuthorAsc(String author, String title, Pageable pageable);
    List<Book> findByTitleContainingOrAuthorContainingOrderByTitleAsc(String author, String title, Pageable pageable);
    List<Book> findByTitleContainingOrAuthorContainingOrderByIsbnAsc(String author, String title, Pageable pageable);
    List<Book> findByTitleContainingOrAuthorContainingOrderByAuthorDesc(String author, String title, Pageable pageable);
    List<Book> findByTitleContainingOrAuthorContainingOrderByTitleDesc(String author, String title, Pageable pageable);
    List<Book> findByTitleContainingOrAuthorContainingOrderByIsbnDesc(String author, String title, Pageable pageable);

}