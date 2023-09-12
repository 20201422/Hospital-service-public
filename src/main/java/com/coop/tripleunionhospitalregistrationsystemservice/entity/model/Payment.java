/**
 * @ClassName Payment
 * @Author 24
 * @Date 2023/6/9 18:54
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.tripleunionhospitalregistrationsystemservice.entity.model;

public class Payment {

    private int payId;
    private int registrationId;
    private String type;
    private String subject;
    private String tradeStatus;
    private String tradeNo;
    private String outTradeNo;
    private String totalAmount;
    private String buyerPayAmount;
    private String buyerId;
    private String gmtPayment;

    public Payment() {
    }

    public Payment(int payId, int registrationId, String type, String subject, String tradeStatus, String tradeNo,
                   String outTradeNo, String totalAmount, String buyerPayAmount, String buyerId, String gmtPayment) {
        this.payId = payId;
        this.registrationId = registrationId;
        this.type = type;
        this.subject = subject;
        this.tradeStatus = tradeStatus;
        this.tradeNo = tradeNo;
        this.outTradeNo = outTradeNo;
        this.totalAmount = totalAmount;
        this.buyerPayAmount = buyerPayAmount;
        this.buyerId = buyerId;
        this.gmtPayment = gmtPayment;
    }

    public int getPayId() {
        return payId;
    }

    public void setPayId(int payId) {
        this.payId = payId;
    }

    public int getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(int registrationId) {
        this.registrationId = registrationId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(String tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getBuyerPayAmount() {
        return buyerPayAmount;
    }

    public void setBuyerPayAmount(String buyerPayAmount) {
        this.buyerPayAmount = buyerPayAmount;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getGmtPayment() {
        return gmtPayment;
    }

    public void setGmtPayment(String gmtPayment) {
        this.gmtPayment = gmtPayment;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "payId=" + payId +
                ", registrationId=" + registrationId +
                ", type='" + type + '\'' +
                ", subject='" + subject + '\'' +
                ", trade_status='" + tradeStatus + '\'' +
                ", trade_no='" + tradeNo + '\'' +
                ", out_trade_no='" + outTradeNo + '\'' +
                ", total_amount='" + totalAmount + '\'' +
                ", buyer_pay_amount='" + buyerPayAmount + '\'' +
                ", buyer_id='" + buyerId + '\'' +
                ", gmt_payment='" + gmtPayment + '\'' +
                '}';
    }
}

//    may the force be with you.
//    @ClassName   Payment
//    Created by 24 on 2023/6/9.
