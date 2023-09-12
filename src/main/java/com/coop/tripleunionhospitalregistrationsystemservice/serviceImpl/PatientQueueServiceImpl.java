package com.coop.tripleunionhospitalregistrationsystemservice.serviceImpl;

import com.coop.tripleunionhospitalregistrationsystemservice.entity.doctor.PatientQueueInfo;
import com.coop.tripleunionhospitalregistrationsystemservice.mapper.PatientQueueMapper;
import com.coop.tripleunionhospitalregistrationsystemservice.service.PatientQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PatientQueueServiceImpl implements PatientQueueService {
    PatientQueueMapper patientQueueMapper;

    @Autowired
    public PatientQueueServiceImpl(PatientQueueMapper patientQueueMapper) {
        this.patientQueueMapper = patientQueueMapper;
    }

    @Override
    public List<PatientQueueInfo> findByDoctorId(String doctorId) {
        return patientQueueMapper.findByDoctorId(doctorId);
    }
}
