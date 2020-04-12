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
import java.util.Arrays;

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
        UserRole userRole = new UserRole(Role.ROLE_USER);
        UserRole adminRole = new UserRole(Role.ROLE_ADMIN);

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

