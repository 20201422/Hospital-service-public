package com.coop.tripleunionhospitalregistrationsystemservice.mapper;

import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.TimeFrame;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TimeFrameMapper {

  @Select("select count(*) from time_frame")
  int getCount();

  @Select("select * from time_frame")
  List<TimeFrame> getTimeFrameList();

  @Select("select * from time_frame where time_frame_begin_time = #{timeFrameBeginTime} and time_frame_end_time = #{timeFrameEndTime}")
  TimeFrame getOneTimeFrame(String timeFrameBeginTime,String timeFrameEndTime);

}
