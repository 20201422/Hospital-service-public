/**
 * @ClassName UserController
 * @Author 24
 * @Date 2023/6/19 09:37
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.tripleunionhospitalregistrationsystemservice.controller;


import com.coop.tripleunionhospitalregistrationsystemservice.entity.ApiResult;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.Patient;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.User;
import com.coop.tripleunionhospitalregistrationsystemservice.serviceImpl.UserServiceImpl;
import com.coop.tripleunionhospitalregistrationsystemservice.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserServiceImpl userService;
    public UserController() {
    }

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    public UserServiceImpl getUserService() {
        return userService;
    }

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ApiResult<?> login(@RequestBody Map<String, String> map) {   // 登录
        System.out.println("登录");
        return ApiResultHandler.success(userService.getUserById(map));
    }

    @PutMapping("/register")
    public ApiResult<?> register(@RequestBody Patient patient) {    // 注册
        System.out.println("注册");
        userService.addUser(patient);
        return ApiResultHandler.success();
    }
    
    @PostMapping("/update")
    public ApiResult<?> update(@RequestBody User user) {    // 更改用户信息
        System.out.println("更改用户信息");
        return ApiResultHandler.success(userService.updatePatient(user));
    }

    @PutMapping("/delete")
    public ApiResult<?> delete(@RequestBody Map<String, Integer> map) { // 删除一个用户
        System.out.println("删除一个用户");
        return ApiResultHandler.success(userService.deletePatient(map.get("userId")));
    }

    
}

//    may the force be with you.
//    @ClassName   UserController
//    Created by 24 on 2023/6/19.
