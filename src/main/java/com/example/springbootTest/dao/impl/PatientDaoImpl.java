package com.example.springbootTest.dao.impl;

import com.example.springbootTest.common.dataSource.TargetDataSource;
import com.example.springbootTest.dao.inter.PatientDaoInter;
import com.example.springbootTest.dao.mapper.PatientDaoMapper;
import com.example.springbootTest.model.Patient;
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
