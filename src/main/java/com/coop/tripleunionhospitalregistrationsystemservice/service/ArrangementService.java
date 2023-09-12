package com.coop.tripleunionhospitalregistrationsystemservice.service;

import com.coop.tripleunionhospitalregistrationsystemservice.entity.arrangement.ArrangementInfo;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.manager.TimeFrameArrangementMaxAndMin;

import java.util.List;

public interface ArrangementService {
    int addArrangement(String doctorId,String consultingRoomId,String numberSourceId,int number);
    int addArrangementInfo(String doctorId,String consultingRoomId,String departmentId,String numberSourceDate,String amOrPm,int number);
    List<ArrangementInfo> findArrangementByDepartmentId(String departmentId);
    List<ArrangementInfo> findArrangementByDoctorId(String doctorId);
    int deleteArrangementInfo(String doctorId,String consultingRoomId,String numberSourceDate,String amOrPm);
    int arrange(String doctorId,String consultingRoomId,String numberSourceDate,String numberSourceId,
                String amOrPm, int number,String departmentId,String consultingRoomType);
    int quickArrange(String departmentId);
    int deleteArrangement(String doctorId,String consultingRoomId,String numberSourceDate,String amOrPm);
    int deleteAll(String departmentId);
    int updateArrangement(String doctorId,String consultingRoomId,String numberSourceDate,
                          String amOrPm,String NewConsultingRoomId,String newNumberSourceId,
                          int number,String departmentId,String newNumberSourceDate,String newAmOrPm,String consultingRoomType);
    TimeFrameArrangementMaxAndMin getMaxAndMin(String departmentId, String timeFrameBeginTime, String timeFrameEndTime, String consultingRoomType);

    int ifHaveDoctor(String doctorId,String numberSourceDate,String amOrPm);

    int ifHaveConsultingRoom(String consultingRoomId,String numberSourceDate,String amOrPm);
}
