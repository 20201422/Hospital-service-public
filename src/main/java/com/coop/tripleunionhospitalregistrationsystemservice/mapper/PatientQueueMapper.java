package com.coop.tripleunionhospitalregistrationsystemservice.mapper;

import com.coop.tripleunionhospitalregistrationsystemservice.entity.doctor.PatientQueueInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface PatientQueueMapper {
    @Select("select patient_name,records_name,number_source_date,AM_or_PM,consultation_period,records_patient_sex,records_patient_address\n" +
            "from medical_records,registration,number_source_detail,patient\n" +
            "where medical_records.records_id = registration.records_id\n" +
            "and number_source_detail.number_source_detail_id = registration.number_source_detail_id\n" +
            "and patient.patient_id = medical_records.patient_id\n" +
            "and DATEDIFF(number_source_date,NOW())>=0\n" +
            "and registration_state = '成功'\n" +
            "and number_source_detail.doctor_id = #{doctorId}")
    List<PatientQueueInfo> findByDoctorId(String doctorId);
}
