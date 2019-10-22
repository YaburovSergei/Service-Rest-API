package com.javastart.accountservice.service;

import com.javastart.accountservice.entity.Account;
import com.javastart.accountservice.exception.AccountNotFoundException;
import com.javastart.accountservice.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    public Long saveAccount(String name, String surname, String dateBirth, String addressResidence) {
        Account account = new Account(name, surname, dateBirth, addressResidence);
        return accountRepository.save(account).getId();
    }


    @Transactional
    public Account getAccountById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Can't find account with id: " + id));
    }

    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    public void deleteAccountById(Long id) {
        accountRepository.deleteById(id);
    }

    public Account modificationAccount(Long id, String name, String surname, String dateBirth, String addressResidence) {

        Account account = accountRepository.findById(id).orElse(null);
        account.setName(name);
        account.setSurname(surname);
        account.setDateBirth(dateBirth);
        account.setAddressResidence(addressResidence);
        accountRepository.save(account);
        return account;
    }
}
