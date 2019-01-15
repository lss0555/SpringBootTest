package com.example.multisource.dao;

import com.example.multisource.dynamic.TargetDataSource;
import com.example.multisource.model.User;

import java.util.List;

/**
 * @Description 用户类
 * @Author lss0555
 **/
public interface UserDaoMapper {
    @TargetDataSource(name = "date2")
    List<User> userList();
}
