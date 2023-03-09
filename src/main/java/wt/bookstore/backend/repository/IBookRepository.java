package wt.bookstore.backend.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import wt.bookstore.backend.domains.Book;

import java.util.List;

public interface IBookRepository extends JpaRepository<Book, Long> {


    List<Book> findByTitleContainingOrAuthorContaining(String title, String Author);
}