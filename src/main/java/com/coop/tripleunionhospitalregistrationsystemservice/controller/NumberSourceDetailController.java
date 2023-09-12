package com.coop.tripleunionhospitalregistrationsystemservice.controller;

import com.coop.tripleunionhospitalregistrationsystemservice.entity.ApiResult;
import com.coop.tripleunionhospitalregistrationsystemservice.serviceImpl.NumberSourceDetailServiceImpl;
import com.coop.tripleunionhospitalregistrationsystemservice.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/numberSourceDetail")
public class NumberSourceDetailController {
  private NumberSourceDetailServiceImpl numberSourceDetailService;

  @Autowired
  public NumberSourceDetailController(NumberSourceDetailServiceImpl numberSourceDetailService){
    this.numberSourceDetailService = numberSourceDetailService;
  }

  @GetMapping(value = "/numberSourceDetail")
  public ApiResult<?> getNumberSourceDetail(){
    return ApiResultHandler.success(numberSourceDetailService.getAllNumberSourceDetailObject());
  }

  @GetMapping(value = "/addNumberSourceDetail")
  public ApiResult<?> addNumberSourceDetail(@RequestParam("doctorId") String doctorId,
                                            @RequestParam("amOrPm") String amOrPm,
                                            @RequestParam("numberSourceDate") String numberSourceDate){
    return ApiResultHandler.success(numberSourceDetailService.addNumberSourceDetail(doctorId,numberSourceDate,amOrPm));
  }

  @GetMapping(value = "/number")
  public ApiResult<?> get(@RequestParam("doctorId") String doctorId,
                          @RequestParam("amOrPm") String amOrPm,
                          @RequestParam("numberSourceDate") String numberSourceDate) throws Exception {
    return ApiResultHandler.success(numberSourceDetailService.register(doctorId,numberSourceDate,amOrPm));
  }

  @PostMapping(value = "/departmentRegistrationData")
  public ApiResult<?> getDepartmentRegistrationData()  {
    return ApiResultHandler.success(numberSourceDetailService.getData());
  }

  @PostMapping(value = "/doctorRegistrationData")
  public ApiResult<?> getDoctorRegistrationData()  {
    return ApiResultHandler.success(numberSourceDetailService.getDoctorRegistrationData());
  }

}
