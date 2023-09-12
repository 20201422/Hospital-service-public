package com.coop.tripleunionhospitalregistrationsystemservice.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.ApiResult;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.manager.NumberSourceObject;
import com.coop.tripleunionhospitalregistrationsystemservice.serviceImpl.NumberSourceServiceImpl;
import com.coop.tripleunionhospitalregistrationsystemservice.serviceImpl.PatientRegistrationServiceImpl;
import com.coop.tripleunionhospitalregistrationsystemservice.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/numberSource")
public class NumberSourceController {
    private NumberSourceServiceImpl numberSourceService;
    private PatientRegistrationServiceImpl patientRegistrationService;
    
    @Autowired
    public NumberSourceController(NumberSourceServiceImpl numberSourceService,
                                  PatientRegistrationServiceImpl patientRegistrationService) {
        this.numberSourceService = numberSourceService;
        this.patientRegistrationService = patientRegistrationService;
    }
    
    public NumberSourceServiceImpl getNumberSourceService() {
        return numberSourceService;
    }
    
    public void setNumberSourceService(NumberSourceServiceImpl numberSourceService) {
        this.numberSourceService = numberSourceService;
    }
    
    public PatientRegistrationServiceImpl getPatientRegistrationService() {
        return patientRegistrationService;
    }
    
    public void setPatientRegistrationService(PatientRegistrationServiceImpl patientRegistrationService) {
        this.patientRegistrationService = patientRegistrationService;
    }
    
    @PostMapping(value = "/numberSource")
    public ApiResult<?> getNumberSource(){
        return ApiResultHandler.success(numberSourceService.getNumberSourceObject());
    }
    
    @GetMapping(value = "/numberSourcePage")
    public ApiResult<?> getNumberSourceObject(@RequestParam("page") Integer page,
                                              @RequestParam("size") Integer size,
                                              @RequestParam("departmentName") String departmentName,
                                              @RequestParam("consultingRoomType") String consultingRoomType,
                                              @RequestParam("numberSourceDate") String numberSourceDate){
        
        Page<NumberSourceObject> numberSourceObjectPage = new Page<>(page,size);
        return ApiResultHandler.success(numberSourceService.getNumberSourceObjectPage(numberSourceObjectPage,departmentName,consultingRoomType,numberSourceDate));
    }
    
    @GetMapping(value = "/forbidDate")
    public ApiResult<?> getForbidDate(@RequestParam("departmentName") String departmentName,
                                      @RequestParam("consultingRoomType") String consultingRoomType){
        
        return ApiResultHandler.success(numberSourceService.getForbidDate(departmentName,consultingRoomType));
    }
    
    @GetMapping(value = "/addNumberSource")
    public ApiResult<?> addNumberSource(@RequestParam("departmentName") String departmentName,
                                        @RequestParam("consultingRoomType") String consultingRoomType,
                                        @RequestParam("numberSourceDate") String numberSourceDate,
                                        @RequestParam("numberSourceFee") double numberSourceFee){
        return ApiResultHandler.success(numberSourceService.insertNumberSource(numberSourceDate, numberSourceFee, departmentName, consultingRoomType));
        
    }
    
    @GetMapping(value = "/updateFee")
    public ApiResult<?> getNumberSourceId(@RequestParam("departmentName") String departmentName,
                                          @RequestParam("consultingRoomType") String consultingRoomType,
                                          @RequestParam("numberSourceDate") String numberSourceDate,
                                          @RequestParam("numberSourceFee") double numberSourceFee){
        
        return ApiResultHandler.success(numberSourceService.updateFee(departmentName,numberSourceDate,consultingRoomType,numberSourceFee));
    }
    
    @PostMapping("/patientGetNumberSource")
    public ApiResult<?> getPatientSourceNumberList(@RequestBody Map<String, String> requestBody) {  // 就诊人查看号源
        System.out.println("就诊人查看号源");
        return ApiResultHandler.success(patientRegistrationService.showNumberSourceInformationList(
                requestBody.get("date"), requestBody.get("departmentId")));
    }
}
