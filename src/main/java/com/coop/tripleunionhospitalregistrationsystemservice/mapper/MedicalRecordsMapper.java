/**
 * @ClassName MedicalRecordsMapper
 * @Author 24
 * @Date 2023/6/21 10:11
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.tripleunionhospitalregistrationsystemservice.mapper;

import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.MedicalRecords;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MedicalRecordsMapper {
    
    @Select("select * from medical_records where patient_id = #{patientId}")
    List<MedicalRecords> getMedicalRecords(String patientId);   // 查找就诊档案列表
    
    @Select("select * from medical_records where records_id = #{recordsId}")
    MedicalRecords getMedicalRecordsById(String recordsId); // 获取一个就诊档案
    
    @Insert("insert into medical_records values(#{recordsId}, #{patientId}, #{recordsName}, #{recordsPatientPhoneNumber}, " +
            "#{recordsPatientAddress}, #{recordsPatientSex}, #{recordsPatientType}, #{recordsCredit})")
    int insertMedicalRecords(MedicalRecords medicalRecords);  // 添加一个就诊档案
    
    @Update("update medical_records set records_name = #{recordsName}, patient_id = #{patientId}, " +
            "records_patient_phone_number = #{recordsPatientPhoneNumber}, records_patient_address = #{recordsPatientAddress}, " +
            "records_patient_sex = #{recordsPatientSex}, records_patient_type = #{recordsPatientType}, " +
            "records_credit = #{recordsCredit} WHERE records_id = #{recordsId}")
    int updateMedicalRecords(MedicalRecords medicalRecords);    //更新一个就诊档案
    
    @Delete("DELETE FROM medical_records WHERE records_id = #{recordsId}")   // 删除一个就诊档案
    int deleteMedicalRecords(String recordsId);
    
    
}

//    may the force be with you.
//    @ClassName   MedicalRecordsMapper
//    Created by 24 on 2023/6/21.
