package com.coop.tripleunionhospitalregistrationsystemservice.serviceImpl;

import com.coop.tripleunionhospitalregistrationsystemservice.entity.manager.DepartmentRegistrationData;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.manager.DoctorRegistrationData;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.manager.NumberSourceDetailObject;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.manager.NumberSourcePool;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.NumberSourceDetail;
import com.coop.tripleunionhospitalregistrationsystemservice.mapper.NumberSourceDetailMapper;
import com.coop.tripleunionhospitalregistrationsystemservice.service.NumberSourceDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class NumberSourceDetailServiceImpl implements NumberSourceDetailService {
  @Autowired
  private NumberSourceDetailMapper numberSourceDetailMapper;

  @Override
  public List<NumberSourceDetailObject> getAllNumberSourceDetailObject() {
    return numberSourceDetailMapper.findAllNumberSourceDetailObject();
  }

  @Override
  public List<DepartmentRegistrationData> getData() {
    return numberSourceDetailMapper.getData();
  }

  @Override
  public List<DoctorRegistrationData> getDoctorRegistrationData() {
    return numberSourceDetailMapper.getDoctorRegistrationData();
  }

  @Override
  public List<NumberSourceDetailObject> getNumberSourceDetailObject(String doctorId, String numberSourceDate,String amOrPm) {
    return numberSourceDetailMapper.findNumberSourceDetailObject(doctorId,numberSourceDate,amOrPm);
  }

  @Override
  public int addNumberSourceDetail(String doctorId,String numberSourceDate,String amOrPm) {
    List<NumberSourceDetailObject> list = getNumberSourceDetailObject(doctorId,numberSourceDate,amOrPm);
    List<NumberSourceDetail> details =  new ArrayList<>();
    for(int i = 0;i<list.size();i++){
      for(int j = 0;j<list.get(i).getNumber();j++){
        NumberSourceDetail numberSourceDetail = new NumberSourceDetail();
        numberSourceDetail.setNumberSourceId(list.get(i).getNumberSourceId());
        numberSourceDetail.setDepartmentName(list.get(i).getDepartmentName());
        numberSourceDetail.setConsultingRoomType(list.get(i).getConsultingRoomType());
        numberSourceDetail.setDoctorId(list.get(i).getDoctorId());
        numberSourceDetail.setDoctorName(list.get(i).getDoctorName());
        numberSourceDetail.setDoctorLevel(list.get(i).getDoctorLevel());
        numberSourceDetail.setNumberSourceDate(list.get(i).getNumberSourceDate());
        numberSourceDetail.setAMOrPM(list.get(i).getAmOrPm());
        numberSourceDetail.setConsultationPeriod(list.get(i).getConsultationPeriod());
        numberSourceDetail.setNumberSourceFee(list.get(i).getNumberSourceFee());
        numberSourceDetail.setState("未挂号");
        details.add(numberSourceDetail);
      }
    }
    numberSourceDetailMapper.insertBatchSomeColumn(details);
    return 200;
  }

  @Override
  public int register(String doctorId, String numberSourceDate, String amOrPm) throws Exception {
    List<NumberSourceDetail> detailList = numberSourceDetailMapper.findUnregister(doctorId,numberSourceDate,amOrPm);
    NumberSourcePool pool = new NumberSourcePool(detailList);
    int data = pool.getNumberSource().getNumberSourceDetailId();
    pool.releaseNumberSource(detailList);
    return data;
  }

  @Override
  public int deleteNumberSourceDetail(String doctorId,String numberSourceDate, String amOrPm) {
    return numberSourceDetailMapper.deleteNumberSourceDetail(doctorId,numberSourceDate,amOrPm);
  }

  @Override
  public int getRegistrationNum(String departmentId) {
    return numberSourceDetailMapper.getRegistrationNum(departmentId);
  }

  @Override
  public int getRegistrationNumSpecial(String departmentId) {
    return numberSourceDetailMapper.getRegistrationNumSpecial(departmentId);
  }

  @Override
  public int getRegistrationNumExpert(String departmentId) {
    return numberSourceDetailMapper.getRegistrationNumExpert(departmentId);
  }

  @Override
  public int getRegistrationNumGeneral(String departmentId) {
    return numberSourceDetailMapper.getRegistrationNumGeneral(departmentId);
  }

  @Override
  public int updateState(Integer numberSourceDetailId, String state) {  // 更改状态
    return numberSourceDetailMapper.updateState(numberSourceDetailId, state);
  }

  @Override
  public NumberSourceDetail getNumberSourceDetail(String numberSourceDetailId) {  // 获取一个号源明细
    return numberSourceDetailMapper.getNumberSourceDetail(numberSourceDetailId);
  }
}
