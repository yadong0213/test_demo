package com.dk.service.impl;

import com.dk.dao.UserMapper;
import com.dk.pojo.User;
import com.dk.pojo.UserExample;
import com.dk.service.UserServiceI;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.beans.Transient;
import java.util.List;

/**
 * @author 孙亚东
 */
@Service
public class UserServceImpl implements UserServiceI {

    @Resource
    private UserMapper userMapper;


    @Override
    public List<User> findAll() {
        return userMapper.selectByExample(new UserExample());
    }

    @Override
    @Transient
    public void insert(User user) {
        userMapper.insert(user);
    }

    @Override
    @Transient
    public void update(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    @Transient
    public void delete(Integer id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public User findById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
