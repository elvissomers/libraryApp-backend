package wt.bookstore.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import wt.bookstore.backend.domains.Book;
import wt.bookstore.backend.domains.Copy;

public interface ICopyRepository extends JpaRepository<Copy, Long>{

	List<Copy> findByBook(Book book);
}
