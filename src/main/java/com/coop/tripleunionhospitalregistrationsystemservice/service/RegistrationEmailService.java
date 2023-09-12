/**
 * @ClassName RegistrationEmailService
 * @Author 24
 * @Date 2023/6/23 15:19
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.tripleunionhospitalregistrationsystemservice.service;

import com.coop.tripleunionhospitalregistrationsystemservice.entity.patient.PatientShowRegistration;

import javax.mail.MessagingException;

public interface RegistrationEmailService {

    void sendRegistrationEmail(PatientShowRegistration patientShowRegistration) throws MessagingException;   // 发送挂号邮件（支付前）
    void sendPayEmail(PatientShowRegistration patientShowRegistration); //发送挂号邮件（支付后）
    void sendCancelEmail(PatientShowRegistration patientShowRegistration); //发送取消邮件
    void sendExitEmail(PatientShowRegistration patientShowRegistration);   // 发送退号邮件
    void sendNotPayEmail(PatientShowRegistration patientShowRegistration); // 发送未支付邮件

}

//    may the force be with you.
//    @ClassName   RegistrationEmailService
//    Created by 24 on 2023/6/23.
