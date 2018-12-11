package com.example.mobilki.repo;

import com.example.mobilki.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByUsernameAndPassword(String username, String password);
    User findFirstByUsername(String username);
}
