package wt.bookstore.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import wt.bookstore.backend.domains.Book;
import wt.bookstore.backend.domains.Copy;

public interface ICopyRepository extends JpaRepository<Copy, Long>{

	List<Copy> findByAvailableTrueAndBookAndArchivedFalse(Book book);
	Optional<Copy> findByBookAndNumberAndArchivedFalse(Book book, int number);

	// Used to get the highest copy number, so we can assign a number to
	// a new copy added to the database
	List<Copy> findByBookOrderByNumberDescAndArchivedFalse(Book book);
}
