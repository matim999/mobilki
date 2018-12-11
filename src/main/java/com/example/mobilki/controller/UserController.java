package com.example.mobilki.controller;

import com.example.mobilki.model.User;
import com.example.mobilki.repo.UserRepository;
import com.example.mobilki.service.UserService;
import com.example.mobilki.util.LoginBox;
import com.example.mobilki.util.SignInBox;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(path = "/user")
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;

    @Autowired
    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping
    public @ResponseBody
    List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping(path = "/login")
    public @ResponseBody
    User getUserLogin(@RequestBody LoginBox box) {
        return userRepository.findUserByUsernameAndPassword(box.getUsername(), box.getPassword());
    }

    @PostMapping(path = "/signIn")
    public @ResponseBody
    User getUserLogin(@RequestBody SignInBox box) {
        return userService.signIn(box);
    }
}
