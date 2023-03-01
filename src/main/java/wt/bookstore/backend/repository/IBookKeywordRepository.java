package wt.bookstore.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wt.bookstore.backend.domains.BookKeyword;

public interface IBookKeywordRepository extends JpaRepository<BookKeyword, Long>{
	List<BookKeyword> findByBookId(long bookId);
}