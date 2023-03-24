package wt.bookstore.backend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import wt.bookstore.backend.domains.Loan;
import wt.bookstore.backend.domains.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long>{

    Optional<User> findByEmailAddressAndPassword(String emailAddress, String password);

    List<User> findByFirstNameOrLastName(String firstName, String lastName, Pageable pageable);

    Optional<User> findByToken(String token);

    @Query("SELECT u FROM User u WHERE (u.firstName LIKE %?1% or u.lastName LIKE %?1%)")
    Page<User> searchUser(String searchTerm, Pageable pageable);


}
