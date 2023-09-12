/**
 * @ClassName PaymentServiceImpl
 * @Author 24
 * @Date 2023/6/30 20:55
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.tripleunionhospitalregistrationsystemservice.serviceImpl;

import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.Payment;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.Registration;
import com.coop.tripleunionhospitalregistrationsystemservice.mapper.PaymentMapper;
import com.coop.tripleunionhospitalregistrationsystemservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PaymentServiceImpl implements PaymentService {
    private PaymentMapper paymentMapper;
    
    private NumberSourceDetailServiceImpl numberSourceDetailService;
    private PatientRegistrationServiceImpl patientRegistrationService;
    
    public PaymentServiceImpl() {
    }
    
    @Autowired
    public PaymentServiceImpl(PaymentMapper paymentMapper, NumberSourceDetailServiceImpl numberSourceDetailService,
                              PatientRegistrationServiceImpl patientRegistrationService) {
        this.paymentMapper = paymentMapper;
        this.numberSourceDetailService = numberSourceDetailService;
        this.patientRegistrationService = patientRegistrationService;
    }
    
    public PaymentMapper getPaymentMapper() {
        return paymentMapper;
    }
    
    public void setPaymentMapper(PaymentMapper paymentMapper) {
        this.paymentMapper = paymentMapper;
    }
    
    public NumberSourceDetailServiceImpl getNumberSourceDetailService() {
        return numberSourceDetailService;
    }
    
    public void setNumberSourceDetailService(NumberSourceDetailServiceImpl numberSourceDetailService) {
        this.numberSourceDetailService = numberSourceDetailService;
    }
    
    public PatientRegistrationServiceImpl getPatientRegistrationService() {
        return patientRegistrationService;
    }
    
    public void setPatientRegistrationService(PatientRegistrationServiceImpl patientRegistrationService) {
        this.patientRegistrationService = patientRegistrationService;
    }
    
    @Override
    public Payment getPaymentById(String registrationId) {   // 查询支付
        return paymentMapper.getPaymentById(registrationId);
    }
    
    @Override
    public int insertPayment(Payment payment) { // 添加支付记录
        
        paymentMapper.insertPayment(payment);   // 添加支付记录
        
        // 更改号源明细状态
        numberSourceDetailService.updateState(((Registration) patientRegistrationService
                .showOneRegistration(payment.getRegistrationId())).getNumberSourceDetailId(), "已挂号");
        
        // 更改挂号单状态
        patientRegistrationService.updateRegistrationState(payment.getRegistrationId(), "成功");
        
        return 1;
    }
}

//    may the force be with you.
//    @ClassName   PaymentServiceImpl
//    Created by 24 on 2023/6/30.
