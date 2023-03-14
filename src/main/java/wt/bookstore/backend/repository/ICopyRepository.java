package wt.bookstore.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import wt.bookstore.backend.domains.Book;
import wt.bookstore.backend.domains.Copy;

public interface ICopyRepository extends JpaRepository<Copy, Long>{

	List<Copy> findByAvailableTrueAndBook(Book book);
	Optional<Copy> findByBookAndNumber(Book book, int number);
}
