package com.coop.tripleunionhospitalregistrationsystemservice.controller;

import com.coop.tripleunionhospitalregistrationsystemservice.entity.ApiResult;
import com.coop.tripleunionhospitalregistrationsystemservice.serviceImpl.ConsultingRoomServiceImpl;
import com.coop.tripleunionhospitalregistrationsystemservice.serviceImpl.DoctorServiceImpl;
import com.coop.tripleunionhospitalregistrationsystemservice.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultingRoom")
public class ConsultingRoomController {
    private ConsultingRoomServiceImpl consultingRoomService;

    public ConsultingRoomController() {
    }
    @Autowired
    public ConsultingRoomController(ConsultingRoomServiceImpl consultingRoomService) {
        this.consultingRoomService = consultingRoomService;
    }

    @GetMapping("/rooms/{departmentId}")
    public ApiResult<?> findRoomByDepartmentId(@PathVariable("departmentId") String departmentId) {
        return ApiResultHandler.success(consultingRoomService.findRoomByDepartmentId(departmentId));
    }
    @GetMapping("/findIdByName/{name}")
    public ApiResult<?> findIdByName(@PathVariable("name") String name){
        return ApiResultHandler.success(consultingRoomService.findIdByName(name));
    }
}
