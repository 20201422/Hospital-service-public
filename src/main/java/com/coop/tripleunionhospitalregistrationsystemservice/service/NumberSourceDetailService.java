package com.coop.tripleunionhospitalregistrationsystemservice.service;

import com.coop.tripleunionhospitalregistrationsystemservice.entity.manager.DepartmentRegistrationData;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.manager.DoctorRegistrationData;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.manager.NumberSourceDetailObject;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.NumberSourceDetail;

import java.util.List;

public interface NumberSourceDetailService {
  public List<NumberSourceDetailObject> getAllNumberSourceDetailObject();

  List<DepartmentRegistrationData> getData();
  List<DoctorRegistrationData> getDoctorRegistrationData();

  List<NumberSourceDetailObject> getNumberSourceDetailObject(String doctorId, String numberSourceDate,String amOrPm);

  public int addNumberSourceDetail(String doctorId, String numberSourceDate,String amOrPm);

  int register(String doctorId,String numberSourceDate,String amOrPm) throws Exception;

  int deleteNumberSourceDetail(String doctorId,String numberSourceDate,String amOrPm);
  int getRegistrationNum(String departmentId);
  int getRegistrationNumSpecial(String departmentId);
  int getRegistrationNumExpert(String departmentId);
  int getRegistrationNumGeneral(String departmentId);
  int updateState(Integer numberSourceDetailId, String state);  // 更改状态

  NumberSourceDetail getNumberSourceDetail(String numberSourceDetailId);  // 获取一个号源明细
}
