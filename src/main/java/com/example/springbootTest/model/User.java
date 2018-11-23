package com.example.springbootTest.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Description 用户
 * @Author lss0555
 * @Date 2018/11/21/021 8:48
 **/
@Setter
@Getter
public class User implements Serializable{
    private int id;
    private String username;
    private String password;
    private String Salt;

}
