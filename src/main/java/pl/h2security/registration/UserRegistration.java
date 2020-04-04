package pl.h2security.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.h2security.registration.exceptions.EmailExistException;
import pl.h2security.registration.exceptions.UserNameExistException;
import pl.h2security.registration.exceptions.UserNotExistException;
import pl.h2security.repository.UserRepository;
import pl.h2security.user.User;

import java.util.List;

@RestController
public class UserRegistration {

    private UserRepository userRepo;

    @Autowired
    public UserRegistration(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @PostMapping("/registration")
    public void registerUser(@RequestBody User user) {
        if (user != null) {
            throw new UserNotExistException("User doesn't exist.");
        } else if (emailExist(user.getEmail())) {
            throw new EmailExistException("There is account with that email adress.");
        } else if (loginExist(user.getUserName())){
            throw new UserNameExistException("There is account with that user name.");
        }
        userRepo.save(user);
    }

    private boolean emailExist(String email) {
        User user = userRepo.findByEmail(email);
        if (user != null) {
            return true;
        }
        return false;
    }

    private boolean loginExist(String login) {
        User user = userRepo.findByUserName(login);
        if (user != null) {
            return true;
        }
        return false;
    }


}
