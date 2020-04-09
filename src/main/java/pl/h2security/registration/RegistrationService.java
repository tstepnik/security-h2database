package pl.h2security.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import pl.h2security.registration.exceptions.EmailAlreadyExistException;
import pl.h2security.registration.exceptions.UserAlreadyExistException;
import pl.h2security.registration.exceptions.UserNotExistException;
import pl.h2security.repository.UserRepository;
import pl.h2security.user.User;

@Service
public class RegistrationService {


    private UserRepository userRepo;

    @Autowired
    public RegistrationService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public void register(User user) {
        if (user != null) {
            throw new UserNotExistException("User doesn't exist.");
        } else if (emailExist(user.getEmail())) {
            throw new EmailAlreadyExistException("There is account with that email adress.");
        } else if (loginExist(user.getUserName())){
            throw new UserAlreadyExistException("There is account with that user name.");
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
