package com.coop.tripleunionhospitalregistrationsystemservice.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.manager.BusinessDetail;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.manager.TimeFrameRegistrationCount;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.Business;

import java.util.List;

public interface BusinessService {
  IPage<BusinessDetail> showBusiness(Page<BusinessDetail> page);
  List<BusinessDetail> showBusinessList();
  IPage<BusinessDetail> showBusinesses(Page<BusinessDetail> page,String departmentName,String consultingRoom,String timeFrameBeginTime,String timeFrameEndTime);
  String insertBusiness(String departmentId,String consultingRoomType,int numberSourceNumber);
  List<Business> getBusinessByDepartmentId(String departmentId, String consultingRoomType);
  void updateBusiness(int numberSourceNumber,String departmentId,String consultingRoomType);
  List<TimeFrameRegistrationCount> getTimeFrameRegistrationCount(String departmentName);
  void updateNumber(int numberSourceNumber,int timeFrameId,String departmentId,String consultingRoomType);
}
