package com.coop.tripleunionhospitalregistrationsystemservice.service;

import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.ConsultingRoom;

import java.util.List;

public interface ConsultingRoomService {
    List<ConsultingRoom> findRoomByDepartmentId(String departmentId);

    String findIdByName(String name);
}
