package wt.bookstore.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wt.bookstore.backend.domains.Keyword;

import java.util.Optional;

public interface IKeywordRepository extends JpaRepository<Keyword, Long>{
	Optional<Keyword> findByName(String name);
}