/**
 * @ClassName AlipayServiceImpl
 * @Author 24
 * @Date 2023/6/22 15:10
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.tripleunionhospitalregistrationsystemservice.serviceImpl;

import cn.hutool.json.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.coop.tripleunionhospitalregistrationsystemservice.config.AlipayConfig;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.Payment;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.Registration;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.pay.Alipay;
import com.coop.tripleunionhospitalregistrationsystemservice.mapper.PaymentMapper;
import com.coop.tripleunionhospitalregistrationsystemservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Service
public class AlipayServiceImpl extends PaymentServiceImpl {
    private SmsServiceImpl smsService;
    private RegistrationEmailServiceImpl registrationEmailService;

    private static final String GATEWAY_URL = "https://openapi-sandbox.dl.alipaydev.com/gateway.do";
    private static final String FORMAT = "JSON";
    private static final String CHARSET = "UTF-8";
    private static final String SIGN_TYPE = "RSA2"; //签名方式
    @Resource
    private AlipayConfig alipayConfig;

    public AlipayServiceImpl() {
    }
    

    @Autowired
    public AlipayServiceImpl(PaymentMapper paymentMapper, NumberSourceDetailServiceImpl numberSourceDetailService,
                             PatientRegistrationServiceImpl patientRegistrationService, SmsServiceImpl smsService,
                             RegistrationEmailServiceImpl registrationEmailService, AlipayConfig alipayConfig) {
        super(paymentMapper, numberSourceDetailService, patientRegistrationService);
        this.smsService = smsService;
        this.registrationEmailService = registrationEmailService;
        this.alipayConfig = alipayConfig;
    }
    public AlipayConfig getAlipayConfig() {
        return alipayConfig;
    }

    public void setAlipayConfig(AlipayConfig alipayConfig) {
        this.alipayConfig = alipayConfig;
    }

    public SmsServiceImpl getSmsService() {
        return smsService;
    }

    public void setSmsService(SmsServiceImpl smsService) {
        this.smsService = smsService;
    }

    public RegistrationEmailServiceImpl getRegistrationEmailService() {
        return registrationEmailService;
    }

    public void setRegistrationEmailService(RegistrationEmailServiceImpl registrationEmailService) {
        this.registrationEmailService = registrationEmailService;
    }

    public String openPay(Alipay alipay) {  // 接入支付宝支付
        
        if (Objects.equals(((Registration) getPatientRegistrationService()   // 支付已经超时
                .showOneRegistration(Integer.parseInt(alipay.getTraceNo()))).getRegistrationState(), "未支付")) {
            return "0";
        }
        
        // 1. 创建Client，通用SDK提供的Client，负责调用支付宝的API
        AlipayClient alipayClient = new DefaultAlipayClient(GATEWAY_URL, alipayConfig.getAppId(),
                alipayConfig.getAppPrivateKey(), FORMAT, CHARSET, alipayConfig.getAlipayPublicKey(), SIGN_TYPE);

        // 2. 创建 Request并设置Request参数
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();  // 发送请求的 Request类
        request.setNotifyUrl(alipayConfig.getNotifyUrl());
        JSONObject bizContent = new JSONObject();
        bizContent.set("out_trade_no", alipay.getTraceNo());  // 我们自己生成的订单编号
        bizContent.set("total_amount", alipay.getTotalAmount()); // 订单的总金额
        bizContent.set("subject", alipay.getSubject());   // 支付的名称
        bizContent.set("product_code", "FAST_INSTANT_TRADE_PAY");  // 固定配置
        request.setBizContent(bizContent.toString());

        // 执行请求，拿到响应的结果，返回给浏览器
        String form = "";
        try {
            form = alipayClient.pageExecute(request).getBody(); // 调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        return form;
    }

    public int payNotify(HttpServletRequest request) throws Exception { // 获取支付结果
        if (request.getParameter("trade_status").equals("TRADE_SUCCESS")) {


            Map<String, String> params = new HashMap<>();
            Map<String, String[]> requestParams = request.getParameterMap();
            for (String name : requestParams.keySet()) {
                params.put(name, request.getParameter(name));
                // System.out.println(name + " = " + request.getParameter(name));
            }

            String sign = params.get("sign");
            String content = AlipaySignature.getSignCheckContentV1(params);
            boolean checkSignature =
                    AlipaySignature.rsa256CheckContent(content, sign, alipayConfig.getAlipayPublicKey(), "UTF-8"); // 验证签名

            // 支付宝验签
            if (checkSignature) {   // 验签通过

                Payment payment = new Payment();

                payment.setRegistrationId(Integer.parseInt(params.get("subject").split("&")[1]));
                payment.setType("支付宝");
                payment.setSubject(params.get("subject").split("&")[0]);
                payment.setTradeStatus(params.get("trade_status"));
                payment.setTradeNo(params.get("trade_no"));
                payment.setOutTradeNo(params.get("out_trade_no"));
                payment.setTotalAmount(params.get("total_amount"));
                payment.setBuyerPayAmount(params.get("buyer_pay_amount"));
                payment.setBuyerId(params.get("buyer_id"));
                payment.setGmtPayment(params.get("gmt_payment"));

                System.out.println("交易名称: " + params.get("subject"));
                System.out.println("交易状态: " + params.get("trade_status"));
                System.out.println("支付宝交易凭证号: " + params.get("trade_no"));
                System.out.println("商户订单号: " + params.get("out_trade_no"));
                System.out.println("交易金额: " + params.get("total_amount"));
                System.out.println("买家付款金额: " + params.get("buyer_pay_amount"));
                System.out.println("买家在支付宝唯一id: " + params.get("buyer_id"));
                System.out.println("买家付款时间: " + params.get("gmt_payment"));
                
                if (Objects.equals(((Registration) getPatientRegistrationService()   // 支付已经超时
                        .showOneRegistration(payment.getRegistrationId())).getRegistrationState(), "未支付")) {
                    returnPay(new Alipay(payment.getOutTradeNo(), payment.getTotalAmount(), payment.getTradeNo()));
                    
                    return 0;
                }

                // 发送预约短信
                smsService.sendMessage(params.get("subject").split("&")[1]);
                // 发送支付成功邮件
                registrationEmailService.sendPayEmail(getPatientRegistrationService()
                        .getPatientShowRegistrationById(params.get("subject").split("&")[1]));

                return insertPayment(payment);
            }
        }
        return -1;
    }

    public String returnPay(Alipay alipay) throws AlipayApiException {    // 退款
        // 1. 创建Client，通用SDK提供的Client，负责调用支付宝的API
        AlipayClient alipayClient = new DefaultAlipayClient(GATEWAY_URL,
                alipayConfig.getAppId(), alipayConfig.getAppPrivateKey(), FORMAT, CHARSET,
                alipayConfig.getAlipayPublicKey(), SIGN_TYPE);

        // 2. 创建 Request，设置参数
        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
        JSONObject bizContent = new JSONObject();
        bizContent.set("trade_no", alipay.getAlipayTraceNo());  // 支付宝回调的订单流水号
        bizContent.set("refund_amount", alipay.getTotalAmount());  // 订单的总金额
        bizContent.set("out_request_no", alipay.getTraceNo());   //  我的订单编号

        request.setBizContent(bizContent.toString());

        // 3. 执行请求
        AlipayTradeRefundResponse response = alipayClient.execute(request);
        if (response.isSuccess()) {  // 退款成功，isSuccess 为true
            return "退款成功";
        } else {   // 退款失败，isSuccess 为false
            System.out.println(response.getBody());
            return "退款失败";
        }
    }
}

//    may the force be with you.
//    @ClassName   AlipayServiceImpl
//    Created by 24 on 2023/6/22.
