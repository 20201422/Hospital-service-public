package com.coop.tripleunionhospitalregistrationsystemservice.mapper;

import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.ConsultingRoom;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ConsultingRoomMapper {
    @Select("select * from consulting_room where department_id = #{departmentId}")
    List<ConsultingRoom> findRoomByDepartmentId(String departmentId);
    @Select("select consulting_room_id from consulting_room where consulting_room_name = #{name}")
    String findIdByName(String name);
}
