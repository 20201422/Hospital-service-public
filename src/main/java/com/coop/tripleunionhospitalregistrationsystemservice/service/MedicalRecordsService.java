/**
 * @ClassName MedicalRecordsService
 * @Author 24
 * @Date 2023/6/21 10:43
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.tripleunionhospitalregistrationsystemservice.service;

import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.MedicalRecords;

import java.util.List;

public interface MedicalRecordsService<T> {
    
    int addMedicalRecords(MedicalRecords medicalRecords);   // 添加就诊档案
    int removeMedicalRecords(String records_id);    // 删除就诊档案
    int updateMedicalRecords(MedicalRecords medicalRecords); // 更新就诊档案
    List<Object> showMedicalRecords(T param);   // 查看就诊档案列表
    Object showOneMedicalRecord(String id); // 查看一个就诊档案
    
}

//    may the force be with you.
//    @ClassName   MedicalRecordsService
//    Created by 24 on 2023/6/21.
