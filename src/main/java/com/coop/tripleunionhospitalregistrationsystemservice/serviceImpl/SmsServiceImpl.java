/**
 * @ClassName SmsServiceImpl
 * @Author 24
 * @Date 2023/6/22 20:10
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.tripleunionhospitalregistrationsystemservice.serviceImpl;

import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.MedicalRecords;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.patient.PatientShowRegistration;
import com.coop.tripleunionhospitalregistrationsystemservice.service.SmsService;
import com.coop.tripleunionhospitalregistrationsystemservice.util.SmsUtil;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;

//导入可选配置类
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;

// 导入对应SMS模块的client
import com.tencentcloudapi.sms.v20210111.SmsClient;

// 导入要请求接口对应的request response类
import com.tencentcloudapi.sms.v20210111.models.SendSmsRequest;
import com.tencentcloudapi.sms.v20210111.models.SendSmsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Tencent Cloud Sms SendSms
 *
 */
@Service
public class SmsServiceImpl implements SmsService {

    private SmsUtil smsUtil = new SmsUtil();

    private PatientRegistrationServiceImpl patientRegistrationService;
    private PatientMedicalRecordsServiceImpl patientMedicalRecordsService;


    public SmsServiceImpl() {
    }

    public SmsServiceImpl(SmsUtil smsUtil) {
        this.smsUtil = smsUtil;
    }

    @Autowired
    public SmsServiceImpl(PatientRegistrationServiceImpl patientRegistrationService,
                          PatientMedicalRecordsServiceImpl patientMedicalRecordsService) {
        this.patientRegistrationService = patientRegistrationService;
        this.patientMedicalRecordsService = patientMedicalRecordsService;
    }


    public SmsUtil getSmsUtil() {
        return smsUtil;
    }

    public void setSmsUtil(SmsUtil smsUtil) {
        this.smsUtil = smsUtil;
    }

    public PatientRegistrationServiceImpl getPatientRegistrationService() {
        return patientRegistrationService;
    }

    public void setPatientRegistrationService(PatientRegistrationServiceImpl patientRegistrationService) {
        this.patientRegistrationService = patientRegistrationService;
    }

    public PatientMedicalRecordsServiceImpl getPatientMedicalRecordsService() {
        return patientMedicalRecordsService;
    }

    public void setPatientMedicalRecordsService(PatientMedicalRecordsServiceImpl patientMedicalRecordsService) {
        this.patientMedicalRecordsService = patientMedicalRecordsService;
    }

    @Override
    public void sendMessage(String registrationId) {
        System.out.println("发送短信");
        PatientShowRegistration patientShowRegistration =
                patientRegistrationService.getPatientShowRegistrationById(registrationId);
        List<String> smsContent = new ArrayList<>();

        smsContent.add(patientShowRegistration.getDepartmentName() // 科室名称
                + patientShowRegistration.getConsultingRoomType()); // 门诊类型
        smsContent.add(patientShowRegistration.getDoctorName());    // 医生姓名
        smsContent.add(patientShowRegistration.getNumberSourceFee());   // 医事服务费
        smsContent.add(patientShowRegistration.getRecordsName());   // 就诊人姓名
        smsContent.add(patientShowRegistration.getNumberSourceDate()   // 号源日期
                + patientShowRegistration.getaMOrPm()); // 号源午别
        smsContent.add(patientShowRegistration.getConsultationPeriod()); // 号源时段
        smsContent.add(registrationId); // 挂号单ID

        String phoneNumber = ((MedicalRecords)patientMedicalRecordsService
                .showOneMedicalRecord(patientShowRegistration.getRecordsId())).getRecordsPatientPhoneNumber();

        smsUtil.sendMessage(phoneNumber, smsContent);

    }

}

//    may the force be with you.
//    @ClassName   SmsServiceImpl
//    Created by 24 on 2023/6/22.
