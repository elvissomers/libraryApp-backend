package wt.bookstore.backend.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import wt.bookstore.backend.domains.Book;
import wt.bookstore.backend.domains.Reservation;

import java.util.List;

public interface IBookRepository extends JpaRepository<Book, Long> {

    List<Book> findByArchivedFalse(Pageable pageable);

    List<Book> findByTitleContainingOrAuthorContaining(String title, String Author, Pageable pageable);

    List<Book> findByArchivedFalseAndTitleContainingOrAuthorContaining(String title, String Author, Pageable pageable);

    List<Book> findByTitleContainingOrAuthorContainingOrKeywords_NameContaining(String title, String Author, String Keyword);

    @Query("SELECT DISTINCT b FROM Book b " +
            "LEFT JOIN b.keywords k " +
            "WHERE (b.archived = false OR (CASE WHEN ?2 = true THEN b.archived = true END)) " +
            "AND (b.title LIKE %?1% OR b.author LIKE %?1% OR k.name LIKE %?1%)")
    Page<Book> searchBook(String searchTerm, boolean archived, Pageable pageable);

}