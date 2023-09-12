package com.coop.tripleunionhospitalregistrationsystemservice.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.patient.NumberSourceInformation;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.manager.NumberSourceObject;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface NumberSourceMapper {

    //查询剩余号源数量
    @Select("select ifnull(sum(number_source_number), 0) - (select count(*) \n" +
            "from number_source_detail\n" +
            "where doctor_level = #{doctorLevel} and number_source_date = #{date} \n" +
            "and AM_or_PM = #{amOrPm} and department_name = (select department_name from department where department_id = #{departmentId}))\n" +
            "from business\n" +
            "where business_id in(\n" +
            "select business_id from number_source\n" +
            "where number_source_date = #{date} and AM_or_PM = #{amOrPm}) and consulting_room_type = #{consultingRoomType} and department_id = #{departmentId} ")
    int findRemainNumberSource(String doctorLevel, String consultingRoomType, String date, String amOrPm ,String departmentId);
    
    @Select("select nsd.doctor_id, nsd.doctor_name, d.doctor_sex, d.doctor_photo, nsd.consulting_room_type,\n" +
            "nsd.number_source_date, nsd.number_source_fee,\n" +
            "COUNT(CASE WHEN nsd.AM_or_PM = '上午' AND nsd.state = '未挂号' THEN nsd.number_source_detail_id ELSE NULL END) AS am_counts,\n" +
            "COUNT(CASE WHEN nsd.AM_or_PM = '下午' AND nsd.state = '未挂号' THEN nsd.number_source_detail_id ELSE NULL END) AS pm_counts\n" +
            "FROM number_source_detail nsd, doctor d, number_source ns, business b\n" +
            "WHERE nsd.doctor_id = d.doctor_id \n" +
            "AND nsd.number_source_id = ns.number_source_id AND ns.business_id = b.business_id\n" +
            "AND ns.number_source_date = #{date} AND b.department_id = #{departmentId}\n" +
            "GROUP BY nsd.doctor_id, nsd.consulting_room_type, nsd.number_source_date;")
    List<NumberSourceInformation> patientGetSourceNumberInfo(String date, String departmentId);    // 患者查看号源

    //根据日期查询号源id,一般会有六个连续的号源id，因为一次排班涉及到6个时段
    @Select("select number_source_id\n" +
            "from number_source\n" +
            "where number_source_date = #{date} and AM_or_PM = #{amOrPm}\n" +
            "and business_id in(\n" +
            "\tselect business_id\n" +
            "\tfrom business\n" +
            "\twhere consulting_room_type = #{consultingRoomType} and department_Id =#{departmentId})")
    List<Integer> findNumberSourceIdByDate(String date, String amOrPm,String consultingRoomType,String departmentId);

    @Select("select ifnull(sum(number_source_number), 0)\n" +
            "from business\n" +
            "where business_id in(\n" +
            "select business_id from number_source\n" +
            "where number_source_date = #{date} and AM_or_PM = #{amOrPm}) and consulting_room_type = #{consultingRoomType} and department_id = #{departmentId}")
    int findAllNumberSourceByType(String consultingRoomType, String date, String amOrPm ,String departmentId);


    @Insert("insert ignore into number_source(number_source_id,business_id,number_source_date,AM_or_PM,number_source_fee,number_state)\n" +
            "select null,business_id,#{numberSourceDate},IF(HOUR(time_frame_end_time) < 12, '上午', '下午') AS AM_or_PM,#{numberSourceFee},null\n" +
            "from business\n" +
            "\tJOIN department ON business.department_id = department.department_id\n" +
            "    JOIN time_frame ON time_frame.time_frame_id = business.time_frame_id\n" +
            "where department_name = #{departmentName} and consulting_room_type = #{consultingRoomType}")
    void insertNumberSource(String numberSourceDate,double numberSourceFee,String departmentName,String consultingRoomType);

    @Select("select department.department_id,department_name,consulting_room_type,number_source_date,sum(number_source_number) as \"number_source_number\"\n" +
            "from business\n" +
            "\tJOIN department ON business.department_id = department.department_id\n" +
            "    JOIN number_source ON business.business_id = number_source.business_id\n" +
            "group by department.department_id,department_name,consulting_room_type,number_source_date")
    List<NumberSourceObject> findAllNumberSourceObject();

    @Select("select department.department_id,department_name,consulting_room_type,number_source_date,number_source_fee,sum(number_source_number) as \"number_source_number\"\n" +
            "from business\n" +
            "\tJOIN department ON business.department_id = department.department_id\n" +
            "    JOIN number_source ON business.business_id = number_source.business_id\n" +
            "where department_name = IFNULL(#{departmentName},department_name) and consulting_room_type = IFNULL(#{consultingRoomType},consulting_room_type) and number_source_date = IFNULL(#{numberSourceDate},number_source_date)\n" +
            "group by department.department_id,department_name,consulting_room_type,number_source_date")
    IPage<NumberSourceObject> findAllNumberSourceObjectPage(Page page, String departmentName, String consultingRoomType, String numberSourceDate);

    @Select("select count(*)\n" +
            "from business\n" +
            "\tJOIN department ON business.department_id = department.department_id\n" +
            "    JOIN number_source ON business.business_id = number_source.business_id\n" +
            "    where department_name = #{departmentName} and number_source_date = #{numberSourceDate} and consulting_room_type = #{consultingRoomType}")
    int isNumberSource(String departmentName,String numberSourceDate,String consultingRoomType);

    @Select("select number_source_date\n" +
            "from business\n" +
            "\tJOIN department ON business.department_id = department.department_id\n" +
            "    JOIN number_source ON business.business_id = number_source.business_id\n" +
            "where department_name = #{departmentName} and consulting_room_type = #{consultingRoomType}\n" +
            "group by department.department_id,department_name,consulting_room_type,number_source_date")
    String[] findForbidDate(String departmentName,String consultingRoomType);

    @Select("select number_source_id\n" +
            "from number_source,business,department\n" +
            "where number_source.business_id = business.business_id and business.department_id = department.department_id\n" +
            " and department_name = #{departmentName} and consulting_room_type = #{consultingRoomType} and number_source_date = #{numberSourceDate}")
    int [] getNumberSourceId(String departmentName,String consultingRoomType,String numberSourceDate);

    @Update("update number_source set number_source_fee = #{numberSourceFee} where number_source_id = #{numberSourceId}")
    void updateFee(double numberSourceFee,int numberSourceId);
}

//    may the force be with you.
//    @ClassName   NumberSourceMapper
//    Created by 24 on 2023/6/20.
