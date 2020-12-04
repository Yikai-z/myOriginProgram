package com.example.simple.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yikai.zhang
 * @title: User
 * @projectName mybatisDemo
 * @description: TODO
 * @date 2020/12/3 15:06
 */
public class User implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private int id;
    private String userName;
    private String password;
    private Date birthday;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String toString() {
        return userName + " : " + password + " : " + birthday.toString();
    }
}
