/**
 * @ClassName DepartmentService
 * @Author 24
 * @Date 2023/6/19 17:45
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.tripleunionhospitalregistrationsystemservice.service;

import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.Department;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    
    Map<String, List<Department>> getDepartments();  // 获取所有科室信息
    Department getDepartmentById(String departmentId);  // 获取一个科室的信息

    Department getDepartmentByName(String departmentName);  // 获取一个科室的信息

    List<Department> getDepartmentList();
}

//    may the force be with you.
//    @ClassName   DepartmentService
//    Created by 24 on 2023/6/19.
