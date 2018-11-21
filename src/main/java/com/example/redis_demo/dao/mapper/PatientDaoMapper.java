package com.example.redis_demo.dao.mapper;

import com.example.redis_demo.model.Patient;
import com.example.redis_demo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName UserDaoMapper
 * @Description
 * @Author lss0555
 **/
@Mapper
public interface PatientDaoMapper {
    @Select(" SELECT top 5 s_glide, s_office, s_name FROM public_sysuser")
    List<Patient> patientList();
}

