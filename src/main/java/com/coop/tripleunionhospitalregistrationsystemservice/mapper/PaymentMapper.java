/**
 * @ClassName PaymentMapper
 * @Author 24
 * @Date 2023/6/22 15:02
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.tripleunionhospitalregistrationsystemservice.mapper;

import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.Payment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PaymentMapper {

    @Select("SELECT * FROM payment WHERE registration_id = #{registrationId};")
    Payment getPaymentById(String registrationId);   // 查询支付

    @Insert("INSERT INTO payment (pay_id, registration_id, type, subject, trade_status, trade_no, out_trade_no, total_amount," +
            " buyer_pay_amount, buyer_id, gmt_payment)\n" +
            "VALUES (0, #{registrationId}, #{type}, #{subject}, #{tradeStatus}, #{tradeNo}, #{outTradeNo}, " +
            "#{totalAmount}, #{buyerPayAmount}, #{buyerId}, #{gmtPayment});\n")
    int insertPayment(Payment payment); // 添加支付记录

}

//    may the force be with you.
//    @ClassName   PaymentMapper
//    Created by 24 on 2023/6/22.
