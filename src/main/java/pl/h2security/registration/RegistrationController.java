package pl.h2security.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pl.h2security.user.User;

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
