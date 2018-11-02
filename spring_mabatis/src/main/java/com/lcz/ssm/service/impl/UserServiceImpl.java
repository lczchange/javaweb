package com.lcz.ssm.service.impl;

import com.lcz.ssm.bean.User;
import com.lcz.ssm.mapper.UserMapper;
import com.lcz.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public class UserServiceImpl implements IUserService {

    private UserMapper userMapper;

    @Override
    public List<User> getAllUser() {
        return null;
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public void deleteUser(int userId) {

    }

    @Override
    public void updateUser(int userId) {

    }
}
