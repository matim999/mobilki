package com.example.mobilki.service;

import com.example.mobilki.model.User;
import com.example.mobilki.repo.UserRepository;
import com.example.mobilki.util.SignInBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User signIn(SignInBox box) {
        if (userRepository.findFirstByUsername(box.getUsername()) != null)
            return null;
        List<Integer> usersIds = userRepository.findAll().stream().map(User::getUserId).collect(Collectors.toList());
        OptionalInt first = IntStream.range(0, 9).filter(value -> !usersIds.contains(value)).findFirst();
        if (!first.isPresent())
            return null;
        return userRepository.save(new User(first.getAsInt(), box));
    }
}
