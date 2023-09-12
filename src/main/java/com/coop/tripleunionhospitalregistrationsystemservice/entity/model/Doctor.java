/**
 * @ClassName Doctor
 * @Author 24
 * @Date 2023/6/9 18:39
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.tripleunionhospitalregistrationsystemservice.entity.model;

public class Doctor {
    
    private String doctorId;
    private String doctorName;
    private String doctorSex;
    private String doctorPhoto;
    private String doctorEmail;
    private String doctorPhoneNumber;
    private String doctorPassword;
    private String doctorIntroduction;
    private String doctorMajor;
    private String doctorLevel;
    private String doctorType;
    private String departmentId;
    
    public Doctor() {
    }
    
    public Doctor(String doctorId, String doctorName, String doctorSex, String doctorPhoto, String doctorEmail,
                  String doctorPhoneNumber, String doctorPassword, String doctorIntroduction, String doctorMajor,
                  String doctorLevel, String doctorType, String departmentId) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.doctorSex = doctorSex;
        this.doctorPhoto = doctorPhoto;
        this.doctorEmail = doctorEmail;
        this.doctorPhoneNumber = doctorPhoneNumber;
        this.doctorPassword = doctorPassword;
        this.doctorIntroduction = doctorIntroduction;
        this.doctorMajor = doctorMajor;
        this.doctorLevel = doctorLevel;
        this.doctorType = doctorType;
        this.departmentId = departmentId;
    }
    
    public String getDoctorId() {
        return doctorId;
    }
    
    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }
    
    public String getDoctorName() {
        return doctorName;
    }
    
    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
    
    public String getDoctorSex() {
        return doctorSex;
    }
    
    public void setDoctorSex(String doctorSex) {
        this.doctorSex = doctorSex;
    }
    
    public String getDoctorPhoto() {
        return doctorPhoto;
    }
    
    public void setDoctorPhoto(String doctorPhoto) {
        this.doctorPhoto = doctorPhoto;
    }
    
    public String getDoctorEmail() {
        return doctorEmail;
    }
    
    public void setDoctorEmail(String doctorEmail) {
        this.doctorEmail = doctorEmail;
    }
    
    public String getDoctorPhoneNumber() {
        return doctorPhoneNumber;
    }
    
    public void setDoctorPhoneNumber(String doctorPhoneNumber) {
        this.doctorPhoneNumber = doctorPhoneNumber;
    }
    
    public String getDoctorPassword() {
        return doctorPassword;
    }
    
    public void setDoctorPassword(String doctorPassword) {
        this.doctorPassword = doctorPassword;
    }
    
    public String getDoctorIntroduction() {
        return doctorIntroduction;
    }
    
    public void setDoctorIntroduction(String doctorIntroduction) {
        this.doctorIntroduction = doctorIntroduction;
    }
    
    public String getDoctorMajor() {
        return doctorMajor;
    }
    
    public void setDoctorMajor(String doctorMajor) {
        this.doctorMajor = doctorMajor;
    }
    
    public String getDoctorLevel() {
        return doctorLevel;
    }
    
    public void setDoctorLevel(String doctorLevel) {
        this.doctorLevel = doctorLevel;
    }
    
    public String getDoctorType() {
        return doctorType;
    }
    
    public void setDoctorType(String doctorType) {
        this.doctorType = doctorType;
    }
    
    public String getDepartmentId() {
        return departmentId;
    }
    
    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }
    
    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId='" + doctorId + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", doctorSex='" + doctorSex + '\'' +
                ", doctorPhoto='" + doctorPhoto + '\'' +
                ", doctorEmail='" + doctorEmail + '\'' +
                ", doctorPhoneNumber='" + doctorPhoneNumber + '\'' +
                ", doctorPassword='" + doctorPassword + '\'' +
                ", doctorIntroduction='" + doctorIntroduction + '\'' +
                ", doctorMajor='" + doctorMajor + '\'' +
                ", doctorLevel='" + doctorLevel + '\'' +
                ", doctorType='" + doctorType + '\'' +
                ", departmentId='" + departmentId + '\'' +
                '}';
    }
}

//    may the force be with you.
//    @ClassName   Doctor
//    Created by 24 on 2023/6/9.
