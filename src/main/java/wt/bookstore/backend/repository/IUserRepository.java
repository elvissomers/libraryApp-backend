package wt.bookstore.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import wt.bookstore.backend.domains.User;

public interface IUserRepository extends JpaRepository<User, Long>{

}
