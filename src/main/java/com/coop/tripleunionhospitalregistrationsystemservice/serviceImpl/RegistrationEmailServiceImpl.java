/**
 * @ClassName RegistrationEmailServiceImpl
 * @Author 24
 * @Date 2023/6/23 15:18
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.tripleunionhospitalregistrationsystemservice.serviceImpl;

import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.MedicalRecords;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.patient.PatientShowRegistration;
import com.coop.tripleunionhospitalregistrationsystemservice.mapper.MedicalRecordsMapper;
import com.coop.tripleunionhospitalregistrationsystemservice.mapper.PatientMapper;
import com.coop.tripleunionhospitalregistrationsystemservice.service.RegistrationEmailService;
import com.coop.tripleunionhospitalregistrationsystemservice.util.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;

@Service
public class RegistrationEmailServiceImpl implements RegistrationEmailService {

    private EmailUtil emailUtil;
    private TemplateEngine templateEngine;
    private PatientMedicalRecordsServiceImpl patientMedicalRecordsService;
    private PatientMapper patientMapper;
    private MedicalRecordsMapper medicalRecordsMapper;

    public RegistrationEmailServiceImpl() {
    }

    @Autowired
    public RegistrationEmailServiceImpl(EmailUtil emailUtil, TemplateEngine templateEngine,
                                        PatientMedicalRecordsServiceImpl patientMedicalRecordsService,
                                        PatientMapper patientMapper, MedicalRecordsMapper medicalRecordsMapper) {
        this.emailUtil = emailUtil;
        this.templateEngine = templateEngine;
        this.patientMedicalRecordsService = patientMedicalRecordsService;
        this.patientMapper = patientMapper;
        this.medicalRecordsMapper = medicalRecordsMapper;
    }
    
    public EmailUtil getEmailUtil() {
        return emailUtil;
    }

    public void setEmailUtil(EmailUtil emailUtil) {
        this.emailUtil = emailUtil;
    }

    public TemplateEngine getTemplateEngine() {
        return templateEngine;
    }

    public void setTemplateEngine(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public PatientMedicalRecordsServiceImpl getPatientMedicalRecordsService() {
        return patientMedicalRecordsService;
    }

    public void setPatientMedicalRecordsService(PatientMedicalRecordsServiceImpl patientMedicalRecordsService) {
        this.patientMedicalRecordsService = patientMedicalRecordsService;
    }
    
    public PatientMapper getPatientMapper() {
        return patientMapper;
    }
    
    public void setPatientMapper(PatientMapper patientMapper) {
        this.patientMapper = patientMapper;
    }
    
    public MedicalRecordsMapper getMedicalRecordsMapper() {
        return medicalRecordsMapper;
    }
    
    public void setMedicalRecordsMapper(MedicalRecordsMapper medicalRecordsMapper) {
        this.medicalRecordsMapper = medicalRecordsMapper;
    }
    
    private Context information(PatientShowRegistration patientShowRegistration, String message) {
        // 通过 Context 构造模版中变量需要的值
        Context ctx = new Context();
        ctx.setVariable("patientName", patientShowRegistration.getRecordsName());
        ctx.setVariable("patientSex", patientShowRegistration.getRecordsPatientSex());
        ctx.setVariable("departmentName", patientShowRegistration.getDepartmentName());
        ctx.setVariable("consultingRoomType", patientShowRegistration.getConsultingRoomType());
        ctx.setVariable("doctorName", patientShowRegistration.getDoctorName());
        ctx.setVariable("numberSourceDate", patientShowRegistration.getNumberSourceDate());
        ctx.setVariable("aMOrPm", patientShowRegistration.getaMOrPm());
        ctx.setVariable("consultationPeriod", patientShowRegistration.getConsultationPeriod());
        ctx.setVariable("message",
                patientShowRegistration.getRecordsName() + message);

        return ctx;
    }
    
    private String getEmail(String recordsId) {
        return patientMapper.findUserByPatientId(
                medicalRecordsMapper.getMedicalRecordsById(recordsId).getPatientId()).getPatientEmail();
    }

    @Override
    public void sendRegistrationEmail(PatientShowRegistration patientShowRegistration) {   // 发送挂号邮件（支付前）

        String message = "您好，号源已经锁定，请在10分钟内完成支付。未及时支付号源将被释放！";

        // 使用TemplateEngine 对模版进行渲染
        String mail = templateEngine.process("EmailTemplate", information(patientShowRegistration, message));

        emailUtil.sendEmail(getEmail(patientShowRegistration.getRecordsId()),
                "三联协和医院预约挂号成功通知", mail);

    }

    @Override
    public void sendPayEmail(PatientShowRegistration patientShowRegistration) {    //发送挂号邮件（支付后）
        String message = "您好，该号源的医事服务费支付成功，请就诊当日携带医保卡或身份证在规定的预约就诊时间前提前半小时到院区门诊就诊！";

        // 使用TemplateEngine 对模版进行渲染
        String mail = templateEngine.process("EmailTemplate", information(patientShowRegistration, message));

        emailUtil.sendEmail(getEmail(patientShowRegistration.getRecordsId()),
                "三联协和医院挂号支付成功通知", mail);
    }

    @Override
    public void sendCancelEmail(PatientShowRegistration patientShowRegistration) { //发送取消邮件

        String message = "您好，该号源已经取消挂号，退款将在24小时内原路返回！";

        // 使用TemplateEngine 对模版进行渲染
        String mail = templateEngine.process("EmailTemplate", information(patientShowRegistration, message));

        emailUtil.sendEmail(getEmail(patientShowRegistration.getRecordsId()),
                "三联协和医院取消预约挂号通知", mail);
    }

    @Override
    public void sendExitEmail(PatientShowRegistration patientShowRegistration) {   // 发送退号邮件
        String message = "您好，该号源已经被退号，3个月内累计退号两次将进入黑名单，6个月内无法通过互联网预约！";

        // 使用TemplateEngine 对模版进行渲染
        String mail = templateEngine.process("EmailTemplate", information(patientShowRegistration, message));

        emailUtil.sendEmail(getEmail(patientShowRegistration.getRecordsId()),
                "三联协和医院退号通知", mail);
    }

    @Override
    public void sendNotPayEmail(PatientShowRegistration patientShowRegistration) { // 发送未支付邮件
        String message = "您好，该号源因支付超时已被释放，每天只有三次未支付的机会！";

        // 使用TemplateEngine 对模版进行渲染
        String mail = templateEngine.process("EmailTemplate", information(patientShowRegistration, message));

        emailUtil.sendEmail(getEmail(patientShowRegistration.getRecordsId()),
                "三联协和医院挂号未支付通知", mail);
    }
}

//    may the force be with you.
//    @ClassName   RegistrationEmailServiceImpl
//    Created by 24 on 2023/6/23.
