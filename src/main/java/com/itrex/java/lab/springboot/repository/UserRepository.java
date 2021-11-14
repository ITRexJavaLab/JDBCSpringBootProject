package com.itrex.java.lab.springboot.repository;

import com.itrex.java.lab.springboot.entity.User;
import java.util.List;

public interface UserRepository {

    List<User> selectAll();
    void add(User user);
    void addAll(List<User> users);

}
