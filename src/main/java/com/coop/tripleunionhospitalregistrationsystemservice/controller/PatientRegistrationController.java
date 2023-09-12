/**
 * @ClassName PatientRegistrationController
 * @Author 24
 * @Date 2023/6/21 18:54
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.tripleunionhospitalregistrationsystemservice.controller;


import com.coop.tripleunionhospitalregistrationsystemservice.entity.ApiResult;
import com.coop.tripleunionhospitalregistrationsystemservice.serviceImpl.PatientRegistrationServiceImpl;
import com.coop.tripleunionhospitalregistrationsystemservice.serviceImpl.SingletonPatientRegistration;
import com.coop.tripleunionhospitalregistrationsystemservice.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/registration")
public class PatientRegistrationController {

    private PatientRegistrationServiceImpl patientRegistrationService;
    
    SingletonPatientRegistration singletonPatientRegistration = SingletonPatientRegistration.getInstance();

    public PatientRegistrationController() {
    }

    @Autowired
    public PatientRegistrationController(PatientRegistrationServiceImpl patientRegistrationService,
                                         SingletonPatientRegistration singletonPatientRegistration) {
        this.patientRegistrationService = patientRegistrationService;
        this.singletonPatientRegistration = singletonPatientRegistration;
    }
    
    public PatientRegistrationServiceImpl getPatientRegistrationService() {
        return patientRegistrationService;
    }

    public void setPatientRegistrationService(PatientRegistrationServiceImpl patientRegistrationService) {
        this.patientRegistrationService = patientRegistrationService;
    }

    @PostMapping("/register")
    public ApiResult<?> register(@RequestBody Map<String, String> map) {  // 挂号预约
        System.out.println("挂号预约");
        return ApiResultHandler.success(singletonPatientRegistration.register(map));
    }

    @PostMapping("/isPay")
    public ApiResult<?> isPay(@RequestBody Map<String, String> map) {   //未支付
        System.out.println("未支付");
        return ApiResultHandler.success(patientRegistrationService.notPayment(Integer.parseInt(map.get("registrationId"))));
    }

    @PostMapping("/cancel")
    public ApiResult<?> cancelAppointment(@RequestBody Map<String, String> map) {   // 取消预约
        System.out.println("取消预约");
        return ApiResultHandler.success(patientRegistrationService.cancelRegistration(Integer.parseInt(map.get("registrationId"))));
    }

    @PostMapping("/exit")
    public ApiResult<?> exitAppointment(@RequestBody Map<String, String> map) { // 退号
        System.out.println("退号");
        return ApiResultHandler.success(patientRegistrationService.exitRegistration(Integer.parseInt(map.get("registrationId"))));
    }

    @GetMapping("/getAll")
    public ApiResult<?> getRegistrations(@RequestParam String patientId) {  // 获取所有挂号单
        System.out.println("获取所有挂号单");
        return ApiResultHandler.success(patientRegistrationService.showRegistrations(patientId));
    }

}

//    may the force be with you.
//    @ClassName   PatientRegistrationController
//    Created by 24 on 2023/6/21.
