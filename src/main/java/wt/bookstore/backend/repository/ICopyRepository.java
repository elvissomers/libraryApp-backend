package wt.bookstore.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import wt.bookstore.backend.domains.Copy;

public interface ICopyRepository extends JpaRepository<Copy, Long>{

}
