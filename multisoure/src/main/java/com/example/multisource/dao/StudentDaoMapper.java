package com.example.multisource.dao;

import com.example.multisource.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description 学生数据
 **/
@Repository
public interface StudentDaoMapper {
    List<Student> userList();
}
