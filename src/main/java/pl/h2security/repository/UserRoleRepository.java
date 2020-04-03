package pl.h2security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.h2security.user.UserRole;


public interface UserRoleRepository extends JpaRepository<UserRole,Long> {
    UserRole findByRole(String role);
}
