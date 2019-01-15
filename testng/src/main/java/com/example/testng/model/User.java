package com.example.testng.model;


import java.io.Serializable;

/**
 * @Description 用户
 * @Author lss0555
 * @Date 2018/11/21/021 8:48
 **/
public class User implements Serializable{
    private int id;
    private String username;
    private String password;
    private String Salt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return Salt;
    }

    public void setSalt(String salt) {
        Salt = salt;
    }

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", Salt='" + Salt + '\'' +
                '}';
    }
}
