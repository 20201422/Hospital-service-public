/**
 * @ClassName DepartmentMapper
 * @Author 24
 * @Date 2023/6/19 17:42
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.tripleunionhospitalregistrationsystemservice.mapper;

import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DepartmentMapper {
    
    @Select("select * from department")
    List<Department> getDepartments();  // 获取所有科室信息
    
    @Select("select * from department where department_id = #{departmentId}")
    Department getDepartmentById(String departmentId);  // 获取一个科室的信息

    @Select("select * from department where department_name = #{departmentName}")
    Department getDepartmentByName(String departmentName);  // 获取一个科室的信息


}

//    may the force be with you.
//    @ClassName   DepartmentMapper
//    Created by 24 on 2023/6/19.
