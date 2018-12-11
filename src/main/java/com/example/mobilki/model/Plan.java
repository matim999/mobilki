package com.example.mobilki.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Plan {
    @Id
    private int planId;
    private String info;
}
