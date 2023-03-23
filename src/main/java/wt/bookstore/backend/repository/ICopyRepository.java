package wt.bookstore.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import wt.bookstore.backend.domains.Book;
import wt.bookstore.backend.domains.Copy;

public interface ICopyRepository extends JpaRepository<Copy, Long>{

	List<Copy> findByBook(Book book);

	List<Copy> findByBookAndArchivedFalse(Book book);
  
	List<Copy> findByAvailableTrueAndBook(Book book);
	Optional<Copy> findByBookAndNumber(Book book, int number);

	// Used to get the highest copy number, so we can assign a number to
	// a new copy added to the database
	List<Copy> findByBookOrderByNumberDesc(Book book);
}
