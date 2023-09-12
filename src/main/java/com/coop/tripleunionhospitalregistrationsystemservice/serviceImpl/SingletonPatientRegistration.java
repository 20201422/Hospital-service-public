/**
 * @ClassName SingletonPatientRegistration
 * @Author 24
 * @Date 2023/7/1 16:32
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.tripleunionhospitalregistrationsystemservice.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SingletonPatientRegistration {
    
    private static SingletonPatientRegistration instance;
    private PatientRegistrationServiceImpl patientRegistrationService;
    
    public SingletonPatientRegistration() {
    }
    
    @Autowired
    public SingletonPatientRegistration(PatientRegistrationServiceImpl patientRegistrationService) {
        this.patientRegistrationService = patientRegistrationService;
    }
    
    public static void setInstance(SingletonPatientRegistration instance) {
        SingletonPatientRegistration.instance = instance;
    }
    
    public PatientRegistrationServiceImpl getPatientRegistrationService() {
        return patientRegistrationService;
    }
    
    public void setPatientRegistrationService(PatientRegistrationServiceImpl patientRegistrationService) {
        this.patientRegistrationService = patientRegistrationService;
    }
    
    public static SingletonPatientRegistration getInstance() {
        if (instance == null) {   // 判断实例是否已经存在
            synchronized (SingletonPatientRegistration.class) {
                if (instance == null) {   // 双重锁定
                    instance = new SingletonPatientRegistration();   // 创建新的实例
                }
            }
        }
        return instance;
    }
    
    public int register(Map<String, String> map) {
        return patientRegistrationService.register(map);
    }
    
}

//    may the force be with you.
//    @ClassName   SingletonPatientRegistration
//    Created by 24 on 2023/7/1.
