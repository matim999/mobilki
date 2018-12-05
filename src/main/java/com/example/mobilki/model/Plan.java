package com.example.mobilki.model;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
public class Plan {
    @Id
    private int PlanId;
    private String info;
}
