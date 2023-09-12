/**
 * @ClassName PatientMedicalRecordsController
 * @Author 24
 * @Date 2023/6/21 10:49
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.tripleunionhospitalregistrationsystemservice.controller;

import com.coop.tripleunionhospitalregistrationsystemservice.entity.ApiResult;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.MedicalRecords;
import com.coop.tripleunionhospitalregistrationsystemservice.serviceImpl.PatientMedicalRecordsServiceImpl;
import com.coop.tripleunionhospitalregistrationsystemservice.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/patientMedicalRecords")
public class PatientMedicalRecordsController {
    
    private PatientMedicalRecordsServiceImpl patientMedicalRecordsService;
    
    public PatientMedicalRecordsController() {
    }
    
    @Autowired
    public PatientMedicalRecordsController(PatientMedicalRecordsServiceImpl patientMedicalRecordsService) {
        this.patientMedicalRecordsService = patientMedicalRecordsService;
    }
    
    public PatientMedicalRecordsServiceImpl getPatientMedicalRecordsService() {
        return patientMedicalRecordsService;
    }
    
    public void setPatientMedicalRecordsService(PatientMedicalRecordsServiceImpl patientMedicalRecordsService) {
        this.patientMedicalRecordsService = patientMedicalRecordsService;
    }
    
    @PostMapping("/add")
    public ApiResult<?> addMedicalRecords(@RequestBody MedicalRecords medicalRecords) { // 添加就诊档案
        System.out.println("添加就诊档案");
        return ApiResultHandler.success(patientMedicalRecordsService.addMedicalRecords(medicalRecords));
    }
    
    @DeleteMapping("/delete")
    public ApiResult<?> deleteMedicalRecords(@RequestParam String recordsId) { // 删除就诊档案
        System.out.println("删除就诊档案");
        return ApiResultHandler.success(patientMedicalRecordsService.removeMedicalRecords(recordsId));
    }
    
    @PutMapping("/update")
    public ApiResult<?> updateMedicalRecords(@RequestBody MedicalRecords medicalRecords) {    // 更新就诊档案
        System.out.println("更新就诊档案");
        return ApiResultHandler.success(patientMedicalRecordsService.updateMedicalRecords(medicalRecords));
    }
    
    @GetMapping("/find/{recordsId}")
    public ApiResult<?> getMedicalRecordsById(@PathVariable String recordsId) {    // 查看就诊档案
        System.out.println("查看就诊档案");
        return ApiResultHandler.success(patientMedicalRecordsService.showOneMedicalRecord(recordsId));
    }
    
    @GetMapping("/findAll")
    public ApiResult<?> searchMedicalRecords(@RequestParam String patientId) { // 查看所有就诊档案
        System.out.println("查看所有就诊档案");
        return ApiResultHandler.success(patientMedicalRecordsService.showMedicalRecords(patientId));
    }
    
    @PostMapping("/import")
    public ApiResult<?> importMedicalRecords(@RequestBody MedicalRecords medicalRecords) {  // 导入就诊档案
        System.out.println("导入就诊档案");
        return ApiResultHandler.success(patientMedicalRecordsService.importMedicalRecords(medicalRecords));
    }
}

//    may the force be with you.
//    @ClassName   PatientMedicalRecordsController
//    Created by 24 on 2023/6/21.
