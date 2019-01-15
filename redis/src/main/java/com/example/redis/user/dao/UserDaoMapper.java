package com.example.redis.user.dao;

import com.example.redis.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description 用户操作
 * @Author lss0555
 **/
@Repository
public interface UserDaoMapper {
    List<User> userList();
}
