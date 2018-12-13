package com.example.mobilki.service;

import com.example.mobilki.model.PlanSeq;
import com.example.mobilki.repo.PlanSeqRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlanSeqService {
    private  final PlanSeqRepository planSeqRepository;

    @Autowired
    public PlanSeqService(PlanSeqRepository planSeqRepository) {
        this.planSeqRepository = planSeqRepository;
    }

    public int getPlanSeq() {
        PlanSeq planSeq = planSeqRepository.findById(0).get();
        planSeq.setNumber(planSeq.getNumber() + 1);
        planSeqRepository.save(planSeq);
        return planSeq.getNumber() - 1;
    }
}
