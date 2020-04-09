package pl.h2security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.h2security.repository.UserRepository;
import pl.h2security.user.User;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@SpringBootApplication
public class DemoApplication {


    UserRepository userRepository;

    public DemoApplication(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @PostConstruct
private void init(){
        User user = new User("user","user");
        User admin = new User("admin","admin");
        userRepository.saveAll(Arrays.asList(user,admin));
}
}
