package com.example.mybatistest.dao;

import com.example.mybatistest.model.User;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description 用户类
 * @Author lss0555
 **/
@Mapper
public interface UserDaoMapper {
    List<User> userList();
    List<User> userList2();
}
