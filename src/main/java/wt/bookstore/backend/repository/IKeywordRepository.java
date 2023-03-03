package wt.bookstore.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wt.bookstore.backend.domains.Keyword;

public interface IKeywordRepository extends JpaRepository<Keyword, Long>{
	
}