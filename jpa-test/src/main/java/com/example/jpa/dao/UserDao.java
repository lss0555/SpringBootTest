package com.example.jpa.dao;

import com.example.jpa.model.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description 用户数据接口层
 * @Author lss0555
 **/
@Repository
public interface UserDao  extends JpaRepository<user,Integer>{
}
