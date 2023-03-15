package wt.bookstore.backend.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import wt.bookstore.backend.domains.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long>{

    Optional<User> findByEmailAddressAndPassword(String emailAddress, String password);

    List<User> findByFirstNameOrLastName(String firstName, String lastName, Pageable pageable);

    List<User> findAllByOrderByFirstNameAsc(Pageable pageable);
    List<User> findAllByOrderByEmailAddressAsc(Pageable pageable);
    List<User> findAllByOrderByLastNameAsc(Pageable pageable);
    List<User> findAllByOrderByFirstNameDesc(Pageable pageable);
    List<User> findAllByOrderByEmailAddressDesc(Pageable pageable);
    List<User> findAllByOrderByLastNameDesc(Pageable pageable);
    List<User> findByFirstNameOrLastNameOrderByLastNameAsc(String author, String title, Pageable pageable);
    List<User> findByFirstNameOrLastNameOrderByFirstNameAsc(String author, String title, Pageable pageable);
    List<User> findByFirstNameOrLastNameOrderByEmailAddressAsc(String author, String title, Pageable pageable);
    List<User> findByFirstNameOrLastNameOrderByLastNameDesc(String author, String title, Pageable pageable);
    List<User> findByFirstNameOrLastNameOrderByFirstNameDesc(String author, String title, Pageable pageable);
    List<User> findByFirstNameOrLastNameOrderByEmailAddressDesc(String author, String title, Pageable pageable);
}
