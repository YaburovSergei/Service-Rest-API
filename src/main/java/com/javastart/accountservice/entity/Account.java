package com.javastart.accountservice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String surname;

    private String dateBirth;

    private String addressResidence;

    public Account(String name, String surname, String dateBirth, String addressResidence) {
        this.name = name;
        this.surname = surname;
        this.dateBirth = dateBirth;
        this.addressResidence = addressResidence;
    }
}
