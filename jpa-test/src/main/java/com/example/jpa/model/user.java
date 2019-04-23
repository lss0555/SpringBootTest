package com.example.jpa.model;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @Description 用户model
 * @Author lss0555
 **/
@Entity
@Table(name="user")
public class user {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(length = 32)
    private String username;
    @Column(length = 64)
    private String password;
    @Column(length = 55)
    private BigDecimal yue;

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

    public BigDecimal getYue() {
        return yue;
    }

    public void setYue(BigDecimal yue) {
        this.yue = yue;
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", yue=" + yue +
                '}';
    }
}
