/**
 * @ClassName UserService
 * @Author 24
 * @Date 2023/6/20 23:40
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.tripleunionhospitalregistrationsystemservice.service;

import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.User;

public interface UserService {
    
    void addUser(Object user);   // 新增用户
    Object getUserById(Object user); // 查找用户
    int updatePatient(User user);    // 更改用户信息
    int deletePatient(int patientId); // 删除一个用户
    
}

//    may the force be with you.
//    @ClassName   UserService
//    Created by 24 on 2023/6/20.
