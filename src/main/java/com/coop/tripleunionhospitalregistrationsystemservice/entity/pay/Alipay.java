/**
 * @ClassName Alipay
 * @Author 24
 * @Date 2023/6/22 22:27
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.tripleunionhospitalregistrationsystemservice.entity.pay;

import lombok.Data;

@Data
public class Alipay {

    private String traceNo;
    private String totalAmount;
    private String subject;
    private String alipayTraceNo;

    public Alipay() {
    }
    
    public Alipay(String traceNo, String totalAmount, String alipayTraceNo) {
        this.traceNo = traceNo;
        this.totalAmount = totalAmount;
        this.alipayTraceNo = alipayTraceNo;
    }
    
    public Alipay(String traceNo, String totalAmount, String subject, String alipayTraceNo) {
        this.traceNo = traceNo;
        this.totalAmount = totalAmount;
        this.subject = subject;
        this.alipayTraceNo = alipayTraceNo;
    }

    public String getTraceNo() {
        return traceNo;
    }

    public void setTraceNo(String traceNo) {
        this.traceNo = traceNo;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAlipayTraceNo() {
        return alipayTraceNo;
    }

    public void setAlipayTraceNo(String alipayTraceNo) {
        this.alipayTraceNo = alipayTraceNo;
    }
}



//    may the force be with you.
//    @ClassName   Alipay
//    Created by 24 on 2023/6/22.
