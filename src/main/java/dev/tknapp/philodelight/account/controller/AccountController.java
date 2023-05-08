package dev.tknapp.philodelight.account.controller;

import dev.tknapp.philodelight.account.model.Account;
import dev.tknapp.philodelight.account.model.AccountRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static dev.tknapp.philodelight.common.Constants.API_V1_ACCOUNT_FULL;

@RestController
@RequestMapping(API_V1_ACCOUNT_FULL)
public class AccountController {
    
    private final AccountRepository repository;
    
    public AccountController(AccountRepository repository) {
        this.repository = repository;
    }
    
    @PostMapping("/add")
    public Account createAccount(@RequestBody Account account){
        return repository.save(account);
    }
}
