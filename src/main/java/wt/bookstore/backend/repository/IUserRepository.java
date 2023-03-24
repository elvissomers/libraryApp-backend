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

    List<User> findByArchivedFalse(Pageable pageable);

    Optional<User> findByEmailAddressAndPasswordAndArchivedFalse(String emailAddress, String password);

    List<User> findByArchivedFalseAndFirstNameOrLastName(String firstName, String lastName, Pageable pageable);

    Optional<User> findByTokenAndArchivedFalse(String token);

    @Query("SELECT u FROM User u WHERE u.archived = false and (u.firstName LIKE %?1% or u.lastName LIKE %?1%)")
    Page<User> searchUser(String searchTerm, Pageable pageable);


}
