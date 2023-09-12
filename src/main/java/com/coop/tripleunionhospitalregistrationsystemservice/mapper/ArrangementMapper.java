package com.coop.tripleunionhospitalregistrationsystemservice.mapper;

import com.coop.tripleunionhospitalregistrationsystemservice.entity.arrangement.ArrangementInfo;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.manager.TimeFrameArrangementMaxAndMin;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ArrangementMapper {
    @Insert("insert into arrangement values(null,#{doctorId},#{consultingRoomId},#{numberSourceId},#{number},'不停诊')")
    int addArrangement(String doctorId,String consultingRoomId,int numberSourceId,int number);

    @Insert("insert into arrangementInfo values(null,#{doctorId},#{consultingRoomId},#{departmentId},#{numberSourceDate}," +
            "#{amOrPm},#{number})")
    int addArrangementInfo(String doctorId,String consultingRoomId,String departmentId,String numberSourceDate,String amOrPm,int number);
    @Select("select arrangementinfo_Id,doctor_name,doctor.doctor_id,consulting_room_name,consulting_room.consulting_room_id,arrangementinfo.number_source_date,arrangementinfo.AM_or_PM,arrangementinfo.number\n" +
            "from arrangementinfo,doctor,consulting_room\n" +
            "where arrangementinfo.doctor_Id = doctor.doctor_id and arrangementinfo.consultingRoom_Id = consulting_room.consulting_room_id\n" +
            "and arrangementinfo.department_Id = #{departmentId}")
    List<ArrangementInfo> findArrangementByDepartmentId(String departmentId);

    @Select("select arrangementinfo_Id,doctor_name,doctor.doctor_id,consulting_room_name,consulting_room.consulting_room_id,arrangementinfo.number_source_date,arrangementinfo.AM_or_PM,arrangementinfo.number\n" +
            "from arrangementinfo,doctor,consulting_room\n" +
            "where arrangementinfo.doctor_Id = doctor.doctor_id and arrangementinfo.consultingRoom_Id = consulting_room.consulting_room_id\n" +
            "and arrangementinfo.doctor_Id = #{doctorId}")
    List<ArrangementInfo> findArrangementByDoctorId(String doctorId);

    @Delete("delete from arrangementInfo where doctor_id = #{doctorId} and consultingRoom_id = #{consultingRoomId} " +
            "and number_source_date =#{numberSourceDate} and AM_or_PM = #{amOrPm} ")
    int deleteArrangementInfo(String doctorId,String consultingRoomId,String numberSourceDate,String amOrPm);

    @Delete("delete from arrangement\n" +
            "where doctor_id = #{doctorId} and consulting_room_id = #{consultingRoomId}\n" +
            "and number_source_id in (\n" +
            "\tselect number_source_id \n" +
            "\tfrom number_source\n" +
            "\twhere number_source_date = #{numberSourceDate} and AM_or_PM = #{amOrPm}\n" +
            ")")
    int deleteArrangement(String doctorId,String consultingRoomId,String numberSourceDate,String amOrPm);

    @Delete("delete from number_source_detail\n" +
            "where number_source_date = #{date} \n" +
            "and department_name = (select department_name from department where department_id = #{departmentId});")
    int deleteNumberSourceDetailOneDay(String departmentId,String date);

    @Delete("delete from arrangementinfo\n" +
            "where department_Id = #{departmentId}\n" +
            "and number_source_date = #{date};")
    int deleteArrangementInfoOneDay(String departmentId,String date);

    @Delete("delete from arrangement\n" +
            "where number_source_id in (\n" +
            "select number_source_id\n" +
            "from number_source\n" +
            "where number_source_date = #{date}\n" +
            "and business_id in (\n" +
            "\tselect business_id from business\n" +
            "\twhere department_Id = #{departmentId}\n" +
            "))")
    int deleteArrangementOneDay(String departmentId,String date);

    @Select("select count(*) from arrangementinfo\n" +
            "where doctor_id = #{doctorId}\n" +
            "and number_source_date = #{numberSourceDate} and AM_or_PM = #{amOrPm}")
    int ifHaveDoctor(String doctorId,String numberSourceDate,String amOrPm);

    @Select("select Max(number) as max,Min(number) as min\n" +
            "from arrangement,number_source,business,time_frame\n" +
            "where arrangement.number_source_id = number_source.number_source_id and number_source.business_id = business.business_id and business.time_frame_id = time_frame.time_frame_id\n" +
            " and department_id = #{departmentId} and time_frame_begin_time = #{timeFrameBeginTime} and time_frame_end_time = #{timeFrameEndTime} and consulting_room_type = #{consultingRoomType}")
    TimeFrameArrangementMaxAndMin getMaxAndMin(String departmentId,String timeFrameBeginTime,String timeFrameEndTime,String consultingRoomType);
    @Select("select count(*) from arrangementinfo\n" +
            "where consultingRoom_Id = #{consultingRoomId} \n" +
            "and number_source_date = #{numberSourceDate} and AM_or_PM = #{amOrPm}")
    int ifHaveConsultingRoom(String consultingRoomId,String numberSourceDate,String amOrPm);

    @Select("select DATEDIFF(#{date},NOW())")
    int dateDiff(String date);

    @Select("select * from arrangementinfo\n" +
            "where department_Id = #{departmentId} and number_source_date = subdate(#{date},7)")
    List<ArrangementInfo> getInfoByTime(String departmentId,String date);
}
