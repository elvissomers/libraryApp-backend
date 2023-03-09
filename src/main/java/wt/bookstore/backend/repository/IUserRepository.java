package wt.bookstore.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import wt.bookstore.backend.domains.User;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long>{

    Optional<User> findByEmailAddressAndPassword(String emailAddress, String password);

}
