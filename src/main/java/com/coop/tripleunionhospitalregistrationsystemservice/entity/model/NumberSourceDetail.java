/**
 * @ClassName NumberSourceDetail
 * @Author 24
 * @Date 2023/6/16 17:28
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.tripleunionhospitalregistrationsystemservice.entity.model;

import com.baomidou.mybatisplus.annotation.TableField;

public class NumberSourceDetail {
    
    private int numberSourceDetailId;
    private int numberSourceId;
    private String departmentName;
    private String consultingRoomType;
    private String doctorId;
    private String doctorName;
    private String doctorLevel;
    private String numberSourceDate;
    @TableField(value="AM_or_PM")
    private String AMOrPM;
    private String consultationPeriod;
    private double numberSourceFee;
    private String state;
    
    public NumberSourceDetail() {
    }
    
    public NumberSourceDetail(int numberSourceDetailId, int numberSourceId, String departmentName,
                              String consultingRoomType, String doctorId, String doctorName, String doctorLevel,
                              String numberSourceDate, String AMOrPM, String consultationPeriod,
                              double numberSourceFee, String state) {
        this.numberSourceDetailId = numberSourceDetailId;
        this.numberSourceId = numberSourceId;
        this.departmentName = departmentName;
        this.consultingRoomType = consultingRoomType;
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.doctorLevel = doctorLevel;
        this.numberSourceDate = numberSourceDate;
        this.AMOrPM = AMOrPM;
        this.consultationPeriod = consultationPeriod;
        this.numberSourceFee = numberSourceFee;
        this.state = state;
    }
    
    public int getNumberSourceDetailId() {
        return numberSourceDetailId;
    }
    
    public void setNumberSourceDetailId(int numberSourceDetailId) {
        this.numberSourceDetailId = numberSourceDetailId;
    }
    
    public int getNumberSourceId() {
        return numberSourceId;
    }
    
    public void setNumberSourceId(int numberSourceId) {
        this.numberSourceId = numberSourceId;
    }
    
    public String getDepartmentName() {
        return departmentName;
    }
    
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    
    public String getConsultingRoomType() {
        return consultingRoomType;
    }
    
    public void setConsultingRoomType(String consultingRoomType) {
        this.consultingRoomType = consultingRoomType;
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
    
    public String getDoctorLevel() {
        return doctorLevel;
    }
    
    public void setDoctorLevel(String doctorLevel) {
        this.doctorLevel = doctorLevel;
    }
    
    public String getNumberSourceDate() {
        return numberSourceDate;
    }
    
    public void setNumberSourceDate(String numberSourceDate) {
        this.numberSourceDate = numberSourceDate;
    }
    
    public String getAMOrPM() {
        return AMOrPM;
    }
    
    public void setAMOrPM(String AMOrPM) {
        this.AMOrPM = AMOrPM;
    }
    
    public String getConsultationPeriod() {
        return consultationPeriod;
    }
    
    public void setConsultationPeriod(String consultationPeriod) {
        this.consultationPeriod = consultationPeriod;
    }
    
    public double getNumberSourceFee() {
        return numberSourceFee;
    }
    
    public void setNumberSourceFee(double numberSourceFee) {
        this.numberSourceFee = numberSourceFee;
    }
    
    public String getState() {
        return state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    @Override
    public String toString() {
        return "NumberSourceDetail{" +
                "numberSourceDetailId=" + numberSourceDetailId +
                ", numberSourceId=" + numberSourceId +
                ", departmentName='" + departmentName + '\'' +
                ", consultingRoomType='" + consultingRoomType + '\'' +
                ", doctorId='" + doctorId + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", doctorLevel='" + doctorLevel + '\'' +
                ", numberSourceDate='" + numberSourceDate + '\'' +
                ", AMOrPM='" + AMOrPM + '\'' +
                ", consultationPeriod='" + consultationPeriod + '\'' +
                ", numberSourceFee=" + numberSourceFee +
                ", state='" + state + '\'' +
                '}';
    }
}

//    may the force be with you.
//    @ClassName   NumberSourceDetail
//    Created by 24 on 2023/6/16.
