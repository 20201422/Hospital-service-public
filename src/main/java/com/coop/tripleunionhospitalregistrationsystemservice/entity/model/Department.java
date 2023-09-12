/**
 * @ClassName Department
 * @Author 24
 * @Date 2023/6/9 18:38
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.tripleunionhospitalregistrationsystemservice.entity.model;

public class Department {
    
    private String departmentId;
    private String departmentName;
    private String departmentType;
    
    public Department() {
    }
    
    public Department(String departmentId, String departmentName, String departmentType) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentType = departmentType;
    }
    
    public String getDepartmentId() {
        return departmentId;
    }
    
    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }
    
    public String getDepartmentName() {
        return departmentName;
    }
    
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    
    public String getDepartmentType() {
        return departmentType;
    }
    
    public void setDepartmentType(String departmentType) {
        this.departmentType = departmentType;
    }
    
    @Override
    public String toString() {
        return "Department{" +
                "departmentId='" + departmentId + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", departmentType='" + departmentType + '\'' +
                '}';
    }
}

//    may the force be with you.
//    @ClassName   Department
//    Created by 24 on 2023/6/9.
