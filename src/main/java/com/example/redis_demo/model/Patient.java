package com.example.redis_demo.model;

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
}
