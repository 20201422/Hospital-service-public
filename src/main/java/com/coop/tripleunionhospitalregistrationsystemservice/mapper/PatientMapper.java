/**
 * @ClassName PatientMapper
 * @Author 24
 * @Date 2023/6/19 09:21
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.tripleunionhospitalregistrationsystemservice.mapper;


import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.Patient;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface PatientMapper {
    
    @Insert("insert into patient values(0, #{patientName}, #{patientEmail}, " +
            "#{patientPhoneNumber}, #{patientPassword});")
    void addUser(Patient patient);    // 新增用户
    
    @Select("select * from patient where patient_phone_number = #{patientPhoneNumber}")
    Patient getUserById(String patientPhoneNumber);    // 查找用户
    
    @Select("select * from patient where patient_id = #{patientId}")
    Patient findUserByPatientId(int patientId);  // 根据id查找用户
    
    @Update("update patient set patient_name = #{userName}, patient_email = #{userEmail}, " +
            "patient_phone_number = #{userPhoneNumber} " +
            "where patient_id = #{userId}")
    int updatePatient(User user);    // 更改用户信息
    
    @Delete("delete from patient where patient_id = #{patientId}")
    int deletePatient(int patientId); // 删除一个用户
    
    
}

//    may the force be with you.
//    @ClassName   PatientMapper
//    Created by 24 on 2023/6/19.
