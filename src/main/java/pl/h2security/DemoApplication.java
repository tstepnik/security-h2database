package pl.h2security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.h2security.repository.UserRepository;
import pl.h2security.repository.UserRoleRepository;
import pl.h2security.user.Role;
import pl.h2security.user.User;
import pl.h2security.user.UserRole;

import javax.annotation.PostConstruct;
import javax.persistence.Enumerated;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class DemoApplication {


    UserRoleRepository roleRepository;
    UserRepository userRepository;


    @Autowired
    public DemoApplication(UserRoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @PostConstruct
    private void init() {
        UserRole userRole = new UserRole(Role.USER_ROLE);
        UserRole adminRole = new UserRole(Role.ADMIN_ROLE);

        roleRepository.save(userRole);
        roleRepository.save(adminRole);

        User user = new User("user", "user");
        user.getRoles().add(userRole);
        User admin = new User ("admin", "admin");
        admin.getRoles().add(adminRole);
        admin.getRoles().add(userRole);
        userRepository.saveAll(Arrays.asList(user,admin));


    }
}

