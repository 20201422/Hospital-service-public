/**
 * @ClassName RegistrationService
 * @Author 24
 * @Date 2023/6/20 08:06
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.tripleunionhospitalregistrationsystemservice.service;

import com.coop.tripleunionhospitalregistrationsystemservice.entity.manager.RegistrationObject;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.Registration;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.patient.NumberSourceInformation;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.patient.PatientShowRegistration;

import java.util.List;
import java.util.Map;

public interface RegistrationService<T> {

    Map<String, List<NumberSourceInformation>> showNumberSourceInformationList(String date, String departmentId);    // 查看号源
    int register(Object map);    // 挂号
    int getLastRegistrationId();    // 获取最后一个挂号单id
    int notPayment(int registrationId);   // 未支付
    int cancelRegistration(int registrationId);  // 取消挂号
    int exitRegistration(int registrationId);   // 退号
    List<PatientShowRegistration> showRegistrations(T param); // 查看挂号列表
    List<Registration> getAllRegistrations();   // 获取所有挂号单
    List<Registration> getRegistrationListByRecordsId(String recordsId);   // 根据档案id查询挂号单
    PatientShowRegistration getPatientShowRegistrationById(String registrationId);  // 根据id查看挂号单
    Object showOneRegistration(int registrationId);    // 查看一个挂号单
    List<RegistrationObject> showRegistrationObjects(); // 统计每个人三个月内的退号次数

}

//    may the force be with you.
//    @ClassName   RegistrationService
//    Created by 24 on 2023/6/20.
