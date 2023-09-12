package com.coop.tripleunionhospitalregistrationsystemservice.mapper;

import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.Doctor;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.patient.DoctorArrangeForSevenDays;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.patient.PatientShowOneDoctor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DoctorMapper {
    @Select("select * from doctor where department_id = #{departmentId}")
    List<Doctor> findDoctorByDepartmentId(String departmentId);
    
    @Select("select * from doctor where doctor_id = #{doctorId}")
    Doctor findDoctorById(String doctorId);

    @Select("select department_id from doctor where doctor_id = #{doctorId}")
    String findDepartmentIdByDoctorId(String doctorId);


    @Select("select doctor_name, doctor_sex, doctor_photo, doctor_introduction, doctor_major, doctor_level\n" +
            "from doctor where doctor_id = #{doctorId}")
    PatientShowOneDoctor getOneDoctorByIdPatientUse(String doctorId);   // 患者查看医生信息
    
    @Select("SELECT doctor_name, number_source_date, AM_or_PM, COUNT(*) as attendance_num, \n" +
            "SUM(CASE WHEN state = '未挂号' THEN 1 ELSE 0 END) AS uninsured_num\n" +
            "FROM number_source_detail\n" +
            "WHERE number_source_date BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 7 DAY)\n" +
            "AND doctor_id = #{doctorId}\n" +
            "GROUP BY doctor_id, number_source_date, AM_or_PM\n" +
            "ORDER BY number_source_date ASC;")
    List<DoctorArrangeForSevenDays> getDoctorArrangeForSevenDays(String doctorId);  // 查看医生的一周排班信息
    


}
