package com.javastart.accountservice.controller;

import com.javastart.accountservice.controller.dto.AccountRequestDTO;
import com.javastart.accountservice.controller.dto.AccountResponseDTO;
import com.javastart.accountservice.entity.Account;
import com.javastart.accountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


    @PostMapping("/accounts")
    public Long saveAccount(@RequestBody AccountRequestDTO accountRequestDTO) {
        return accountService.saveAccount(accountRequestDTO.getName(),
                accountRequestDTO.getSurname(),
                accountRequestDTO.getDateBirth(),
                accountRequestDTO.getAddressResidence());
    }

    @GetMapping("/accounts/{id}")
    public AccountResponseDTO getAccount(@PathVariable Long id) {
        return new AccountResponseDTO(accountService.getAccountById(id));
    }

    @RequestMapping(value = "/accounts/delete/{id}", method = RequestMethod.DELETE)
    public void deleteAccount(@PathVariable Long id) {
        accountService.deleteAccountById(id);
    }

    @RequestMapping(value = "/accounts/modification/{id}", method = RequestMethod.PUT)
    public Account modificationAccount(@PathVariable Long id, @RequestBody AccountRequestDTO accountRequestDTO) {
        return accountService.modificationAccount(id, accountRequestDTO.getName(), accountRequestDTO.getSurname(),
                accountRequestDTO.getDateBirth(), accountRequestDTO.getAddressResidence());
    }


    @GetMapping("/accounts")
    public List<AccountResponseDTO> getAccounts() {
        return accountService.getAccounts()
                .stream()
                .map(AccountResponseDTO::new)
                .collect(Collectors.toList());
    }
}
