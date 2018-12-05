package com.example.mobilki.model;

import com.example.mobilki.model.enums.AccountType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class User {
    @Id
    private int userId;
    private String name;
    private String surname;
    private int progress;
    private String accountType;
    @JsonIgnore
    private String username;
    @JsonIgnore
    private String password;
}
