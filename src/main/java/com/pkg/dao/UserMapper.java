package com.pkg.dao;

import com.pkg.pojo.User;

import java.util.List;

public interface UserMapper {
    User getUserById(int id);
    List<User> getUsers();
}
