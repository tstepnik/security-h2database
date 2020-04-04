package pl.h2security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.h2security.user.User;


public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmail(String email);
    User findByUserName(String userName);

}
