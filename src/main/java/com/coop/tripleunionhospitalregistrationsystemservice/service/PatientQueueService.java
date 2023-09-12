package com.coop.tripleunionhospitalregistrationsystemservice.service;

import com.coop.tripleunionhospitalregistrationsystemservice.entity.doctor.PatientQueueInfo;

import java.util.List;

public interface PatientQueueService {
    List<PatientQueueInfo> findByDoctorId(String doctorId);
}
