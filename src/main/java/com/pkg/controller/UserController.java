package com.pkg.controller;

import com.pkg.pojo.User;
import com.pkg.service.UserMapperImpl;
import com.pkg.util.JsonSerialize;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @GetMapping("/users")
    public List<User> getUsers() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationConfig.xml");
        UserMapperImpl userMapper = context.getBean("userMapperImpl", UserMapperImpl.class);
        List<User> users = userMapper.getUsers();
        users.stream().forEach(System.out::println);
        return users;
    }
    @GetMapping(value = "/user/{id}")
    public User getUserById(@PathVariable int id) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationConfig.xml");
        UserMapperImpl userMapper = context.getBean("userMapperImpl", UserMapperImpl.class);
        User user = userMapper.getUserById(id);
        return user;
    }
    @PostMapping("/test")
    public Map<String, Object> test(@RequestBody User user) {
        System.out.println(user);
        Map<String, Object> map = JsonSerialize.MapObject(user);
        return map;
    }
}
