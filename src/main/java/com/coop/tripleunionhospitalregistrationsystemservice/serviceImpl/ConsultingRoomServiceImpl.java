package com.coop.tripleunionhospitalregistrationsystemservice.serviceImpl;

import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.ConsultingRoom;
import com.coop.tripleunionhospitalregistrationsystemservice.mapper.ConsultingRoomMapper;
import com.coop.tripleunionhospitalregistrationsystemservice.service.ConsultingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ConsultingRoomServiceImpl implements ConsultingRoomService {
    ConsultingRoomMapper consultingRoomMapper;

    public ConsultingRoomServiceImpl() {
    }
    @Autowired
    public ConsultingRoomServiceImpl(ConsultingRoomMapper consultingRoomMapper) {
        this.consultingRoomMapper = consultingRoomMapper;
    }

    @Override
    public List<ConsultingRoom> findRoomByDepartmentId(String departmentId) {
        return consultingRoomMapper.findRoomByDepartmentId(departmentId);
    }

    @Override
    public String findIdByName(String name) {
        return consultingRoomMapper.findIdByName(name);
    }
}
