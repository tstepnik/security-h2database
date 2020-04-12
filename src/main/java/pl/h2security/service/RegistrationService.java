package pl.h2security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.h2security.repository.UserRepository;
import pl.h2security.user.User;
import pl.h2security.exceptions.*;
import java.util.Optional;

@Service
public class RegistrationService {

    private final UserRepository userRepo;
    private final UserService userService;

    @Autowired
    public RegistrationService(UserRepository userRepo,UserService userService) {
        this.userRepo = userRepo;
        this.userService=userService;
    }

    public void register(User user) {
        if (emailExist(user.getEmail())) {
            throw new EmailAlreadyExistException("There is account with that email adress.");
        } else if (loginExist(user.getUserName())){
            throw new UserAlreadyExistException("There is account with that user name.");
        }
        userService.addWithDefaultRole(user);
    }

    private boolean emailExist(String email) {
        Optional<User> user = userRepo.findByEmail(email);
        if (user.isPresent()) {
            return true;
        }
        return false;
    }

    private boolean loginExist(String login) {
        Optional<User> user = userRepo.findByUserName(login);
        if (user.isPresent()) {
            return true;
        }
        return false;
    }
}
