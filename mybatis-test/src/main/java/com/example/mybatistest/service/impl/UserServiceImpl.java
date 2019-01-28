package com.example.mybatistest.service.impl;

import com.example.mybatistest.dao.UserDaoMapper;
import com.example.mybatistest.model.User;
import com.example.mybatistest.service.UserServiceInter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description 用户
 * @Author lss0555
 * @Date 2019/1/25/025 11:32
 **/
@Service
public class UserServiceImpl implements UserServiceInter {
    @Resource
    UserDaoMapper userDaoMapper;

    /**
     * @Description  用户列表
     * 启动事务,则开启mybatis以及缓存,
     *
     * 存在弊端:
     * 同一个事务中在查询中间如果有其他线程修改了这条数据，这两条两次查询的还是内容相同
     * 原因是同一个事务中spring使用的是同一个SqlSession，此时走的是SqlSession的缓存，并没有从数据中查询。
     **/
    @Override
    @Transactional
    public List<User> user_list() {
        userDaoMapper.userList();
        List<User> users = userDaoMapper.userList();
        return users;
    }

    /**
     * @Description  不适用缓存
     **/
    @Override
    public List<User> userList1() {
        return userDaoMapper.userList();
    }

    /**
     * @Description  用户列表使用二级缓存
     **/
    @Override
    public List<User> userList2() {
        return userDaoMapper.userList2();
    }
}
