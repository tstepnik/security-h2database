package pl.h2security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.h2security.user.User;
import pl.h2security.user.UserRole;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);
    Optional<User> findByUserName(String userName);

}
