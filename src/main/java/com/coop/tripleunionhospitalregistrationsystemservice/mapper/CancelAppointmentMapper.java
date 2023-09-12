/**
 * @ClassName CancelAppointmentMapper
 * @Author 24
 * @Date 2023/6/21 22:37
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.tripleunionhospitalregistrationsystemservice.mapper;

import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.CancelAppointment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CancelAppointmentMapper {

    @Insert("insert into cancel_appointment values(0, #{registrationId}, #{appointmentTime}, CURRENT_TIMESTAMP())")
    int insertCancelAppointment(CancelAppointment cancelAppointment);  // 添加取消预约

}

//    may the force be with you.
//    @ClassName   CancelAppointmentMapper
//    Created by 24 on 2023/6/21.
