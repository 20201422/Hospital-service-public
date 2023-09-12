package com.coop.tripleunionhospitalregistrationsystemservice.service;
import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.manager.NumberSourceObject;

public interface NumberSourceService {
  int findRemainNumberSource(String doctorLevel, String consultingRoomType, String date, String amOrPm,String departmentId);

  List<Integer> findNumberSourceIdByDate(String date, String amOrPm, String consultingRoomType,String departmentId);
  int findAllNumberSourceByType(String consultingRoomType, String date, String amOrPm ,String departmentId);
  public List<NumberSourceObject> getNumberSourceObject();
  String insertNumberSource(String numberSourceDate,double numberSourceFee,String departmentName,String consultingRoomType);

  IPage<NumberSourceObject> getNumberSourceObjectPage(Page<NumberSourceObject> page, String departmentName, String consultingRoomType, String numberSourceDate);
  String [] getForbidDate(String departmentName,String consultingRoomType);

  int iSNumberSource(String departmentName,String numberSourceDate,String consultingRoomType);

  int[] getNumberSourceId(String departmentName,String consultingRoomType,String numberSourceDate);

  String updateFee(String departmentName, String numberSourceDate, String consultingRoomType,double numberSourceFee);
}
