/**
 * @ClassName DepartmentServiceImpl
 * @Author 24
 * @Date 2023/6/19 17:46
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.tripleunionhospitalregistrationsystemservice.serviceImpl;

import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.Department;
import com.coop.tripleunionhospitalregistrationsystemservice.mapper.DepartmentMapper;
import com.coop.tripleunionhospitalregistrationsystemservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    
    private DepartmentMapper departmentMapper;
    
    public DepartmentServiceImpl() {
    }
    
    @Autowired
    public DepartmentServiceImpl(DepartmentMapper departmentMapper) {
        this.departmentMapper = departmentMapper;
    }
    
    public DepartmentMapper getDepartmentMapper() {
        return departmentMapper;
    }
    
    public void setDepartmentMapper(DepartmentMapper departmentMapper) {
        this.departmentMapper = departmentMapper;
    }
    
    @Override
    public Map<String, List<Department>> getDepartments() {  // 获取所有科室信息
        
        List<Department> departments = departmentMapper.getDepartments();
        
        Map<String, List<Department>> map = new HashMap<>();
        for (Department department : departments) {
            String type = department.getDepartmentType();
            List<Department> departmentList = map.computeIfAbsent(type, k -> new ArrayList<>());
            departmentList.add(department);
        }
        
        return map;
    }
    
    @Override
    public Department getDepartmentById(String departmentId) {  // 获取一个科室的信息
        return departmentMapper.getDepartmentById(departmentId);
    }

    @Override
    public Department getDepartmentByName(String departmentName) {
        return departmentMapper.getDepartmentByName(departmentName);
    }

    @Override
    public List<Department> getDepartmentList() {
        return departmentMapper.getDepartments();
    }
    
}

//    may the force be with you.
//    @ClassName   DepartmentServiceImpl
//    Created by 24 on 2023/6/19.
