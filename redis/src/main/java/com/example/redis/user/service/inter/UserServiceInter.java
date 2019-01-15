package com.example.redis.user.service.inter;

import com.example.redis.model.TResult;
import com.example.redis.model.User;

/**
 * @Description 用户相关
 * @Author lss0555
 **/
public interface UserServiceInter {
    TResult<User> userList();
}
