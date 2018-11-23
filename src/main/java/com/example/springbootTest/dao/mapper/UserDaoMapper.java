package com.example.springbootTest.dao.mapper;

import com.example.springbootTest.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName UserDaoMapper
 * @Description
 * @Author lss0555
 **/
@Mapper
public interface UserDaoMapper {
    @Select(" select *  from `user`")
    List<User> userList();

    @Select(" select *  from `user`")
    List<User> usersList();
}