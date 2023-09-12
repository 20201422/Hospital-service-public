package com.coop.tripleunionhospitalregistrationsystemservice.serviceImpl;

import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.TimeFrame;
import com.coop.tripleunionhospitalregistrationsystemservice.mapper.TimeFrameMapper;
import com.coop.tripleunionhospitalregistrationsystemservice.service.TimeFrameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeFrameServiceImpl implements TimeFrameService {

  private TimeFrameMapper timeFrameMapper;

  @Autowired
  public TimeFrameServiceImpl(TimeFrameMapper timeFrameMapper){
    this.timeFrameMapper = timeFrameMapper;
  }

  @Override
  public int getCount() {
    return timeFrameMapper.getCount();
  }

  @Override
  public List<TimeFrame> getTimeFrameList() {
    return timeFrameMapper.getTimeFrameList();
  }

  @Override
  public TimeFrame getOneTimeFrame(String timeFrameBeginTime, String timeFrameEndTime) {
    return timeFrameMapper.getOneTimeFrame(timeFrameBeginTime,timeFrameEndTime);
  }
}
