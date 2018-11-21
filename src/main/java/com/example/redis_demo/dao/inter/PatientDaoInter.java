package com.example.redis_demo.dao.inter;

import com.example.redis_demo.model.Patient;
import com.example.redis_demo.model.User;

import java.util.List;

/**
 * @ClassName UserDaoInter
 * @Description 用户列表
 * @Author lss0555
 * @Date 2018/11/21/021 8:49
 * @Version 1.0
 **/
public interface PatientDaoInter {
    List<Patient> patientList();
}
