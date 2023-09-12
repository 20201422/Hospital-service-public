package com.coop.tripleunionhospitalregistrationsystemservice.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.manager.BusinessDetail;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.manager.TimeFrameRegistrationCount;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.Business;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface BusinessMapper {
  @Select("select department_name,time_frame_begin_time,time_frame_end_time,consulting_room_type,number_source_number " +
          "from department,business,time_frame where business.department_id = department.department_id" +
          " and business.time_frame_id = time_frame.time_frame_id")
  IPage<BusinessDetail> findAllBusiness(Page page);

  @Select("select department_name,time_frame_begin_time,time_frame_end_time,consulting_room_type,number_source_number " +
          "from department,business,time_frame where business.department_id = department.department_id" +
          " and business.time_frame_id = time_frame.time_frame_id")
  List<BusinessDetail> findAll();

  @Select("select department_name,time_frame_begin_time,time_frame_end_time,consulting_room_type,number_source_number\n" +
          "          from department,business,time_frame where business.department_id = department.department_id\n" +
          "           and business.time_frame_id = time_frame.time_frame_id and department_name = IFNULL(#{departmentName},department_name) and consulting_room_type = IFNULL(#{consultingRoom},consulting_room_type) \n" +
          "\t\t   and (COALESCE(time_frame_begin_time,'') = #{timeFrameBeginTime} or COALESCE(time_frame_end_time,'') = #{timeFrameEndTime})")
  IPage<BusinessDetail> findBusinesses(Page page,String departmentName,String consultingRoom,String timeFrameBeginTime,String timeFrameEndTime);

  @Select("select department_name,time_frame_begin_time,time_frame_end_time,consulting_room_type,number_source_number\n" +
          "          from department,business,time_frame where business.department_id = department.department_id\n" +
          "           and business.time_frame_id = time_frame.time_frame_id and department_name=IFNULL(#{departmentName},department_name) and consulting_room_type=IFNULL(#{consultingRoom},consulting_room_type) \n" +
          "           and (time_frame_begin_time = IFNULL(null,time_frame_begin_time) or time_frame_end_time = IFNULL(null,time_frame_end_time))")
  IPage<BusinessDetail> findBusiness(Page page,String departmentName,String consultingRoom);

  @Select("select department_name,time_frame.time_frame_id,state,count(*) as count\n" +
          "from number_source_detail,number_source,business,time_frame\n" +
          "where number_source_detail.number_source_id = number_source.number_source_id \n" +
          "and number_source.business_id = business.business_id\n" +
          "and business.time_frame_id = time_frame.time_frame_id and state = '已挂号' and department_name = #{departmentName}\n" +
          "group by time_frame.time_frame_id")
  List<TimeFrameRegistrationCount> getTimeFrameRegistrationCount(String departmentName);

  @Select("select * from business where department_id = #{departmentId} and consulting_room_type = #{consultingRoomType}")
  List<Business> getBusinessByDepartmentId(String departmentId, String consultingRoomType);

  @Update("update business set number_source_number = #{numberSourceNumber} where department_id = #{departmentId} and consulting_room_type = #{consultingRoomType}")
  void updateBusiness(int numberSourceNumber,String departmentId,String consultingRoomType);

  @Update("update business set number_source_number = #{numberSourceNumber} where time_frame_id = #{timeFrameId} and department_id = #{departmentId} and consulting_room_type = #{consultingRoomType}")
  void updateNumber(int numberSourceNumber,int timeFrameId,String departmentId,String consultingRoomType);

  @Insert("insert ignore into business(business_id,time_frame_id,department_id,consulting_room_type,number_source_number) " +
          "values(null,#{timeFrameId},#{departmentId},#{consultingRoomType},#{numberSourceNumber})")
  void insertBusiness(int timeFrameId,String departmentId,String consultingRoomType,int numberSourceNumber);

}
