package com.example.mobilki.repo;

import com.example.mobilki.model.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface PlanRepository extends JpaRepository<Plan, Integer> {
}
