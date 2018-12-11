package com.example.mobilki.model;

import com.example.mobilki.util.SignInBox;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.OptionalInt;

@Entity
@Getter
@Setter
@NoArgsConstructor
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

    public User(int userId, SignInBox box) {
        this.userId = userId;
        this.name = box.getName();
        this.surname = box.getSurname();
        this.username = box.getUsername();
        this.password = box.getPassword();
        this.progress = 0;
        this.accountType = "S";
    }
}
