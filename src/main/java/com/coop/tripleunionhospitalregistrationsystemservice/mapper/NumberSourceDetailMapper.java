package com.coop.tripleunionhospitalregistrationsystemservice.mapper;

import com.coop.tripleunionhospitalregistrationsystemservice.entity.manager.DepartmentRegistrationData;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.manager.DoctorRegistrationData;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.manager.NumberSourceDetailObject;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.NumberSourceDetail;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NumberSourceDetailMapper extends ManagerBaseMapper<NumberSourceDetail>{
  @Select("select number_source.number_source_id,department_name,consulting_room_type,doctor.doctor_id,doctor_name,doctor_level,number_source_date,AM_or_PM,CONCAT(time_frame_begin_time, '～', time_frame_end_time) as consultation_period,number_source_fee,arrangement.number\n" +
          "          from department,business,time_frame,number_source,arrangement,doctor where business.department_id = department.department_id and business.time_frame_id = time_frame.time_frame_id \n" +
          "          and number_source.business_id = business.business_id and number_source.number_source_id = arrangement.number_source_id and arrangement.doctor_id = doctor.doctor_id")
  List<NumberSourceDetailObject> findAllNumberSourceDetailObject();

  @Select("select number_source.number_source_id,department_name,consulting_room_type,doctor.doctor_id,doctor_name,doctor_level,number_source_date,AM_or_PM,CONCAT(time_frame_begin_time, '～', time_frame_end_time) as consultation_period,number_source_fee,arrangement.number\n" +
          "          from department,business,time_frame,number_source,arrangement,doctor where business.department_id = department.department_id and business.time_frame_id = time_frame.time_frame_id \n" +
          "          and number_source.business_id = business.business_id and number_source.number_source_id = arrangement.number_source_id and arrangement.doctor_id = doctor.doctor_id and doctor.doctor_id = #{doctorId} and number_source_date = #{numberSourceDate} and AM_or_PM = #{amOrPm}")
  List<NumberSourceDetailObject> findNumberSourceDetailObject(String doctorId,String numberSourceDate,String amOrPm);


  @Select("SELECT department_name, '上一周' AS week_type, DAYOFWEEK(number_source_date) AS date, COUNT(*) AS count\n" +
          "FROM number_source_detail\n" +
          "WHERE number_source_date BETWEEN DATE_SUB(DATE_SUB(DATE_FORMAT(DATE_SUB(CURRENT_DATE, INTERVAL WEEKDAY(CURRENT_DATE) DAY), '%Y-%m-%d'), INTERVAL 7 DAY), INTERVAL 1 DAY) \n" +
          "AND  DATE_SUB(DATE_FORMAT(DATE_ADD(CURRENT_DATE, INTERVAL 6 - WEEKDAY(CURRENT_DATE) DAY), '%Y-%m-%d'), INTERVAL 7 DAY) AND state = '已挂号'\n" +
          "GROUP BY DAYOFWEEK(number_source_date),department_name\n" +
          "\n" +
          "UNION ALL\n" +
          "\n" +
          "SELECT department_name, '本周' AS week_type, DAYOFWEEK(number_source_date) AS date, COUNT(*) AS count\n" +
          "FROM number_source_detail\n" +
          "WHERE number_source_date BETWEEN DATE_FORMAT(DATE_SUB(CURRENT_DATE, INTERVAL WEEKDAY(CURRENT_DATE) DAY), '%Y-%m-%d') \n" +
          "AND DATE_FORMAT(DATE_ADD(CURRENT_DATE, INTERVAL 6 - WEEKDAY(CURRENT_DATE) DAY), '%Y-%m-%d') AND state = '已挂号'\n" +
          "GROUP BY DAYOFWEEK(number_source_date),department_name\n" +
          "\n" +
          "UNION ALL\n" +
          "\n" +
          "SELECT department_name,'下一周' AS week_type, DAYOFWEEK(number_source_date) AS date, COUNT(*) AS count\n" +
          "FROM number_source_detail\n" +
          "WHERE number_source_date BETWEEN DATE_ADD(DATE_FORMAT(DATE_SUB(CURRENT_DATE, INTERVAL WEEKDAY(CURRENT_DATE) DAY), '%Y-%m-%d'), INTERVAL 7 DAY) \n" +
          "AND DATE_ADD( DATE_ADD( DATE_FORMAT(DATE_ADD(CURRENT_DATE, INTERVAL 6 - WEEKDAY(CURRENT_DATE) DAY), '%Y-%m-%d'), INTERVAL 7 DAY), INTERVAL 1 DAY) AND state = '已挂号'\n" +
          "GROUP BY DAYOFWEEK(number_source_date),department_name;")
  List<DepartmentRegistrationData> getData();

  @Select("SELECT department_name, doctor_name, '上一周' AS week_type, DAYOFWEEK(number_source_date) AS date, COUNT(*) AS count\n" +
          "FROM number_source_detail\n" +
          "WHERE number_source_date BETWEEN DATE_SUB(DATE_SUB(DATE_FORMAT(DATE_SUB(CURRENT_DATE, INTERVAL WEEKDAY(CURRENT_DATE) DAY), '%Y-%m-%d'), INTERVAL 7 DAY), INTERVAL 1 DAY) \n" +
          "AND  DATE_SUB(DATE_FORMAT(DATE_ADD(CURRENT_DATE, INTERVAL 6 - WEEKDAY(CURRENT_DATE) DAY), '%Y-%m-%d'), INTERVAL 7 DAY) AND state = '已挂号'\n" +
          "GROUP BY DAYOFWEEK(number_source_date),department_name,doctor_name\n" +
          "\n" +
          "UNION ALL\n" +
          "\n" +
          "SELECT department_name, doctor_name, '本周' AS week_type, DAYOFWEEK(number_source_date) AS date, COUNT(*) AS count\n" +
          "FROM number_source_detail\n" +
          "WHERE number_source_date BETWEEN DATE_FORMAT(DATE_SUB(CURRENT_DATE, INTERVAL WEEKDAY(CURRENT_DATE) DAY), '%Y-%m-%d') \n" +
          "AND DATE_FORMAT(DATE_ADD(CURRENT_DATE, INTERVAL 6 - WEEKDAY(CURRENT_DATE) DAY), '%Y-%m-%d') AND state = '已挂号'\n" +
          "GROUP BY DAYOFWEEK(number_source_date),department_name,doctor_name\n" +
          "\n" +
          "UNION ALL\n" +
          "\n" +
          "SELECT department_name, doctor_name, '下一周' AS week_type, DAYOFWEEK(number_source_date) AS date, COUNT(*) AS count\n" +
          "FROM number_source_detail\n" +
          "WHERE number_source_date BETWEEN DATE_ADD(DATE_FORMAT(DATE_SUB(CURRENT_DATE, INTERVAL WEEKDAY(CURRENT_DATE) DAY), '%Y-%m-%d'), INTERVAL 7 DAY) \n" +
          "AND DATE_ADD( DATE_ADD( DATE_FORMAT(DATE_ADD(CURRENT_DATE, INTERVAL 6 - WEEKDAY(CURRENT_DATE) DAY), '%Y-%m-%d'), INTERVAL 7 DAY), INTERVAL 1 DAY) AND state = '已挂号'\n" +
          "GROUP BY DAYOFWEEK(number_source_date),department_name,doctor_name;")
  List<DoctorRegistrationData> getDoctorRegistrationData();

  @Delete("delete from number_source_detail\n" +
          "where doctor_id = #{doctorId} \n" +
          "and number_source_date =#{numberSourceDate} and AM_or_PM = #{amOrPm}")
  int deleteNumberSourceDetail(String doctorId,String numberSourceDate,String amOrPm);

  @Select("select count(*) from number_source_detail\n" +
          "where department_name = (select department_name from department where department_id = #{departmentId})\n" +
          "and state = '已挂号'")
  int getRegistrationNum(String departmentId);

  @Select("select count(*) from number_source_detail\n" +
          "where department_name = (select department_name from department where department_id = #{departmentId})\n" +
          "and state = '已挂号'\n" +
          "and doctor_level = '主治医师'")
  int getRegistrationNumSpecial(String departmentId);

  @Select("select count(*) from number_source_detail\n" +
          "where department_name = (select department_name from department where department_id = #{departmentId})\n" +
          "and state = '已挂号'\n" +
          "and doctor_level = '主任医师'")
  int getRegistrationNumExpert(String departmentId);

  @Select("select count(*) from number_source_detail\n" +
          "where department_name = (select department_name from department where department_id = #{departmentId})\n" +
          "and state = '已挂号'\n" +
          "and doctor_level = '医生'")
  int getRegistrationNumGeneral(String departmentId);

  @Insert("insert ignore into number_source_detail(number_source_id,department_name,consulting_room_type,doctor_id,doctor_name,doctor_level,number_source_date,AM_or_PM,consultation_period,number_source_fee,state) "+
          "values(#{numberSourceId},#{departmentName},#{consultingRoomType},#{doctorId},#{doctorName},#{doctorLevel},#{numberSourceDate}," +
          "#{AMOrPM},#{consultationPeriod},#{numberSourceFee},'未挂号')")
  void add(NumberSourceDetail numberSourceDetail);

  @Select("select * from number_source_detail where doctor_id = #{doctorId} and number_source_date = #{numberSourceDate} and AM_or_PM = #{amOrPm} and state = '未挂号' ORDER BY CAST(SUBSTRING(consultation_period, 1, 5) AS TIME)")
  List<NumberSourceDetail> findUnregister(String doctorId,String numberSourceDate,String amOrPm);

  @Update("update number_source_detail set state = #{state} WHERE number_source_detail_id = #{numberSourceDetailId};")
  int updateState(Integer numberSourceDetailId, String state);  // 更改状态

  @Select("select * from number_source_detail where number_source_detail_id = #{numberSourceDetailId};")
  NumberSourceDetail getNumberSourceDetail(String numberSourceDetailId);  // 获取一个号源明细

}
