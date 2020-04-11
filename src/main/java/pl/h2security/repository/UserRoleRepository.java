package pl.h2security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.h2security.user.UserRole;

import java.util.Optional;


public interface UserRoleRepository extends JpaRepository<UserRole,Long> {
    UserRole findByRole(String role);
    Optional<UserRole> findById(Long id);
}
