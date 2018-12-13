package com.example.mobilki.controller;

import com.example.mobilki.model.Plan;
import com.example.mobilki.model.User;
import com.example.mobilki.repo.PlanRepository;
import com.example.mobilki.repo.PlanSeqRepository;
import com.example.mobilki.repo.UserRepository;
import com.example.mobilki.service.PlanSeqService;
import com.example.mobilki.util.PlanBox;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j
public class PlanController {
    private final PlanRepository planRepository;
    private final UserRepository userRepository;
    private final PlanSeqRepository planSeqRepository;
    private final PlanSeqService planSeqService;

    @Autowired
    public PlanController(PlanRepository planRepository, UserRepository userRepository, PlanSeqRepository planSeqRepository, PlanSeqService planSeqService) {
        this.planRepository = planRepository;
        this.userRepository = userRepository;
        this.planSeqRepository = planSeqRepository;
        this.planSeqService = planSeqService;
    }

    @GetMapping(path = "/plan")
    Plan getPlan() {
        log.info("/plan");
        return planRepository.findById(0).get();
    }

    @GetMapping(path = "/planSeq")
    Integer getPlanSeq() {
        log.info("/planSeq");
        return planSeqRepository.findById(0).get().getNumber();
    }

    @PostMapping(path = "/plan")
    String addPlan(@RequestBody PlanBox plan) {
        log.info(plan.getPlan());
        Plan currentPlan = planRepository.findById(0).get();
        currentPlan.setInfo(plan.getPlan());
        planRepository.save(currentPlan);
        planSeqService.getPlanSeq();
        return "OK";
    }

    @PostMapping(path = "/progress")
    String addProgress(@RequestBody Map<String, Integer> box) {
        log.info("/progress  " + box.toString());
        addProgressToUsers(box);
        return "OK";
    }

    private void addProgressToUsers(Map<String, Integer> map) {
        map.entrySet().forEach(element -> {
            System.out.println(element.toString());
                    addAcceptedHours(element.getKey(), element.getValue());
                }
        );
    }

    private void addAcceptedHours(String key, Integer value) {
        User user = userRepository.findById(Integer.valueOf(key)).get();
        user.setProgress(user.getProgress() + value);
        userRepository.save(user);
    }
}
