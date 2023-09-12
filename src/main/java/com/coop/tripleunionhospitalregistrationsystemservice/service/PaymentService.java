/**
 * @ClassName PaymentService
 * @Author 24
 * @Date 2023/6/22 15:08
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.tripleunionhospitalregistrationsystemservice.service;

import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.Payment;

public interface PaymentService {

    Payment getPaymentById(String paymentId);   // 查询支付
    int insertPayment(Payment payment); // 添加支付记录

}

//    may the force be with you.
//    @ClassName   PaymentService
//    Created by 24 on 2023/6/22.
