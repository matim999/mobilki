package com.example.mobilki.controller;

import com.example.mobilki.model.User;
import com.example.mobilki.repo.UserRepository;
import com.example.mobilki.util.LoginBox;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(path = "/user")
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public @ResponseBody
    List<User> getAllUsers() {
        log.info("/user");
        return userRepository.findAll();
    }

    @PostMapping(path = "/login")
    public @ResponseBody
    User getUserLogin(@RequestBody LoginBox box) {
        log.info("/login" + box.username + box.password);

        return userRepository.findUserByUsernameAndPassword(box.username, box.password);
    }
}
