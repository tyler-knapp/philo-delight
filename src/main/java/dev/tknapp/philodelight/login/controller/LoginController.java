package dev.tknapp.philodelight.login.controller;

import dev.tknapp.philodelight.login.LoginRequest;
import dev.tknapp.philodelight.login.LoginResponse;
import dev.tknapp.philodelight.login.model.RegistrationRequest;
import dev.tknapp.philodelight.login.model.RegistrationResponse;
import dev.tknapp.philodelight.login.pipeline.LoginPipeline;
import dev.tknapp.philodelight.login.pipeline.RegistrationPipeline;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static dev.tknapp.philodelight.common.Constants.API_V1_LOGIN_FULL;

@RestController
@RequestMapping(API_V1_LOGIN_FULL)
@AllArgsConstructor
public class LoginController {
    
    private final RegistrationPipeline registrationPipeline;
    
    private final LoginPipeline loginPipeline;
    
    @PostMapping()
    public LoginResponse login(@RequestBody LoginRequest request) {
        boolean isAuthenticated = validateCredentials(request.getEmail(), request.getPassword());
        return new LoginResponse(isAuthenticated);
    }
    
    @PostMapping()
    public RegistrationResponse register(@RequestBody RegistrationRequest request){
        return registrationPipeline.registerAccount(request);
    }
    
    private boolean validateCredentials(String email, String password) {
        String validEmail = "user@example.com";
        String validPassword = "password123";
        return email.equals(validEmail) && password.equals(validPassword);
    }
    
}
