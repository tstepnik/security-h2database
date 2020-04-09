package pl.h2security.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.h2security.registration.exceptions.EmailAlreadyExistException;
import pl.h2security.registration.exceptions.UserAlreadyExistException;
import pl.h2security.registration.exceptions.UserNotExistException;
import pl.h2security.repository.UserRepository;
import pl.h2security.service.UserService;
import pl.h2security.user.User;

import javax.swing.plaf.PanelUI;

@RestController
public class RegistrationController {

private RegistrationService registrationService;

    @Autowired
public RegistrationController(RegistrationService registrationService){
        this.registrationService=registrationService;
    }

    @PostMapping("/register")
    public void registerUser(@RequestBody User user){
         registrationService.register(user);
    }




}
