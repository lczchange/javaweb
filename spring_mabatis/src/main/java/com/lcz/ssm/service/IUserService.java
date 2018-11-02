package com.lcz.ssm.service;

import com.lcz.ssm.bean.User;

import java.util.List;

public interface IUserService {
    /**
     * 获取用户列表
     * @return
     */
    List<User> getAllUser();

    /**
     * 添加用户信息
     * @param user
     */
    void addUser(User user);

    /**
     * 根据用户ID进行删除用户信息
     * @param userId
     */
    void deleteUser(int userId);

    /**
     * 根据用户ID进行修改用户信息
     * @param userId
     */
    void updateUser(int userId);
}
