package com.javastart.accountservice.controller.dto;

import com.javastart.accountservice.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class AccountResponseDTO {

    private String name;

    private String surname;

    private String dateBirth;

    private String addressResidence;

    public AccountResponseDTO(Account account){

        this.name = account.getName();
        this.surname = account.getSurname();
        this.dateBirth = account.getDateBirth();
        this.addressResidence = account.getAddressResidence();
    }
}
