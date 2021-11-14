package com.itrex.java.lab.springboot.service;

import com.itrex.java.lab.springboot.entity.User;
import com.itrex.java.lab.springboot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository jdbcUserRepository;

    public List<User> getAllUsers() {
        return jdbcUserRepository.selectAll();
    }

    public void add(User user) {
        jdbcUserRepository.add(user);
    }

    public void addAll(List<User> users) {
        jdbcUserRepository.addAll(users);
    }
}
