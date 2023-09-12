package com.coop.tripleunionhospitalregistrationsystemservice.serviceImpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.manager.NumberSourceObject;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.Business;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.Department;
import com.coop.tripleunionhospitalregistrationsystemservice.mapper.NumberSourceMapper;
import com.coop.tripleunionhospitalregistrationsystemservice.service.NumberSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Objects;

@Service
public class NumberSourceServiceImpl implements NumberSourceService {

  private NumberSourceMapper numberSourceMapper;
  private BusinessServiceImpl businessService;

  private DepartmentServiceImpl departmentService;

  @Autowired
  public NumberSourceServiceImpl(NumberSourceMapper numberSourceMapper,DepartmentServiceImpl departmentService,BusinessServiceImpl businessService) {
    this.numberSourceMapper = numberSourceMapper;
    this.departmentService = departmentService;
    this.businessService = businessService;
  }

  public NumberSourceServiceImpl() {
  }

  @Override
  public List<NumberSourceObject> getNumberSourceObject() {
    return numberSourceMapper.findAllNumberSourceObject();
  }

  @Override
  public int findRemainNumberSource(String doctorLevel, String consultingRoomType, String date, String amOrPm, String departmentId) {
    return numberSourceMapper.findRemainNumberSource(doctorLevel, consultingRoomType, date, amOrPm, departmentId);
  }

  @Override
  public List<Integer> findNumberSourceIdByDate(String date, String amOrPm, String consultingRoomType,String departmentId) {
    return numberSourceMapper.findNumberSourceIdByDate(date, amOrPm, consultingRoomType,departmentId);
  }

  @Override
  public int findAllNumberSourceByType(String consultingRoomType, String date, String amOrPm, String departmentId) {
    return numberSourceMapper.findAllNumberSourceByType(consultingRoomType, date, amOrPm, departmentId);
  }

  @Override
  public String insertNumberSource(String numberSourceDate, double numberSourceFee, String departmentName, String consultingRoomType) {
    DecimalFormat df = new DecimalFormat("#.##");
    double num = Double.parseDouble(df.format(numberSourceFee));

    if(Objects.equals(consultingRoomType, "普通门诊")){
      if(numberSourceFee<20||numberSourceFee>50){
        return "添加失败，普通门诊的费用应该在20-50元";
      }
    }
    if(Objects.equals(consultingRoomType, "专家门诊")){
      if(numberSourceFee<40||numberSourceFee>120){
        return "添加失败，专家门诊的费用应该在40-120元";
      }
    }
    if(Objects.equals(consultingRoomType, "特需门诊")){
      if(numberSourceFee<300||numberSourceFee>500){
        return "添加失败，特需门诊的费用应该在300-500元";
      }
    }
    Department department = departmentService.getDepartmentByName(departmentName);

    List<Business> list = businessService.getBusinessByDepartmentId(department.getDepartmentId(),consultingRoomType);

    if(iSNumberSource(departmentName,numberSourceDate,consultingRoomType)>0){
      return "这天已安排号源！";
    }
    else {
      if(list.size()!=0) {
        numberSourceMapper.insertNumberSource(numberSourceDate, num, departmentName, consultingRoomType);
        return "号源安排成功！";
      }
      else {
        return "请先安排业务！";
      }
    }
  }

  @Override
  public IPage<NumberSourceObject> getNumberSourceObjectPage(Page<NumberSourceObject> page, String departmentName, String consultingRoomType, String numberSourceDate) {
    if(departmentName == null || departmentName.length() == 0){
      departmentName = null;
    }

    if(consultingRoomType == null || consultingRoomType.length() == 0){
      consultingRoomType = null;
    }

    if(numberSourceDate == null || numberSourceDate.length() == 0){
      numberSourceDate = null;
    }
    return numberSourceMapper.findAllNumberSourceObjectPage(page, departmentName, consultingRoomType, numberSourceDate);
  }

  @Override
  public String[] getForbidDate(String departmentName, String consultingRoomType) {
    return numberSourceMapper.findForbidDate(departmentName, consultingRoomType);
  }

  @Override
  public int iSNumberSource(String departmentName, String numberSourceDate, String consultingRoomType) {
    return numberSourceMapper.isNumberSource(departmentName, numberSourceDate, consultingRoomType);
  }

  @Override
  public int[] getNumberSourceId(String departmentName, String consultingRoomType, String numberSourceDate) {
    return numberSourceMapper.getNumberSourceId(departmentName,consultingRoomType,numberSourceDate);
  }

  @Override
  public String updateFee(String departmentName, String numberSourceDate, String consultingRoomType,double numberSourceFee) {
    if(Objects.equals(consultingRoomType, "普通门诊")){
      if(numberSourceFee<20||numberSourceFee>50){
        return "更新失败，普通门诊的费用应该在20-50元";
      }
    }
    if(Objects.equals(consultingRoomType, "专家门诊")){
      if(numberSourceFee<40||numberSourceFee>120){
        return "更新失败，专家门诊的费用应该在40-120元";
      }
    }
    if(Objects.equals(consultingRoomType, "特需门诊")){
      if(numberSourceFee<300||numberSourceFee>500){
        return "更新失败，特需门诊的费用应该在300-500元";
      }
    }
    int[] numberSourceIds = getNumberSourceId(departmentName,consultingRoomType,numberSourceDate);
    for(int i = 0;i<numberSourceIds.length;i++) {
      numberSourceMapper.updateFee(numberSourceFee, numberSourceIds[i]);
    }
    return "更新费用成功！";
  }

}
