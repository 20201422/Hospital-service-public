package com.coop.tripleunionhospitalregistrationsystemservice.controller;

import com.coop.tripleunionhospitalregistrationsystemservice.entity.ApiResult;
import com.coop.tripleunionhospitalregistrationsystemservice.serviceImpl.DoctorServiceImpl;
import com.coop.tripleunionhospitalregistrationsystemservice.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    private DoctorServiceImpl doctorService;

    public DoctorController() {
    }
    @Autowired
    public DoctorController(DoctorServiceImpl doctorService) {
        this.doctorService = doctorService;
    }
    @GetMapping("/doctors/{departmentId}")
    public ApiResult<?> findDoctorByDepartmentId(@PathVariable("departmentId") String departmentId){
        return ApiResultHandler.success(doctorService.findDoctorByDepartmentId(departmentId));
    }
    @GetMapping("/findById/{doctorId}")
    public ApiResult<?> findDoctorById(@PathVariable("doctorId") String doctorId){
        return ApiResultHandler.success(doctorService.findDoctorById(doctorId));
    }
    
    @GetMapping("/getDoctor/{doctorId}")
    public ApiResult<?> getOneDoctorByIdPatientUse(@PathVariable("doctorId") String doctorId){  // 患者查看医生信息
        System.out.println("患者查看医生信息");
        return ApiResultHandler.success(doctorService.getOneDoctorByIdPatientUse(doctorId));
    }
    
    @GetMapping("/getDoctorArrange/{doctorId}")
    public ApiResult< ? > getDoctorArrangeForSevenDays(@PathVariable("doctorId") String doctorId) { // 查看医生的一周排班信息
        System.out.println("查看医生的一周排班信息");
        return ApiResultHandler.success(doctorService.getDoctorArrangeForSevenDays(doctorId));
    }
}
