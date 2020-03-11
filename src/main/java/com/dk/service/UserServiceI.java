package com.dk.service;

import com.dk.pojo.User;

import java.util.List;

/**
 * @author 孙亚东
 */
public interface UserServiceI {
    List<User> findAll();

    void insert(User user);

    void update(User user);

    void delete(Integer id);

    User findById(Integer id);
}
