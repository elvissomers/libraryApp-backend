package wt.bookstore.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wt.bookstore.backend.domains.Keyword;

public interface IBookKeywordRepository extends JpaRepository<Keyword, Long>{
	
}