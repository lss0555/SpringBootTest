package com.example.mycat.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @Description 用户
 * @Author lss0555
 **/
@Entity
@Table(name="user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(length = 32)
    private String username;
    @Column(length = 64)
    private String password;
}
