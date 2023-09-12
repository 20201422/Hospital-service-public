package com.coop.tripleunionhospitalregistrationsystemservice.service;

import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.TimeFrame;

import java.util.List;

public interface TimeFrameService {
  int getCount();
  List<TimeFrame> getTimeFrameList();
  TimeFrame getOneTimeFrame(String timeFrameBeginTime,String timeFrameEndTime);
}
