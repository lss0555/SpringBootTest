package com.example.redis_demo.dao.impl;

import com.example.redis_demo.common.TargetDataSource;
import com.example.redis_demo.dao.inter.PatientDaoInter;
import com.example.redis_demo.dao.inter.UserDaoInter;
import com.example.redis_demo.dao.mapper.PatientDaoMapper;
import com.example.redis_demo.dao.mapper.UserDaoMapper;
import com.example.redis_demo.model.Patient;
import com.example.redis_demo.model.User;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description 用户列表
 * @Author lss0555
 * @Date 2018/11/21/021 8:50
 **/
@Repository
public class PatientDaoImpl implements PatientDaoInter {
    @Resource
    PatientDaoMapper patientDaoMapper;

    @TargetDataSource("read1")
    @Override
    public List<Patient> patientList() {
        return patientDaoMapper.patientList();
    }
}
