package com.coop.tripleunionhospitalregistrationsystemservice;

import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.Registration;
import com.coop.tripleunionhospitalregistrationsystemservice.serviceImpl.PatientRegistrationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.List;
@EnableScheduling //执行定时任务
@SpringBootApplication
public class TripleUnionHospitalRegistrationSystemServiceApplication {

    private static PatientRegistrationServiceImpl patientRegistrationService;

    public TripleUnionHospitalRegistrationSystemServiceApplication() {
    }

    @Autowired
    public TripleUnionHospitalRegistrationSystemServiceApplication(PatientRegistrationServiceImpl patientRegistrationService) {
        this.patientRegistrationService = patientRegistrationService;
    }

    public PatientRegistrationServiceImpl getPatientRegistrationService() {
        return patientRegistrationService;
    }

    public void setPatientRegistrationService(PatientRegistrationServiceImpl patientRegistrationService) {
        this.patientRegistrationService = patientRegistrationService;
    }

    public static void main(String[] args) {
        SpringApplication.run(TripleUnionHospitalRegistrationSystemServiceApplication.class, args);

        checkNotPay();

    }

    public static void checkNotPay() { // 循环挂号单检查是否有超时未支付的挂号单

        List<Registration> list = patientRegistrationService.getAllRegistrations();

        for (Registration registration : list) {
            patientRegistrationService.notPayment(registration.getRegistrationId());
        }
    }

}
