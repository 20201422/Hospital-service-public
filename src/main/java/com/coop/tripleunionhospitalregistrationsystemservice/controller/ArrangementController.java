package com.coop.tripleunionhospitalregistrationsystemservice.controller;

import com.coop.tripleunionhospitalregistrationsystemservice.entity.ApiResult;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.Department;
import com.coop.tripleunionhospitalregistrationsystemservice.serviceImpl.*;
import com.coop.tripleunionhospitalregistrationsystemservice.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/arrangement")
public class ArrangementController {
    NumberSourceServiceImpl numberSourceService;
    ArrangementServiceImpl arrangementService;
    NumberSourceDetailServiceImpl numberSourceDetailService;
    DoctorServiceImpl doctorService;

    DepartmentServiceImpl departmentService;

    public ArrangementController() {
    }
    @Autowired
    public ArrangementController(NumberSourceServiceImpl numberSourceService, ArrangementServiceImpl arrangementService, NumberSourceDetailServiceImpl numberSourceDetailService, DoctorServiceImpl doctorService,DepartmentServiceImpl departmentService) {
        this.numberSourceService = numberSourceService;
        this.arrangementService = arrangementService;
        this.numberSourceDetailService = numberSourceDetailService;
        this.doctorService = doctorService;
        this.departmentService = departmentService;
    }

    @GetMapping("/getRemainNumber")
    public ApiResult<?> findRemainNumberSource(@RequestParam("doctorLevel") String doctorLevel,
                                               @RequestParam("consultingRoomType") String consultingRoomType,
                                               @RequestParam("date") String date,
                                               @RequestParam("amOrPm") String amOrPm,
                                               @RequestParam("departmentId") String departmentId){
        return ApiResultHandler.success(numberSourceService.findRemainNumberSource(doctorLevel,consultingRoomType,
                                        date,amOrPm,departmentId));
    }

    @GetMapping("/getAllNumberSource")
    public ApiResult<?> findAllNumberSourceByType(@RequestParam("consultingRoomType") String consultingRoomType,
                                                  @RequestParam("date") String date,
                                                  @RequestParam("amOrPm") String amOrPm,
                                                  @RequestParam("departmentId") String departmentId){
        return ApiResultHandler.success(numberSourceService.findAllNumberSourceByType(consultingRoomType,date,amOrPm,departmentId));
    }

