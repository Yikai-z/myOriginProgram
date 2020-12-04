package com.example.simple.dao;



import com.example.simple.domain.User;

import java.util.List;

/**
 * @author yikai.zhang
 * @title: IUserDao
 * @projectName mybatisDemo
 * @description: TODO
 * @date 2020/12/3 16:38
 */
public interface IUserDao {
    void addUser(User user);

    List<User> selectUser();

    User selectUser(String userName, String password);

    void updateUser(User user);

    void deleteUser(User user);
}
