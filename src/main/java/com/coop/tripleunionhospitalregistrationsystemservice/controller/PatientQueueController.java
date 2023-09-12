package com.coop.tripleunionhospitalregistrationsystemservice.controller;

import com.coop.tripleunionhospitalregistrationsystemservice.entity.ApiResult;
import com.coop.tripleunionhospitalregistrationsystemservice.serviceImpl.PatientQueueServiceImpl;
import com.coop.tripleunionhospitalregistrationsystemservice.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patientQueue")
public class PatientQueueController {
    PatientQueueServiceImpl patientQueueService;

    @Autowired
    public PatientQueueController(PatientQueueServiceImpl patientQueueService) {
        this.patientQueueService = patientQueueService;
    }

    @GetMapping("/getByDoctorId/{doctorId}")
    public ApiResult<?> findByDoctorId(@PathVariable("doctorId") String doctorId){
        return ApiResultHandler.success(patientQueueService.findByDoctorId(doctorId));
    }
}
