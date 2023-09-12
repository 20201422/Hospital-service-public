/**
 * @ClassName DoctorArrangeForSevenDays
 * @Author 24
 * @Date 2023/6/20 18:11
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.tripleunionhospitalregistrationsystemservice.entity.patient;

public class DoctorArrangeForSevenDays {
    
    private String doctorId;
    private String doctorName;
    private String numberSourceDate;
    private String AMOrPM;
    private String attendanceNum;
    private String uninsuredNum;
    
    public DoctorArrangeForSevenDays() {
    }
    
    public DoctorArrangeForSevenDays(String doctorId, String doctorName, String numberSourceDate,
                                     String AMOrPM, String attendanceNum, String uninsuredNum) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.numberSourceDate = numberSourceDate;
        this.AMOrPM = AMOrPM;
        this.attendanceNum = attendanceNum;
        this.uninsuredNum = uninsuredNum;
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
    
    public String getAttendanceNum() {
        return attendanceNum;
    }
    
    public void setAttendanceNum(String attendanceNum) {
        this.attendanceNum = attendanceNum;
    }
    
    public String getUninsuredNum() {
        return uninsuredNum;
    }
    
    public void setUninsuredNum(String uninsuredNum) {
        this.uninsuredNum = uninsuredNum;
    }
    
    @Override
    public String toString() {
        return "DoctorArrangeForSevenDays{" +
                "doctorId='" + doctorId + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", numberSourceDate='" + numberSourceDate + '\'' +
                ", AMOrPM='" + AMOrPM + '\'' +
                ", attendanceNum='" + attendanceNum + '\'' +
                ", uninsuredNum='" + uninsuredNum + '\'' +
                '}';
    }
}

//    may the force be with you.
//    @ClassName   DoctorArrangeForSevenDays
//    Created by 24 on 2023/6/20.
