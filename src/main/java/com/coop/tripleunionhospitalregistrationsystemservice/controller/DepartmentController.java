/**
 * @ClassName DepartmentController
 * @Author 24
 * @Date 2023/6/19 17:49
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.tripleunionhospitalregistrationsystemservice.controller;

import com.coop.tripleunionhospitalregistrationsystemservice.entity.ApiResult;
import com.coop.tripleunionhospitalregistrationsystemservice.serviceImpl.DepartmentServiceImpl;
import com.coop.tripleunionhospitalregistrationsystemservice.serviceImpl.NumberSourceDetailServiceImpl;
import com.coop.tripleunionhospitalregistrationsystemservice.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    
    private DepartmentServiceImpl departmentService;
    private NumberSourceDetailServiceImpl numberSourceDetailService;
    
    public DepartmentController() {
    }
    @Autowired
    public DepartmentController(DepartmentServiceImpl departmentService, NumberSourceDetailServiceImpl numberSourceDetailService) {
        this.departmentService = departmentService;
        this.numberSourceDetailService = numberSourceDetailService;
    }
    
    public DepartmentServiceImpl getDepartmentService() {
        return departmentService;
    }
    
    public void setDepartmentService(DepartmentServiceImpl departmentService) {
        this.departmentService = departmentService;
    }

    public NumberSourceDetailServiceImpl getNumberSourceDetailService() {
        return numberSourceDetailService;
    }

    public void setNumberSourceDetailService(NumberSourceDetailServiceImpl numberSourceDetailService) {
        this.numberSourceDetailService = numberSourceDetailService;
    }

    @PostMapping("/getAll")
    public ApiResult<?> getDepartments() {  // 获取所有科室信息
        System.out.println("获取所有科室信息");
        return ApiResultHandler.success(departmentService.getDepartments());
    }
    
    @GetMapping("/get/{departmentId}")
    public ApiResult<?> getDepartmentById(@PathVariable String departmentId) {    // 获取一个科室的信息
        System.out.println("获取一个科室的信息");
        return ApiResultHandler.success(departmentService.getDepartmentById(departmentId));
    }

    @PostMapping(value = "/departmentList")
    public ApiResult<?> getDepartmentList() {
        return ApiResultHandler.success(departmentService.getDepartmentList());
    }

    @GetMapping("/getRegistrationNum/{departmentId}")
    public ApiResult<?> getRegistrationNum(@PathVariable("departmentId") String departmentId){
        return ApiResultHandler.success(numberSourceDetailService.getRegistrationNum(departmentId));
    }
    @GetMapping("getRegistrationNumSpecial/{departmentId}")
    public ApiResult<?> getRegistrationNumSpecial(@PathVariable("departmentId") String departmentId){
        return ApiResultHandler.success(numberSourceDetailService.getRegistrationNumSpecial(departmentId));
    }
    @GetMapping("getRegistrationNumExpert/{departmentId}")
    public ApiResult<?> getRegistrationNumExpert(@PathVariable("departmentId") String departmentId){
        return ApiResultHandler.success(numberSourceDetailService.getRegistrationNumExpert(departmentId));
    }
    @GetMapping("getRegistrationNumGeneral/{departmentId}")
    public ApiResult<?> getRegistrationNumGeneral(@PathVariable("departmentId") String departmentId){
        return ApiResultHandler.success(numberSourceDetailService.getRegistrationNumGeneral(departmentId));
    }
}

//    may the force be with you.
//    @ClassName   DepartmentController
//    Created by 24 on 2023/6/19.
