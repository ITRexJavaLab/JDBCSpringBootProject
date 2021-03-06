package com.itrex.java.lab.springboot;

import com.itrex.java.lab.springboot.entity.User;
import com.itrex.java.lab.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class JDBCSpringBootProjectApplication implements CommandLineRunner {

    @Autowired
    ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(JDBCSpringBootProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        UserService userService = context.getBean(UserService.class);

        System.out.println("===================START APP======================");
        workWithJDBC(userService);
        System.out.println("=================SHUT DOWN APP====================");
    }

    public static void workWithJDBC(UserService userService) {
        List<User> users = userService.getAllUsers();
        System.out.println("Step 1 select all users:\n" + users);
        User firstAddedUser = new User();
        firstAddedUser.setName("some name");
        firstAddedUser.setEmail("some email");
        firstAddedUser.setDateOfBirth(Timestamp.valueOf(LocalDateTime.now()));

        userService.add(firstAddedUser);
        System.out.println("Step 2 add user:\n" + firstAddedUser);

        users = userService.getAllUsers();
        System.out.println("Step 3 select all users:\n" + users);
        List<User> newUsers = new ArrayList<>();
        User user = new User();
        user.setName("some name");
        user.setEmail("some email 2");
        user.setDateOfBirth(Timestamp.valueOf(LocalDateTime.now()));

        newUsers.add(user);
        User user2 = new User();
        user2.setName("some name");
        user2.setEmail("some email 3");
        user2.setDateOfBirth(Timestamp.valueOf(LocalDateTime.now()));
        newUsers.add(user2);

        userService.addAll(newUsers);
        System.out.println("Step 4 add all users:\n" + newUsers);

        users = userService.getAllUsers();
        System.out.println("Step 5 select all users:\n" + users);
    }

}
