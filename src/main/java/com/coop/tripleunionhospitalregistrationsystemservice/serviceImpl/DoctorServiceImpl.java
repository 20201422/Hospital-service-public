package com.coop.tripleunionhospitalregistrationsystemservice.serviceImpl;

import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.Doctor;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.patient.DoctorArrangeForSevenDays;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.patient.PatientShowOneDoctor;
import com.coop.tripleunionhospitalregistrationsystemservice.mapper.DoctorMapper;
import com.coop.tripleunionhospitalregistrationsystemservice.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DoctorServiceImpl implements DoctorService {
    DoctorMapper doctorMapper;

    public DoctorServiceImpl() {
    }
    @Autowired
    public DoctorServiceImpl(DoctorMapper doctorMapper) {
        this.doctorMapper = doctorMapper;
    }

    @Override
    public List<Doctor> findDoctorByDepartmentId(String departmentId) {
        return doctorMapper.findDoctorByDepartmentId(departmentId);
    }

    @Override
    public Doctor findDoctorById(String doctorId) {
        return doctorMapper.findDoctorById(doctorId);
    }

    @Override
    public String findDepartmentIdByDoctorId(String doctorId) {
        return doctorMapper.findDepartmentIdByDoctorId(doctorId);
    }


    @Override
    public PatientShowOneDoctor getOneDoctorByIdPatientUse(String doctorId) {   // 患者查看医生信息
        return doctorMapper.getOneDoctorByIdPatientUse(doctorId);
    }
    
    @Override
    public List<DoctorArrangeForSevenDays> getDoctorArrangeForSevenDays(String doctorId) {  // 查看医生的一周排班信息
        return doctorMapper.getDoctorArrangeForSevenDays(doctorId);
    }
}
