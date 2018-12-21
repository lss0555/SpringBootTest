package com.example.springbootTest.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * @Description
 * @Author lss0555
 * @Date 2018/11/21/021 11:07
 **/
@Getter
@Setter
public class Patient {
    String userName;
    @NotNull(message = "密码不能为空")
    String password;
    String userKey;
    String token;
    String s_glide;
    String s_office;
    String s_name;

    @Override
    public String toString() {
        return "Patient{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", userKey='" + userKey + '\'' +
                ", token='" + token + '\'' +
                ", s_glide='" + s_glide + '\'' +
                ", s_office='" + s_office + '\'' +
                ", s_name='" + s_name + '\'' +
                '}';
    }
}
