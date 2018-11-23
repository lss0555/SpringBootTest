package com.example.springbootTest.dao.mapper;

import com.example.springbootTest.model.Patient;
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

