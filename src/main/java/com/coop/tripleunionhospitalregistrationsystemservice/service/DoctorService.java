package com.coop.tripleunionhospitalregistrationsystemservice.service;

import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.Doctor;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.patient.DoctorArrangeForSevenDays;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.patient.PatientShowOneDoctor;

import java.util.List;

public interface DoctorService {
    List<Doctor> findDoctorByDepartmentId(String departmentId);

    Doctor findDoctorById(String doctorId);

    String findDepartmentIdByDoctorId(String doctorId);
    
    PatientShowOneDoctor getOneDoctorByIdPatientUse(String doctorId);    // 患者查看医生信息
    
    List<DoctorArrangeForSevenDays> getDoctorArrangeForSevenDays(String doctorId);  // 查看医生的一周排班信息
    
}
