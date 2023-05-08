package dev.tknapp.philodelight.account.controller;

import dev.tknapp.philodelight.account.model.Account;
import dev.tknapp.philodelight.account.model.AccountRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    
    @PostMapping("/delete")
    public void deleteAccount(@RequestBody Account account){
        repository.delete(account);
    }
    
    @GetMapping("/accounts")
    public List<Account> getAllAccounts(){
        return repository.findAll();
    }
}
