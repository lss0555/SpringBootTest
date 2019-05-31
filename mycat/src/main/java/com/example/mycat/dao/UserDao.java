package com.example.mycat.dao;

import com.example.mycat.model.User;
import org.apache.ibatis.annotations.Insert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description 用户数据接口层
 * @Author lss0555
 **/
@Repository
public interface UserDao extends JpaRepository<User,Integer>{
}
