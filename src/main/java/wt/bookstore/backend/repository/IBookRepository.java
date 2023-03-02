package wt.bookstore.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import wt.bookstore.backend.domains.Book;

public interface IBookRepository extends JpaRepository<Book, Long> {

}