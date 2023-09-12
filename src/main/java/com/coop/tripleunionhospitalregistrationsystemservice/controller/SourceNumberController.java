/**
 * @ClassName SourceNumberController
 * @Author 24
 * @Date 2023/6/20 08:12
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.tripleunionhospitalregistrationsystemservice.controller;

import com.coop.tripleunionhospitalregistrationsystemservice.entity.ApiResult;
import com.coop.tripleunionhospitalregistrationsystemservice.serviceImpl.PatientRegistrationServiceImpl;
import com.coop.tripleunionhospitalregistrationsystemservice.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/numberSource")
public class SourceNumberController {
    
    private PatientRegistrationServiceImpl patientRegistrationService;
    
    public SourceNumberController() {
    }
    
    @Autowired
    public SourceNumberController(PatientRegistrationServiceImpl patientRegistrationService) {
        this.patientRegistrationService = patientRegistrationService;
    }
    
    public PatientRegistrationServiceImpl getPatientRegistrationService() {
        return patientRegistrationService;
    }
    
    public void setPatientRegistrationService(PatientRegistrationServiceImpl patientRegistrationService) {
        this.patientRegistrationService = patientRegistrationService;
    }
    
    @PostMapping("/patientGetNumberSource")
    public ApiResult<?> getPatientSourceNumberList(@RequestBody Map<String, String> requestBody) {  // 就诊人查看号源
        System.out.println("就诊人查看号源");
        return ApiResultHandler.success(patientRegistrationService.showNumberSourceInformationList(
                requestBody.get("date"), requestBody.get("departmentId")));
    }
}

//    may the force be with you.
//    @ClassName   SourceNumberController
//    Created by 24 on 2023/6/20.
