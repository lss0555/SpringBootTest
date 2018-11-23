package com.example.springbootTest.dao.impl;

import com.example.springbootTest.common.dataSource.TargetDataSource;
import com.example.springbootTest.dao.inter.UserDaoInter;
import com.example.springbootTest.dao.mapper.UserDaoMapper;
import com.example.springbootTest.model.User;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description 用户列表
 * @Author lss0555
 * @Date 2018/11/21/021 8:50
 **/
@Repository
public class UserDaoImpl implements UserDaoInter {
    @Resource
    UserDaoMapper userDaoMapper;

    @TargetDataSource("write")
    @Override
    public List<User> userList() {
        return userDaoMapper.userList();
    }

    @TargetDataSource("read2")
    @Override
    public List<User> usersList() {
        return userDaoMapper.usersList();
    }
}
