package com.example.mobilki.repo;

import com.example.mobilki.model.PlanSeq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface PlanSeqRepository extends JpaRepository<PlanSeq, Integer> {
}
