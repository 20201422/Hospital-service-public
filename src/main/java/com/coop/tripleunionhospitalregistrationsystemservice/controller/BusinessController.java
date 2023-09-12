package com.coop.tripleunionhospitalregistrationsystemservice.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.ApiResult;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.manager.BusinessDetail;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.Department;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.TimeFrame;
import com.coop.tripleunionhospitalregistrationsystemservice.serviceImpl.BusinessServiceImpl;
import com.coop.tripleunionhospitalregistrationsystemservice.serviceImpl.DepartmentServiceImpl;
import com.coop.tripleunionhospitalregistrationsystemservice.serviceImpl.TimeFrameServiceImpl;
import com.coop.tripleunionhospitalregistrationsystemservice.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/business")
public class BusinessController {
  private BusinessServiceImpl businessService;
  private TimeFrameServiceImpl timeFrameService;

  private DepartmentServiceImpl departmentService;

  @Autowired
  public BusinessController(BusinessServiceImpl businessService, TimeFrameServiceImpl timeFrameService, DepartmentServiceImpl departmentService) {
    this.businessService = businessService;
    this.timeFrameService = timeFrameService;
    this.departmentService = departmentService;
  }

  @PostMapping(value = "/businessList")
  public ApiResult<?> getBusinessList() {
    return ApiResultHandler.success(businessService.showBusinessList());
  }

  @GetMapping(value = "/businessPart")
  public ApiResult<?> getBusinessPart(@RequestParam("page") Integer page,
                                      @RequestParam("size") Integer size,
                                      @RequestParam("departmentName") String departmentName,
                                      @RequestParam("timeFrameBeginTime") String timeFrameBeginTime,
                                      @RequestParam("timeFrameEndTime") String timeFrameEndTime,
                                      @RequestParam("consultingRoom") String consultingRoom) {
    Page<BusinessDetail> business = new Page<>(page, size);
    return ApiResultHandler.success(businessService.showBusinesses(business, departmentName, consultingRoom, timeFrameBeginTime, timeFrameEndTime));
  }

  @GetMapping(value = "/addBusiness")
  public ApiResult<?> addBusiness(@RequestParam("departmentId") String departmentId,
                                  @RequestParam("consultingRoomType") String consultingRoomType,
                                  @RequestParam("numberSourceNumber") Integer numberSourceNumber) {
    return ApiResultHandler.success(businessService.insertBusiness(departmentId, consultingRoomType, numberSourceNumber));
  }

  @GetMapping(value = "/updateNumber")
  public ApiResult<?> updateNumber(@RequestParam("numberSourceNumber") int numberSourceNumber,
                                   @RequestParam("departmentName") String departmentName,
                                   @RequestParam("timeFrameBeginTime") String timeFrameBeginTime,
                                   @RequestParam("timeFrameEndTime") String timeFrameEndTime,
                                   @RequestParam("consultingRoomType") String consultingRoomType) {

    TimeFrame timeFrame = timeFrameService.getOneTimeFrame(timeFrameBeginTime,timeFrameEndTime);

    Department department = departmentService.getDepartmentByName(departmentName);

    businessService.updateNumber(numberSourceNumber,timeFrame.getTimeFrameId(),department.getDepartmentId(),consultingRoomType);

    return ApiResultHandler.success("更新号源数量成功！");
  }

}
