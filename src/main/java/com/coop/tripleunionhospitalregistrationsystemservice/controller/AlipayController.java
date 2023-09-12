/**
 * @ClassName AlipayController
 * @Author 24
 * @Date 2023/6/22 15:21
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.tripleunionhospitalregistrationsystemservice.controller;

import cn.hutool.json.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.coop.tripleunionhospitalregistrationsystemservice.config.AlipayConfig;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.ApiResult;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.Payment;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.pay.Alipay;
import com.coop.tripleunionhospitalregistrationsystemservice.serviceImpl.AlipayServiceImpl;
import com.coop.tripleunionhospitalregistrationsystemservice.serviceImpl.PatientRegistrationServiceImpl;
import com.coop.tripleunionhospitalregistrationsystemservice.serviceImpl.SmsServiceImpl;
import com.coop.tripleunionhospitalregistrationsystemservice.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/alipay")
public class AlipayController {

    private AlipayServiceImpl alipayService;

    public AlipayController() {
    }

    @Autowired
    public AlipayController(AlipayServiceImpl alipayService) {
        this.alipayService = alipayService;
    }

    public AlipayServiceImpl getAlipayService() {
        return alipayService;
    }

    public void setAlipayService(AlipayServiceImpl alipayService) {
        this.alipayService = alipayService;
    }

    @PostMapping("/pay")
    public ApiResult<?> openPay(@RequestBody Alipay alipay) { // 打开支付宝支付接口
        System.out.println("打开支付宝支付接口");
        return ApiResultHandler.success(alipayService.openPay(alipay));
    }

    @PostMapping("/notify")  // 注意这里必须是POST接口
    public ApiResult<?> payNotify(HttpServletRequest request) throws Exception {    // 获取支付结果
        System.out.println("=========支付宝异步回调========");
        return ApiResultHandler.success(alipayService.payNotify(request));
    }

    @PostMapping("/return")
    public ApiResult returnPay(@RequestBody Alipay alipay) throws AlipayApiException {  // 退款
        System.out.println("退款");
        return ApiResultHandler.success(alipayService.returnPay(alipay));
    }

    @PostMapping("/find")
    public ApiResult<?> findPayment(@RequestBody Map<String, String> map) { // 查询支付记录
        System.out.println("查询支付记录");
        return ApiResultHandler.success(alipayService.getPaymentById(map.get("registrationId")));
    }

}

//    may the force be with you.
//    @ClassName   AlipayController
//    Created by 24 on 2023/6/22.
