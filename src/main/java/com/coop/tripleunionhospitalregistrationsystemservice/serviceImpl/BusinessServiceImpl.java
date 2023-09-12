package com.coop.tripleunionhospitalregistrationsystemservice.serviceImpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.manager.BusinessDetail;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.manager.TimeFrameRegistrationCount;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.Business;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.Department;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.TimeFrame;
import com.coop.tripleunionhospitalregistrationsystemservice.mapper.BusinessMapper;
import com.coop.tripleunionhospitalregistrationsystemservice.service.BusinessService;
import com.coop.tripleunionhospitalregistrationsystemservice.service.FindBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessServiceImpl implements BusinessService {

  private BusinessMapper businessMapper;

  private TimeFrameServiceImpl timeFrameService;

  private DepartmentServiceImpl departmentService;

  private FindBusinessService findBusinessService;

  @Autowired
  public BusinessServiceImpl(BusinessMapper businessMapper,TimeFrameServiceImpl timeFrameService,DepartmentServiceImpl departmentService){
    this.businessMapper = businessMapper;
    this.timeFrameService = timeFrameService;
    this.departmentService = departmentService;
  }

  @Override
  public IPage<BusinessDetail> showBusiness(Page<BusinessDetail> page) {
    return businessMapper.findAllBusiness(page);
  }

  @Override
  public List<BusinessDetail> showBusinessList() {
    return businessMapper.findAll();
  }

  @Override
  public IPage<BusinessDetail> showBusinesses(Page<BusinessDetail> page, String departmentName, String consultingRoom, String timeFrameBeginTime, String timeFrameEndTime) {

    if (departmentName == null || departmentName.length() == 0) {
      departmentName = null;
    }

    if (timeFrameBeginTime == null || timeFrameBeginTime.length() == 0) {
      timeFrameBeginTime = null;
    }

    if (timeFrameEndTime == null || timeFrameEndTime.length() == 0) {
      timeFrameEndTime = null;
    }

    if (consultingRoom == null || consultingRoom.length() == 0) {
      consultingRoom = null;
    }
    if (timeFrameBeginTime == null && timeFrameEndTime == null) {
      findBusinessService = new TwoFindBusinessServiceImpl(businessMapper);
      return findBusinessService.showBusiness(page,departmentName,consultingRoom,timeFrameBeginTime,timeFrameEndTime);
    } else {
      findBusinessService = new FourthFindBusinessServiceImpl(businessMapper);
      return findBusinessService.showBusiness(page,departmentName,consultingRoom,timeFrameBeginTime,timeFrameEndTime);
    }
  }

  @Override
  public String insertBusiness(String departmentId, String consultingRoomType, int numberSourceNumber) {
    int count = timeFrameService.getCount();
    Department department = departmentService.getDepartmentById(departmentId);
    List<Business> list = getBusinessByDepartmentId(departmentId, consultingRoomType);
    List<TimeFrame> timeFrames = timeFrameService.getTimeFrameList();
    if (list.size() != 0) {
      return "该" + department.getDepartmentName() + "已经添加业务！";
    } else {
      for (int i = 0; i < timeFrames.size(); i++) {
        int min = numberSourceNumber * i / count;
        int max = numberSourceNumber * (i + 1) / count;
        int averageNum = max - min;
        businessMapper.insertBusiness(timeFrames.get(i).getTimeFrameId(),departmentId,consultingRoomType,averageNum);
      }
      return "添加数据成功！";
    }
  }

  @Override
  public List<TimeFrameRegistrationCount> getTimeFrameRegistrationCount(String departmentName) {
    return businessMapper.getTimeFrameRegistrationCount(departmentName);
  }

  @Override
  public void updateNumber(int numberSourceNumber, int timeFrameId, String departmentId, String consultingRoomType) {
    businessMapper.updateNumber(numberSourceNumber,timeFrameId,departmentId,consultingRoomType);
  }

  @Override
  public List<Business> getBusinessByDepartmentId(String departmentId, String consultingRoomType) {
    return businessMapper.getBusinessByDepartmentId(departmentId,consultingRoomType);
  }

  @Override
  public void updateBusiness(int numberSourceNumber, String departmentId,String consultingRoomType) {
    businessMapper.updateBusiness(numberSourceNumber,departmentId,consultingRoomType);
  }
}