    @GetMapping("/getNumberSourceByDate")
    public ApiResult<?> findNumberSourceIdByDate(@RequestParam("date") String date,
                                                 @RequestParam("amOrPm") String amOrPm,
                                                 @RequestParam("consultingRoomType") String consultingRoomType,
                                                 @RequestParam("departmentId") String departmentId) {
        return ApiResultHandler.success(numberSourceService.findNumberSourceIdByDate(date,amOrPm,consultingRoomType,departmentId));
    }
    @GetMapping("/add")
    public ApiResult<?> addArrangement(@RequestParam("doctorId") String doctorId,
                                       @RequestParam("consultingRoomId") String consultingRoomId,
                                       @RequestParam("numberSourceId") String numberSourceId,
                                       @RequestParam("number") int number){

        return ApiResultHandler.success(arrangementService.addArrangement(doctorId,consultingRoomId,numberSourceId,number));
    }
    @GetMapping("/addInfo")
    public ApiResult<?> addArrangementInfo(@RequestParam("doctorId") String doctorId,
                                           @RequestParam("consultingRoomId") String consultingRoomId,
                                           @RequestParam("departmentId") String departmentId,
                                           @RequestParam("numberSourceDate") String numberSourceDate,
                                           @RequestParam("amOrPm") String amOrPm,
                                           @RequestParam("number") int number){
        return ApiResultHandler.success(arrangementService.addArrangementInfo(doctorId,consultingRoomId,departmentId,
                                                                                numberSourceDate,amOrPm,number));
    }
    @GetMapping("/findByDepartmentId/{departmentId}")
    public ApiResult<?> findArrangementByDepartmentId(@PathVariable("departmentId") String departmentId){
        return ApiResultHandler.success(arrangementService.findArrangementByDepartmentId(departmentId));
    }
    @GetMapping("findByDoctorId/{doctorId}")
    public ApiResult<?> findArrangementByDoctorId(@PathVariable("doctorId") String doctorId){
        return ApiResultHandler.success(arrangementService.findArrangementByDoctorId(doctorId));
    }
    @GetMapping("/del")
    public ApiResult<?> deleteArrangement(@RequestParam("doctorId") String doctorId,
                                          @RequestParam("consultingRoomId") String consultingRoomId,
                                          @RequestParam("numberSourceDate") String numberSourceDate,
                                          @RequestParam("amOrPm") String amOrPm){
        return ApiResultHandler.success(arrangementService.deleteArrangement(doctorId,consultingRoomId,numberSourceDate,amOrPm));
    }
    @GetMapping("/findDepartmentIdByDoctorId/{doctorId}")
    public ApiResult<?> findDepartmentIdByDoctorId(@PathVariable("doctorId") String doctorId){
        return ApiResultHandler.success(doctorService.findDepartmentIdByDoctorId(doctorId));
    }
    @GetMapping("/checkDoctor")
    public ApiResult<?> checkDoctor(@RequestParam("doctorId") String doctorId,
                                    @RequestParam("numberSourceDate") String numberSourceDate,
                                    @RequestParam("amOrPm") String amOrPm){
        return ApiResultHandler.success(arrangementService.ifHaveDoctor(doctorId,numberSourceDate,amOrPm));
    }
    @GetMapping("/checkConsultingRoom")
    public ApiResult<?> checkConsultingRoom(@RequestParam("consultingRoomId") String consultingRoomId,
                                            @RequestParam("numberSourceDate") String numberSourceDate,
                                            @RequestParam("amOrPm") String amOrPm){
        return ApiResultHandler.success(arrangementService.ifHaveConsultingRoom(consultingRoomId,numberSourceDate,amOrPm));
    }
    @GetMapping("/updateArrangement")
    public ApiResult<?> updateArrangement(@RequestParam("doctorId") String doctorId,
                                          @RequestParam("consultingRoomId") String consultingRoomId,
                                          @RequestParam("numberSourceDate") String numberSourceDate,
                                          @RequestParam("amOrPm") String amOrPm,
                                          @RequestParam("NewConsultingRoomId") String NewConsultingRoomId,
                                          @RequestParam("newNumberSourceId") String newNumberSourceId,
                                          @RequestParam("number") int number,
                                          @RequestParam("departmentId") String departmentId,
                                          @RequestParam("newNumberSourceDate") String newNumberSourceDate,
                                          @RequestParam("newAmOrPm") String newAmOrPm,
                                          @RequestParam("consultingRoomType") String consultingRoomType){
        return ApiResultHandler.success(arrangementService.updateArrangement(doctorId,consultingRoomId,numberSourceDate,
                amOrPm,NewConsultingRoomId,newNumberSourceId,number,departmentId,newNumberSourceDate,newAmOrPm,consultingRoomType));
    }
    @GetMapping("/arrange")
    public ApiResult<?> arrange(@RequestParam("doctorId") String doctorId,
                                @RequestParam("consultingRoomId") String consultingRoomId,
                                @RequestParam("numberSourceDate") String numberSourceDate,
                                @RequestParam("numberSourceId") String numberSourceId,
                                @RequestParam("amOrPm") String amOrPm,
                                @RequestParam("number") int number,
                                @RequestParam("departmentId") String departmentId,
                                @RequestParam("consultingRoomType") String consultingRoomType){
        return ApiResultHandler.success(arrangementService.arrange(doctorId,consultingRoomId,numberSourceDate,
                numberSourceId,amOrPm,number,departmentId,consultingRoomType));
    }
    @GetMapping("/quickArrange/{departmentId}")
    public ApiResult<?> quickArrange(@PathVariable("departmentId") String departmentId){
        return ApiResultHandler.success(arrangementService.quickArrange(departmentId));
    }
    @GetMapping("/deleteAll/{departmentId}")
    public ApiResult<?> deleteAll(@PathVariable("departmentId") String departmentId){
        return ApiResultHandler.success(arrangementService.deleteAll(departmentId));
    }

    @GetMapping(value = "/maxAndmin")
    public ApiResult<?> getMaxAndMin(@RequestParam("departmentName") String departmentName,
                                     @RequestParam("timeFrameBeginTime") String timeFrameBeginTime,
                                     @RequestParam("timeFrameEndTime") String timeFrameEndTime,
                                     @RequestParam("consultingRoomType") String consultingRoomType){
        Department department = departmentService.getDepartmentByName(departmentName);
        return ApiResultHandler.success(arrangementService.getMaxAndMin(department.getDepartmentId(),timeFrameBeginTime,timeFrameEndTime,consultingRoomType));
    }
}
