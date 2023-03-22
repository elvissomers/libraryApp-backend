package wt.bookstore.backend.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import wt.bookstore.backend.domains.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long>{

    List<User> findByArchivedFalse(Pageable pageable);

    Optional<User> findByEmailAddressAndPasswordAndArchivedFalse(String emailAddress, String password);

    List<User> findByArchivedFalseAndFirstNameOrLastName(String firstName, String lastName, Pageable pageable);

    Optional<User> findByTokenAndArchivedFalse(String token);

}
