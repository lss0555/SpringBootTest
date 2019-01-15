package com.example.redis.user.service;

import com.example.redis.model.TResult;
import com.example.redis.model.User;
import com.example.redis.user.dao.UserDaoMapper;
import com.example.redis.user.service.inter.UserServiceInter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description 用户接口实现
 * @Author lss0555
 * @Date 2019/1/4/004 16:07
 **/
@Service
public class UserServiceImpl implements UserServiceInter{
    @Resource
    UserDaoMapper userDaoMapper;

    @Override
    public TResult<User> userList() {
        TResult<User> result = new TResult<>();
        try {
            List<User> users = userDaoMapper.userList();
            result.setList(users);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
