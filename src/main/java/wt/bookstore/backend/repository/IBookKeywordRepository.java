package wt.bookstore.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import wt.bookstore.backend.domains.BookKeyword;

public interface IBookKeywordRepository extends JpaRepository<BookKeyword, Long>{
	
}