package dev.tknapp.philodelight.controller.login;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static dev.tknapp.philodelight.constants.Constants.API_V1_LOGIN_FULL;

@RestController
@RequestMapping(API_V1_LOGIN_FULL)
public class LoginController {
    
    @PostMapping()
    public LoginResponse login(@RequestBody LoginRequest request) {
        boolean isAuthenticated = validateCredentials(request.getEmail(), request.getPassword());
        return new LoginResponse(isAuthenticated);
    }
    
    private boolean validateCredentials(String email, String password) {
        String validEmail = "user@example.com";
        String validPassword = "password123";
        return email.equals(validEmail) && password.equals(validPassword);
    }
    
}
