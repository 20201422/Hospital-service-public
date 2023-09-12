/**
 * @ClassName UserServiceImpl
 * @Author 24
 * @Date 2023/6/19 09:33
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.tripleunionhospitalregistrationsystemservice.serviceImpl;

import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.Doctor;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.Manager;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.Patient;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.User;
import com.coop.tripleunionhospitalregistrationsystemservice.mapper.DoctorMapper;
import com.coop.tripleunionhospitalregistrationsystemservice.mapper.ManagerMapper;
import com.coop.tripleunionhospitalregistrationsystemservice.mapper.PatientMapper;
import com.coop.tripleunionhospitalregistrationsystemservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private PatientMapper patientMapper;
    private DoctorMapper doctorMapper;
    private ManagerMapper managerMapper;

    public UserServiceImpl() {
    }

    @Autowired
    public UserServiceImpl(PatientMapper patientMapper, DoctorMapper doctorMapper, ManagerMapper managerMapper) {
        this.patientMapper = patientMapper;
        this.doctorMapper = doctorMapper;
        this.managerMapper = managerMapper;
    }

    public PatientMapper getPatientMapper() {
        return patientMapper;
    }

    public void setPatientMapper(PatientMapper patientMapper) {
        this.patientMapper = patientMapper;
    }

    public DoctorMapper getDoctorMapper() {
        return doctorMapper;
    }

    public void setDoctorMapper(DoctorMapper doctorMapper) {
        this.doctorMapper = doctorMapper;
    }

    public ManagerMapper getManagerMapper() {
        return managerMapper;
    }

    public void setManagerMapper(ManagerMapper managerMapper) {
        this.managerMapper = managerMapper;
    }

    @Override
    public void addUser(Object user) {   // 注册
        Patient patient = (Patient) user;
        patient.setPatientPassword(DigestUtils.md5DigestAsHex(patient.getPatientPassword().getBytes()));  // MD5加密

        patientMapper.addUser(patient);
    }

    @Override
    public Object getUserById(Object map) {    // 登录

        String id = ((Map<String, String>) map).get("id");
        String password = ((Map<String, String>) map).get("password");

        User user = new User();

        // 管理员
        if (id.length() == 4) {
            Manager manager = managerMapper.findManagerById(id);

            if (manager == null) {  // 管理员不存在
                return -1;
            }
            if (manager.getManagerPassword().equals(password)) { // 验证成功
                user.setUserId(manager.getManagerId());
                user.setUserName(manager.getManagerName());
                user.setUserEmail(manager.getManagerEmail());
                user.setUserPhoneNumber(manager.getManagerPhoneNumber());
                user.setUserType("管理员");

                return user;
            } else {    // 密码错误
                return 0;
            }
        }

        // 医生
        if (id.length() == 7) {
            Doctor doctor = doctorMapper.findDoctorById(id);

            if (doctor == null) {   // 医生不存在
                return -1;
            }
            if (doctor.getDoctorPassword().equals(password)) {   // 验证成功
                user.setUserId(doctor.getDoctorId());
                user.setUserName(doctor.getDoctorName());
                user.setUserEmail(doctor.getDoctorEmail());
                user.setUserPhoneNumber(doctor.getDoctorPhoneNumber());
                user.setUserType(doctor.getDoctorType());

                return user;
            } else {    // 密码错误
                return 0;
            }
        }

        // 就诊人
        Patient patient = patientMapper.getUserById(id);   // 获取到就诊人的信息

        if (patient == null) { // 用户不存在
            return -1;
        }
        if (patient.getPatientPassword().equals(DigestUtils.md5DigestAsHex(password.getBytes()))) {   // 验证成功
            user.setUserId(String.valueOf(patient.getPatientId()));
            user.setUserName(patient.getPatientName());
            user.setUserEmail(patient.getPatientEmail());
            user.setUserPhoneNumber(patient.getPatientPhoneNumber());
            user.setUserType("就诊人");

            return user;
        } else {    // 密码错误
            return 0;
        }
    }
    
    @Override
    public int updatePatient(User user) {   // 更改用户信息
        return patientMapper.updatePatient(user);
    }
    
    @Override
    public int deletePatient(int patientId) {   // 删除一个用户
        return patientMapper.deletePatient(patientId);
    }
}

//    may the force be with you.
//    @ClassName   UserServiceImpl
//    Created by 24 on 2023/6/19.
