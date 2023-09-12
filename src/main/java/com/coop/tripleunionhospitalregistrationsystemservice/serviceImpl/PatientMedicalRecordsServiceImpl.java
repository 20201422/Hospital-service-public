/**
 * @ClassName PatientMedicalRecordsServiceImpl
 * @Author 24
 * @Date 2023/6/21 10:45
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.tripleunionhospitalregistrationsystemservice.serviceImpl;

import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.MedicalRecords;
import com.coop.tripleunionhospitalregistrationsystemservice.mapper.MedicalRecordsMapper;
import com.coop.tripleunionhospitalregistrationsystemservice.service.MedicalRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PatientMedicalRecordsServiceImpl implements MedicalRecordsService<String> {
    
    private MedicalRecordsMapper medicalRecordsMapper;
    
    public PatientMedicalRecordsServiceImpl() {
    }
    
    @Autowired
    public PatientMedicalRecordsServiceImpl(MedicalRecordsMapper medicalRecordsMapper) {
        this.medicalRecordsMapper = medicalRecordsMapper;
    }
    
    public MedicalRecordsMapper getMedicalRecordsMapper() {
        return medicalRecordsMapper;
    }
    
    public void setMedicalRecordsMapper(MedicalRecordsMapper medicalRecordsMapper) {
        this.medicalRecordsMapper = medicalRecordsMapper;
    }
    
    @Override
    public int addMedicalRecords(MedicalRecords medicalRecords) {   // 添加就诊档案
        
        if (medicalRecordsMapper.getMedicalRecordsById(medicalRecords.getRecordsId()) != null) {    // 存在该就诊档案
            return 0;
        }
        
        if (medicalRecordsMapper.getMedicalRecords(String.valueOf(medicalRecords.getPatientId())).size() >= 3) { // 该账号下的就诊档案已经3个了
            return -1;
        }
        return medicalRecordsMapper.insertMedicalRecords(medicalRecords);
    }
    
    @Override
    public int removeMedicalRecords(String records_id) {    // 删除就诊档案
        return medicalRecordsMapper.deleteMedicalRecords(records_id);
    }
    
    @Override
    public int updateMedicalRecords(MedicalRecords medicalRecords) {    // 更新就诊档案
        return medicalRecordsMapper.updateMedicalRecords(medicalRecords);
    }
    
    @Override
    public List<Object> showMedicalRecords(String param) {  // 查看就诊档案列表
        return Collections.singletonList(medicalRecordsMapper.getMedicalRecords(String.valueOf(param)));
    }
    
    @Override
    public Object showOneMedicalRecord(String recordsId) { // 查看一个就诊档案
        return medicalRecordsMapper.getMedicalRecordsById(recordsId);
    }
    
    public int importMedicalRecords(MedicalRecords medicalRecords) {    // 导入就诊档案
        if (medicalRecordsMapper.getMedicalRecords(String.valueOf(medicalRecords.getPatientId())).size() >= 3) { // 该账号下的就诊档案已经3个了
            return -1;
        }
        
        MedicalRecords record = medicalRecordsMapper.getMedicalRecordsById(medicalRecords.getRecordsId());
        
        if (record.getPatientId() == medicalRecords.getPatientId()) {// 已经在该账号下就诊档案
            return 0;
        }
        
        return medicalRecordsMapper.updateMedicalRecords(medicalRecords);
    }
    
}

//    may the force be with you.
//    @ClassName   PatientMedicalRecordsServiceImpl
//    Created by 24 on 2023/6/21.
