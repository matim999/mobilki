package com.example.mobilki.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class PlanSeq {
    @Id
    private int planSeqId;
    private int number;
}
